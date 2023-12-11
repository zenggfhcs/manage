package com.lib.service.impl;

import com.lib.dao.PublisherMapper;
import com.lib.model.Parameter;
import com.lib.model.Publisher;
import com.lib.model.Response;
import com.lib.service.PublisherService;
import org.springframework.stereotype.Service;


@Service
public class PublisherDefaultService extends BaseDefaultService<Publisher> implements PublisherService {
public PublisherDefaultService(PublisherMapper publisherMapper) {
   super(publisherMapper);
}

@Override
public Response getBy(Parameter<Publisher> parameter) {
   return null;
}

@Override
public Response create(Parameter<Publisher> parameter) {
   return null;
}

@Override
public Response getById(Parameter<Publisher> parameter) {
   return super.getById(parameter);
}

@Override
public Response update(Parameter<Publisher> parameter) {
   return null;
}

@Override
public Response delete(Parameter<Publisher> parameter) {
   return null;
}
}
