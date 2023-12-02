package com.lib.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatedLog {
/**
 * 日志 id
 */
private Long logId;
/**
 * 修改的数据类名
 */
private String dataClass;
/**
 * 数据 id
 */
private Integer dataId;
/**
 * 旧的数据
 */
private String oldData;
/**
 * 新的数据
 */
private String newData;
/**
 * 日志创建时间
 */
private LocalDateTime createTime;
/**
 * 日志创建者（方法调用者）
 */
private Integer createBy;
}
