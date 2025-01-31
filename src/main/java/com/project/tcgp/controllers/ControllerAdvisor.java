package com.project.tcgp.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
		@NonNull MethodArgumentNotValidException ex,
		@NonNull HttpHeaders headers,
		@NonNull HttpStatusCode status,
		@NonNull WebRequest request) {

		BindingResult bindingResult = ex.getBindingResult();
		List<Map<String, String>> errors = bindingResult.getFieldErrors()
				.stream()
				.map(fieldError -> {
					Map<String, String> response = new HashMap<>();
					response.put("message", fieldError.getDefaultMessage());
					response.put("field", fieldError.getField());
					Object rejectedValue = fieldError.getRejectedValue();
					response.put("value", rejectedValue != null ? rejectedValue.toString() : "null");
					return response;
				})
				.toList();
		return handleExceptionInternal(ex, errors, new HttpHeaders(), BAD_REQUEST, request);
	}
	// DataIntegrityViolationException --> HTTP 409
}