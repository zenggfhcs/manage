package com.lib.aop;

import com.lib.model.Parameter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BeforeOperation {
/**
 * 将 token 封装到 parameter 里面去
 * @param point service-method
 */
@Before("@annotation(com.lib.anno.BeforeService)")
public void beforeService(JoinPoint point) {
   // 预期参数为 { parameter, token }
   Object[] _params = point.getArgs();
   
   Parameter parameter = (Parameter) _params[0];
   String token = (String) _params[1];
   parameter.setToken(token);
   // System.out.println(Json.stringify(parameter));
}
}
