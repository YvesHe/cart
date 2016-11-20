/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : yves

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2016-11-19 17:18:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` varchar(255) NOT NULL,
  `isbn` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `publisher` varchar(255) NOT NULL,
  `pubdate` datetime NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
