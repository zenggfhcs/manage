package com.lib.dao;

import com.lib.anno.AroundMapper;
import com.lib.model.Parameter;
import com.lib.model.Publisher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PublisherMapper {
@AroundMapper
Publisher getById(Parameter parameter);

@AroundMapper
List<Publisher> getBy(Parameter parameter);

@AroundMapper
int update(Parameter parameter);

@AroundMapper
int create(Parameter parameter);

@AroundMapper
int delete(Parameter parameter);
}
