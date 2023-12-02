package com.lib.dao;

import com.lib.anno.AroundMapper;
import com.lib.model.BookInfo;
import com.lib.model.Parameter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookInfoMapper {
@AroundMapper
List<BookInfo> getBy(Parameter parameter);

@AroundMapper
BookInfo getById(Parameter parameter);

int update(Parameter parameter);

int delete(Parameter parameter);

int create(Parameter parameter);
}
