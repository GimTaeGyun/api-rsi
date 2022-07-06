package com.bfly.management.exception;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ConstraintResult {
	private List<ConstrainDetail> errors;

	public static ConstraintResult create(ConstraintViolationException errors) {

		List<ConstrainDetail> details = errors.getConstraintViolations().stream()
				.map(constraintViolation -> ConstrainDetail.create(constraintViolation)).collect(Collectors.toList());

		return new ConstraintResult(details);
	}
}
