package customeexception;

public class InvalidchoiceException extends RuntimeException {
	private String message;
	public InvalidchoiceException(String message) {
		this.message=message;
	}
	@Override
	public String getMessage() {
		return message;
	}

}
