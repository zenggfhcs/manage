package com.lib.dao;

import com.lib.model.DeletedLog;
import com.lib.model.Parameter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeletedLogMapper extends BaseMapper<DeletedLog> {
DeletedLog getById(Parameter<DeletedLog> parameter);

List<DeletedLog> getBy(Parameter<DeletedLog> parameter);

int create(Parameter<DeletedLog> parameter);

int update(Parameter<DeletedLog> parameter);

int delete(Parameter<DeletedLog> parameter);

DeletedLog getByUpdate(Parameter<DeletedLog> parameter);
}
