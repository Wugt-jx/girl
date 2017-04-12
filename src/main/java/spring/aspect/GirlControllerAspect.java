package spring.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wgt on 2017/3/17.
 * controller切面程序，使用AOP原理配置日志
 */

@Aspect
@Component
public class GirlControllerAspect {

    private static Logger logger= LoggerFactory.getLogger(GirlControllerAspect.class);

    //标记controller
    @Pointcut("execution(public * spring.controller.*.*(..))")
    public void log(){}


    //在对象方法执行前行为
    @Before("log()")
    public void befor_GirlController(JoinPoint joinPoint){
        ServletRequestAttributes sra=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=sra.getRequest();
        //url
        logger.info("url:{}",request.getRequestURL());

        //method
        logger.info("method:{}" ,request.getMethod());

        //IP
        logger.info("ip:{}",request.getRemoteAddr());

        //ClassMethod
        logger.info("class_method:{}",joinPoint.getSignature().getDeclaringTypeName()
                +"."+joinPoint.getSignature().getName());

        //params
        logger.info("params:{}",joinPoint.getArgs());
    }


    //在对象方法执行后行为
    @AfterReturning(returning = "object",value = "log()")
    public void after_GirlController(Object object){
        if(object!=null) {
            logger.info("respones:{}", object.toString());
        }
    }
}
