/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : springcloud_sell

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-12-11 16:27:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `type` int(2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '盖饭类', '1', '2018-12-11 10:59:40', '2018-12-11 10:59:42');
INSERT INTO `category` VALUES ('2', '粥类', '2', '2018-12-11 11:00:00', '2018-12-11 11:00:02');
INSERT INTO `category` VALUES ('3', '套餐类', '3', '2018-12-11 11:00:15', '2018-12-11 11:00:16');

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `product_name` varchar(64) DEFAULT NULL,
  `product_price` double DEFAULT NULL,
  `product_quantity` int(11) DEFAULT NULL COMMENT '数量',
  `product_icon` varchar(512) DEFAULT NULL COMMENT '小图',
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('1', '1', '2', '木须肉盖饭', '22', '1', null, '2018-12-11 14:44:08', '2018-12-11 14:44:08');

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(64) DEFAULT NULL COMMENT '订单号',
  `name` varchar(32) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `openid` varchar(64) DEFAULT NULL COMMENT '买家微信openid',
  `amount` double DEFAULT '0' COMMENT '订单总价',
  `order_status` int(1) DEFAULT '0' COMMENT '订单状态：默认新下单',
  `pay_status` int(1) DEFAULT '0' COMMENT '支付状态：默认未支付',
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES ('1', null, '张三', '13389817374', '北京市海淀区紫竹桥路3号', 'fghdfhdf4564fgs54df56sd1g4', '50', '1', '1', '2018-12-11 14:38:37', null);
INSERT INTO `order_master` VALUES ('2', null, '李四', '13389817374', '北京市海淀区万寿路8号', 'fghdfhdf4564fgs54df56sd1g4', '32', '0', '0', '2018-12-11 14:52:20', '2018-12-11 14:52:20');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `stock` int(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `category` int(2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '皮蛋瘦肉粥', '12', '50', '营养粥', null, '1', '2', '2018-12-11 10:45:50', '2018-12-11 10:45:53');
INSERT INTO `product` VALUES ('2', '木须肉盖饭', '22', '45', '可口的木须肉盖饭', null, '1', '1', '2018-12-11 13:28:22', '2018-12-11 13:28:24');
INSERT INTO `product` VALUES ('3', '木须肉套餐', '30', '20', '皮蛋瘦肉粥+木须肉盖饭', null, '1', '3', '2018-12-11 13:29:04', '2018-12-11 13:29:06');
