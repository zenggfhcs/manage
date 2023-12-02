package com.lib.dao;

import com.lib.anno.AroundMapper;
import com.lib.model.Parameter;
import com.lib.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {
@AroundMapper
List<User> getBy(Parameter parameter);

@AroundMapper
int create(Parameter parameter);

@AroundMapper
User getById(Parameter parameter);

@AroundMapper
int delete(Parameter parameter);

@AroundMapper
int update(Parameter parameter);

@AroundMapper
int has(Parameter parameter);

int login(Parameter parameter);
}
