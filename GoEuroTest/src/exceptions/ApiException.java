package exceptions;

/**
 * Api Exception to be implemented on top of all other exceptions
 * 
 * @author oded herbst
 * 
 */
public class ApiException extends Exception {

	private static final long serialVersionUID = -3526158638211026008L;

	public ApiException() {
		super();
	}

	public ApiException(String message, Throwable t) {
		super(message, t);
	}

	public ApiException(String message) {
		super(message, null);
	}

}
