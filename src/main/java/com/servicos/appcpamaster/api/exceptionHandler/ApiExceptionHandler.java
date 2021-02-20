package com.servicos.appcpamaster.api.exceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.servicos.appcpamaster.domain.exception.NegocioException;


@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<Object> handleException(NegocioException ex, WebRequest request) {
		var status = HttpStatus.BAD_REQUEST;
		
		var errorHandle = new ErrorHandler();
		errorHandle.setStatus(status.value());
		errorHandle.setTitulo(ex.getMessage());
		errorHandle.setDataHora(LocalDateTime.now());
		
		return handleExceptionInternal(ex, errorHandle, new HttpHeaders(), status, request);
		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		var campos = new ArrayList<ErrorHandler.Campo>();
		
		for(ObjectError error : ex.getBindingResult().getAllErrors()) {
			String nome = ((FieldError) error).getField();
			String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			
			campos.add(new ErrorHandler.Campo(nome, mensagem));
		}
		
		var errorHandler = new ErrorHandler();
		
		errorHandler.setStatus(status.value());
		errorHandler.setTitulo("Um ou mais campos estão inválidos. "
				+ "Faça o preenchimento correto e tente novamente!");
		errorHandler.setDataHora(LocalDateTime.now());
		
		errorHandler.setCampos(campos);

		return super.handleExceptionInternal(ex, errorHandler, headers, status, request);
	}

}
