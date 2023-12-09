package com.lib.service;

import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.model.UpdatedLog;

public interface UpdateLogService {
void createLog(UpdatedLog log);

void updateLog(UpdatedLog log);

Response getBy(Parameter parameter, String token);

Response create(Parameter parameter, String token);

Response getById(Parameter parameter, String token);

Response update(Parameter parameter, String token);

Response delete(Parameter parameter, String token);
}
