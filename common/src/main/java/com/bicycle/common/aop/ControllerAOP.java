package com.bicycle.common.aop;

import com.bicycle.common.exception.IdempotentException;
import com.bicycle.common.exception.JsonException;
import com.bicycle.common.exception.ModelAndViewException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import javax.validation.ConstraintViolationException;
import java.lang.reflect.Method;

/**
 * @author miujoke
 * @date 2025/3/13 23:23
 */
@Aspect
@Order(1)
@Component
public class ControllerAOP {
    private static Logger logger = LoggerFactory.getLogger(ControllerAOP.class);


    /**
     * @Pointcut("execution(* com.joinsoft..*.*Controller.*(..))")
     * @within :使用 “@within(注解类型)” 匹配所以持有指定注解类型内的方法;注解类型也必须是全限定类型名;
     * 注解类型为Controller，事务都生效
     */
    @Pointcut("@within(org.springframework.stereotype.Controller)")
    private void anyMethod() {
    }//定义一个切入点


    @Around("anyMethod()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        try {
            //执行该方法
            Object object = pjp.proceed();
            return object;
        } catch (Exception e) {
            logger.error("出错啦!!", e);
            Method method = ((MethodSignature) pjp.getSignature()).getMethod();
            if(e instanceof ConstraintViolationException){
                throw e;
            }
            if (e instanceof IdempotentException) {
                throw new IdempotentException(e);
            }
            Class[] exceptions = method.getExceptionTypes();
            if (exceptions != null && exceptions.length >= 1) {
                if (exceptions[0].equals(JsonException.class)) {
                    throw new JsonException(e);
                } else if (exceptions[0].equals(ModelAndViewException.class)) {
                    throw new ModelAndViewException(e);
                }
            }
        }
        return null;
    }
}
