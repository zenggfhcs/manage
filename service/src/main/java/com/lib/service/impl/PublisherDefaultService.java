package com.lib.service.impl;

import com.lib.anno.AroundGet;
import com.lib.dao.PublisherMapper;
import com.lib.model.Parameter;
import com.lib.model.Publisher;
import com.lib.model.Response;
import com.lib.service.PublisherService;
import org.springframework.stereotype.Service;


@Service
public class PublisherDefaultService implements PublisherService {
private final PublisherMapper publisherMapper;
private final BaseDefaultService<Publisher> baseService;

public PublisherDefaultService(PublisherMapper publisherMapper) {
   this.publisherMapper = publisherMapper;
   baseService = new BaseDefaultService<>(publisherMapper);
}

@Override
public Response getBy(Parameter<Publisher> parameter) {
   return baseService.getBy(parameter);
}

@Override
public Response create(Parameter<Publisher> parameter) {
   return baseService.create(parameter);
}

@AroundGet
@Override
public Response getById(Parameter<Publisher> parameter) {
   return baseService.getById(parameter);
}

@Override
public Response update(Parameter<Publisher> parameter) {
   return baseService.update(parameter);
}

@Override
public Response delete(Parameter<Publisher> parameter) {
   return baseService.delete(parameter);
}
}
