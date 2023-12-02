package com.lib.service.impl;

import com.lib.anno.BeforeService;
import com.lib.dao.BookInfoMapper;
import com.lib.model.BookInfo;
import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.service.BookInfoService;
import org.springframework.stereotype.Service;

@Service
public class BookInfoDefaultService implements BookInfoService {

private final BookInfoMapper bookInfoMapper;

public BookInfoDefaultService(BookInfoMapper bookInfoMapper) {
   this.bookInfoMapper = bookInfoMapper;
}

@Override
public Response getBy(Parameter parameter, String token) {
   return Response.success();
}

@Override
public Response create(Parameter parameter, String token) {
   return Response.success();
}
@BeforeService
@Override
public Response getById(Parameter parameter, String token) {
   BookInfo info = bookInfoMapper.getById(parameter);
   return Response.success(info);
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
