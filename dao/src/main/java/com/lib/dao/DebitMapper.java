package com.lib.dao;

import com.lib.model.Debit;
import com.lib.model.Parameter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DebitMapper {
List<Debit> getBy(Parameter parameter);

int create(Parameter parameter);

Debit getById(Parameter parameter);

int update(Parameter parameter);

int delete(Parameter parameter);
}
