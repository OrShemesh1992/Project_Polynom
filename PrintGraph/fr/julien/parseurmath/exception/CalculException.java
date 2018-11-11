package fr.julien.parseurmath.exception;

public class CalculException extends AbstractException{

	private static final long serialVersionUID = 1L;

	public CalculException() {
		super();
	}

	public CalculException(String message, Throwable cause) {
		super(message, cause);
	}

	public CalculException(String message) {
		super(message);
	}

	public CalculException(Throwable cause) {
		super(cause);
	}
	
	

}
