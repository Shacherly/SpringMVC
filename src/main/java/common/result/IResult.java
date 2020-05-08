package common.result;

public interface IResult {

    /**
     * 获取状态编码
     * @return
     */
    Integer getCode();

    /**
     * 获取提示消息
     * @return
     */
    String getMessage();
}
