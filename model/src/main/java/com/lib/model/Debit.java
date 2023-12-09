package com.lib.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Debit {
/**
 *
 */
private Long debitId;
/**
 *
 */
private Book book;
/**
 *
 */
private LocalDate returnDeadline;
/**
 *
 */
private LocalDate returnDate;
/**
 *
 */
private Integer createBy;
/**
 *
 */
private LocalDateTime createTime;
/**
 *
 */
private Integer updateBy;
/**
 *
 */
private LocalDateTime updateTime;
/**
 *
 */
private Integer revision;
}
