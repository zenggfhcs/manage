package com.lib.service.impl;

import com.lib.dao.BookInfoMapper;
import com.lib.model.BookInfo;
import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookInfoDefaultService implements BookInfoService {

private final BookInfoMapper bookInfoMapper;
private final BaseDefaultService<BookInfo> baseService;
@Autowired
public BookInfoDefaultService(BookInfoMapper bookInfoMapper) {
   this.bookInfoMapper = bookInfoMapper;
   baseService = new BaseDefaultService<>(bookInfoMapper);
}

@Override
public Response getBy(Parameter<BookInfo> parameter) {
   return baseService.getBy(parameter);
}

@Override
public Response create(Parameter<BookInfo> parameter) {
   return baseService.create(parameter);
}

@Override
public Response getById(Parameter<BookInfo> parameter) {
   return baseService.getById(parameter);
}

@Override
public Response update(Parameter<BookInfo> parameter) {
   return baseService.update(parameter);
}

@Override
public Response delete(Parameter<BookInfo> parameter) {
   return baseService.delete(parameter);
}
}
