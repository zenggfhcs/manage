package com.lib.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * book 实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
/**
 * 书籍唯一标识
 */
private Integer bookId;

/**
 * 书籍破损级别
 */
private Short bookDamageLevel;

/**
 * 可借的
 */
private Boolean borrowable;

/**
 * 书籍出版信息
 */
private BookInfo bookInfo;
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
}
