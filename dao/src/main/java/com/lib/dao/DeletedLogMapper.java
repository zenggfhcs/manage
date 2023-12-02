package com.lib.dao;

import com.lib.model.DeletedLog;
import com.lib.model.Parameter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeletedLogMapper {
List<DeletedLog> getBy(Parameter parameter);

int create(Parameter parameter);

DeletedLog getById(Parameter parameter);

int update(Parameter parameter);

int delete(Parameter parameter);
}
