package com.lib.service.impl;

import com.lib.dao.UserMapper;
import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.model.User;
import com.lib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDefaultService implements UserService {
private final UserMapper userMapper;
private final BaseDefaultService<User> baseService;
@Autowired
public UserDefaultService(UserMapper userMapper) {
   this.userMapper = userMapper;
   baseService = new BaseDefaultService<>(userMapper);
}


@Override
public Response login(Parameter<User> parameter) {
   boolean loginSuccess = userMapper.login(parameter) == 1;
   if (loginSuccess) {
      return Response.success();
   }
   
   /* -------- 异常提示 -------- */
   return Response.error("用户ID或密码无效");
}


/**
 * 聚合查询
 *
 * @return 聚合查询结果
 */
@Override
public Response getBy(Parameter<User> parameter) {
   return baseService.getBy(parameter);
}


@Override
public Response create(Parameter<User> parameter) {
   return baseService.create(parameter);
}

@Override
public Response getById(Parameter<User> parameter) {
   return baseService.getById(parameter);
}


@Override
public Response update(Parameter<User> parameter) {
   return baseService.update(parameter);
}

@Override
public Response delete(Parameter<User> parameter) {
   return baseService.delete(parameter);
}

}

