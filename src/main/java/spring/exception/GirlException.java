package spring.exception;

import spring.domain.Girl;
import spring.enums.ResultEnum;

/**
 * Created by wgt on 2017/3/18.
 * 自定义异常，通过异常拦截处理不同的程序错误
 */

public class GirlException extends RuntimeException{

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
    }

    public GirlException(ResultEnum resultEnum,String msg) {
        super(msg);
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
