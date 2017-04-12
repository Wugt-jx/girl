package spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring.domain.Girl;
import spring.enums.ResultEnum;
import spring.exception.GirlException;
import spring.service.GirlService;
import spring.utils.MsgResult;
import spring.utils.ResultUtil;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;

/**
 * Created by wgt on 2017/3/1.
 */

@RestController
public class GirlController {
    @Resource
    private GirlService service;
    private static Logger logger= LoggerFactory.getLogger(GirlController.class);

    /**
     * 使用@Validated进行表单验证
     * @param girl
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public MsgResult<Girl> add(@Validated Girl girl, BindingResult bindingResult)throws Exception{

        if (bindingResult.hasErrors()){
            logger.info("errorMessage:{}",bindingResult.getFieldError().getDefaultMessage());
            throw new GirlException(ResultEnum.NOT_FOUND_PARAMS,bindingResult.getFieldError().getDefaultMessage());
        }
        service.insert(girl);
        return ResultUtil.success(girl);
    }

    @RequestMapping(value = "/add2",method = RequestMethod.POST)
    public int add2(@RequestParam("name")String name,@RequestParam("password")String password){
        HashMap<String,Object> map=new HashMap<String, Object>();
        map.put("name",name);
        map.put("password",password);
        return service.insertByMap(map);
    }

    @RequestMapping(value = "/add3",method = RequestMethod.GET)
    public int add3(@RequestParam("name")String name,@RequestParam("password")String password){
        return service.insertByParams(name,password);
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public List<Girl> getAll(){
        return service.getAll();
    }



    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    public Girl findById(@PathVariable("id")Integer id){
        return service.findById(id);
    }


    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public MsgResult<Girl> update(@Validated Girl girl,BindingResult bindingResult)throws Exception{
        if (bindingResult.hasErrors()){
            return ResultUtil.error(ResultEnum.NOT_FOUND_PARAMS.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        service.update(girl);
        return ResultUtil.success(girl);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable("id")Integer id){
        service.delete(id);
        return "success";
    }
}
