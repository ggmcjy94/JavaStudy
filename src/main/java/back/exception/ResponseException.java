package back.exception;

public class ResponseException extends RuntimeException{

    public ResponseException(String message, Throwable cause) {
        super(message, cause);
    }
}
