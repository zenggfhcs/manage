package com.lib.service;

import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.model.UpdateLog;

public interface UpdateLogService extends BaseService<UpdateLog> {
void createLog(UpdateLog log);

void updateLog(UpdateLog log);

Response getBy(Parameter<UpdateLog> parameter);

Response create(Parameter<UpdateLog> parameter);

Response getById(Parameter<UpdateLog> parameter);

Response update(Parameter<UpdateLog> parameter);

Response delete(Parameter<UpdateLog> parameter);
}
