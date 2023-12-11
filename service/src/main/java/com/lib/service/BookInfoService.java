package com.lib.service;

import com.lib.model.BookInfo;
import com.lib.model.Parameter;
import com.lib.model.Response;

public interface BookInfoService extends BaseService<BookInfo> {
Response getBy(Parameter<BookInfo> parameter);

Response create(Parameter<BookInfo> parameter);

Response getById(Parameter<BookInfo> parameter);

Response update(Parameter<BookInfo> parameter);

Response delete(Parameter<BookInfo> parameter);
}
