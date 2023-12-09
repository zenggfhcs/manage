package com.lib.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
/**
 * 用户 id
 */
private Integer userId;
/**
 * 用户验证字符串
 */
private String authenticationString;

/**
 * 用户名
 */
private String displayName;
/**
 * 用户邮箱
 */
private String userEmail;

/**
 * 用户电话号码
 */
private String userPhoneNumber;

/**
 * 已启用
 */
private Integer state;

/**
 * 权限聚合值
 */
private Integer authority;
/**
 * 姓
 */
private String surname;
/**
 * 名
 */
private String name;
/**
 * 性别
 */
private Short sex;
/**
 * 年龄
 */
private Short age;
/**
 * 最后登录时间
 */
private LocalDateTime lastLoginTime;
/**
 * 创建人
 */
private Integer createBy;

/**
 * 创建时间
 */
private LocalDateTime createTime;

/**
 * 最后更新者
 */
private Integer updateBy;

/**
 * 最后更新时间
 */
private LocalDateTime updateTime;

/**
 * 版本号，乐观锁
 */
private Integer revision;

/**
 * 测试是否具有对应权限
 *
 * @param a 权限类型
 * @return 权限检查结果
 */
public boolean hasAuthority(Authority a) {
   return ((authority >> a.ordinal()) & 1) == 1;
}

public void updateAuthority(Authority a, Condition c) {
   authority = set(authority, a.ordinal(), c.ordinal());
}

public boolean isState(State s) {
   return ((state >> s.ordinal()) & 1) == 1;
}

public void updateState(State s, Condition c) {
   state = set(state, s.ordinal(), c.ordinal());
}

private int set(int a, int i, int b) {
   return a & ~(1 << i) | (b << i);
}

/**
 * 权限枚举
 */
public enum Authority {
   //   A_UPDATE,
   BOOK_CREATE, BOOK_UPDATE, BOOK_DELETE, USER_CREATE, USER_UPDATE, USER_DELETE,
}

/**
 * 状态枚举
 */
public enum State {
   IS_DELETE, // 已删除
   IS_ENABLE, // 已启用
   EMAIL_VERIFIED, // 邮箱已验证
   PHONENUMBER_VERIFIED, // 电话号码已验证
}

public enum Condition {
   DISABLE,
   ENABLE,  // 开、是、is
}
}
