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

 Date: 08/06/2022 15:38:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `userId` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户id',
  `houseId` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '房屋id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES ('1', '2', '2');
INSERT INTO `collect` VALUES ('1534439145479372802', '4', '1');

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
INSERT INTO `comment` VALUES ('1530559654013575169', 'zk1', '2', '2022-05-28 22:40:33', '押金多少？');
INSERT INTO `comment` VALUES ('1530561650657513474', 'zk1', '2', '2022-05-28 22:48:29', '押多少付多少？');
INSERT INTO `comment` VALUES ('1530569585144098818', 'zk2', '2', '2022-05-28 23:20:00', '能便宜点吗？');
INSERT INTO `comment` VALUES ('1534340611066359809', 'lyh', '1', '2022-06-08 09:04:43', '评论');

-- ----------------------------
-- Table structure for house_info
-- ----------------------------
DROP TABLE IF EXISTS `house_info`;
CREATE TABLE `house_info`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标题',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '地址',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
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
INSERT INTO `house_info` VALUES ('4', '豪华上下床四人间', '广州城市理工学院C16-365', 740.00, '2022-06-08 15:25:10', 0, 3);
INSERT INTO `house_info` VALUES ('5', '豪华上下床四人间', '广州城市理工学院C16-366', 750.00, '2022-06-08 15:26:17', 0, 1);
INSERT INTO `house_info` VALUES ('6', '豪华上下床四人间', '广州城市理工学院C16-367', 760.00, '2022-06-08 15:27:39', 2, 1);
INSERT INTO `house_info` VALUES ('7', '豪华上下床四人间', '广州城市理工学院C16-368', 780.00, '2022-06-08 15:28:06', 0, 2);
INSERT INTO `house_info` VALUES ('8', '豪华上下床四人间', '广州城市理工学院C16-369', 780.00, '2022-06-08 15:28:44', 0, 3);

-- ----------------------------
-- Table structure for talk
-- ----------------------------
DROP TABLE IF EXISTS `talk`;
CREATE TABLE `talk`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '是否已读1已读2未读 ',
  `postId` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '发送方id',
  `getId` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '接收方id',
  `context` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '内容',
  `time` datetime(0) NOT NULL COMMENT '时间',
  `readed` int(0) NULL DEFAULT NULL COMMENT '是否已读1已读2未读 ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of talk
-- ----------------------------
INSERT INTO `talk` VALUES ('1', '2', '4', '您好', '2022-05-27 22:11:14', 1);
INSERT INTO `talk` VALUES ('2', '4', '2', '你好', '2022-05-27 22:11:31', 1);
INSERT INTO `talk` VALUES ('3', '4', '2', '可以详细描述一下房子吗', '2022-05-27 22:11:52', 1);
INSERT INTO `talk` VALUES ('5', '2', '4', '好的', '2022-05-27 22:13:06', 1);
INSERT INTO `talk` VALUES ('6', '4', '3', '我想知道更多', '2022-05-27 22:12:15', 2);
INSERT INTO `talk` VALUES ('7', '4', '3', '可以优惠点吗', '2022-06-08 11:53:44', 2);

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
INSERT INTO `user_house_relation` VALUES ('1', '2', '1');
INSERT INTO `user_house_relation` VALUES ('2', '2', '2');
INSERT INTO `user_house_relation` VALUES ('3', '2', '3');
INSERT INTO `user_house_relation` VALUES ('4', '2', '4');
INSERT INTO `user_house_relation` VALUES ('5', '2', '5');
INSERT INTO `user_house_relation` VALUES ('6', '3', '6');
INSERT INTO `user_house_relation` VALUES ('7', '3', '7 ');
INSERT INTO `user_house_relation` VALUES ('8', '3', '8');

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
INSERT INTO `user_info` VALUES ('1', 'admin', '123', '441423200103172711', '12345678901', '12345667888@qq.com', '管理', '2022-05-25 22:35:49', 3);
INSERT INTO `user_info` VALUES ('2', 'fd1', '123', '441423200103172712', '12345678902', '12345667888@qq.com', '房东1', '2022-05-25 22:35:39', 2);
INSERT INTO `user_info` VALUES ('3', 'fd2', '123', '441423200103172713', '12345678903', '12345667888@qq.com', '房东2', '2022-05-25 22:35:45', 2);
INSERT INTO `user_info` VALUES ('4', 'zk1', '123', '441423200103172714', '12345678904', '12345667888@qq.com', '租客1', '2022-06-08 15:23:00', 1);
INSERT INTO `user_info` VALUES ('5', 'zk2', '123', '441423200103172715', '12345678904', '12345667888@qq.com', '租客2', '2022-06-08 15:23:24', 1);

SET FOREIGN_KEY_CHECKS = 1;
