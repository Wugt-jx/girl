package spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.domain.Girl;
import spring.utils.MsgResult;
import spring.utils.ResultUtil;

/**
 * Created by Administrator on 2017/4/12.
 */
@RestController
public class TestRedisController {
    private static Logger logger= LoggerFactory.getLogger(TestRedisController.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/setString",method = RequestMethod.GET)
    public MsgResult<String> setString(@RequestParam String key, @RequestParam String value){
        stringRedisTemplate.opsForValue().set(key,value);
        logger.info("set value success");
        return ResultUtil.success("set value success");
    }

    @RequestMapping(value = "/getString",method = RequestMethod.GET)
    public MsgResult<String> getString(@RequestParam String key){
        String result=stringRedisTemplate.opsForValue().get(key);
        logger.info("get value success");
        return ResultUtil.success(result);
    }
}
