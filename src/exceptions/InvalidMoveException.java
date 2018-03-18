package exceptions;

public class InvalidMoveException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4181475150415857423L;

	public InvalidMoveException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidMoveException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidMoveException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidMoveException(String message) {
		super(message);
	}

	public InvalidMoveException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
