package com.lib.service.impl;

import com.lib.dao.BookMapper;
import com.lib.model.Book;
import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookDefaultService  implements BookService {
private final BookMapper bookMapper;
private final BaseDefaultService<Book> baseService;
@Autowired
public BookDefaultService(BookMapper bookMapper) {
   this.bookMapper = bookMapper;
   baseService = new BaseDefaultService<>(bookMapper);
}

@Override
public Response getBy(Parameter<Book> parameter) {
   return baseService.getBy(parameter);
}

@Override
public Response create(Parameter<Book> parameter) {
   return baseService.create(parameter);
}

@Override
public Response getById(Parameter<Book> parameter) {
   return baseService.getById(parameter);
}

@Override
public Response update(Parameter<Book> parameter) {
   return baseService.getById(parameter);
}

@Override
public Response delete(Parameter<Book> parameter) {
   return baseService.delete(parameter);
}
}
