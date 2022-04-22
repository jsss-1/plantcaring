/*
 Navicat Premium Data Transfer

 Source Server         : plantcaring
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : plantcaring

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 22/01/2022 19:51:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_area
-- ----------------------------
DROP TABLE IF EXISTS `tb_area`;
CREATE TABLE `tb_area`  (
                            `area_id` int(0) NOT NULL AUTO_INCREMENT,
                            `area_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                            `priority` int(2) UNSIGNED ZEROFILL NOT NULL,
                            `create_time` datetime(0) NULL DEFAULT NULL,
                            `last_edit_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
                            PRIMARY KEY (`area_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_area
-- ----------------------------
INSERT INTO `tb_area` VALUES (1, '上海', 01, '2022-01-16 23:18:29', '2022-01-16 23:19:14');
INSERT INTO `tb_area` VALUES (2, '杭州', 02, '2022-01-16 23:20:23', '2022-01-16 23:20:29');

-- ----------------------------
-- Table structure for tb_head_line
-- ----------------------------
DROP TABLE IF EXISTS `tb_head_line`;
CREATE TABLE `tb_head_line`  (
                                 `line_id` int(0) NOT NULL AUTO_INCREMENT,
                                 `line_name` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                 `line_link` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                 `line_img` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                 `enable_status` int(0) NOT NULL DEFAULT 0,
                                 `create_time` datetime(0) NULL DEFAULT NULL,
                                 `last_edit_time` datetime(0) NULL DEFAULT NULL,
                                 `priority` int(0) NULL DEFAULT NULL,
                                 PRIMARY KEY (`line_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_head_line
-- ----------------------------

-- ----------------------------
-- Table structure for tb_local_auth
-- ----------------------------
DROP TABLE IF EXISTS `tb_local_auth`;
CREATE TABLE `tb_local_auth`  (
                                  `local_auth_id` int(0) NOT NULL AUTO_INCREMENT,
                                  `user_id` int(0) NOT NULL,
                                  `username` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                  `create_time` datetime(0) NULL DEFAULT NULL,
                                  `last_edit_time` datetime(0) NULL DEFAULT NULL,
                                  PRIMARY KEY (`local_auth_id`) USING BTREE,
                                  UNIQUE INDEX `username`(`username`) USING BTREE,
                                  INDEX `user_id`(`user_id`) USING BTREE,
                                  CONSTRAINT `fk_localauth_profile` FOREIGN KEY (`user_id`) REFERENCES `tb_person_info` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_local_auth
-- ----------------------------

-- ----------------------------
-- Table structure for tb_person_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_person_info`;
CREATE TABLE `tb_person_info`  (
                                   `user_id` int(0) NOT NULL AUTO_INCREMENT,
                                   `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                   `profile_img` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                   `email` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                   `gender` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0:禁止使用商城1：可以使用商城',
                                   `enable_status` int(0) NOT NULL,
                                   `user_type` int(0) NOT NULL,
                                   `create_time` datetime(0) NULL DEFAULT NULL,
                                   `last_edit_time` datetime(0) NULL DEFAULT NULL,
                                   PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_person_info
-- ----------------------------
INSERT INTO `tb_person_info` VALUES (1, '温迪', NULL, NULL, '男', 1, 1, '2022-01-21 04:46:12', '2022-01-21 04:46:12');
INSERT INTO `tb_person_info` VALUES (2, '温迪', NULL, NULL, '男', 1, 1, '2022-01-21 05:27:59', '2022-01-21 05:27:59');

-- ----------------------------
-- Table structure for tb_product
-- ----------------------------
DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product`  (
                               `product_id` int(0) NOT NULL,
                               `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                               `product_desc` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                               `img_addr` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
                               `normal_price` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                               `promotion_price` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                               `priority` int(0) NOT NULL,
                               `create_time` datetime(0) NULL DEFAULT NULL,
                               `last_edit_time` datetime(0) NULL DEFAULT NULL,
                               `enable_status` int(0) NULL DEFAULT 0,
                               `product_category_id` int(0) NOT NULL,
                               `shop_id` int(0) NOT NULL,
                               `point` int(0) NULL DEFAULT NULL,
                               PRIMARY KEY (`product_id`, `shop_id`, `product_category_id`) USING BTREE,
                               INDEX `product_category_id`(`product_category_id`) USING BTREE,
                               INDEX `fk_product_shop`(`shop_id`) USING BTREE,
                               INDEX `product_id`(`product_id`) USING BTREE,
                               CONSTRAINT `fk_product_procate` FOREIGN KEY (`product_category_id`) REFERENCES `tb_product_catagory` (`product_category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                               CONSTRAINT `fk_product_shop` FOREIGN KEY (`shop_id`) REFERENCES `tb_shop` (`shop_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_product
-- ----------------------------

-- ----------------------------
-- Table structure for tb_product_catagory
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_catagory`;
CREATE TABLE `tb_product_catagory`  (
                                        `product_category_id` int(0) NOT NULL AUTO_INCREMENT,
                                        `product_category_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                        `priority` int(0) NULL DEFAULT 0,
                                        `create_time` datetime(0) NULL DEFAULT NULL,
                                        `shop_id` int(0) NOT NULL,
                                        PRIMARY KEY (`product_category_id`) USING BTREE,
                                        INDEX `fk_procate_shop`(`shop_id`) USING BTREE,
                                        CONSTRAINT `fk_procate_shop` FOREIGN KEY (`shop_id`) REFERENCES `tb_shop` (`shop_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_product_catagory
-- ----------------------------

-- ----------------------------
-- Table structure for tb_product_img
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_img`;
CREATE TABLE `tb_product_img`  (
                                   `product_img_id` int(0) NOT NULL AUTO_INCREMENT,
                                   `img_addr` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                   `img_desc` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                   `priority` int(0) NULL DEFAULT NULL,
                                   `create_time` datetime(0) NULL DEFAULT NULL,
                                   `product_id` int(0) NULL DEFAULT NULL,
                                   PRIMARY KEY (`product_img_id`) USING BTREE,
                                   INDEX `fk_proimg_product`(`product_id`) USING BTREE,
                                   CONSTRAINT `fk_proimg_product` FOREIGN KEY (`product_id`) REFERENCES `tb_product` (`product_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_product_img
-- ----------------------------

-- ----------------------------
-- Table structure for tb_shop
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop`;
CREATE TABLE `tb_shop`  (
                            `shop_id` int(0) NOT NULL,
                            `shop_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                            `owner_id` int(0) NOT NULL,
                            `area_id` int(0) NOT NULL,
                            `shop_catagory_id` int(0) NOT NULL,
                            `shop_desc` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
                            `shop_addr` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
                            `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                            `shop_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                            `priority` int(0) NOT NULL,
                            `last_edit_time` datetime(0) NULL DEFAULT NULL,
                            `enable_status` int(0) NOT NULL,
                            `advice` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                            `create_time` datetime(0) NULL DEFAULT NULL,
                            PRIMARY KEY (`shop_id`) USING BTREE,
                            INDEX `fk_shop_area`(`area_id`) USING BTREE,
                            INDEX `fk_shop_profile`(`owner_id`) USING BTREE,
                            INDEX `fk_shop_shopcate`(`shop_catagory_id`) USING BTREE,
                            CONSTRAINT `fk_shop_area` FOREIGN KEY (`area_id`) REFERENCES `tb_area` (`area_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                            CONSTRAINT `fk_shop_profile` FOREIGN KEY (`owner_id`) REFERENCES `tb_person_info` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                            CONSTRAINT `fk_shop_shopcate` FOREIGN KEY (`shop_catagory_id`) REFERENCES `tp_shop_catagory` (`shop_category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_shop
-- ----------------------------

-- ----------------------------
-- Table structure for tb_wechat_auth
-- ----------------------------
DROP TABLE IF EXISTS `tb_wechat_auth`;
CREATE TABLE `tb_wechat_auth`  (
                                   `wechat_auth_id` int(0) NOT NULL AUTO_INCREMENT,
                                   `user_id` int(0) NOT NULL,
                                   `open_id` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                   `create_time` datetime(0) NOT NULL,
                                   PRIMARY KEY (`wechat_auth_id`) USING BTREE,
                                   INDEX `user_id`(`user_id`) USING BTREE,
                                   CONSTRAINT `fk_wechatauth_profile` FOREIGN KEY (`user_id`) REFERENCES `tb_person_info` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_wechat_auth
-- ----------------------------

-- ----------------------------
-- Table structure for tp_shop_catagory
-- ----------------------------
DROP TABLE IF EXISTS `tp_shop_catagory`;
CREATE TABLE `tp_shop_catagory`  (
                                     `shop_category_id` int(0) NOT NULL AUTO_INCREMENT,
                                     `shop_category_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
                                     `shop_category_desc` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
                                     `shop_category_img` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                     `priority` int(0) NOT NULL,
                                     `create_time` datetime(0) NULL DEFAULT NULL,
                                     `last_edit_time` datetime(0) NULL DEFAULT NULL,
                                     `parent_id` int(0) NULL DEFAULT NULL,
                                     PRIMARY KEY (`shop_category_id`) USING BTREE,
                                     INDEX `fk_shop_catagory_self`(`parent_id`) USING BTREE,
                                     CONSTRAINT `fk_shop_catagory_self` FOREIGN KEY (`parent_id`) REFERENCES `tp_shop_catagory` (`shop_category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tp_shop_catagory
-- ----------------------------

-- ----------------------------
-- Table structure for usermessage
-- ----------------------------
DROP TABLE IF EXISTS `usermessage`;
CREATE TABLE `usermessage`  (
                                `userid` int(0) NOT NULL AUTO_INCREMENT,
                                `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                `level` int(0) NOT NULL,
                                PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usermessage
-- ----------------------------
INSERT INTO `usermessage` VALUES (1, '张桂花', '112233', 1);
INSERT INTO `usermessage` VALUES (2, '李梅梅', '111111', 1);
INSERT INTO `usermessage` VALUES (3, '吴桐叶', '334455', 3);
INSERT INTO `usermessage` VALUES (4, '白蔷薇', '777777', 2);

SET FOREIGN_KEY_CHECKS = 1;
