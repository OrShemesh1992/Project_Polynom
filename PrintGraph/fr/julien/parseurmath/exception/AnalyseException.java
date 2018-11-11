package fr.julien.parseurmath.exception;

public class AnalyseException extends AbstractException{

	private static final long serialVersionUID = 1L;

	public AnalyseException() {
		super();
	}

	public AnalyseException(String message, Throwable cause) {
		super(message, cause);
	}

	public AnalyseException(String message) {
		super(message);
	}

	public AnalyseException(Throwable cause) {
		super(cause);
	}
	
}
