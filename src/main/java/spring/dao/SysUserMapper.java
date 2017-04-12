package spring.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import spring.sys.SysRole;
import spring.sys.SysUser;

import java.util.List;

/**
 * Created by wgt on 2017/3/21.
 */
@Mapper
@Component
public interface SysUserMapper {

    @Select("SELECT id,username,password FROM sysuser WHERE username=#{username}")
    public SysUser findByUserName(@Param("username")String username);

    @Select("SELECT r.id,r.name " +
            "FROM sysrole AS r " +
            "INNER JOIN user_role AS ur " +
            "ON r.id=ur.role_id " +
            "WHERE ur.user_id=#{userId}")
    public List<SysRole>findRoleById(@Param("userId")Integer userId);
}
