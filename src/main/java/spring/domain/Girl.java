package spring.domain;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by wgt on 2017/3/1.
 *
 */
public class Girl {

    //
    //以下属性上的注解用于提交表单验证
    //
    private Integer id;
    @NotNull(message = "用户名不能为空！")
    private String name;
    @NotNull(message = "年龄不能为空！")
    @Min(value = 18,message = "未满18岁的未成年人禁止入内！")
    private Integer age;
    @NotNull(message = "密码不能为空！")
    @Length(min = 6,max = 12,message = "密码长度必须在6~12个字符之间！")
    private String password;



    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
