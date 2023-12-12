package com.lib.service.impl;

import com.lib.dao.UpdatedLogMapper;
import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.model.UpdatedLog;
import com.lib.service.UpdateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateLogDefaultService extends BaseDefaultService<UpdatedLog> implements UpdateLogService {

private final UpdatedLogMapper updatedLogMapper;

@Autowired
public UpdateLogDefaultService(UpdatedLogMapper updatedLogMapper) {
   super(updatedLogMapper);
   this.updatedLogMapper = updatedLogMapper;
}

@Override
public void createLog(UpdatedLog log) {
   Parameter<UpdatedLog> _parameter = new Parameter<>();
   _parameter.setEntity(log);
   
   updatedLogMapper.create(_parameter);
}

@Override
public void updateLog(UpdatedLog log) {
   Parameter<UpdatedLog> _parameter = new Parameter<>();
   _parameter.setEntity(log);
   
   updatedLogMapper.update(_parameter);
}

@Override
public Response getBy(Parameter<UpdatedLog> parameter) {
   return null;
}

@Override
public Response create(Parameter<UpdatedLog> parameter) {
   return null;
}

@Override
public Response getById(Parameter<UpdatedLog> parameter) {
   return null;
}

@Override
public Response update(Parameter<UpdatedLog> parameter) {
   return null;
}

@Override
public Response delete(Parameter<UpdatedLog> parameter) {
   return null;
}
}
