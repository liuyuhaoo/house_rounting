/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : house_renting

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 07/06/2022 21:14:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `houseId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '房源id',
  `time` datetime(0) NOT NULL COMMENT '评论时间',
  `context` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1530559654013575169', 'admin', '1', '2022-05-28 22:40:33', '时间对吗');
INSERT INTO `comment` VALUES ('1530561650657513474', 'admin', '1', '2022-05-28 22:48:29', '对的');
INSERT INTO `comment` VALUES ('1530569585144098818', 'lyh', '1', '2022-05-28 23:20:00', '我是lyh');

-- ----------------------------
-- Table structure for house_info
-- ----------------------------
DROP TABLE IF EXISTS `house_info`;
CREATE TABLE `house_info`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标题',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '地址',
  `price` decimal(10, 2) NOT NULL COMMENT '价格',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `sale` int(0) NULL DEFAULT 0 COMMENT '销量',
  `status` int(0) NULL DEFAULT NULL COMMENT '审核状态1通过，2未通过，3审核失败',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of house_info
-- ----------------------------
INSERT INTO `house_info` VALUES ('1', '学生宿舍', '广州城市理工学院C16', 809.00, '2022-05-21 23:49:26', 3, 1);
INSERT INTO `house_info` VALUES ('2', '豪华上下床四人间', '广州城市理工学院C16-363', 750.00, '2022-05-22 15:49:02', 0, 2);
INSERT INTO `house_info` VALUES ('3', '豪华上下床四人间', '广州城市理工学院C16-364', 770.00, '2022-05-25 11:40:06', 0, 1);

-- ----------------------------
-- Table structure for talk
-- ----------------------------
DROP TABLE IF EXISTS `talk`;
CREATE TABLE `talk`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `postId` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '发送方id',
  `getId` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '接收方id',
  `context` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '内容',
  `time` datetime(0) NOT NULL COMMENT '时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of talk
-- ----------------------------
INSERT INTO `talk` VALUES ('1', '1', '3', '您好', '2022-05-27 22:11:14');
INSERT INTO `talk` VALUES ('1532364942616539137', '2', '66', '测试', '2022-06-02 22:14:07');
INSERT INTO `talk` VALUES ('2', '3', '1', '你好', '2022-05-27 22:11:31');
INSERT INTO `talk` VALUES ('3', '1', '3', '可以详细描述一下房子吗', '2022-05-27 22:11:52');
INSERT INTO `talk` VALUES ('5', '3', '1', '好的', '2022-05-27 22:13:06');
INSERT INTO `talk` VALUES ('6', '1', '3', '我想知道更多', '2022-05-27 22:12:15');

-- ----------------------------
-- Table structure for user_house_relation
-- ----------------------------
DROP TABLE IF EXISTS `user_house_relation`;
CREATE TABLE `user_house_relation`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `userId` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户id',
  `houseId` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '房源id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_house_relation
-- ----------------------------
INSERT INTO `user_house_relation` VALUES ('1', '1', '1');
INSERT INTO `user_house_relation` VALUES ('2', '2', '2');
INSERT INTO `user_house_relation` VALUES ('3', '3', '3');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码\r\n',
  `idcard` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `realName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `type` int(0) NULL DEFAULT NULL COMMENT '账号类型1租客2房东3管理员',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'admin', '123', '441423200103172717', '13417345898', '1967877060@qq.com', '管理', '2022-05-25 22:35:49', 2);
INSERT INTO `user_info` VALUES ('2', 'liuyuhao', '123', '441423200103172711', '13417345898', '1967877060@qq.com', '用户一', '2022-05-25 22:35:39', 1);
INSERT INTO `user_info` VALUES ('3', 'lyh', '123', '441423200103172717', '13417345898', '1967877060@qq.com', '用户二', '2022-05-25 22:35:45', 3);

SET FOREIGN_KEY_CHECKS = 1;
