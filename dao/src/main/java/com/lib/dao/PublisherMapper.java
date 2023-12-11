package com.lib.dao;

import com.lib.model.Parameter;
import com.lib.model.Publisher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PublisherMapper extends BaseMapper<Publisher> {

Publisher getById(Parameter<Publisher> parameter);

List<Publisher> getBy(Parameter<Publisher> parameter);

int update(Parameter<Publisher> parameter);

int create(Parameter<Publisher> parameter);

int delete(Parameter<Publisher> parameter);

Publisher getByUpdate(Parameter<Publisher> parameter);
}
