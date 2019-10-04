package com.cg.exception;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class EMSServiceErrorAdvice 
{
	@ResponseBody
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(value=Exception.class)
	protected ErrorInfo handleConflict(Exception e, HttpServletRequest request)
	{
		String bodyOfResponse=e.getMessage();

		String url = request.getRequestURL().toString();
		System.out.println(" handleConflict error msg " + bodyOfResponse + " Req URL "+ url);
		return new ErrorInfo(url,bodyOfResponse);
	}
	
	@ExceptionHandler({EMSNotFoundException.class,SQLException.class})
	protected ResponseEntity<String> handleConflict2(EMSNotFoundException pnfexp)
	{
		return error (HttpStatus.INTERNAL_SERVER_ERROR,pnfexp);
	}
	
	protected ResponseEntity<String> error(HttpStatus status, EMSNotFoundException emsnfexp)
	{
		return ResponseEntity.status(status).body(emsnfexp.getMessage());
	}
}
