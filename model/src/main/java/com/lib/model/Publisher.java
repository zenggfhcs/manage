package com.lib.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {
/**
 * 出版社 Id
 */
private Integer publishId;

/**
 * 出版社名称
 */
private String name;

/**
 * 备注
 */
private String remark;
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
 * 版本号、乐观锁
 */
private Integer revision;
}
