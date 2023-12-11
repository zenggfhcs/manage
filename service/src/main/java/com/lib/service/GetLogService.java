package com.lib.service;

import com.lib.model.GetLog;
import com.lib.model.Parameter;
import com.lib.model.Response;

public interface GetLogService extends BaseService<GetLog> {
void createLog(GetLog log);

void updateLog(GetLog log);

Response getBy(Parameter<GetLog> parameter);

Response create(Parameter<GetLog>  parameter);

Response getById(Parameter<GetLog>  parameter);

Response update(Parameter<GetLog>  parameter);

Response delete(Parameter<GetLog>  parameter);
}
