package spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import spring.dao.SysUserMapper;
import spring.sys.SysUser;

/**
 * Created by wgt on 2017/3/21.
 */
public class CustomUserService implements UserDetailsService{

    private static Logger logger= LoggerFactory.getLogger(CustomUserService.class);

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser user=userMapper.findByUserName(s);
        if (user==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        user.setRoles(userMapper.findRoleById(user.getId()));
        logger.info(user.getUsername()+":"+user.getPassword());
        return user;
    }
}
