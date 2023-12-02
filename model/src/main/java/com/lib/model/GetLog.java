package com.lib.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetLog {
/**
 * 日志 id
 */
private Long logId;
/**
 * 调用方法所属的类
 */
private String className;
/**
 * 调用方法名
 */
private String method;
/**
 * 方法接收的参数
 */
private String parameter;
/**
 * 方法的返回结果
 */
private String returnValue;
/**
 * 方法耗时
 */
private Long elapsedTime;
/**
 * 方法运行起始时间
 */
private LocalDateTime runTime;
/**
 * 日志创建时间
 */
private LocalDateTime createTime;
/**
 * 日志创建者（方法调用者）
 */
private Integer createBy;

public static GetLog create() {
   return new GetLog();
}
}