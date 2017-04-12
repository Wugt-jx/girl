package spring.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import spring.domain.Girl;

import java.util.List;
import java.util.Map;

/**
 * Created by wgt on 2017/3/1.
 */
@Mapper
@Component
public interface GirlMapper {

    /**
     * 添加对象
     * @param girl  对象
     * @return  影响的数据条数
     */
    @Insert("INSERT INTO girl(name,password,age) VALUES(#{name},#{password},#{age})")
    int insert(Girl girl);

    /**
     * 使用map的形式添加对象
     * @param map
     * @return
     */
    @Insert("INSERT INTO girl(name,password) VALUES(#{name,jdbcType=VARCHAR},#{password,jdbcType=VARCHAR})")
    int insertByMap(Map<String,Object>map);

    /**
     * 使用属性的方式添加对象
     * @param name
     * @param password
     * @return
     */
    @Insert("INSERT INTO girl(name,password) VALUES(#{name},#{password})")
    int insertByParams(@Param("name")String name,@Param("password")String password);

    /**
     * 获取所有对象的集合
     * @return
     */
    @Select("SELECT * FROM girl")
    List<Girl> getAll();

    /**
     * 根据ID查询指定对象
     * @param id
     * @return
     */
    @Select("SELECT * FROM girl where id=#{id}")
    Girl findById(@Param("id")Integer id);

    /**
     * 修改对象
     * @param girl
     */
    @Update("UPDATE girl SET name=#{name},password=#{password} Where id=#{id}")
    void update(Girl girl);

    /**
     * 删除对象
     * @param id
     */
    @Delete("DELETE FROM girl WHERE id=#{id}")
    void delete(@Param("id")Integer id);
}
