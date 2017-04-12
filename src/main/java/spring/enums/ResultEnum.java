package spring.enums;

/**
 * Created by wgt on 2017/3/18.
 */

/**
 *返回结果响应码和信息的枚举类
 */
public enum ResultEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(0,"success"),
    NO_LONG_ERROR(101,"你可能刚成年不久！"),
    TOO_LONG_ERROR(102,"你已经太老了！"),
    NOT_FOUND_PARAMS(103),      //请求参数异常，异常信息交由validate验证获取
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    ResultEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
