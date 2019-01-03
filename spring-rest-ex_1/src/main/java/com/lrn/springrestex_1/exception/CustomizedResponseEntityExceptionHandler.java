package com.lrn.springrestex_1.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	// Changing The value of the annotation to handle all the exceptions
	@ExceptionHandler(StudentNotFoundException.class)
	public final ResponseEntity<ErrorDetails> customExceptionHandler(StudentNotFoundException ex, WebRequest req) {
		ErrorDetails details = new ErrorDetails(new Date(), req.getDescription(false), ex.getMessage());
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders header,
			HttpStatus status, WebRequest request) {
		ErrorDetails details = new ErrorDetails(new Date(), ex.getBindingResult().toString(), "Validation Failed");
		return new ResponseEntity<Object>(details, HttpStatus.NOT_FOUND);
	}

}
