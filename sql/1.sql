-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.34 - MySQL Community Server - GPL
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;


-- 导出 library 的数据库结构
CREATE DATABASE IF NOT EXISTS `library` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_bin */ /*!80016 DEFAULT ENCRYPTION = 'N' */;
USE `library`;

-- 导出  表 library.book 结构
CREATE TABLE IF NOT EXISTS `book`
(
    `book_id`           int       NOT NULL AUTO_INCREMENT COMMENT '图书唯一标识符',
    `book_damage_level` tinyint   NOT NULL DEFAULT '0' COMMENT '书籍破损级别',
    `borrowable`        bit(1)    NOT NULL DEFAULT (0) COMMENT '可借的',
    `book_info_id`      int       NOT NULL COMMENT '书籍信息id',
    `create_by`         int                DEFAULT NULL,
    `create_time`       timestamp NULL     DEFAULT (now()),
    `update_by`         int                DEFAULT NULL,
    `update_time`       timestamp NULL     DEFAULT (now()),
    `revision`          int       NOT NULL DEFAULT '0' COMMENT '乐观锁',
    PRIMARY KEY (`book_id`) USING BTREE,
    KEY `book_info_id` (`book_info_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb3
  COLLATE = utf8mb3_bin COMMENT ='书籍信息';

-- 正在导出表  library.book 的数据：~1 rows (大约)
DELETE
FROM `book`;
INSERT INTO `book` (`book_id`, `book_damage_level`, `borrowable`, `book_info_id`, `create_by`, `create_time`,
                    `update_by`, `update_time`, `revision`)
VALUES (1, 0, b'1', 1, 1, '2023-12-02 07:55:47', 1, '2023-12-02 07:55:47', 0);

-- 导出  表 library.book_info 结构
CREATE TABLE IF NOT EXISTS `book_info`
(
    `book_info_id`  int       NOT NULL AUTO_INCREMENT,
    `publish_id`    int       NOT NULL COMMENT '出版社 id',
    `publish_place` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT '' COMMENT '出版地',
    `isbn`          varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin  DEFAULT NULL COMMENT 'ISBN',
    `cip`           varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin  DEFAULT NULL COMMENT 'CIP 号',
    `book_name`     varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '图书名称',
    `book_type`     varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin  DEFAULT NULL COMMENT '图书类型：中图法分类',
    `cover`         varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '封面链接',
    `author`        varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '作者',
    `describe`      text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin COMMENT '描述',
    `publish_date`  date                                                   DEFAULT NULL COMMENT '出版日期',
    `keyword`       varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin  DEFAULT NULL COMMENT '主题词',
    `lang`          varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin  DEFAULT NULL COMMENT '正文语种',
    `price`         decimal(10, 2)                                         DEFAULT NULL COMMENT '价格',
    `stock`         int                                                    DEFAULT NULL COMMENT '库存量',
    `create_by`     int       NOT NULL                                     DEFAULT '1',
    `create_time`   timestamp NOT NULL                                     DEFAULT (now()),
    `update_by`     int                                                    DEFAULT NULL,
    `update_time`   timestamp NULL                                         DEFAULT (now()),
    `revision`      int       NOT NULL                                     DEFAULT '0' COMMENT '乐观锁',
    PRIMARY KEY (`book_info_id`) USING BTREE,
    UNIQUE KEY `isbn` (`isbn`),
    UNIQUE KEY `cip` (`cip`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb3
  COLLATE = utf8mb3_bin COMMENT ='书籍出版信息';

-- 正在导出表  library.book_info 的数据：~0 rows (大约)
DELETE
FROM `book_info`;
INSERT INTO `book_info` (`book_info_id`, `publish_id`, `publish_place`, `isbn`, `cip`, `book_name`, `book_type`,
                         `cover`, `author`, `describe`, `publish_date`, `keyword`, `lang`, `price`, `stock`,
                         `create_by`, `create_time`, `update_by`, `update_time`, `revision`)
VALUES (1, 1, '北京', '978-7-111-64343-2', '2019268688', 'Java核心技术', 'TP312.8JA',
        'http://10.3.107.194/public/bookbrain-static/img/af8c4dc3-60fb-4b62-8709-6068155a1a36.png',
        '(美)凯·S. 霍斯特曼(Cay S. Horstmann)著',
        '本书共分12章。第1章介绍了Java中的流库；第2章涵盖输入、输出处理，探讨了Java 11中引入的广受欢迎的改进和优化；第3章介绍了XML，展示如何解析XML文件、生成XML和使用XSL转换；第4章讲解了网络API，以及怎样连接到服务器、实现自己的服务器、创建HTTP连接，并讨论了新的HTTP客户端；第5章介绍了数据库编程，讲解JDBC，即Java数据库连接API；第6章涵盖如何使用新的日期和时间库来处理日历及时区；第7章讨论国际化；第8章介绍3种处理代码的技术；第9章讲解从Java 9开始引入的Java平台模块系统，以促进Java平台和核心类库的有序演化；第10章继续介绍Java安全模型，展示怎样编写类加载器和安全管理器，以及允许使用消息、代码签名、授权和认证及加密等重要特性的安全API；第11章讨论没有纳入卷Ⅰ的所有Swing知识；第12章介绍本地方法。',
        '2020-01-15', 'JAVA语言', 'chi', 149.00, 0, 1, '2023-11-25 02:25:36', NULL, '2023-11-25 02:25:36', 0);

-- 导出  表 library.debit 结构
CREATE TABLE IF NOT EXISTS `debit`
(
    `debit_id`        bigint    NOT NULL AUTO_INCREMENT,
    `book_id`         int       NOT NULL COMMENT '书籍 id',
    `return_deadline` date      NOT NULL COMMENT '最后归还日期',
    `return_date`     date               DEFAULT NULL COMMENT '实际归还日期',
    `create_by`       int       NOT NULL,
    `create_time`     timestamp NOT NULL DEFAULT (now()) COMMENT '（创建）借出时间',
    `update_by`       int       NOT NULL,
    `update_time`     timestamp NOT NULL DEFAULT (now()),
    `revision`        int       NOT NULL DEFAULT '0' COMMENT '乐观锁',
    PRIMARY KEY (`debit_id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb3
  COLLATE = utf8mb3_bin COMMENT ='借记\r\n借阅记录';

-- 正在导出表  library.debit 的数据：~0 rows (大约)
DELETE
FROM `debit`;

-- 导出  表 library.delete_log 结构
CREATE TABLE IF NOT EXISTS `delete_log`
(
    `log_id`       bigint                                                 NOT NULL AUTO_INCREMENT,
    `data_class`   varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL DEFAULT '' COMMENT '删除的数据类',
    `data_id`      int                                                    NOT NULL COMMENT '数据所属 id',
    `data`         text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin         NOT NULL COMMENT '数据',
    `elapsed_time` bigint                                                 NOT NULL DEFAULT '0' COMMENT '运行实耗时间',
    `create_time`  timestamp                                              NOT NULL DEFAULT (now()) COMMENT '创建',
    `create_by`    int                                                             DEFAULT NULL COMMENT '执行者',
    PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8mb3
  COLLATE = utf8mb3_bin COMMENT ='记录删除';

-- 正在导出表  library.delete_log 的数据：~6 rows (大约)
DELETE
FROM `delete_log`;
INSERT INTO `delete_log` (`log_id`, `data_class`, `data_id`, `data`, `elapsed_time`, `create_time`, `create_by`)
VALUES (1, '', 100, '', 0, '2023-12-09 02:25:21', 100),
       (2, 'com.lib.model.Publisher', 2, '', 0, '2023-12-09 02:40:15', 1),
       (3, 'com.lib.model.Publisher', 2, '{}', 0, '2023-12-09 02:50:40', 1),
       (4, 'com.lib.model.Publisher', 3,
        '{"publisher":{"createBy":1,"createTime":"2023-12-09 10:50:12","name":"人民邮电出版社","publishId":3,"remark":"re","revision":0,"updateBy":1,"updateTime":"2023-12-09 10:50:12"}}',
        0, '2023-12-09 02:50:45', 1),
       (5, 'com.lib.model.Publisher', 3, '{}', 19, '2023-12-09 02:53:25', 1),
       (6, 'com.lib.model.Publisher', 4,
        '{"publisher":{"createBy":1,"createTime":"2023-12-09 10:53:29","name":"人民邮电出版社","publishId":4,"remark":"re","revision":0,"updateBy":1,"updateTime":"2023-12-09 10:53:29"}}',
        15, '2023-12-09 02:53:35', 1);

-- 导出  表 library.enum 结构
CREATE TABLE IF NOT EXISTS `enum`
(
    `id`          int                                                   NOT NULL AUTO_INCREMENT,
    `group`       varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
    `key`         tinyint                                               NOT NULL DEFAULT '0',
    `value`       varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
    `create_by`   int                                                            DEFAULT NULL,
    `create_time` timestamp                                             NULL     DEFAULT (now()),
    `update_by`   int                                                            DEFAULT NULL,
    `update_time` timestamp                                             NULL     DEFAULT (now()),
    `revision`    int                                                   NOT NULL DEFAULT '0' COMMENT '乐观锁',
    `remark`      varchar(256) COLLATE utf8mb3_bin                               DEFAULT '',
    PRIMARY KEY (`id`),
    UNIQUE KEY `group_key` (`group`, `key`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8mb3
  COLLATE = utf8mb3_bin COMMENT ='枚举';

-- 正在导出表  library.enum 的数据：~6 rows (大约)
DELETE
FROM `enum`;
INSERT INTO `enum` (`id`, `group`, `key`, `value`, `create_by`, `create_time`, `update_by`, `update_time`, `revision`,
                    `remark`)
VALUES (1, 'sex', 0, '女', NULL, '2023-11-22 11:52:52', NULL, '2023-11-22 11:52:52', 0, ''),
       (2, 'sex', 1, '男', NULL, '2023-11-22 11:53:24', NULL, '2023-11-22 11:53:24', 0, ''),
       (3, 'book_damage_level', 0, '无损', NULL, '2023-11-22 12:07:11', NULL, '2023-11-22 12:07:11', 0, '全新'),
       (4, 'book_damage_level', 1, '轻微破损', NULL, '2023-11-22 12:07:11', NULL, '2023-11-22 12:07:11', 0,
        '封面、封底的轻微磨损、掉色、污渍、裂缝等'),
       (5, 'book_damage_level', 2, '中度破损', NULL, '2023-11-22 12:07:11', NULL, '2023-11-22 12:07:11', 0,
        '书页的断裂、缺失、残缺、虫蛀等'),
       (6, 'book_damage_level', 3, '重度破损', NULL, '2023-11-22 12:07:11', NULL, '2023-11-22 12:07:11', 0,
        '包括书叶大面积缺失、严重虫蛀、烧毁、水浸等');

-- 导出  表 library.get_log 结构
CREATE TABLE IF NOT EXISTS `get_log`
(
    `log_id`       bigint                                                 NOT NULL AUTO_INCREMENT,
    `class_name`   varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL DEFAULT '',
    `method`       varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin  NOT NULL DEFAULT '' COMMENT '方法名',
    `parameter`    text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin         NOT NULL COMMENT '参数',
    `return_value` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin COMMENT '返回值',
    `elapsed_time` bigint                                                 NOT NULL DEFAULT '0' COMMENT '运行实耗时间',
    `run_time`     timestamp                                              NOT NULL COMMENT '运行时刻',
    `create_time`  timestamp                                              NOT NULL DEFAULT (now()),
    `create_by`    int                                                             DEFAULT NULL COMMENT '执行者',
    PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb3
  COLLATE = utf8mb3_bin;

-- 正在导出表  library.get_log 的数据：~1 rows (大约)
DELETE
FROM `get_log`;
INSERT INTO `get_log` (`log_id`, `class_name`, `method`, `parameter`, `return_value`, `elapsed_time`, `run_time`,
                       `create_time`, `create_by`)
VALUES (1, 'com.lib.service.impl.PublisherDefaultService', 'getById',
        '{"id":2,"tokenBody":{"exp":1702689357,"id":1,"name":"admin"}}',
        '{"code":0,"data":{"createBy":1,"createTime":"2023-12-09 00:04:48","name":"人民邮电出版社","publishId":2,"remark":"re","revision":2,"updateBy":1,"updateTime":"2023-12-09 09:52:51"},"exp":"2023-12-09 09:55:27.588516800","msg":"success"}',
        10, '2023-12-09 01:55:28', '2023-12-09 01:55:27', 1),
       (2, 'com.lib.service.impl.PublisherDefaultService', 'getById',
        '{"id":2,"tokenBody":{"exp":1702689357,"id":1,"name":"admin"}}',
        '{"code":0,"data":{"createBy":1,"createTime":"2023-12-09 00:04:48","name":"人民邮电出版社","publishId":2,"remark":"re","revision":2,"updateBy":1,"updateTime":"2023-12-09 09:52:51"},"exp":"2023-12-09 10:35:41.527773700","msg":"success"}',
        30, '2023-12-09 02:35:41', '2023-12-09 02:35:41', 1);

-- 导出  表 library.login_log 结构
CREATE TABLE IF NOT EXISTS `login_log`
(
    `log_id` bigint NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`log_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb3
  COLLATE = utf8mb3_bin COMMENT ='记录登录';

-- 正在导出表  library.login_log 的数据：~0 rows (大约)
DELETE
FROM `login_log`;

-- 导出  表 library.publisher 结构
CREATE TABLE IF NOT EXISTS `publisher`
(
    `publish_id`  int                                                   NOT NULL AUTO_INCREMENT COMMENT '出版社 id',
    `name`        varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL DEFAULT '0' COMMENT '出版社名称',
    `remark`      varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin         DEFAULT NULL COMMENT '备注',
    `create_by`   int                                                   NOT NULL DEFAULT '1',
    `create_time` timestamp                                             NOT NULL DEFAULT (now()),
    `update_by`   int                                                            DEFAULT NULL,
    `update_time` timestamp                                             NOT NULL DEFAULT (now()),
    `revision`    int                                                   NOT NULL DEFAULT '0' COMMENT '乐观锁',
    PRIMARY KEY (`publish_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8mb3
  COLLATE = utf8mb3_bin;

-- 正在导出表  library.publisher 的数据：~1 rows (大约)
DELETE
FROM `publisher`;
INSERT INTO `publisher` (`publish_id`, `name`, `remark`, `create_by`, `create_time`, `update_by`, `update_time`,
                         `revision`)
VALUES (1, '机械工业出版社1', 'remark', 1, '2023-11-25 02:23:56', 1, '2023-12-09 01:30:14', 20);

-- 导出  表 library.update_log 结构
CREATE TABLE IF NOT EXISTS `update_log`
(
    `log_id`       bigint                                                 NOT NULL AUTO_INCREMENT,
    `data_class`   varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL DEFAULT '' COMMENT '修改的数据类',
    `data_id`      int                                                    NOT NULL COMMENT '数据所属 id',
    `old_data`     text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin         NOT NULL COMMENT '参数',
    `new_data`     text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin         NOT NULL COMMENT '返回值',
    `elapsed_time` bigint                                                 NOT NULL DEFAULT '0' COMMENT '运行实耗时间',
    `create_time`  timestamp                                              NOT NULL DEFAULT (now()) COMMENT '创建',
    `create_by`    int                                                             DEFAULT NULL COMMENT '执行者',
    PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 17
  DEFAULT CHARSET = utf8mb3
  COLLATE = utf8mb3_bin COMMENT ='记录更新';

-- 正在导出表  library.update_log 的数据：~15 rows (大约)
DELETE
FROM `update_log`;
INSERT INTO `update_log` (`log_id`, `data_class`, `data_id`, `old_data`, `new_data`, `elapsed_time`, `create_time`,
                          `create_by`)
VALUES (1, 'Publisher', 1, '',
        '{"id":1,"publisher":{"name":"机械工业出版社12"},"tokenBody":{"exp":1702209765,"id":1,"name":"admin"}}', 220,
        '2023-12-08 13:39:42', 1),
       (2, 'Publisher', 1,
        '{"id":1,"publisher":{"name":"机械工业出版社12","revision":8},"token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6ImFkbWluIiwiZXhwIjoxNzAyMjA5NzY1fQ.GEhy1TEdm-IrghQTcVcUekrt3K0WpJZ3zTriMUavq1g","tokenBody":{"exp":1702209765,"id":1,"name":"admin"}}',
        '{"id":1,"publisher":{"name":"机械工业出版社12"},"tokenBody":{"exp":1702209765,"id":1,"name":"admin"}}', 206,
        '2023-12-08 13:41:44', 1),
       (3, 'Publisher', 1,
        '{"id":1,"publisher":{"name":"机械工业出版社12","revision":9},"token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6ImFkbWluIiwiZXhwIjoxNzAyMjA5NzY1fQ.GEhy1TEdm-IrghQTcVcUekrt3K0WpJZ3zTriMUavq1g","tokenBody":{"exp":1702209765,"id":1,"name":"admin"}}',
        '{"id":1,"publisher":{"name":"机械工业出版社123"},"tokenBody":{"exp":1702209765,"id":1,"name":"admin"}}', 17,
        '2023-12-08 13:42:05', 1),
       (4, 'Publisher', 1,
        '{"id":1,"publisher":{"name":"机械工业出版社123","revision":10},"token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6ImFkbWluIiwiZXhwIjoxNzAyMjA5NzY1fQ.GEhy1TEdm-IrghQTcVcUekrt3K0WpJZ3zTriMUavq1g","tokenBody":{"exp":1702209765,"id":1,"name":"admin"}}',
        '{"id":1,"publisher":{"name":"机械工业出版社123"},"tokenBody":{"exp":1702209765,"id":1,"name":"admin"}}', 146,
        '2023-12-08 14:01:10', 1),
       (5, 'Publisher', 1, '',
        '{"id":1,"publisher":{"name":"机械工业出版社1234"},"tokenBody":{"exp":1702209765,"id":1,"name":"admin"}}', 0,
        '2023-12-08 14:13:35', 1),
       (6, 'Publisher', 1, '',
        '{"id":1,"publisher":{"name":"机械工业出版社1234"},"tokenBody":{"exp":1702209765,"id":1,"name":"admin"}}', 0,
        '2023-12-08 14:14:59', 1),
       (7, 'Publisher', 1, '',
        '{"id":1,"publisher":{"name":"机械工业出版社"},"tokenBody":{"exp":1702689357,"id":1,"name":"admin"}}', 0,
        '2023-12-09 01:18:01', 1),
       (8, 'Publisher', 1, '',
        '{"id":1,"publisher":{"name":"机械工业出版社1"},"tokenBody":{"exp":1702689357,"id":1,"name":"admin"}}', 0,
        '2023-12-09 01:22:18', 1),
       (9, 'Publisher', 1, '',
        '{"id":1,"publisher":{"name":"机械工业出版社"},"tokenBody":{"exp":1702689357,"id":1,"name":"admin"}}', 0,
        '2023-12-09 01:23:47', 1),
       (10, 'Publisher', 1, '',
        '{"id":1,"publisher":{"name":"机械工业出版社1"},"tokenBody":{"exp":1702689357,"id":1,"name":"admin"}}', 0,
        '2023-12-09 01:26:41', 1),
       (11, 'Publisher', 1, '{"id":1,"publisher":{"name":"机械工业出版社1","revision":18}}',
        '{"id":1,"publisher":{"name":"机械工业出版社1"},"tokenBody":{"exp":1702689357,"id":1,"name":"admin"}}', 126,
        '2023-12-09 01:28:20', 1),
       (12, 'Publisher', 1, '{"id":1,"publisher":{"name":"机械工业出版社1","revision":19}}',
        '{"id":1,"publisher":{"name":"机械工业出版社1"},"tokenBody":{"exp":1702689357,"id":1,"name":"admin"}}', 6,
        '2023-12-09 01:30:14', 1),
       (13, 'Publisher', 2, '{"id":2,"publisher":{"name":"人民邮电出版社","revision":0}}',
        '{"id":2,"publisher":{"name":"人民邮电出版社1"},"tokenBody":{"exp":1702689357,"id":1,"name":"admin"}}', 6,
        '2023-12-09 01:33:00', 1),
       (14, 'com.lib.model.Publisher', 2, '{"id":2,"publisher":{"name":"人民邮电出版社1","revision":1}}',
        '{"id":2,"publisher":{"name":"人民邮电出版社"},"tokenBody":{"exp":1702689357,"id":1,"name":"admin"}}', 63,
        '2023-12-09 01:52:51', 1),
       (15, 'com.lib.model.Publisher', 2, '{"id":2}', '{"id":2,"tokenBody":{"exp":1702689357,"id":1,"name":"admin"}}',
        0, '2023-12-09 02:35:59', 1),
       (16, 'com.lib.model.Publisher', 2, '{"id":2}', '{"id":2,"tokenBody":{"exp":1702689357,"id":1,"name":"admin"}}',
        0, '2023-12-09 02:38:06', 1);

-- 导出  表 library.user 结构
CREATE TABLE IF NOT EXISTS `user`
(
    `user_id`               int                                                   NOT NULL AUTO_INCREMENT COMMENT '用户id，自增',
    `authentication_string` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin        NOT NULL COMMENT '用户验证字符串',
    `display_name`          varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL DEFAULT '' COMMENT '用户名',
    `user_phone_number`     varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin          DEFAULT NULL COMMENT '电话',
    `state`                 int                                                   NOT NULL DEFAULT '3' COMMENT '状态聚合值',
    `authority`             int                                                   NOT NULL DEFAULT '0' COMMENT '权限聚合值',
    `user_email`            varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin         DEFAULT NULL COMMENT '邮箱',
    `email_normal`          varchar(255) COLLATE utf8mb3_bin GENERATED ALWAYS AS (concat_ws(_utf8mb3'@',
                                                                                            substring_index(
                                                                                                    substring_index(`user_email`, _utf8mb4'@', 1),
                                                                                                    _utf8mb4'+', 1),
                                                                                            substring_index(`user_email`, _utf8mb4'@', -(1)))) VIRTUAL,
    `surname`               varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL DEFAULT '0' COMMENT '姓',
    `name`                  varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL DEFAULT '0' COMMENT '名',
    `age`                   tinyint                                               NOT NULL COMMENT '年龄',
    `sex`                   tinyint                                               NOT NULL COMMENT '性别',
    `last_login_time`       timestamp                                             NOT NULL DEFAULT (now()),
    `create_by`             int                                                            DEFAULT NULL COMMENT '创建者',
    `create_time`           timestamp                                             NOT NULL DEFAULT (now()) COMMENT '创建时间',
    `update_by`             int                                                            DEFAULT NULL COMMENT '最后一次更新者',
    `update_time`           timestamp                                             NOT NULL DEFAULT (now()) COMMENT '最后一次更新时间',
    `revision`              int                                                   NOT NULL DEFAULT '0' COMMENT '乐观锁',
    PRIMARY KEY (`user_id`) USING BTREE,
    UNIQUE KEY `user_email` (`user_email`) USING BTREE,
    UNIQUE KEY `user_phone_number` (`user_phone_number`) USING BTREE,
    UNIQUE KEY `email_normal` (`email_normal`),
    KEY `surname_name` (`surname`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb3
  COLLATE = utf8mb3_bin;

-- 正在导出表  library.user 的数据：~1 rows (大约)
DELETE
FROM `user`;
INSERT INTO `user` (`user_id`, `authentication_string`, `display_name`, `user_phone_number`, `state`, `authority`,
                    `user_email`, `surname`, `name`, `age`, `sex`, `last_login_time`, `create_by`, `create_time`,
                    `update_by`, `update_time`, `revision`)
VALUES (1, 'e10adc3949ba59abbe56e057f20f883e', 'admin', '18156825621', 3, 0, '1635276938+123@qq.com', 'zeng', '0', 21,
        1, '2023-11-25 07:49:54', 1, '2023-11-22 12:38:31', NULL, '2023-11-25 04:16:26', 0);

/*!40103 SET TIME_ZONE = IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE = IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS = IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES = IFNULL(@OLD_SQL_NOTES, 1) */;
