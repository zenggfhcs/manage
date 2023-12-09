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

@Autowired
public UpdateLogDefaultService(UpdatedLogMapper updatedLogMapper) {
   this.updatedLogMapper = updatedLogMapper;
}

@Override
public void createLog(UpdatedLog log) {
   Parameter _parameter = new Parameter();
   _parameter.setULog(log);
   
   updatedLogMapper.create(_parameter);
}

@Override
public void updateLog(UpdatedLog log) {
   Parameter _parameter = new Parameter();
   _parameter.setULog(log);
   
   updatedLogMapper.update(_parameter);
}

@Override
public Response getBy(Parameter parameter, String token) {
   return null;
}

@Override
public Response create(Parameter parameter, String token) {
   return null;
}

@Override
public Response getById(Parameter parameter, String token) {
   return null;
}

@Override
public Response update(Parameter parameter, String token) {
   return null;
}

@Override
public Response delete(Parameter parameter, String token) {
   return null;
}
}
