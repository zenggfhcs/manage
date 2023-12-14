package com.lib.service.impl;

import com.lib.dao.DeletedLogMapper;
import com.lib.model.DeletedLog;
import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.service.DeleteLogService;
import org.springframework.stereotype.Service;

@Service
public class DeleteLogDefaultService implements DeleteLogService {
private final DeletedLogMapper deletedLogMapper;
private final BaseDefaultService<DeletedLog> baseService;
public DeleteLogDefaultService(DeletedLogMapper deletedLogMapper) {
   this.deletedLogMapper = deletedLogMapper;
   baseService = new BaseDefaultService<>(deletedLogMapper);
}


@Override
public void createLog(DeletedLog log) {
   Parameter<DeletedLog> _parameter = new Parameter<>();
   _parameter.setEntity(log);
   deletedLogMapper.create(_parameter);
}

@Override
public void updateLog(DeletedLog log) {
   Parameter<DeletedLog> _parameter = new Parameter<>();
   _parameter.setEntity(log);
   deletedLogMapper.update(_parameter);
}

@Override
public Response getBy(Parameter<DeletedLog> parameter) {
   return baseService.getBy(parameter);
}

@Override
public Response create(Parameter<DeletedLog> parameter) {
   return baseService.create(parameter);
}

@Override
public Response getById(Parameter<DeletedLog> parameter) {
   return baseService.getById(parameter);
}

@Override
public Response update(Parameter<DeletedLog> parameter) {
   return baseService.update(parameter);
}

@Override
public Response delete(Parameter<DeletedLog> parameter) {
   return baseService.delete(parameter);
}
}
