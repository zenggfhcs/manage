package com.lib.aop;

import com.lib.model.*;
import com.lib.service.DeleteLogService;
import com.lib.service.GetLogService;
import com.lib.service.UpdateLogService;
import com.lib.utils.Json;
import com.lib.utils.Jwt;
import com.lib.utils.Parse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class AroundOperation {
private final GetLogService getLogService;
private final UpdateLogService updateLogService;
private final DeleteLogService deleteLogService;

@Autowired
public AroundOperation(GetLogService getLogService, UpdateLogService updateLogService, DeleteLogService deleteLogService) {
   this.getLogService = getLogService;
   this.updateLogService = updateLogService;
   this.deleteLogService = deleteLogService;
}

/**
 * 记录查询
 *
 * @param point 方法代理对象
 * @return 方法的返回值（代理对象执行）
 * @throws Throwable 方法执行的异常
 */
@Around("@annotation(com.lib.anno.AroundGet)")
public Object logGet(ProceedingJoinPoint point) throws Throwable {
   /* -------- 前 -------- */
   // 解析参数
   Parameter<BaseEntity> _parameter = (Parameter<BaseEntity>) point.getArgs()[0];
   
   GetLog _getLog = GetLog.create();
   {
      // 运行时时刻
      _getLog.setRunTime(LocalDateTime.now());
      // 执行的方法所在的类（接口）
      _getLog.setClassName(point.getSignature().getDeclaringType().getName());
      // 执行的方法
      _getLog.setMethod(point.getSignature().getName());
      // 方法接收的参数
      _getLog.setParameter(Json.stringify(_parameter));
      // 返回值
      _getLog.setReturnValue("");
      // 运行时长
      _getLog.setElapsedTime(0L);
      // 方法执行者
      _getLog.setCreateBy(_parameter.getTokenBody().getId());
   }
   // 插入日志，无论调用是否成功都有日志
   getLogService.createLog(_getLog);
   /* -------- 前 -------- */
   
   // 执行起始时间
   long _startTime = System.currentTimeMillis();
   
   Object _res = null;
   try {
      // 执行原始方法
      _res = point.proceed();
   } catch (Exception e) {
      _res = e.getMessage();
      throw e;
   } finally {
      /* -------- 后 -------- */
      // 执行结束时间
      long _endTime = System.currentTimeMillis();
      {
         // 返回值
         _getLog.setReturnValue(Json.stringify(_res));
         // 运行时间
         _getLog.setElapsedTime(_endTime - _startTime);
      }
      getLogService.updateLog(_getLog);
      /* -------- 后 -------- */
   }
   return _res;
}

/**
 * 记录更新
 *
 * @param point 方法代理对象
 * @return 方法的返回值（代理对象执行）
 * @throws Throwable 方法执行的异常
 */
@Around("@annotation(com.lib.anno.AroundUpdate)")
public Object logUpdate(ProceedingJoinPoint point) throws Throwable {
   /* -------- 前 -------- */
   // 解析参数 => parameter
   Parameter<BaseEntity> _parameter = (Parameter<BaseEntity>) point.getArgs()[0];
   UpdatedLog _updatedLog = new UpdatedLog();
   {
      _updatedLog.setDataClass(Parse.serviceToDataClass(point.getSignature().getDeclaringType().getName()));
      _updatedLog.setDataId(_parameter.getId());
      _updatedLog.setOldData("");
      _updatedLog.setNewData(Json.stringify(_parameter));
      _updatedLog.setElapsedTime(0L);
      _updatedLog.setCreateBy(_parameter.getTokenBody().getId());
      // 插入日志
      updateLogService.createLog(_updatedLog);
   }
   
   /* -------- 前 -------- */
   Object _res;
   Long _startTime = System.currentTimeMillis();
   try {
      _res = point.proceed();
   } finally {
      /* -------- 后 -------- */
      Long _endTime = System.currentTimeMillis();
      {
         _updatedLog.setElapsedTime(_endTime - _startTime);
         _parameter.setTokenBody(null);
         _updatedLog.setOldData(Json.stringify(_parameter));
         // 更新日志
         updateLogService.updateLog(_updatedLog);
      }
      /* -------- 后 -------- */
   }
   return _res;
}

@Around("@annotation(com.lib.anno.AroundDelete)")
public Object logDelete(ProceedingJoinPoint point) throws Throwable {
   /* -------- 前 -------- */
   // 解析参数 => parameter
   Parameter<BaseEntity> _parameter = (Parameter<BaseEntity>) point.getArgs()[0];
   DeletedLog _deletedLog = new DeletedLog();
   {
      _deletedLog.setDataClass(Parse.serviceToDataClass(point.getSignature().getDeclaringType().getName()));
      _deletedLog.setDataId(_parameter.getId());
      _deletedLog.setData("");
      _deletedLog.setElapsedTime(0L);
      _deletedLog.setCreateBy(_parameter.getTokenBody().getId());
      // 插入日志
      deleteLogService.createLog(_deletedLog);
   }
   
   /* -------- 前 -------- */
   Object _res;
   Long _startTime = System.currentTimeMillis();
   try {
      _res = point.proceed();
   } finally {
      /* -------- 后 -------- */
      Long _endTime = System.currentTimeMillis();
      {
         _deletedLog.setElapsedTime(_endTime - _startTime);
         _parameter.setTokenBody(null);
         _parameter.setId(null);
         _deletedLog.setData(Json.stringify(_parameter));
         // 更新日志
         deleteLogService.updateLog(_deletedLog);
      }
      /* -------- 后 -------- */
   }
   return _res;
}

/**
 * 将 token 封装到 parameter 里面去
 *
 * @param point service-method
 */
@Around("@within(com.lib.anno.AroundConduct)")
public Object aroundConduct(ProceedingJoinPoint point) throws Throwable {
   // 预期参数为 { parameter, token, id }
   Object[] args = point.getArgs();
   Parameter<BaseEntity> _parameter = argsToParameter(args);
   args[0] = _parameter;
   return point.proceed(args);
}


private  Parameter<BaseEntity> argsToParameter(Object[] args) {
   // 解析参数 => parameter
   Parameter<BaseEntity> _parameter = args[0] == null ? new Parameter<>() : (Parameter<BaseEntity>) args[0];
   // token
   String token = args[1].toString();
   // token => tokenBody
   TokenBody tokenBody = Jwt.decodeToken(token);
   _parameter.setTokenBody(tokenBody);
   if (args.length == 3) {
      _parameter.setId(Integer.parseInt (args[2].toString()));
   }
   return _parameter;
}
}