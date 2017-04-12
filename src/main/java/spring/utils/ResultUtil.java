package spring.utils;

/**
 * Created by wgt on 2017/3/18.
 */
public class ResultUtil {

    private static MsgResult result=new MsgResult();

    public static MsgResult success(Object object){
        result.setCode(000);
        result.setMsg("success");
        result.setDatas(object);
        return result;
    }

    public static MsgResult error(Integer code,String msg){
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
