package com.lib.service.impl;

import com.lib.anno.BeforeService;
import com.lib.dao.BookMapper;
import com.lib.model.Book;
import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookDefaultService implements BookService {

private final BookMapper bookMapper;

public BookDefaultService(BookMapper bookMapper) {
   this.bookMapper = bookMapper;
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
   Book book = bookMapper.getById(parameter);
   return Response.success(book);
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
