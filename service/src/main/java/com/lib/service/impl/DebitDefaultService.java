package com.lib.service.impl;

import com.lib.dao.DebitMapper;
import com.lib.model.Debit;
import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.service.DebitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DebitDefaultService implements DebitService {

private final DebitMapper debitMapper;
private final BaseDefaultService<Debit> baseService;
@Autowired
public DebitDefaultService(DebitMapper debitMapper) {
   this.debitMapper = debitMapper;
   baseService = new BaseDefaultService<>(debitMapper);
}

@Override
public Response getBy(Parameter<Debit> parameter) {
   return baseService.getBy(parameter);
}

@Override
public Response create(Parameter<Debit> parameter) {
   return baseService.create(parameter);
}

@Override
public Response getById(Parameter<Debit> parameter) {
   return baseService.getById(parameter);
}

@Override
public Response update(Parameter<Debit> parameter) {
   return baseService.update(parameter);
}

@Override
public Response delete(Parameter<Debit> parameter) {
   return baseService.delete(parameter);
}
}
