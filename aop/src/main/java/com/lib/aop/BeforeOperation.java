package com.lib.aop;

import com.lib.utils.Parse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BeforeOperation {
/**
 * 将 token 封装到 parameter 里面去
 *
 * @param point service-method
 */
@Before("@annotation(com.lib.anno.BeforeConduct)")
public void beforeService(JoinPoint point) {
   // 预期参数为 { parameter, token }
   Parse.argsToParameter(point.getArgs());
}
}
