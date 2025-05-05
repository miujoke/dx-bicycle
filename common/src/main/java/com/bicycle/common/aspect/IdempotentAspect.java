package com.bicycle.common.aspect;

import com.bicycle.common.annotation.IdempotentAnnotation;
import io.micrometer.core.instrument.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * @author miujoke
 * @date 2025/3/15 22:41
 */
@Aspect
@Order(2)
@Component
public class IdempotentAspect {

    private static final Logger logger = LoggerFactory.getLogger(IdempotentAspect.class);

    //@Autowired
    //private RedisService redisService;

    @Around("@annotation(idempotentAnnotation)")
    public Object doAround(ProceedingJoinPoint joinPoint, IdempotentAnnotation idempotentAnnotation) throws Throwable{
        logger.info("加入redis锁切面开始");
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String openid = (String) request.getAttribute("Constant.OPENID");
        String key = "";
        if (StringUtils.isNotBlank(openid)) {
            key = idempotentAnnotation.key() + openid;
            logger.info("给方法加入redis锁，redis key为{}", key);
            /*if (!redisService.repeatLock(key, idempotentAnnotation.expireTime())) {
                throw new IdempotentException("重复请求了");
            }*/
        }
        try {
            logger.info("redis锁切面开始进入方法");
            return joinPoint.proceed();
        } finally {
            if (StringUtils.isNotBlank(key)) {
                logger.info("方法执行完成，删除redis锁，redis key为{}", key);
                //redisService.remove(key);
            }
            logger.info("加入redis锁切面结束");
        }
    }
}
