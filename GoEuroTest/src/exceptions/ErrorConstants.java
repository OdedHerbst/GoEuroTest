package exceptions;

/**
 * This class holds string constants for possible errors to occur during the
 * flow
 * 
 * @author oded herbst
 * 
 */
public enum ErrorConstants {
	ErrorInvalidArgument("Error - Invalid Argument"),
	ErrorInRemoteServer("Error - in remote server"),
	ErrorEmptyResult("Error - Result from server was empty"),
	ErrorCreatingOrWritingToFile("Error - unable to create or write to file"),
	ErrorInRequestUrl("Error - bad url : "),
	ErrorJsonString("Error reading json string"), 
	ErrorWrongUsage("Error - jar was run inproperly");
	
	private final String text;

	/**
	 * @param text
	 */
	private ErrorConstants(final String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
