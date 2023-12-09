package com.lib.dao;

import com.lib.model.Parameter;
import com.lib.model.Publisher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PublisherMapper {

Publisher getById(Parameter parameter);


List<Publisher> getBy(Parameter parameter);


int update(Parameter parameter);


int create(Parameter parameter);

int delete(Parameter parameter);

Publisher getByUpdate(Parameter parameter);
}
