package com.lib.aop;

import com.lib.model.GetLog;
import com.lib.model.Parameter;
import com.lib.model.TokenBody;
import com.lib.service.LogService;
import com.lib.utils.Json;
import com.lib.utils.Jwt;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class AroundOperation {
private final LogService logService;

@Autowired
public AroundOperation(LogService logService) {
   this.logService = logService;
}

@Around("@annotation(com.lib.anno.AroundGet)")
public Object logGet(ProceedingJoinPoint point) throws Throwable {
   /* -------- 前 -------- */
   Integer createBy;
   String paramString;
   {
      // 解析参数
      Parameter _parameter = (Parameter) point.getArgs()[0];
      paramString = Json.stringify(_parameter);
      // 从参数中获取 token
      String token = _parameter.getToken();
      // 解析 token
      TokenBody tokenBody = Jwt.decodeToken(token);
      createBy = tokenBody.getId();
   }
   
   GetLog log = GetLog.create();
   {  // 数据填充
      // 运行时间
      log.setRunTime(LocalDateTime.now());
      // 执行的方法所在的类（接口）
      log.setClassName(point.getSignature().getDeclaringType().getName());
      // 执行的方法
      log.setMethod(point.getSignature().getName());
      // 方法接收的参数
      log.setParameter(paramString);
      // 设置默认值
      log.setReturnValue(""); // 返回值
      log.setElapsedTime(0L); // 运行时长
      // 方法执行者
      log.setCreateBy(createBy);
   }
   logService.createLog(log);
   /* -------- 前 -------- */
   
   // 执行起始时间
   long startTime = System.currentTimeMillis();
   
   Object o = null;
   try {
      // 执行原始方法
      o = point.proceed();
   } catch (Exception e) {
      o = e.getMessage();
      throw e;
   } finally {
      /* -------- 后 -------- */
      // 执行结束时间
      long endTime = System.currentTimeMillis();
      {
         // 返回值
         log.setReturnValue(Json.stringify(o));
         // 运行时间
         log.setElapsedTime(endTime - startTime);
      }
      logService.updateLog(log);
      /* -------- 后 -------- */
   }
   return o;
}

@Around("@annotation(com.lib.anno.AroundUpdate)")
public Object logUpdate(ProceedingJoinPoint point) throws Throwable {
   /* -------- 前 -------- */
   // 解析参数
   Parameter _parameter = (Parameter) point.getArgs()[0];
   System.out.println(Json.stringify(_parameter));
   /* -------- 前 -------- */
   Object o = point.proceed();
   /* -------- 后 -------- */
   _parameter = (Parameter) point.getArgs()[0];
   System.out.println(Json.stringify(_parameter));
   
   /* -------- 后 -------- */
   return o;
}
}
