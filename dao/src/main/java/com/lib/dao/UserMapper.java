package com.lib.dao;

import com.lib.model.Parameter;
import com.lib.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {

List<User> getBy(Parameter parameter);


int create(Parameter parameter);


User getById(Parameter parameter);


int delete(Parameter parameter);


int update(Parameter parameter);


int has(Parameter parameter);

int login(Parameter parameter);
}
