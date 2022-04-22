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
CREATE DATABASE /*!32312 IF NOT EXISTS*/`plantcaring` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `plantcaring`;

/*Table structure for table `plant_condition` */

DROP TABLE IF EXISTS `plant_condition`;

CREATE TABLE `plant_condition` (
                                   `plant_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
                                   `zone_id` int(10) DEFAULT NULL COMMENT '灌溉区连接',
                                   `user_id` int(10) DEFAULT NULL COMMENT '用户id',
                                   `kind` varchar(60) DEFAULT NULL COMMENT '种类',
                                   `general` int(10) DEFAULT NULL COMMENT '总体情况 1:优秀 2:良好 3:中等 4：较差 5：差：',
                                   `is_delete` int(10) DEFAULT '0' COMMENT '是否删除：1删除',
                                   PRIMARY KEY (`plant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `plant_condition` */

insert  into `plant_condition`(`plant_id`,`zone_id`,`user_id`,`kind`,`general`,`is_delete`) values
(1,1,1,'梨花',1,0),
(2,1,1,'百合',1,0),
(3,1,1,'海棠',1,1),
(4,1,2,'山茶',1,0),
(5,2,2,'玫瑰',1,0);

/*Table structure for table `plant_zone` */

DROP TABLE IF EXISTS `plant_zone`;

CREATE TABLE `plant_zone` (
                              `zone_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '区域编号',
                              `user_id` int(10) DEFAULT NULL COMMENT '用户id',
                              `zone_name` varchar(60) DEFAULT NULL COMMENT '名字',
                              `temp` double DEFAULT NULL COMMENT '温度',
                              `hum` double DEFAULT NULL COMMENT '大气湿度',
                              `LI` double DEFAULT NULL COMMENT '光照',
                              `SH` double DEFAULT NULL COMMENT '土壤湿度',
                              `manure` double DEFAULT NULL COMMENT '供肥浓度',
                              `fld` int(11) DEFAULT NULL COMMENT '灌溉方式',
                              `seed_date` date DEFAULT NULL COMMENT '播种日期',
                              `last_irrigate_date` date DEFAULT NULL COMMENT '上次灌溉日期',
                              `type` int(10) DEFAULT NULL COMMENT '灌溉区域类型',
                              `remarks` varchar(60) DEFAULT NULL COMMENT '备注',
                              `is_delete` int(10) DEFAULT '0' COMMENT '是否删除',
                              PRIMARY KEY (`zone_id`),
                              KEY `hum` (`hum`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `plant_zone` */

insert  into `plant_zone`(`zone_id`,`user_id`,`zone_name`,`temp`,`hum`,`LI`,`SH`,`manure`,`fld`,`seed_date`,`last_irrigate_date`,`type`,`remarks`,`is_delete`) values
(1,1,'一号',25,70,20,11,11,1,'2022-04-10','2022-04-10',1,'很好',0),
(5,NULL,'zzzz',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


