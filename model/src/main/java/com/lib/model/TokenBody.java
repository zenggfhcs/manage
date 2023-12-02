package com.lib.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * token body
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenBody {
/**
 * 用户 id
 */
private Integer userId;
/**
 * 用户名
 */
private String userName;
/**
 * 到期时间
 */
private Long exp;
}
