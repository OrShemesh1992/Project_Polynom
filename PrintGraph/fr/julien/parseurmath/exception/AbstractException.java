package fr.julien.parseurmath.exception;

public abstract class AbstractException extends Exception{

	private static final long serialVersionUID = 1L;

	public AbstractException() {
		super();
	}

	public AbstractException(String message, Throwable cause) {
		super(new StringBuilder().append(cause.getMessage()).append("\n").toString()+message, cause);
	}

	public AbstractException(String message) {
		super(message);
	}

	public AbstractException(Throwable cause) {
		super(new StringBuilder().append(cause.getMessage()).append("\n").toString(), cause);
	}

}
