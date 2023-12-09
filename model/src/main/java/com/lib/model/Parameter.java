package com.lib.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 统一参数类，包含所有可能用到的参数
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parameter {
private static LocalDateTime MIN_TIME_DEFAULT_VALUE = LocalDateTime.of(2023, 1, 1, 0, 0);
private static LocalDateTime MAX_TIME_DEFAULT_VALUE = LocalDateTime.of(2038, 1, 1, 0, 0);
/**
 * token
 */
//private String token;

/**
 * id
 */
private Integer id;
/**
 * user
 */
private User user;
/**
 * log
 */
private GetLog gLog;
private UpdatedLog uLog;
private DeletedLog dLog;
/**
 * publish
 */
private Publisher publisher;
/**
 * bookInfo
 */
private BookInfo bookInfo;
/**
 * book
 */
private Book book;
/**
 * debit
 */
private Debit debit;
/**
 * 最后登录时间下限
 */
private LocalDateTime minLastLoginTime;
/**
 * 最后登录时间上限
 */
private LocalDateTime maxLastLoginTime;
/**
 * 创建时间下限
 */
private LocalDateTime minCreateTime;
/**
 * 创建时间上限
 */
private LocalDateTime maxCreateTime;
/**
 * 最后更新时间下限
 */
private LocalDateTime minUpdateTime;
/**
 * 最后更新时间上限
 */
private LocalDateTime maxUpdateTime;
/**
 * 最后更新时间下限
 */
private LocalDateTime minRunTime;
/**
 * 最后更新时间上限
 */
private LocalDateTime maxRunTime;
/**
 * 年龄下限
 */
private Integer minAge;
/**
 * 年龄上限
 */
private Integer maxAge;
/**
 * 分页查询-起始行
 */
private Integer pageStart;
/**
 * 分页查询-页长
 */
private Integer pageSize;
/**
 * 执行时间下限
 */
private Long minElapsedTime;
/**
 * 执行时间上限
 */
private Long maxElapsedTime;
/**
 * 请求者
 */
private TokenBody tokenBody;

public static Parameter createDefault() {
   Parameter p = new Parameter();
   {
      p.setMinCreateTime(MIN_TIME_DEFAULT_VALUE);
      p.setMaxCreateTime(MAX_TIME_DEFAULT_VALUE);
   }
   {
      p.setMinLastLoginTime(MIN_TIME_DEFAULT_VALUE);
      p.setMaxLastLoginTime(MAX_TIME_DEFAULT_VALUE);
   }
   {
      p.setMinRunTime(MIN_TIME_DEFAULT_VALUE);
      p.setMaxRunTime(MAX_TIME_DEFAULT_VALUE);
   }
   {
      p.setMinUpdateTime(MIN_TIME_DEFAULT_VALUE);
      p.setMaxUpdateTime(MAX_TIME_DEFAULT_VALUE);
   }
   {
      p.setMinAge(0);
      p.setMaxAge(300);
   }
   {
      p.setMinElapsedTime(0L);
      p.setMaxElapsedTime(3_600_000L);
   }
   {
      p.setPageStart(0);
      p.setPageSize(10);
   }
   return p;
}

}
