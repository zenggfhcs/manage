package com.lib.service;

import com.lib.model.BaseEntity;
import com.lib.model.Parameter;
import com.lib.model.Response;

public interface BaseService<T extends BaseEntity> {
Response getBy(Parameter<T> parameter);

Response create(Parameter<T> parameter);

Response getById(Parameter<T> parameter);

Response update(Parameter<T> parameter);

Response delete(Parameter<T> parameter);
}
