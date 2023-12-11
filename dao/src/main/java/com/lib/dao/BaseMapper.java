package com.lib.dao;

import com.lib.model.BaseEntity;
import com.lib.model.Parameter;

import java.util.List;

public interface BaseMapper<T extends BaseEntity> {

T getById(Parameter<T> parameter);


List<T> getBy(Parameter<T> parameter);


int update(Parameter<T> parameter);


int create(Parameter<T> parameter);

int delete(Parameter<T> parameter);

T getByUpdate(Parameter<T> parameter);
}
