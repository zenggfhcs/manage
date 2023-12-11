package com.lib.service.impl;

import com.lib.dao.GetLogMapper;
import com.lib.model.GetLog;
import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.service.GetLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GetLogDefaultService extends BaseDefaultService<GetLog> implements GetLogService {
private final GetLogMapper getLogMapper;

public GetLogDefaultService(GetLogMapper getLogMapper) {
   super(getLogMapper);
   this.getLogMapper = getLogMapper;
}

/**
 * 创建一个日志
 *
 * @param log 需要创建的日志
 */
@Override
@Transactional(propagation = Propagation.REQUIRES_NEW)
public void createLog(GetLog log) {
   Parameter<GetLog> parameter = new Parameter<>();
   parameter.setEntity(log);
   
   getLogMapper.create(parameter);
   
}

/**
 * 更新一个日志，用于更新返回值和执行时间
 *
 * @param log 需要更新的日志
 */
@Override
public void updateLog(GetLog log) {
   Parameter<GetLog> parameter = new Parameter<>();
   parameter.setEntity(log);
   
   getLogMapper.update(parameter);
}

/**
 * 获取日志
 *
 * @param parameter 相关参数
 * @param token     请求 token
 * @return 日志
 */
@Override
public Response getBy(Parameter<GetLog> parameter) {
   List<GetLog> logs = getLogMapper.getBy(parameter);
   
   return Response.success(logs);
}

@Override
public Response create(Parameter<GetLog> parameter) {
   return Response.success();
}

@Override
public Response getById(Parameter<GetLog> parameter) {
   return Response.success();
}

@Override
public Response update(Parameter<GetLog> parameter) {
   return Response.success();
}

@Override
public Response delete(Parameter<GetLog> parameter) {
   return Response.success();
}
}
