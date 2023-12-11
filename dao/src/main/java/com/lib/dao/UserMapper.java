package com.lib.dao;

import com.lib.model.Parameter;
import com.lib.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper extends BaseMapper<User> {

List<User> getBy(Parameter<User> parameter);

int create(Parameter<User> parameter);

User getById(Parameter<User> parameter);

int delete(Parameter<User> parameter);

int update(Parameter<User> parameter);

User getByUpdate(Parameter<User> parameter);

int has(Parameter<User> parameter);

int login(Parameter<User> parameter);
}
