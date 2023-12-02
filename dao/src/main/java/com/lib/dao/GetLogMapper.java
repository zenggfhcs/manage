package com.lib.dao;

import com.lib.anno.AroundMapper;
import com.lib.model.GetLog;
import com.lib.model.Parameter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GetLogMapper {
@AroundMapper
List<GetLog> getBy(Parameter parameter);

int create(Parameter parameter);

@AroundMapper
GetLog getById(Parameter parameter);

int update(Parameter parameter);

int delete(Parameter parameter);

}
