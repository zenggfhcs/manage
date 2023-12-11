package com.lib.service;

import com.lib.model.DeletedLog;
import com.lib.model.Parameter;
import com.lib.model.Response;

public interface DeleteLogService extends BaseService<DeletedLog> {
void createLog(DeletedLog log);

void updateLog(DeletedLog log);

Response getBy(Parameter<DeletedLog> parameter);

Response create(Parameter<DeletedLog> parameter);

Response getById(Parameter<DeletedLog> parameter);

Response update(Parameter<DeletedLog> parameter);

Response delete(Parameter<DeletedLog> parameter);
}
