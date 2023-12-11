package com.lib.dao;

import com.lib.model.Parameter;
import com.lib.model.UpdateLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UpdatedLogMapper extends BaseMapper<UpdateLog> {
UpdateLog getById(Parameter<UpdateLog> parameter);

List<UpdateLog> getBy(Parameter<UpdateLog> parameter);

int create(Parameter<UpdateLog> parameter);

int update(Parameter<UpdateLog> parameter);

int delete(Parameter<UpdateLog> parameter);

UpdateLog getByUpdate(Parameter<UpdateLog> parameter);
}
