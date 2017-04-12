package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.GirlMapper;
import spring.domain.Girl;
import spring.enums.ResultEnum;
import spring.exception.GirlException;

import java.util.List;
import java.util.Map;

/**
 * Created by wgt on 2017/3/1.
 */
@Service
@Transactional
public class  GirlService {
    @Autowired
    private GirlMapper mapper;

    @Transactional
    public int insert(Girl girl)throws Exception{
        if (girl.getAge()<20){
            throw new GirlException(ResultEnum.NO_LONG_ERROR);
        }

        if (girl.getAge()>30){
            throw new GirlException(ResultEnum.TOO_LONG_ERROR);
        }
        return mapper.insert(girl);
    }

    @Transactional
    public int insertByMap(Map<String,Object>map){
        return mapper.insertByMap(map);
    }

    @Transactional
    public int insertByParams(String name,String password){
        return mapper.insertByParams(name,password);
    }

    public List<Girl> getAll(){
        return mapper.getAll();
    }

    public Girl findById(Integer id){
        return mapper.findById(id);
    }

    @Transactional
    public void update(Girl girl){
        mapper.update(girl);
    }

    @Transactional
    public void delete(Integer id){
        mapper.delete(id);
    }
}
