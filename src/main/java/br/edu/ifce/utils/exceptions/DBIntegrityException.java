package br.edu.ifce.utils.exceptions;

public class DBIntegrityException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DBIntegrityException(String msg) {
		super(msg);
		System.out.println("Violação de integridade!");
	}
}
