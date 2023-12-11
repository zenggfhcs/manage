package com.lib.service.impl;

import com.lib.dao.UpdatedLogMapper;
import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.model.UpdateLog;
import com.lib.service.UpdateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateLogDefaultService extends BaseDefaultService<UpdateLog> implements UpdateLogService {

private final UpdatedLogMapper updatedLogMapper;

@Autowired
public UpdateLogDefaultService(UpdatedLogMapper updatedLogMapper) {
   super(updatedLogMapper);
   this.updatedLogMapper = updatedLogMapper;
}

@Override
public void createLog(UpdateLog log) {
   Parameter<UpdateLog> _parameter = new Parameter<>();
   _parameter.setEntity(log);
   
   updatedLogMapper.create(_parameter);
}

@Override
public void updateLog(UpdateLog log) {
   Parameter<UpdateLog> _parameter = new Parameter<>();
   _parameter.setEntity(log);
   
   updatedLogMapper.update(_parameter);
}

@Override
public Response getBy(Parameter<UpdateLog> parameter) {
   return null;
}

@Override
public Response create(Parameter<UpdateLog> parameter) {
   return null;
}

@Override
public Response getById(Parameter<UpdateLog> parameter) {
   return null;
}

@Override
public Response update(Parameter<UpdateLog> parameter) {
   return null;
}

@Override
public Response delete(Parameter<UpdateLog> parameter) {
   return null;
}
}
