package com.lib.service;

import com.lib.model.DeletedLog;
import com.lib.model.Parameter;
import com.lib.model.Response;

public interface DeleteLogService {
void createLog(DeletedLog log);

void updateLog(DeletedLog log);

Response getBy(Parameter parameter, String token);

Response create(Parameter parameter, String token);

Response getById(Parameter parameter, String token);

Response update(Parameter parameter, String token);

Response delete(Parameter parameter, String token);
}
