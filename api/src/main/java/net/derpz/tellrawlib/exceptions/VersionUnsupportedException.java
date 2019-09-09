package net.derpz.tellrawlib.exceptions;

public class VersionUnsupportedException extends Exception {

    public VersionUnsupportedException() {
        super();
    }

    public VersionUnsupportedException(String message) {
        super(message);
    }

    public VersionUnsupportedException(String message, Throwable cause) {
        super(message, cause);
    }

    public VersionUnsupportedException(Throwable cause) {
        super(cause);
    }


}
