package com.lib.service;

import com.lib.model.Book;
import com.lib.model.Parameter;
import com.lib.model.Response;

public interface BookService extends BaseService<Book> {

Response getBy(Parameter<Book> parameter);

Response create(Parameter<Book> parameter);

Response getById(Parameter<Book> parameter);

Response update(Parameter<Book> parameter);

Response delete(Parameter<Book> parameter);
}
