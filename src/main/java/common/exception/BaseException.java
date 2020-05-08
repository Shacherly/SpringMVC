package common.exception;

public abstract class BaseException extends Exception {


    public Integer code;
    public String message;


    public BaseException(String message) {
        super(message);
    }
}
