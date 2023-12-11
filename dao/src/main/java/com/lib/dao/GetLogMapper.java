package com.lib.dao;

import com.lib.model.GetLog;
import com.lib.model.Parameter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GetLogMapper extends BaseMapper<GetLog> {
GetLog getById(Parameter<GetLog> parameter);

List<GetLog> getBy(Parameter<GetLog> parameter);

int create(Parameter<GetLog> parameter);

int update(Parameter<GetLog> parameter);

int delete(Parameter<GetLog> parameter);

GetLog getByUpdate(Parameter<GetLog> parameter);

}
