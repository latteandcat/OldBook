/*
Navicat MySQL Data Transfer

Source Server         : zsw
Source Server Version : 50155
Source Host           : localhost:3306
Source Database       : jiushuguan

Target Server Type    : MYSQL
Target Server Version : 50155
File Encoding         : 65001

Date: 2017-05-15 22:51:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(20) NOT NULL,
  `adminname` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(20) NOT NULL,
  `bookname` varchar(20) NOT NULL,
  `author` varchar(20) NOT NULL,
  `bigclass` varchar(20) NOT NULL,
  `smallclass` varchar(20) NOT NULL,
  `damage` varchar(20) NOT NULL COMMENT '破损度',
  `content` varchar(255) DEFAULT NULL,
  `want` varchar(50) NOT NULL COMMENT '分别是买书还是换书',
  `addtime` datetime NOT NULL,
  `type` varchar(20) NOT NULL,
  `u_id` int(20) NOT NULL,
  `status` varchar(20) NOT NULL COMMENT '表示是否已经卖出去或换出去',
  PRIMARY KEY (`id`),
  KEY `user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------

-- ----------------------------
-- Table structure for `circle`
-- ----------------------------
DROP TABLE IF EXISTS `circle`;
CREATE TABLE `circle` (
  `id` int(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `introduce` varchar(255) NOT NULL,
  `initiator` varchar(20) NOT NULL COMMENT '发起者',
  `joiner` varchar(255) DEFAULT NULL COMMENT '参与者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of circle
-- ----------------------------

-- ----------------------------
-- Table structure for `collection`
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `id` int(20) NOT NULL,
  `u_id` int(20) NOT NULL,
  `b_id` int(20) NOT NULL,
  `coltime` datetime NOT NULL COMMENT '收藏时间',
  PRIMARY KEY (`id`),
  KEY `book` (`b_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collection
-- ----------------------------

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(20) NOT NULL,
  `c_id` int(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `title` varchar(50) NOT NULL,
  `content` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(20) NOT NULL,
  `from` varchar(20) NOT NULL,
  `to` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL COMMENT '分别是换书还是买书',
  `status` varchar(20) NOT NULL COMMENT '分别是非是已完成订单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `sex` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `register_date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for `word`
-- ----------------------------
DROP TABLE IF EXISTS `word`;
CREATE TABLE `word` (
  `id` int(20) NOT NULL,
  `content` varchar(255) NOT NULL COMMENT '留言内容',
  `from` int(20) NOT NULL COMMENT '留言者',
  `to` int(20) NOT NULL COMMENT '被留言人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of word
-- ----------------------------
