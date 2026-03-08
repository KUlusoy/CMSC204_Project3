
public class UserNotFoundException extends Exception{
	public UserNotFoundException(String msg) {
		super(msg);
	}
	public UserNotFoundException() {
		super("User wasnt found");
	}
}
