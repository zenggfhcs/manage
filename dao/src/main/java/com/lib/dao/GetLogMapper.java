package com.lib.dao;

import com.lib.model.GetLog;
import com.lib.model.Parameter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GetLogMapper {

List<GetLog> getBy(Parameter parameter);

int create(Parameter parameter);


GetLog getById(Parameter parameter);

int update(Parameter parameter);

int delete(Parameter parameter);

}
