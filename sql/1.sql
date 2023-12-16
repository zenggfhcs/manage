CREATE DATABASE  IF NOT EXISTS `library` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `library`;
-- MySQL dump 10.13  Distrib 8.0.35, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: library
-- ------------------------------------------------------
-- Server version	8.0.35-0ubuntu0.22.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
                        `book_id` int NOT NULL AUTO_INCREMENT COMMENT '图书唯一标识符',
                        `book_damage_level` tinyint NOT NULL DEFAULT '0' COMMENT '书籍破损级别',
                        `borrowable` bit(1) NOT NULL DEFAULT (0) COMMENT '可借的',
                        `book_info_id` int NOT NULL COMMENT '书籍信息id',
                        `create_by` int DEFAULT NULL,
                        `create_time` timestamp NULL DEFAULT (now()),
                        `update_by` int DEFAULT NULL,
                        `update_time` timestamp NULL DEFAULT (now()),
                        `revision` int NOT NULL DEFAULT '0' COMMENT '乐观锁',
                        PRIMARY KEY (`book_id`) USING BTREE,
                        KEY `book_info_id` (`book_info_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='书籍信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `book_info`
--

DROP TABLE IF EXISTS `book_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_info` (
                             `book_info_id` int NOT NULL AUTO_INCREMENT,
                             `publish_id` int NOT NULL COMMENT '出版社 id',
                             `publish_place` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT '' COMMENT '出版地',
                             `isbn` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'ISBN',
                             `cip` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'CIP 号',
                             `book_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '图书名称',
                             `book_type` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '图书类型：中图法分类',
                             `cover` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '封面链接',
                             `author` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '作者',
                             `describe` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin COMMENT '描述',
                             `publish_date` date DEFAULT NULL COMMENT '出版日期',
                             `keyword` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '主题词',
                             `lang` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '正文语种',
                             `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
                             `stock` int DEFAULT NULL COMMENT '库存量',
                             `create_by` int NOT NULL DEFAULT '1',
                             `create_time` timestamp NOT NULL DEFAULT (now()),
                             `update_by` int DEFAULT NULL,
                             `update_time` timestamp NULL DEFAULT (now()),
                             `revision` int NOT NULL DEFAULT '0' COMMENT '乐观锁',
                             PRIMARY KEY (`book_info_id`) USING BTREE,
                             UNIQUE KEY `isbn` (`isbn`),
                             UNIQUE KEY `cip` (`cip`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='书籍出版信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `debit`
--

DROP TABLE IF EXISTS `debit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `debit` (
                         `debit_id` bigint NOT NULL AUTO_INCREMENT,
                         `book_id` int NOT NULL COMMENT '书籍 id',
                         `return_deadline` date NOT NULL COMMENT '最后归还日期',
                         `return_date` date DEFAULT NULL COMMENT '实际归还日期',
                         `create_by` int NOT NULL,
                         `create_time` timestamp NOT NULL DEFAULT (now()) COMMENT '（创建）借出时间',
                         `update_by` int NOT NULL,
                         `update_time` timestamp NOT NULL DEFAULT (now()),
                         `revision` int NOT NULL DEFAULT '0' COMMENT '乐观锁',
                         PRIMARY KEY (`debit_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='借记\r\n借阅记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `delete_log`
--

DROP TABLE IF EXISTS `delete_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delete_log` (
                              `log_id` bigint NOT NULL AUTO_INCREMENT,
                              `data_class` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL DEFAULT '' COMMENT '删除的数据类',
                              `data_id` int NOT NULL COMMENT '数据所属 id',
                              `data` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '数据',
                              `elapsed_time` bigint NOT NULL DEFAULT '0' COMMENT '运行实耗时间',
                              `create_time` timestamp NOT NULL DEFAULT (now()) COMMENT '创建',
                              `create_by` int DEFAULT NULL COMMENT '执行者',
                              PRIMARY KEY (`log_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='记录删除';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `enum`
--

DROP TABLE IF EXISTS `enum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enum` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `group` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
                        `key` tinyint NOT NULL DEFAULT '0',
                        `value` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
                        `create_by` int DEFAULT NULL,
                        `create_time` timestamp NULL DEFAULT (now()),
                        `update_by` int DEFAULT NULL,
                        `update_time` timestamp NULL DEFAULT (now()),
                        `revision` int NOT NULL DEFAULT '0' COMMENT '乐观锁',
                        `remark` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT '',
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `group_key` (`group`,`key`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='枚举';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `get_log`
--

DROP TABLE IF EXISTS `get_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `get_log` (
                           `log_id` bigint NOT NULL AUTO_INCREMENT,
                           `class_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL DEFAULT '',
                           `method` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL DEFAULT '' COMMENT '方法名',
                           `payload` text COLLATE utf8mb3_bin NOT NULL COMMENT '参数',
                           `return_value` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin COMMENT '返回值',
                           `elapsed_time` bigint NOT NULL DEFAULT '0' COMMENT '运行实耗时间',
                           `create_time` timestamp NOT NULL DEFAULT (now()),
                           `create_by` int DEFAULT NULL COMMENT '执行者',
                           PRIMARY KEY (`log_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `login_log`
--

DROP TABLE IF EXISTS `login_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login_log` (
                             `log_id` bigint NOT NULL AUTO_INCREMENT,
                             PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='记录登录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `publisher`
--

DROP TABLE IF EXISTS `publisher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publisher` (
                             `publish_id` int NOT NULL AUTO_INCREMENT COMMENT '出版社 id',
                             `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL DEFAULT '0' COMMENT '出版社名称',
                             `remark` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '备注',
                             `create_by` int NOT NULL DEFAULT '1',
                             `create_time` timestamp NOT NULL DEFAULT (now()),
                             `update_by` int DEFAULT NULL,
                             `update_time` timestamp NOT NULL DEFAULT (now()),
                             `revision` int NOT NULL DEFAULT '0' COMMENT '乐观锁',
                             PRIMARY KEY (`publish_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `update_log`
--

DROP TABLE IF EXISTS `update_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `update_log` (
                              `log_id` bigint NOT NULL AUTO_INCREMENT,
                              `data_class` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL DEFAULT '' COMMENT '修改的数据类',
                              `data_id` int NOT NULL COMMENT '数据所属 id',
                              `old_data` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '参数',
                              `new_data` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '返回值',
                              `elapsed_time` bigint NOT NULL DEFAULT '0' COMMENT '运行实耗时间',
                              `create_time` timestamp NOT NULL DEFAULT (now()) COMMENT '创建',
                              `create_by` int DEFAULT NULL COMMENT '执行者',
                              PRIMARY KEY (`log_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='记录更新';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
                        `user_id` int NOT NULL AUTO_INCREMENT COMMENT '用户id，自增',
                        `authentication_string` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '用户验证字符串',
                        `display_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL DEFAULT '' COMMENT '用户名',
                        `user_phone_number` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '电话',
                        `state` int NOT NULL DEFAULT '3' COMMENT '状态聚合值',
                        `authority` int NOT NULL DEFAULT '0' COMMENT '权限聚合值',
                        `user_email` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '邮箱',
                        `email_normal` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin GENERATED ALWAYS AS (concat_ws(_utf8mb3'@',substring_index(substring_index(`user_email`,_utf8mb4'@',1),_utf8mb4'+',1),substring_index(`user_email`,_utf8mb4'@',-(1)))) VIRTUAL,
                        `surname` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL DEFAULT '0' COMMENT '姓',
                        `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL DEFAULT '0' COMMENT '名',
                        `age` tinyint NOT NULL COMMENT '年龄',
                        `sex` tinyint NOT NULL COMMENT '性别',
                        `last_login_time` timestamp NOT NULL DEFAULT (now()),
                        `create_by` int DEFAULT NULL COMMENT '创建者',
                        `create_time` timestamp NOT NULL DEFAULT (now()) COMMENT '创建时间',
                        `update_by` int DEFAULT NULL COMMENT '最后一次更新者',
                        `update_time` timestamp NOT NULL DEFAULT (now()) COMMENT '最后一次更新时间',
                        `revision` int NOT NULL DEFAULT '0' COMMENT '乐观锁',
                        PRIMARY KEY (`user_id`) USING BTREE,
                        UNIQUE KEY `user_email` (`user_email`) USING BTREE,
                        UNIQUE KEY `user_phone_number` (`user_phone_number`) USING BTREE,
                        UNIQUE KEY `email_normal` (`email_normal`),
                        KEY `surname_name` (`surname`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-16 17:45:31