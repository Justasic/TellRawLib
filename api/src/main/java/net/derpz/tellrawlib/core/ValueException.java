package net.derpz.tellrawlib.core;

/**
 * Created by xiurobert on 06-Sep-19.
 */
public class ValueException extends Exception {
    public ValueException() {
        super();
    }

    public ValueException(String message) {
        super(message);
    }

    public ValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValueException(Throwable cause) {
        super(cause);
    }
}
