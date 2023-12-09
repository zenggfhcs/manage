package com.lib.service.impl;

import com.lib.anno.AroundGet;
import com.lib.anno.AroundUpdate;
import com.lib.anno.BeforeService;
import com.lib.dao.UserMapper;
import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.model.User;
import com.lib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDefaultService implements UserService {
private final UserMapper userMapper;

@Autowired
public UserDefaultService(UserMapper userMapper) {
   this.userMapper = userMapper;
}


@BeforeService
@Override
public Response login(Parameter parameter, String token) {
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
@AroundGet
@Override
public Response getBy(Parameter parameter, String token) {
   List<User> list = userMapper.getBy(parameter);
   if (list != null) {
      return Response.success(list);
   }
   
   /* -------- 异常提示 -------- */
   return Response.error("查询出错");
}


@Override
public Response create(Parameter parameter, String token) {
   int value = userMapper.create(parameter);
   if (value == 1) {
      return Response.success();
   }
   /* -------- 异常提示 -------- */
   return Response.error("出现错误，添加失败");
}

@AroundGet
@Override
public Response getById(Parameter parameter, String token) {
   User user = userMapper.getById(parameter);
   if (user != null) {
      return Response.success(user);
   }
   /* -------- 异常提示 -------- */
   return Response.error("用户ID无效 / 用户不存在");
}

@AroundUpdate
@Override
public Response update(Parameter parameter, String token) {
   User user = userMapper.getById(parameter);
   
   int value = userMapper.update(parameter);
   if (value == 1) {
      parameter.setUser(user);
      return Response.success();
   }
   
   /* -------- 异常提示 -------- */
   return Response.error("更新失败");
}

@Override
public Response delete(Parameter parameter, String token) {
   {
      /* -------- 检验数据 -------- */
      User user = userMapper.getById(parameter);
      if (user == null) {
         return Response.error("该用户不存在");
      }
      if (user.isState(User.State.IS_DELETE)) {
         return Response.error("该用户已删除");
      }
      
      /* -------- 设置用户状态：已删除 -------- */
      user.updateState(User.State.IS_DELETE, User.Condition.ENABLE);
      
      /* -------- 模拟删除 -------- */
      userMapper.delete(parameter);
   }
   
   return Response.success();
}

}

