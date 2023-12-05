package com.lib.dao;

import com.lib.anno.AroundGet;
import com.lib.model.BookInfo;
import com.lib.model.Parameter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookInfoMapper {
@AroundGet
List<BookInfo> getBy(Parameter parameter);

@AroundGet
BookInfo getById(Parameter parameter);

int update(Parameter parameter);

int delete(Parameter parameter);

int create(Parameter parameter);
}
