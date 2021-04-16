package br.com.brq.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

// this identity class is used to generate the error messages in the requests.
// the way we design


@Data
@AllArgsConstructor
public class StandardError {
	
	//private Long timeStamp;
	private LocalDateTime timeStamp;
	private int status;
	private String error;
	private String message;
	private String path;
}
