package spring.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.enums.ResultEnum;
import spring.exception.GirlException;
import spring.utils.MsgResult;
import spring.utils.ResultUtil;

/**
 * Created by wgt on 2017/3/18.
 */

/**
 * controller异常拦截器
 */
@ControllerAdvice
public class ExceptionHandle {

    private static Logger logger=LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(Exception.class)  //异常拦截
    @ResponseBody
    public MsgResult handle(Exception e){

        if (e instanceof GirlException){
            logger.error("自定义异常:{}",e);
            GirlException girlException=(GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else{
            logger.error("系统异常:{}",e);
            return ResultUtil.error(ResultEnum.UNKNOW_ERROR.getCode()
                                    ,ResultEnum.UNKNOW_ERROR.getMsg());
        }
    }
}
