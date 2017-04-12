package spring.utils;

/**
 * Created by wgt on 2017/3/18.
 */
public class MsgResult<T> {

    private Integer code;   //信息代码：000表示成功
    private String msg;     //错误信息
    private T datas;        //返回数据


    public MsgResult() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }




    @Override
    public String toString() {
        return "MsgResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", datas=" + datas +
                '}';
    }
}
