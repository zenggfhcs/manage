package com.lib.service;

import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.model.UpdatedLog;

public interface UpdateLogService extends BaseService<UpdatedLog> {
void createLog(UpdatedLog log);

void updateLog(UpdatedLog log);

Response getBy(Parameter<UpdatedLog> parameter);

Response create(Parameter<UpdatedLog> parameter);

Response getById(Parameter<UpdatedLog> parameter);

Response update(Parameter<UpdatedLog> parameter);

Response delete(Parameter<UpdatedLog> parameter);
}
