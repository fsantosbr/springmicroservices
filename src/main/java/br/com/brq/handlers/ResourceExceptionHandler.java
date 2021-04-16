package br.com.brq.handlers;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.brq.exceptions.FieldMessageList;
import br.com.brq.exceptions.ObjetoNaoEncontradoException;
import br.com.brq.exceptions.StandardError;


@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validador(MethodArgumentNotValidException e, HttpServletRequest request) {
		
		FieldMessageList error = new FieldMessageList(
				LocalDateTime.now(),
				HttpStatus.UNPROCESSABLE_ENTITY.value(),
				"Exceção", 
				"Erro ao validar os dados", 
				request.getRequestURI()
		);
		
		for (FieldError fieldError: e.getBindingResult().getFieldErrors() ) {
			error.addError(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY.value()).body(error);		
	}
	
	
	@ExceptionHandler (ObjetoNaoEncontradoException.class)
	public ResponseEntity<StandardError> objetoNaoEncontrado( ObjetoNaoEncontradoException e, HttpServletRequest request ) {
		StandardError error = new StandardError(				
				LocalDateTime.now(),
				HttpStatus.NOT_FOUND.value(),			
				"Objeto Não Encontrado", 
				e.getMessage(), 
				request.getRequestURI()
		);
		LocalDateTime.now().getMonth();
		return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
	}
}
