package com.lib.dao;

import com.lib.anno.AroundGet;
import com.lib.model.Parameter;
import com.lib.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {
@AroundGet
List<User> getBy(Parameter parameter);

@AroundGet
int create(Parameter parameter);

@AroundGet
User getById(Parameter parameter);

@AroundGet
int delete(Parameter parameter);

@AroundGet
int update(Parameter parameter);

@AroundGet
int has(Parameter parameter);

int login(Parameter parameter);
}
