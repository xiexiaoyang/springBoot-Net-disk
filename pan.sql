CREATE DATABASE  IF NOT EXISTS `pan` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pan`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: pan
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `directory`
--

DROP TABLE IF EXISTS `directory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `directory` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `createdate` datetime DEFAULT NULL,
  `dirname` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `uname` varchar(255) DEFAULT NULL,
  `updirid` int(11) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `directory`
--

LOCK TABLES `directory` WRITE;
/*!40000 ALTER TABLE `directory` DISABLE KEYS */;
INSERT INTO `directory` VALUES (1,'2018-05-26 21:03:35','小白','2018-05-26 21:03:35','小白',0),(2,'2018-05-26 21:03:58','小七','2018-05-26 21:03:58','小七',0),(3,'2018-05-26 21:04:14','小说很好看','2018-05-26 21:04:23','小白',1),(4,'2018-06-02 15:46:25','布拉德','2018-06-02 15:46:25','布拉德',0),(5,'2018-06-02 16:04:00','小白白','2018-06-02 16:04:00','小白白',0),(6,'2018-06-03 19:49:23','250233@qq.com','2018-06-03 19:49:23','250233@qq.com',0),(7,'2018-06-04 23:02:32','小明','2018-06-04 23:02:32','小明',0),(8,'2018-06-04 23:12:50','杰克','2018-06-04 23:12:50','杰克',0),(9,'2018-06-04 23:23:35','小杰','2018-06-04 23:23:35','小杰',0),(10,'2018-06-04 23:35:02','小华','2018-06-04 23:35:02','小华',0),(11,'2018-06-05 00:03:55','小花','2018-06-05 00:03:55','小花',0),(12,'2018-06-05 00:09:24','小黑','2018-06-05 00:09:24','小黑',0),(13,'2018-06-05 00:15:42','小张','2018-06-05 00:15:42','小张',0),(14,'2018-06-05 12:43:46','小一','2018-06-05 12:43:46','小一',0),(15,'2018-06-05 12:47:04','爱心','2018-06-05 12:47:04','爱心',0),(16,'2018-06-05 12:52:38','小二','2018-06-05 12:52:38','小二',0),(17,'2018-06-05 12:56:00','小三','2018-06-05 12:56:00','小三',0),(18,'2018-06-05 13:10:32','小四','2018-06-05 13:10:32','小四',0),(19,'2018-06-05 13:20:30','小刘','2018-06-05 13:20:30','小刘',0),(20,'2018-06-05 13:57:24','小把','2018-06-05 13:57:24','小把',0),(21,'2018-06-05 21:53:01','xiaoyang','2018-06-05 21:53:01','xiaoyang',0),(22,'2018-06-05 22:08:00','杰克1','2018-06-05 22:08:00','杰克1',0),(23,'2018-06-06 12:03:46','小小','2018-06-06 12:03:46','小小',0),(24,'2018-06-06 12:39:30','张胜','2018-06-06 12:39:30','张胜',0),(25,'2019-03-11 11:00:45','风语','2019-03-11 11:00:45','风语',0),(26,'2019-03-11 16:52:12','笑笑','2019-03-11 16:52:12','笑笑',0),(27,'2019-03-11 17:05:44','刘能','2019-03-11 17:05:44','刘能',0),(28,'2019-03-11 17:10:07','刘欣','2019-03-11 17:10:07','刘欣',0);
/*!40000 ALTER TABLE `directory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `file` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `createdate` datetime DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `filepath` varchar(255) DEFAULT NULL,
  `filesize` decimal(19,2) DEFAULT NULL,
  `filetype` varchar(255) DEFAULT NULL,
  `is_delete` bit(1) NOT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `uname` varchar(255) DEFAULT NULL,
  `updirid` int(11) DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (66,'2018-06-05 00:16:46','1111111.mp3','J:\\pan\\files\\小白\\1111111.mp3',7084535.00,'其他','\0','2018-06-05 20:45:59','小白',1),(67,'2018-06-05 00:17:15','死侍.mp4','J:\\pan\\files\\小白\\死侍.mp4',500685618.00,'视频','\0','2018-06-05 00:17:15','小白',1),(68,'2018-06-05 21:02:19','javaweb错误集.txt','J:\\pan\\files\\小白\\javaweb错误集.txt',249.00,'文本','\0','2018-06-05 21:02:19','小白',1),(69,'2018-06-05 21:32:54','Back To December-Taylor Swift.mp3','J:\\pan\\files\\小白\\Back To December-Taylor Swift.mp3',7084535.00,'其他','\0','2018-06-05 21:32:54','小白',1),(70,'2018-06-05 21:53:29','javaweb错误集.txt','J:\\pan\\files\\xiaoyang\\javaweb错误集.txt',249.00,'文本','\0','2018-06-05 21:53:29','xiaoyang',21),(71,'2018-06-05 21:54:12','Back To December-Taylor Swift.mp3','J:\\pan\\files\\xiaoyang\\Back To December-Taylor Swift.mp3',7084535.00,'音乐','\0','2018-06-05 21:54:12','xiaoyang',21),(72,'2018-06-05 21:54:42','壁纸.jpg','J:\\pan\\files\\xiaoyang\\壁纸.jpg',372719.00,'图片','\0','2018-06-05 21:54:42','xiaoyang',21),(73,'2018-06-05 21:56:38','死侍.mp4','J:\\pan\\files\\xiaoyang\\死侍.mp4',500685618.00,'视频','\0','2018-06-05 21:56:38','xiaoyang',21),(74,'2018-06-05 22:13:58','javaweb错误集.txt','J:\\pan\\files\\杰克1\\javaweb错误集.txt',249.00,'文本','\0','2018-06-05 22:13:58','杰克1',23),(75,'2018-06-05 22:14:24','Back To December-Taylor Swift.mp3','J:\\pan\\files\\杰克1\\Back To December-Taylor Swift.mp3',7084535.00,'音乐','\0','2018-06-05 22:14:24','杰克1',23),(76,'2018-06-05 22:14:42','壁纸.jpg','J:\\pan\\files\\杰克1\\壁纸.jpg',372719.00,'图片','\0','2018-06-05 22:14:42','杰克1',23),(77,'2018-06-05 22:15:07','死侍.mp4','J:\\pan\\files\\杰克1\\死侍.mp4',500685618.00,'视频','\0','2018-06-05 22:15:07','杰克1',23),(78,'2018-06-05 22:15:39','321.rar','J:\\pan\\files\\杰克1\\321.rar',490263.00,'其他','\0','2018-06-05 22:15:39','杰克1',23),(80,'2018-06-06 12:04:42','壁纸.jpg','J:\\pan\\files\\小小\\壁纸.jpg',372719.00,'图片','\0','2018-06-06 12:04:42','小小',24),(81,'2018-06-06 12:04:49','Back To December-Taylor Swift.mp3','J:\\pan\\files\\小小\\Back To December-Taylor Swift.mp3',7084535.00,'音乐','\0','2018-06-06 12:04:49','小小',24),(82,'2018-06-06 12:04:56','321.rar','J:\\pan\\files\\小小\\321.rar',490263.00,'其他','\0','2018-06-06 12:04:56','小小',24),(83,'2018-06-06 12:05:31','死侍.mp4','J:\\pan\\files\\小小\\死侍.mp4',500685618.00,'视频','\0','2018-06-06 12:05:31','小小',24),(104,'2018-06-06 13:05:01','321.rar','J:\\pan\\files\\张胜\\321.rar',490263.00,'其他','\0','2018-06-06 13:05:01','张胜',25),(105,'2018-06-06 13:05:06','壁纸.jpg','J:\\pan\\files\\张胜\\壁纸.jpg',372719.00,'图片','\0','2018-06-06 13:05:06','张胜',25),(106,'2018-06-06 13:05:26','死侍.mp4','J:\\pan\\files\\张胜\\死侍.mp4',500685618.00,'视频','\0','2018-06-06 13:05:26','张胜',25),(107,'2018-06-06 13:11:16','javaweb错误集.txt','J:\\pan\\files\\张胜\\javaweb错误集.txt',249.00,'文本','\0','2018-06-06 13:11:16','张胜',25),(108,'2019-03-11 11:01:02','14.jpg','./files/风语/14.jpg',69470.00,'图片','\0','2019-03-11 20:23:11','风语',26),(109,'2019-03-11 11:02:03','haha 分布函数.mp4','./files/风语/haha 分布函数.mp4',59520048.00,'视频','\0','2019-03-11 20:39:32','风语',26),(110,'2019-03-11 16:52:34','1-1 样本空间和随机事件.mp4','..\\files\\笑笑\\1-1 样本空间和随机事件.mp4',52827155.00,'视频','\0','2019-03-11 16:52:34','笑笑',27),(111,'2019-03-11 16:53:51','屏幕截图(299).png','..\\files\\笑笑\\屏幕截图(299).png',463193.00,'图片','\0','2019-03-11 16:53:51','笑笑',27),(112,'2019-03-11 17:05:55','屏幕截图(299).png','.\\files\\刘能\\屏幕截图(299).png',463193.00,'图片','\0','2019-03-11 17:05:55','刘能',28),(113,'2019-03-11 17:10:20','屏幕截图(299).png','.\\files\\刘欣\\屏幕截图(299).png',463193.00,'图片','\0','2019-03-11 17:10:20','刘欣',29);
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `uname` varchar(255) NOT NULL,
  PRIMARY KEY (`lid`),
  UNIQUE KEY `UK_n20hk4dm38o08x5jdq578uslx` (`uname`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'123','小白'),(2,'123','小七'),(3,'123','布拉德'),(4,'123456','小白白'),(5,'123','250233@qq.com'),(6,'123','小明'),(8,'123','杰克'),(9,'123','小杰'),(10,'123','小华'),(11,'123','小花'),(12,'123','小黑'),(13,'123','小张'),(14,'123','小一'),(15,'123','爱心'),(16,'123','小二'),(17,'123','小三'),(18,'1234','小四'),(19,'123','小刘'),(20,'123','小把'),(21,'123','xiaoyang'),(23,'123','杰克1'),(24,'123','小小'),(25,'123','张胜'),(26,'123456','风语'),(27,'123456','笑笑'),(28,'123456','刘能'),(29,'123456','刘欣');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `createdate` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `uname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `UK_33usp01rahy3w7nv0g62b3s8s` (`uname`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2018-05-26 21:03:35','111111222222@qq.com','我要改变','2018-06-05 20:52:03','123456789','F:a.png','男','小白'),(2,'2018-05-26 21:03:58','111123333@qq.com','afds','2018-05-26 21:03:58','34324668888','F:a.png','女','小七'),(14,'2018-06-05 12:43:46','23422@qq.com',NULL,'2018-06-05 12:43:46','12345678901','F:a.png','男','小一'),(15,'2018-06-05 12:47:04','25099@qq.com',NULL,'2018-06-05 12:47:04','12345678901','F:a.png','女','爱心'),(16,'2018-06-05 12:52:38','23432@qq.com',NULL,'2018-06-05 12:52:38','12345678901','F:a.png','男','小二'),(17,'2018-06-05 12:56:00','250900@qq.com',NULL,'2018-06-05 12:56:00','12345678901','F:a.png','女','小三'),(18,'2018-06-05 13:10:32','23455@qq.com',NULL,'2018-06-05 13:10:32','12345678901','F:a.png','男','小四'),(19,'2018-06-05 13:20:30','1342@qq.com',NULL,'2018-06-05 13:20:30','12345678901','F:a.png','男','小刘'),(20,'2018-06-05 13:57:24','1234@qq.com',NULL,'2018-06-05 13:57:24','12345678901','F:a.png','女','小把'),(21,'2018-06-05 21:53:01','2590@qq.com',NULL,'2018-06-05 21:53:01','12345678901','F:a.png','男','xiaoyang'),(22,'2018-06-05 22:07:54','qeqre34@qq.com',NULL,'2018-06-05 22:07:54','12345678901','F:a.png','男','杰克'),(23,'2018-06-05 22:08:00','qeqre34@qq.com',NULL,'2018-06-05 22:08:00','12345678901','F:a.png','男','杰克1'),(24,'2018-06-06 12:03:46','qrqere@qq.com',NULL,'2018-06-06 12:03:46','12345678901','F:a.png','男','小小'),(25,'2018-06-06 12:39:30','33322322332q@qq.com',NULL,'2018-06-06 13:14:39','12345678901','F:a.png','女','张胜'),(26,'2019-03-11 11:00:44','2509039243@qq.com',NULL,'2019-03-11 11:02:34','15735658018','F:a.png','女','风语'),(27,'2019-03-11 16:52:12','1245789@1456.com',NULL,'2019-03-11 16:52:12','12345678901','F:a.png','女','笑笑'),(28,'2019-03-11 17:05:44','122434@qq.com',NULL,'2019-03-11 17:05:44','12345678901','F:a.png','男','刘能'),(29,'2019-03-11 17:10:07','134253654@qq.com',NULL,'2019-03-11 17:10:07','11223344551','F:a.png','男','刘欣');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'pan'
--

--
-- Dumping routines for database 'pan'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-12  9:47:31
