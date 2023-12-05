package com.lib.dao;

import com.lib.anno.AroundGet;
import com.lib.model.Parameter;
import com.lib.model.Publisher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PublisherMapper {
@AroundGet
Publisher getById(Parameter parameter);

@AroundGet
List<Publisher> getBy(Parameter parameter);

@AroundGet
int update(Parameter parameter);

@AroundGet
int create(Parameter parameter);

@AroundGet
int delete(Parameter parameter);
}
