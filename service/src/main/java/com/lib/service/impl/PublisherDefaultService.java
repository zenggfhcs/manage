package com.lib.service.impl;

import com.lib.anno.AroundDelete;
import com.lib.anno.AroundGet;
import com.lib.anno.AroundUpdate;
import com.lib.anno.BeforeService;
import com.lib.dao.PublisherMapper;
import com.lib.model.Parameter;
import com.lib.model.Publisher;
import com.lib.model.Response;
import com.lib.service.PublisherService;
import org.springframework.stereotype.Service;

@Service
public class PublisherDefaultService implements PublisherService {
private final PublisherMapper publisherMapper;

public PublisherDefaultService(PublisherMapper publisherMapper) {
   this.publisherMapper = publisherMapper;
}

@AroundGet
@Override
public Response getById(Parameter parameter, String token) {
   Publisher publisher = publisherMapper.getById(parameter);
   if (publisher == null) {
      return Response.error("该出版社不存在");
   }
   return Response.success(publisher);
}

@BeforeService
@Override
public Response getBy(Parameter parameter, String token) {
   return Response.success();
}
@BeforeService
@Override
public Response create(Parameter parameter, String token) {
   int _cc = publisherMapper.create(parameter);
   if (_cc == 0) {
       return Response.error("新建失败");
   }
   return Response.success();
}

@AroundUpdate
@Override
public Response update(Parameter parameter, String token) {
   // 新数据
   Publisher newPublisher = parameter.getPublisher();
   // 空数据处理
   if (newPublisher == null) {
      return Response.error("更新数据为空");
   }
   // 获取原始数据
   Publisher oldPublisher = publisherMapper.getByUpdate(parameter);
   // 空数据处理
   if (oldPublisher == null) {
      return Response.error("旧数据异常");
   }
   // 设置版本号（乐观锁）
   newPublisher.setRevision(oldPublisher.getRevision());
   // 更新
   int uc = publisherMapper.update(parameter);
   // old replace new
   parameter.setPublisher(oldPublisher);
   // 判断结果
   if (uc == 0) {
      return Response.error("更新失败");
   }
   return Response.success();
}

@AroundDelete
@Override
public Response delete(Parameter parameter, String token) {
   Publisher _publisher = publisherMapper.getById(parameter);
   if (_publisher == null) {
      return Response.error("该 id 不存在对应的出版社");
   }
   int _dc = publisherMapper.delete(parameter);
   if (_dc == 0) {
       return Response.error("删除失败");
   }
   parameter.setPublisher(_publisher);
   return Response.success();
}
}
