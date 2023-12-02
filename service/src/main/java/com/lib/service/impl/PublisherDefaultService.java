package com.lib.service.impl;

import com.lib.anno.BeforeDelete;
import com.lib.anno.BeforeService;
import com.lib.dao.PublisherMapper;
import com.lib.model.Parameter;
import com.lib.model.Publisher;
import com.lib.model.Response;
import com.lib.service.PublisherService;
import org.springframework.stereotype.Service;

@Service
public class PublisherDefaultService implements PublisherService {
private final PublisherMapper publisherMapper;

public PublisherDefaultService(PublisherMapper publisherMapper) {
   this.publisherMapper = publisherMapper;
}

@BeforeService
@Override
public Response getById(Parameter parameter, String token) {
   Publisher publisher = publisherMapper.getById(parameter);
   if (publisher == null) {
      return Response.error("该出版社不存在");
   }
   return Response.success(publisher);
}

@BeforeService
@Override
public Response getBy(Parameter parameter, String token) {
   return Response.success();
}

@Override
public Response create(Parameter parameter, String token) {
   return Response.success();
}

@Override
public Response update(Parameter parameter, String token) {
   return Response.success();
}

@BeforeDelete
@Override
public Response delete(Parameter parameter, String token) {
   return Response.success();
}
}
