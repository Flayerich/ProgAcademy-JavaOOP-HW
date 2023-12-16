package hw9;

public class GroupOverflowException extends Exception {

    private static final long serialVersionUID = 1L;

    public GroupOverflowException() {
        super();
    }

    public GroupOverflowException(String message, Throwable cause) {
        super(message, cause);
    }

    public GroupOverflowException(String message) {
        super(message);
    }

    public GroupOverflowException(Throwable cause) {
        super(cause);
    }
}
