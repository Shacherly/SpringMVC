package common.exception;

import common.result.IResult;
import common.result.ResultEnum;

import java.text.MessageFormat;

public class ResultException extends BaseException {

    private Integer code;

    /**
     * 统一异常处理
     * @param code 状态码
     * @param message 提示信息
     */
    public ResultException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ResultException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public ResultException(IResult result) {
        super(result.getMessage());
        this.code = result.getCode();
    }

    // public ResultException(IResult result, String messsage) {
    //     super(result, messsage);
    // }

    // public ResultException
}
