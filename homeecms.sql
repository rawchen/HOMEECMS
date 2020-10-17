/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50561
 Source Host           : localhost:3306
 Source Schema         : homeecms

 Target Server Type    : MySQL
 Target Server Version : 50561
 File Encoding         : 65001

 Date: 17/10/2020 21:58:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_address
-- ----------------------------
DROP TABLE IF EXISTS `tb_address`;
CREATE TABLE `tb_address`  (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(5) NULL DEFAULT NULL,
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`address_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of tb_address
-- ----------------------------
INSERT INTO `tb_address` VALUES (1, 2, '陈双全', '18259234126', '福建省厦门市海沧区xxx');
INSERT INTO `tb_address` VALUES (2, 2, '陈双全2', '18259234126', '福建省厦门市集美区理工路600号');
INSERT INTO `tb_address` VALUES (7, 2, '测试账号', '11031321323', '奥术大师大多奥术大师大所多');

-- ----------------------------
-- Table structure for tb_cart
-- ----------------------------
DROP TABLE IF EXISTS `tb_cart`;
CREATE TABLE `tb_cart`  (
  `cart_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(10) NULL DEFAULT NULL,
  `user_id` int(5) NOT NULL,
  `product_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_price` int(10) NULL DEFAULT NULL,
  `product_quantity` int(10) NULL DEFAULT NULL,
  `product_style` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_photo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cart_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of tb_cart
-- ----------------------------
INSERT INTO `tb_cart` VALUES (1, 7, 2, '跳舞兰仿真花干花', 30, 5, '0', '7.jpg');
INSERT INTO `tb_cart` VALUES (2, 13, 2, '木纹笔筒', 35, 2, '0', '13.jpg');
INSERT INTO `tb_cart` VALUES (3, 12, 2, '手绘画餐厅墙面装饰画', 35, 2, '0', '1592836702270.jpg');
INSERT INTO `tb_cart` VALUES (4, 16, 2, '花瓶', 56, 3, '0', '1593241026791.jpg');
INSERT INTO `tb_cart` VALUES (5, 1, 2, '仿木纹漆金裂纹台面花瓶系列套装', 20, 4, '0', '1.jpg');
INSERT INTO `tb_cart` VALUES (6, 7, 9, '跳舞兰仿真花干花', 30, 1, '0', '7.jpg');
INSERT INTO `tb_cart` VALUES (7, 10, 9, '跳舞兰仿真花干花4', 20, 2, '0', '1592655179968.jpg');

-- ----------------------------
-- Table structure for tb_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category`  (
  `category_id` int(10) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `category_parentid` int(10) NOT NULL,
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of tb_category
-- ----------------------------
INSERT INTO `tb_category` VALUES (1, '装饰摆件', 0);
INSERT INTO `tb_category` VALUES (2, '布艺软饰', 0);
INSERT INTO `tb_category` VALUES (3, '墙式壁挂', 0);
INSERT INTO `tb_category` VALUES (4, '腊艺香薰', 0);
INSERT INTO `tb_category` VALUES (5, '创意家居', 0);
INSERT INTO `tb_category` VALUES (6, '啊啊啊啊', 0);
INSERT INTO `tb_category` VALUES (7, '干花花艺', 1);
INSERT INTO `tb_category` VALUES (8, '花瓶花器', 1);
INSERT INTO `tb_category` VALUES (9, '桌布罩件', 2);
INSERT INTO `tb_category` VALUES (10, '抱枕靠垫', 2);
INSERT INTO `tb_category` VALUES (13, '新中式客厅', 3);
INSERT INTO `tb_category` VALUES (16, '999', 6);

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment`  (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(5) NULL DEFAULT NULL,
  `product_id` int(10) NULL DEFAULT NULL,
  `comment_time` datetime NULL DEFAULT NULL,
  `comment_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of tb_comment
-- ----------------------------
INSERT INTO `tb_comment` VALUES (1, 2, 8, '2020-06-26 16:56:19', '奥术大师多大萨达大大所多');
INSERT INTO `tb_comment` VALUES (2, 3, 8, '2020-03-01 16:57:07', '的发生的骄傲几十块大海的狂欢节');
INSERT INTO `tb_comment` VALUES (3, 2, 8, '2020-06-27 00:29:28', '<p><span style=\"font-size:28px\"><s>6666666666666666666666666666666666666666666</s></span>66666666666<img alt=\"yes\" src=\"https://cdn.ckeditor.com/4.14.0/full/plugins/smiley/images/thumbs_up.png\" style=\"height:23px; width:23px\" title=\"yes\" /></p>\r\n');
INSERT INTO `tb_comment` VALUES (4, 2, 8, '2020-06-27 15:01:45', '<p><span style=\"font-size:48px\">6666666666</span></p>\r\n');
INSERT INTO `tb_comment` VALUES (5, 2, 8, '2020-06-27 15:33:25', '<p>爱仕达多多多</p>\r\n');
INSERT INTO `tb_comment` VALUES (6, 2, 8, '2020-06-28 08:57:21', '<p>hhhhhhhhh</p>\r\n');
INSERT INTO `tb_comment` VALUES (7, 2, 8, '2020-10-13 11:19:15', '<p>嗷嗷嗷</p>\r\n');

-- ----------------------------
-- Table structure for tb_notify
-- ----------------------------
DROP TABLE IF EXISTS `tb_notify`;
CREATE TABLE `tb_notify`  (
  `notify_id` int(11) NOT NULL AUTO_INCREMENT,
  `notify_time` datetime NULL DEFAULT NULL,
  `user_id` int(5) NULL DEFAULT NULL,
  `notify_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`notify_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of tb_notify
-- ----------------------------

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(5) NULL DEFAULT NULL,
  `order_price` int(5) NULL DEFAULT NULL,
  `order_time` datetime NULL DEFAULT NULL,
  `is_pay` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_ship` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_receipt` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address_id` int(11) NULL DEFAULT 0,
  `product_id` int(10) NULL DEFAULT NULL,
  `product_quantity` int(10) NULL DEFAULT NULL,
  `product_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_photo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_price` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 84 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES (1, '15930607071702', 2, 60, '2020-06-23 21:23:18', '1', '1', '1', 2, 8, 3, '跳舞兰仿真花干花2', '8.jpg', 20);
INSERT INTO `tb_order` VALUES (62, '15930720383012', 2, 520, '2020-06-25 16:00:38', '1', '1', '1', 2, 12, 4, '手绘画餐厅墙面装饰画', '1592828240086.jpg', 130);
INSERT INTO `tb_order` VALUES (63, '15930783283922', 2, 60, '2020-06-25 17:45:28', '1', '0', '0', 2, 10, 3, '跳舞兰仿真花干花4', '1592655179968.jpg', 20);
INSERT INTO `tb_order` VALUES (65, '15931407126072', 2, 60, '2020-06-26 11:05:13', '1', '0', '0', 2, 1, 3, '仿木纹漆金裂纹台面花瓶系列套装', '1.jpg', 20);
INSERT INTO `tb_order` VALUES (66, '15931410861762', 2, 40, '2020-06-26 11:11:26', '0', '0', '0', 0, 9, 2, '跳舞兰仿真花干花3', '1592655156977.jpg', 20);
INSERT INTO `tb_order` VALUES (67, '15931674816112', 2, 175, '2020-06-26 18:31:22', '1', '0', '0', 7, 13, 5, '木纹笔筒', '13.jpg', 35);
INSERT INTO `tb_order` VALUES (68, '15931871584682', 2, 390, '2020-06-26 23:59:18', '1', '0', '0', 7, 11, 3, '新中式装饰壁挂客厅轻奢墙面装饰', '1592828240086.jpg', 130);
INSERT INTO `tb_order` VALUES (75, '15932359331172', 2, 100, '2020-06-27 13:32:13', '0', '0', '0', 0, 14, 2, '复古式插画深褐色玻璃瓶', '1593235091938.jpg', 50);
INSERT INTO `tb_order` VALUES (76, '15932407810632', 2, 105, '2020-06-27 14:53:01', '1', '1', '1', 7, 13, 3, '木纹笔筒', '13.jpg', 35);
INSERT INTO `tb_order` VALUES (77, '15932459173802', 2, 72, '2020-06-27 16:18:37', '0', '0', '0', 0, 15, 2, '帆船壁挂壁画客房客厅壁画', '1593235194484.jpg', 36);
INSERT INTO `tb_order` VALUES (78, '15932474659372', 2, 108, '2020-06-27 16:44:26', '0', '0', '0', 0, 15, 3, '帆船壁挂壁画客房客厅壁画', '1593235194484.jpg', 36);
INSERT INTO `tb_order` VALUES (79, '15933057352282', 2, 100, '2020-06-28 08:55:35', '1', '1', '1', 2, 8, 5, '跳舞兰仿真花干花2', '8.jpg', 20);
INSERT INTO `tb_order` VALUES (80, '16024264486299', 9, 30, '2020-10-11 22:27:28', '0', '0', '0', 0, 7, 1, '跳舞兰仿真花干花', '7.jpg', 30);
INSERT INTO `tb_order` VALUES (82, '160251585763810', 10, 112, '2020-10-12 23:17:37', '0', '0', '0', 0, 16, 2, '花瓶', '1593241026791.jpg', 56);
INSERT INTO `tb_order` VALUES (83, '16025589087312', 2, 1554, '2020-10-13 11:15:08', '1', '0', '0', 7, 17, 2, '887', '1593305616619.jpg', 777);

-- ----------------------------
-- Table structure for tb_orderlist
-- ----------------------------
DROP TABLE IF EXISTS `tb_orderlist`;
CREATE TABLE `tb_orderlist`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_id` int(10) NULL DEFAULT NULL,
  `product_quantity` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of tb_orderlist
-- ----------------------------
INSERT INTO `tb_orderlist` VALUES (1, '15930607071702', 8, '3');
INSERT INTO `tb_orderlist` VALUES (56, '15930720383012', 12, '4');
INSERT INTO `tb_orderlist` VALUES (57, '15930783283922', 10, '3');

-- ----------------------------
-- Table structure for tb_product
-- ----------------------------
DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product`  (
  `product_id` int(10) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_info` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_price` int(10) NULL DEFAULT NULL,
  `product_stock` int(10) NULL DEFAULT NULL,
  `product_fid` int(5) NULL DEFAULT NULL,
  `product_cid` int(5) NULL DEFAULT NULL,
  `product_photo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_style` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  `product_sales` int(5) NULL DEFAULT 0,
  `product_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of tb_product
-- ----------------------------
INSERT INTO `tb_product` VALUES (1, '仿木纹漆金裂纹台面花瓶系列套装', '<p>仿木纹漆金裂纹台面花瓶系列套装仿木纹漆金裂纹台面花瓶系列套装</p>\r\n\r\n<p><img alt=\"\" src=\"https://yoyling.oss-cn-shenzhen.aliyuncs.com/temp/1.jpg\" style=\"height:696px; width:940px\" /></p>\r\n\r\n<p><img alt=\"\" src=\"https://yoyling.oss-cn-shenzhen.aliyuncs.com/temp/2.jpg\" style=\"height:896px; width:937px\" /></p>', 20, 48, 1, 8, '1.jpg', '0', 20, '2020-06-22 17:42:16');
INSERT INTO `tb_product` VALUES (7, '跳舞兰仿真花干花', '<img src=\"https://yoyling.oss-cn-shenzhen.aliyuncs.com/temp/1.jpg\">\r\n                <img src=\"https://yoyling.oss-cn-shenzhen.aliyuncs.com/temp/2.jpg\">', 30, 176, 1, 7, '7.jpg', '0', 59, '2020-06-22 17:42:31');
INSERT INTO `tb_product` VALUES (8, '跳舞兰仿真花干花2', '跳舞兰仿真花干花跳舞兰仿真花干花2', 20, 35, 1, 7, '8.jpg', '0', 89, '2020-06-22 17:42:34');
INSERT INTO `tb_product` VALUES (9, '跳舞兰仿真花干花3', '跳舞兰仿真花干花跳舞兰仿真花干花', 20, 30, 1, 7, '1592655156977.jpg', '0', 37, '2020-06-22 17:42:37');
INSERT INTO `tb_product` VALUES (10, '跳舞兰仿真花干花4', '跳舞兰仿真花干花跳舞兰仿真花干花跳舞兰仿真花干花', 20, 40, 1, 7, '1592655179968.jpg', '0', 79, '2020-06-22 17:42:41');
INSERT INTO `tb_product` VALUES (11, '新中式装饰壁挂客厅轻奢墙面装饰', '新中式装饰壁挂客厅轻奢墙面装饰铁艺挂件沙发背景墙山水立体墙饰', 130, 40, 3, 13, '1592828240086.jpg', '0', 0, '2020-06-22 19:42:41');
INSERT INTO `tb_product` VALUES (12, '手绘画餐厅墙面装饰画', '手绘画餐厅墙面装饰画轻奢挂画简美风玄关油画客厅壁画', 35, 60, 3, 13, '1592836702270.jpg', '0', 0, '2020-06-22 22:38:22');
INSERT INTO `tb_product` VALUES (13, '木纹笔筒', '<p><s><span style=\"font-size:48px\">这是木纹笔筒的介绍<img alt=\"yes\" src=\"https://cdn.ckeditor.com/4.14.0/full/plugins/smiley/images/thumbs_up.png\" style=\"height:23px; width:23px\" title=\"yes\" /></span></s></p>\r\n', 35, 37, 1, 8, '13.jpg', '0', 0, '2020-06-26 16:07:49');
INSERT INTO `tb_product` VALUES (14, '复古式插画深褐色玻璃瓶', '<p><span style=\"font-size:28px\">奥术大师大所<strong><s>多大声道123</s></strong></span><span style=\"font-size:16px\">阿萨德<img alt=\"frown\" src=\"https://cdn.ckeditor.com/4.14.0/full/plugins/smiley/images/confused_smile.png\" style=\"height:23px; width:23px\" title=\"frown\" /></span></p>\r\n\r\n<p><span style=\"font-size:16px\"><img alt=\"\" src=\"https://yoyling.oss-cn-shenzhen.aliyuncs.com/temp/1.jpg\" style=\"height:696px; width:940px\" /></span></p>\r\n', 50, 80, 1, 8, '1593235091938.jpg', '0', 0, '2020-06-27 13:18:12');
INSERT INTO `tb_product` VALUES (15, '帆船壁挂壁画客房客厅壁画', '<p><span style=\"font-size:20px\">帆<strong>船壁挂壁画客房</strong>客厅<s>壁画帆船壁挂</s>壁画客房客厅壁画<img alt=\"cool\" src=\"https://cdn.ckeditor.com/4.14.0/full/plugins/smiley/images/shades_smile.png\" style=\"height:23px; width:23px\" title=\"cool\" /></span></p>\r\n\r\n<p><span style=\"font-size:20px\"><img alt=\"\" src=\"https://yoyling.oss-cn-shenzhen.aliyuncs.com/temp/1.jpg\" style=\"height:696px; width:940px\" /></span></p>\r\n', 36, 78, 3, 13, '1593235194484.jpg', '0', 0, '2020-06-27 13:19:54');
INSERT INTO `tb_product` VALUES (16, '花瓶', '<p>敖德萨所多</p>\r\n', 56, 56, 1, 7, '1593241026791.jpg', '0', 0, '2020-06-27 14:57:07');
INSERT INTO `tb_product` VALUES (17, '887', '<p><span style=\"font-size:20px\">sdfsdfdsf</span></p>\r\n', 777, 77, 1, 7, '1593305616619.jpg', '0', 0, '2020-06-28 08:53:37');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_id` int(5) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '未知昵称',
  `user_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_sex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_vip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_viptime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_photo` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0.jpg',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'admin', '管理员hhh', 'admin', '女', '0', '0', '2', '1.jpg');
INSERT INTO `tb_user` VALUES (2, 'yoyling', '测试小熊', 'yoyling', '男', '0', '0', '1', '2.jpg');
INSERT INTO `tb_user` VALUES (3, '88', '88', '88', '男', '0', '0', '1', '3.jpg');
INSERT INTO `tb_user` VALUES (4, '2', '2', '2', '男', '0', '0', '1', '4.jpg');
INSERT INTO `tb_user` VALUES (5, '3', '3', '3', '女', '0', '0', '2', '5.jpg');
INSERT INTO `tb_user` VALUES (6, '8', '8', '8', '男', '0', '0', '2', '6.jpg');
INSERT INTO `tb_user` VALUES (7, '999', '无昵称哦哦', '999', '女', '0', '0', '1', '7.jpg');
INSERT INTO `tb_user` VALUES (8, '111', '无昵称哦', '11', NULL, '0', '0', '1', 'default_0.jpg');
INSERT INTO `tb_user` VALUES (9, 'asd', '失眠', 'asd', '女', '0', '0', '1', '9.png');
INSERT INTO `tb_user` VALUES (10, '123', '无昵称哦', '123', NULL, '0', '0', '1', 'default_0.jpg');
INSERT INTO `tb_user` VALUES (11, '123456', '无昵称哦', '123', NULL, '0', '0', '1', '11.png');
INSERT INTO `tb_user` VALUES (12, '11', '无昵称哦', '122', NULL, '0', '0', '1', 'default_0.jpg');
INSERT INTO `tb_user` VALUES (13, '888', '无昵称哦', '888', NULL, '0', '0', '1', 'default_0.jpg');
INSERT INTO `tb_user` VALUES (14, '1', '无昵称哦', '1', NULL, '0', '0', '1', 'default_0.jpg');

SET FOREIGN_KEY_CHECKS = 1;
