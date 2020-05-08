package common.result;

import lombok.Getter;

@Getter
public enum ResultEnum implements IResult {

    /**
     * 通用状态
     */
    SUCCESS(200, "成功"),
    ERROR(400, "错误");


    private final Integer code;

    private final String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
