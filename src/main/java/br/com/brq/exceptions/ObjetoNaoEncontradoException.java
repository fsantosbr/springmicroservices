package br.com.brq.exceptions;

// Exception class to throw ours exceptions and error messages

public class ObjetoNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ObjetoNaoEncontradoException (String mensagem) {
		super(mensagem);
	}
	
}
