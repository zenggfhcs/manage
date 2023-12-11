package com.lib.dao;

import com.lib.model.Book;
import com.lib.model.Parameter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper extends BaseMapper<Book> {

Book getById(Parameter<Book> parameter);

List<Book> getBy(Parameter<Book> parameter);

int create(Parameter<Book> parameter);

int update(Parameter<Book> parameter);

int delete(Parameter<Book> parameter);

Book getByUpdate(Parameter<Book> parameter);
}
