package com.lib.service.impl;

import com.lib.dao.BaseMapper;
import com.lib.model.BaseEntity;
import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.service.BaseService;

import java.util.List;

public class BaseDefaultService<T extends BaseEntity> implements BaseService<T> {
protected final BaseMapper<T> baseMapper;

public BaseDefaultService(BaseMapper<T> baseMapper) {
   this.baseMapper = baseMapper;
}


@Override
public Response getById(Parameter<T> parameter) {
   T _t = baseMapper.getById(parameter);
   if (_t == null) {
      return Response.error("不存在");
   }
   return Response.success(_t);
}

@Override
public Response getBy(Parameter<T> parameter) {
   List<T> _list = baseMapper.getBy(parameter);
   return Response.success(_list);
}

@Override
public Response create(Parameter<T> parameter) {
   if (parameter.getEntity() == null) {
      return Response.error("需要新建的 xx 信息为空");
   }
   
   int _cc = baseMapper.create(parameter);
   
   if (_cc == 0) {
      return Response.error("新建失败");
   }
   return Response.success();
}

@Override
public Response update(Parameter<T> parameter) {
   // 新数据
   T _newEntityData = parameter.getEntity();
   // 空数据处理
   if (_newEntityData == null) {
      return Response.error("更新数据为空");
   }
   // 获取原始数据
   T _oldEntityData = baseMapper.getByUpdate(parameter);
   // 空数据处理
   if (_oldEntityData == null) {
      return Response.error("旧数据异常");
   }
   // 设置版本号（乐观锁）
   _newEntityData.setRevision(_oldEntityData.getRevision());
   // 更新
   int _uc = baseMapper.update(parameter);
   // old replace new
   parameter.setEntity(_newEntityData);
   // 判断结果
   if (_uc == 0) {
      return Response.error("更新失败");
   }
   return Response.success();
}


@Override
public Response delete(Parameter<T> parameter) {
   T _entity = baseMapper.getById(parameter);
   if (_entity == null) {
      return Response.error("该 id 不存在对应的 publisher");
   }
   int _dc = baseMapper.delete(parameter);
   if (_dc == 0) {
      return Response.error("删除失败");
   }
   parameter.setEntity(_entity);
   return Response.success();
}
}
