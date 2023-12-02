package com.lib.service.impl;

import com.lib.anno.BeforeService;
import com.lib.dao.GetLogMapper;
import com.lib.model.GetLog;
import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.service.LogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LogDefaultService implements LogService {
private final GetLogMapper logMapper;

public LogDefaultService(GetLogMapper logMapper) {
   this.logMapper = logMapper;
}

/**
 * 创建一个日志
 *
 * @param log 需要创建的日志
 */
@Override
@Transactional(propagation = Propagation.REQUIRES_NEW)
public void createLog(GetLog log) {
   Parameter parameter = new Parameter();
   parameter.setLog(log);
   
   logMapper.create(parameter);
   
}

/**
 * 更新一个日志，用于更新返回值和执行时间
 *
 * @param log 需要更新的日志
 */
@Override
public void updateLog(GetLog log) {
   Parameter parameter = new Parameter();
   parameter.setLog(log);
   
   logMapper.update(parameter);
}

/**
 * 获取日志
 *
 * @param parameter 相关参数
 * @param token     请求 token
 * @return 日志
 */
@BeforeService
@Override
public Response getBy(Parameter parameter, String token) {
   List<GetLog> logs = logMapper.getBy(parameter);
   
   return Response.success(logs);
}

@Override
public Response create(Parameter parameter, String token) {
   return Response.success();
}

@Override
public Response getById(Parameter parameter, String token) {
   return Response.success();
}

@Override
public Response update(Parameter parameter, String token) {
   return Response.success();
}

@Override
public Response delete(Parameter parameter, String token) {
   return Response.success();
}
}
