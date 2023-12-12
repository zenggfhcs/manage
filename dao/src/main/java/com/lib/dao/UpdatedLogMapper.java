package com.lib.dao;

import com.lib.model.Parameter;
import com.lib.model.UpdatedLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UpdatedLogMapper extends BaseMapper<UpdatedLog> {
UpdatedLog getById(Parameter<UpdatedLog> parameter);

List<UpdatedLog> getBy(Parameter<UpdatedLog> parameter);

int create(Parameter<UpdatedLog> parameter);

int update(Parameter<UpdatedLog> parameter);

int delete(Parameter<UpdatedLog> parameter);

UpdatedLog getByUpdate(Parameter<UpdatedLog> parameter);
}
