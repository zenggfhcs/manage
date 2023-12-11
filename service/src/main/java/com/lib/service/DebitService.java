package com.lib.service;

import com.lib.model.Debit;
import com.lib.model.Parameter;
import com.lib.model.Response;

public interface DebitService extends BaseService<Debit> {
Response getBy(Parameter<Debit> parameter);

Response create(Parameter<Debit> parameter);

Response getById(Parameter<Debit> parameter);

Response update(Parameter<Debit> parameter);

Response delete(Parameter<Debit> parameter);
}
