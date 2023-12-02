package com.lib.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * bookinfo 实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookInfo {
/**
 * 书籍信息 Id
 */
private Integer bookInfoId;

/**
 * 出版社
 */
private Publisher publisher;

/**
 * 出版地
 */
private String publishPlace;

/**
 * 书籍 ISBN 号
 */
private String isbn;

/**
 * CIP 核验号
 */
private String cip;

/**
 * 书籍名称
 */
private String bookName;

/**
 * 书籍类型
 */
private String bookType;

/**
 * 书籍封面
 */
private String cover;

/**
 * 作者
 */
private String author;

/**
 * 书籍描述
 */
private String describe;

/**
 * 出版时间
 */
private LocalDate publishDate;

/**
 * 关键字
 */
private String keyword;

/**
 * 正文语种
 */
private String lang;

/**
 * 出版价格
 */
private Double price;

/**
 * 库存量
 */
private Integer stock;

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
