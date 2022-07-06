package com.bfly.management.exception;

import java.util.stream.StreamSupport;

import javax.validation.ConstraintViolation;
import javax.validation.Path;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ConstrainDetail {
	private String field;
	private String message;

	public static ConstrainDetail create(ConstraintViolation<?> constraintViolation) {

		String name = StreamSupport.stream(constraintViolation.getPropertyPath().spliterator(), false)
				.map(Path.Node::getName)
				.reduce((first, second) -> second)
				.orElseGet(() -> constraintViolation.getPropertyPath().toString());

		return new ConstrainDetail(name, constraintViolation.getMessage());
	}
}
