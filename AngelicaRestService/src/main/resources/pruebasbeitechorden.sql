/*
Navicat MySQL Data Transfer

Source Server         : MySQL localhost
Source Server Version : 50638
Source Host           : localhost:3306
Source Database       : pruebasbeitechorden

Target Server Type    : MYSQL
Target Server Version : 50638
File Encoding         : 65001

Date: 2017-10-22 12:47:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for allowed_product_customer
-- ----------------------------
DROP TABLE IF EXISTS `allowed_product_customer`;
CREATE TABLE `allowed_product_customer` (
  `product_customer_id` bigint(45) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(45) NOT NULL,
  `product_id` bigint(45) NOT NULL,
  PRIMARY KEY (`product_customer_id`),
  KEY `fk_producto` (`product_id`),
  KEY `fk_customer` (`customer_id`),
  CONSTRAINT `fx_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of allowed_product_customer
-- ----------------------------
INSERT INTO `allowed_product_customer` VALUES ('1', '1019085669', '1');
INSERT INTO `allowed_product_customer` VALUES ('2', '1019085669', '2');
INSERT INTO `allowed_product_customer` VALUES ('3', '1019085669', '3');
INSERT INTO `allowed_product_customer` VALUES ('4', '1019085669', '4');
INSERT INTO `allowed_product_customer` VALUES ('5', '1019085669', '5');
INSERT INTO `allowed_product_customer` VALUES ('6', '1019085669', '6');
INSERT INTO `allowed_product_customer` VALUES ('7', '1019085669', '8');
INSERT INTO `allowed_product_customer` VALUES ('8', '1019085669', '10');
INSERT INTO `allowed_product_customer` VALUES ('9', '1019085669', '12');
INSERT INTO `allowed_product_customer` VALUES ('10', '1019085669', '13');
INSERT INTO `allowed_product_customer` VALUES ('11', '10200758345', '7');
INSERT INTO `allowed_product_customer` VALUES ('12', '10200758345', '9');
INSERT INTO `allowed_product_customer` VALUES ('13', '10200758345', '11');
INSERT INTO `allowed_product_customer` VALUES ('14', '10200758345', '13');
INSERT INTO `allowed_product_customer` VALUES ('15', '41778433', '11');
INSERT INTO `allowed_product_customer` VALUES ('16', '41778433', '12');
INSERT INTO `allowed_product_customer` VALUES ('17', '102043567', '13');
INSERT INTO `allowed_product_customer` VALUES ('18', '102043567', '14');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` bigint(45) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', 'Carnes');
INSERT INTO `category` VALUES ('2', 'Lacteos');
INSERT INTO `category` VALUES ('3', 'Ropa');
INSERT INTO `category` VALUES ('4', 'Mercado');
INSERT INTO `category` VALUES ('5', 'Electrodomésticos');
INSERT INTO `category` VALUES ('6', 'Tecnología');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customer_id` bigint(45) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `correo_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('41778433', 'María Vargas', 'maria@gmail.com');
INSERT INTO `customer` VALUES ('102043567', 'Daniel Vega', 'daniel@gmail.com');
INSERT INTO `customer` VALUES ('1019085669', 'Angelica quevedo', 'angelica@gmail.com');
INSERT INTO `customer` VALUES ('10200758345', 'Juan Vargas', 'juan@gmail.com');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` bigint(45) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(45) NOT NULL,
  `delivery_address` varchar(250) NOT NULL,
  `delivery_date` date NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `k_orden_custumer1_idx_idx` (`customer_id`),
  CONSTRAINT `fx_customer_order` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `detail_id` bigint(45) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(45) NOT NULL,
  `product_id` bigint(45) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `product_description` varchar(255) NOT NULL,
  PRIMARY KEY (`detail_id`),
  KEY `fk_order_detail1_idx` (`order_id`),
  KEY `fx_product_detail1_idx` (`product_id`),
  CONSTRAINT `order_detail_order` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `order_detail_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` bigint(45) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `creation_date` date NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `category_id` bigint(45) NOT NULL,
  PRIMARY KEY (`product_id`),
  KEY `k_product_category1_idx_idx` (`category_id`),
  CONSTRAINT `product_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'Carne de res', 'Carne de res', '2017-10-19', '5', '1');
INSERT INTO `product` VALUES ('2', 'Carne de cerdo', 'Carne de cerdo', '2017-10-19', '8', '1');
INSERT INTO `product` VALUES ('3', 'Pollo', 'Pollo', '2017-10-19', '6', '1');
INSERT INTO `product` VALUES ('4', 'Leche entera', 'Leche entera', '2017-10-19', '15', '2');
INSERT INTO `product` VALUES ('5', 'Yoghurt', 'Yoghurt', '2017-10-19', '3', '2');
INSERT INTO `product` VALUES ('6', 'Leche descremada', 'Leche descremada', '2017-10-19', '16', '2');
INSERT INTO `product` VALUES ('7', 'Camisa hombre', 'Camisa hombre', '2017-10-19', '40', '3');
INSERT INTO `product` VALUES ('8', 'Camisa mujer', 'Camisa mujer', '2017-10-19', '35', '3');
INSERT INTO `product` VALUES ('9', 'Pantalon hombre', 'Pantalon hombre', '2017-10-19', '60', '3');
INSERT INTO `product` VALUES ('10', 'Pantalon mujer', 'Paantalon mujer', '2017-10-19', '55', '3');
INSERT INTO `product` VALUES ('11', 'Televisor samsung', 'Televisor samsung', '2017-10-19', '650', '6');
INSERT INTO `product` VALUES ('12', 'Televisor LG', 'Televisor LG', '2017-10-19', '700', '6');
INSERT INTO `product` VALUES ('13', 'Celular iPhone 8', 'Celular iPhone 8', '2017-10-19', '1900', '6');
INSERT INTO `product` VALUES ('14', 'Celular iPhone 7', 'Celular iPhone 7', '2017-10-19', '1500', '6');
