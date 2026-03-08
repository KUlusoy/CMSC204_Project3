
public class InvalidUserFormatException extends Exception{
public InvalidUserFormatException(String msg) {
	super(msg);
}
public InvalidUserFormatException() {
	super("Invalid format of user");
}
}
