package twitter.exceptions;

@SuppressWarnings("serial")
public class NoPropertiesFileFound extends RuntimeException {

	public NoPropertiesFileFound() {
		super();
	}
	
	public NoPropertiesFileFound(String message) {
		super(message);
	}
}
