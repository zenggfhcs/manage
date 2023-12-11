package com.lib.dao;

import com.lib.model.BookInfo;
import com.lib.model.Parameter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookInfoMapper extends BaseMapper<BookInfo> {
BookInfo getById(Parameter<BookInfo> parameter);

List<BookInfo> getBy(Parameter<BookInfo> parameter);

int update(Parameter<BookInfo> parameter);

int create(Parameter<BookInfo> parameter);

int delete(Parameter<BookInfo> parameter);

BookInfo getByUpdate(Parameter<BookInfo> parameter);
}
