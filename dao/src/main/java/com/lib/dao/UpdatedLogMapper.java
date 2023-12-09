package com.lib.dao;

import com.lib.model.Parameter;
import com.lib.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UpdatedLogMapper {

List<User> getBy(Parameter parameter);

void create(Parameter parameter);


User getById(Parameter parameter);


int delete(Parameter parameter);


int update(Parameter parameter);
}
