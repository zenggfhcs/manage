package com.lib.service;

import com.lib.model.Parameter;
import com.lib.model.Publisher;
import com.lib.model.Response;

public interface PublisherService extends BaseService<Publisher> {
Response getBy(Parameter<Publisher> parameter);

Response create(Parameter<Publisher> parameter);

Response getById(Parameter<Publisher> parameter);

Response update(Parameter<Publisher> parameter);

Response delete(Parameter<Publisher> parameter);
}
