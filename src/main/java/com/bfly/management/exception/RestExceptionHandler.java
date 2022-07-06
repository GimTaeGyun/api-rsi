package com.bfly.management.exception;

import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import com.bfly.management.model.common.ApiResult;
import com.bfly.management.model.common.EnumMapperType;
import com.bfly.management.model.common.ErrorCode;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.WebUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<?> handleNotFoundException(HttpServletRequest request, NoHandlerFoundException ex) {

		requestParameterLogging(request, ex);

		return createResponse(ErrorCode.ERROR_NOT_FOUND, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ IllegalArgumentException.class, TypeMismatchException.class,
			HttpMessageNotReadableException.class })
	public ResponseEntity<?> handleBadRequestException(HttpServletRequest request, Exception ex) {

		requestParameterLogging(request, ex);

		ErrorCode errorCode = null;

		if (ex instanceof TypeMismatchException) {
			errorCode = ErrorCode.ERROR_TYPEMISMATCH;
		} else {
			errorCode = ErrorCode.ERROR_UNEXPECTED;
		}

		return createResponse(errorCode, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<?> handleMethodNotAllowedException(HttpServletRequest request,
			HttpRequestMethodNotSupportedException ex) {

		requestParameterLogging(request, ex);

		ErrorCode errorCode = ErrorCode.ERROR_METHOD_NOT_ALLOWED;

		return createResponse(errorCode, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<?> handleExceptions(HttpServletRequest request, BusinessException ex) {

		requestParameterLogging(request, ex);

		return createResponse(ex.getCode(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(BindException.class)
	public ResponseEntity<?> handleArgumentNotValidException(HttpServletRequest request, BindException ex) {

		requestParameterLogging(request, ex);

		ErrorCode errorCode = ErrorCode.ERROR_TYPEMISMATCH;

		return createResponse(errorCode, ValidationResult.create(ex), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> constraintViolationException(HttpServletRequest request, ConstraintViolationException ex) {
		requestParameterLogging(request, ex);

		ErrorCode errorCode = ErrorCode.ERROR_TYPEMISMATCH;

		return createResponse(errorCode, ConstraintResult.create(ex), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<?> missingServletRequestParameterException(HttpServletRequest request,
			MissingServletRequestParameterException ex) {
		requestParameterLogging(request, ex);

		String msg = MessageFormat.format("{0} 파라미터는 필수입니다.", ex.getParameterName());

		ErrorCode errorCode = ErrorCode.ERROR_TYPEMISMATCH;

		return createResponse(errorCode, msg, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleExceptions(HttpServletRequest request, Exception ex) {
		requestParameterLogging(request, ex);

		ErrorCode errorCode = ErrorCode.ERROR_UNEXPECTED;

		return createResponse(errorCode, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private ResponseEntity<?> createResponse(Enum<? extends EnumMapperType> code, HttpStatus status) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<>(new ApiResult<>(code, null), headers, status);
	}

	private ResponseEntity<?> createResponse(Enum<? extends EnumMapperType> code, Object message, HttpStatus status) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<>(new ApiResult<>(code, message), headers, status);
	}

	private void requestParameterLogging(HttpServletRequest request, Exception ex) {

		StringBuilder msg = null;

		try {

			msg = new StringBuilder();
			msg.append("[");
			msg.append(request.getMethod()).append(" ");
			msg.append(request.getRequestURI());

			String queryString = request.getQueryString();
			if (queryString != null) {
				msg.append('?').append(queryString);
			}

			String payload = getMessagePayload(request);
			if (payload != null) {
				msg.append(", payload=").append(payload);
			}

			msg.append("]");

		} catch (Exception e) {
			msg = null;
		}

		log.error(ex.getMessage(), ex);

		if (msg != null) {
			log.error(msg.toString());
		}
	}

	private String getMessagePayload(HttpServletRequest request) {
		ContentCachingRequestWrapper wrapper = WebUtils.getNativeRequest(request, ContentCachingRequestWrapper.class);
		if (wrapper != null) {
			byte[] buf = wrapper.getContentAsByteArray();
			if (buf.length > 0) {
				int length = Math.min(buf.length, 100000);
				try {
					return new String(buf, 0, length, wrapper.getCharacterEncoding());
				} catch (UnsupportedEncodingException ex) {
					return "[unknown]";
				}
			}
		}
		return null;
	}
}