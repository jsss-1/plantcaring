/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 5.7.19 : Database - planttcaring
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`plantcaring` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `plantcaring`;

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` char(32) DEFAULT NULL COMMENT '密码',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `gender` int(11) DEFAULT '1' COMMENT '性别',
  `avatar` varchar(50) DEFAULT NULL COMMENT '头像',
  `isDelete` int(11) DEFAULT '0' COMMENT '是否删除',
  `salt` varchar(50) DEFAULT NULL COMMENT '盐值',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`uid`,`username`,`password`,`phone`,`email`,`gender`,`avatar`,`isDelete`,`salt`) values 
(1,'lyl','BBF2EB2F3C4CFD6E1EEFC75A1D3D0BEA',NULL,NULL,NULL,NULL,0,'4FDCFD13-6D99-4948-BBF8-3A8AC02B8F4A'),
(2,'123','44E2AD4F68A868FF9DAC6BFB275CB5B8',NULL,NULL,NULL,NULL,0,'0BB82E4E-141C-4723-ADE2-1030887F3143');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
