package com.lib.service.impl;

import com.lib.dao.UpdatedLogMapper;
import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.model.UpdatedLog;
import com.lib.service.UpdateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateLogDefaultService implements UpdateLogService {

private final UpdatedLogMapper updatedLogMapper;
private final BaseDefaultService<UpdatedLog> baseService;

@Autowired
public UpdateLogDefaultService(UpdatedLogMapper updatedLogMapper) {
   this.updatedLogMapper = updatedLogMapper;
   baseService = new BaseDefaultService<>(updatedLogMapper);
}

@Override
public void createLog(UpdatedLog log) {
   Parameter<UpdatedLog> _parameter = new Parameter<>();
   _parameter.setEntity(log);
   this.create(_parameter);
}

@Override
public void updateLog(UpdatedLog log) {
   Parameter<UpdatedLog> _parameter = new Parameter<>();
   _parameter.setEntity(log);
   this.update(_parameter);
}

@Override
public Response getBy(Parameter<UpdatedLog> parameter) {
   return baseService.getBy(parameter);
}

@Override
public Response create(Parameter<UpdatedLog> parameter) {
   return baseService.create(parameter);
}

@Override
public Response getById(Parameter<UpdatedLog> parameter) {
   return baseService.getById(parameter);
}

@Override
public Response update(Parameter<UpdatedLog> parameter) {
   return baseService.update(parameter);
}

@Override
public Response delete(Parameter<UpdatedLog> parameter) {
   return baseService.delete(parameter);
}
}
