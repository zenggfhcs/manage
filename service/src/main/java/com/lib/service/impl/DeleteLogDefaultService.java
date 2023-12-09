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

public DeleteLogDefaultService(DeletedLogMapper deletedLogMapper) {
   this.deletedLogMapper = deletedLogMapper;
}


@Override
public void createLog(DeletedLog log) {
   Parameter _parameter = new Parameter();
   _parameter.setDLog(log);
   deletedLogMapper.create(_parameter);
}

@Override
public void updateLog(DeletedLog log) {
   Parameter _parameter = new Parameter();
   _parameter.setDLog(log);
   deletedLogMapper.update(_parameter);
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
