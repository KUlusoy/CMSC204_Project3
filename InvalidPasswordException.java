
public class InvalidPasswordException extends Exception {
public InvalidPasswordException(String msg) {
	super(msg);
}
public InvalidPasswordException() {
	super("Invalid password entered");
}
}
