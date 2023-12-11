package com.lib.service;

import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.model.User;

public interface UserService {
Response login(Parameter<User> parameter);

Response getBy(Parameter<User>  parameter);

Response create(Parameter<User>  parameter);

Response getById(Parameter<User>  parameter);

Response update(Parameter<User>  parameter);

Response delete(Parameter<User>  parameter);


}

