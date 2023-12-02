package com.lib.service.impl;

import com.lib.dao.DebitMapper;
import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.service.DebitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DebitDefaultService implements DebitService {

private final DebitMapper debitMapper;

@Autowired
public DebitDefaultService(DebitMapper debitMapper) {
   this.debitMapper = debitMapper;
}

@Override
public Response getBy(Parameter parameter, String token) {
   return Response.success();
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
