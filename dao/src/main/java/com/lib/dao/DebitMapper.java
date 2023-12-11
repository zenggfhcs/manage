package com.lib.dao;

import com.lib.model.Debit;
import com.lib.model.Parameter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DebitMapper extends BaseMapper<Debit> {
Debit getById(Parameter<Debit> parameter);

List<Debit> getBy(Parameter<Debit> parameter);

int create(Parameter<Debit> parameter);

int update(Parameter<Debit> parameter);

int delete(Parameter<Debit> parameter);

Debit getByUpdate(Parameter<Debit> parameter);
}
