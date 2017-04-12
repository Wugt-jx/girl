package spring.utils;

import java.io.Serializable;

/**
 * Created by wgt on 2017/3/21.
 */
public class MsgRole implements Serializable{

    private static final long serialVersionUID = -5991959941009819612L;

    public MsgRole() {
    }

    public MsgRole(String title, String content, String etraInfo) {
        this.title = title;
        this.content = content;
        this.etraInfo = etraInfo;
    }

    private String title;
    private String content;
    private String etraInfo;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEtraInfo() {
        return etraInfo;
    }

    public void setEtraInfo(String etraInfo) {
        this.etraInfo = etraInfo;
    }
}
