package com.lib.dao;

import com.lib.model.Book;
import com.lib.model.Parameter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
List<Book> getBy(Parameter parameter);

int create(Parameter parameter);

Book getById(Parameter parameter);

int update(Parameter parameter);

int delete(Parameter parameter);
}
