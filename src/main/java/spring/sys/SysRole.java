package spring.sys;

import java.io.Serializable;

/**
 * Created by wgt on 2017/3/21.
 */
public class SysRole implements Serializable{


    private static final long serialVersionUID = -1359361512718492785L;

    private Long id;
    private String name;


    public SysRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
