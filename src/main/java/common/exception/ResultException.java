package common.exception;

public class ResultException extends RuntimeException {

    private Integer code;

    public ResultException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ResultException
}
