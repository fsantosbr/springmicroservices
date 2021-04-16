package br.com.brq.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

// A class to store a list/array of FieldMessage, a class that has the fields for our personal message error

@Data
@EqualsAndHashCode(callSuper=false) // to not use the hashCode and Equals from super class
public class FieldMessageList extends StandardError{
	
	public FieldMessageList(LocalDateTime timeStamp, int status, String error, String message, String path) {
		super(timeStamp, status, error, message, path);		
	}

	private List<FieldMessage> errors = new ArrayList<>();
	
	public void addError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}
}
