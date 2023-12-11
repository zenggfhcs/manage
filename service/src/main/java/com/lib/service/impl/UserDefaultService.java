package com.lib.service.impl;

import com.lib.anno.AroundUpdate;
import com.lib.dao.UserMapper;
import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.model.User;
import com.lib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDefaultService extends BaseDefaultService<User> implements UserService {
private final UserMapper userMapper;

@Autowired
public UserDefaultService(UserMapper userMapper) {
   super(userMapper);
   this.userMapper = userMapper;
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
   return Response.success();
}


@Override
public Response create(Parameter<User> parameter) {
   return Response.success();
}

@Override
public Response getById(Parameter<User> parameter) {
   return Response.success();
}

@AroundUpdate
@Override
public Response update(Parameter<User> parameter) {
   return Response.error("更新失败");
}

@Override
public Response delete(Parameter<User> parameter) {
   return Response.success();
}

}

