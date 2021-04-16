package br.com.brq.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// a class to store a personal message error

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldMessage {
	
	private String fieldName;
	private String message;
}
