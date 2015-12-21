drop database if exists mobily_dev_test;
create database mobily_dev_test;
use mobily_dev_test;

CREATE TABLE `theme_category` (
  `category_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `parent_category_id` smallint(5) unsigned DEFAULT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(1000) DEFAULT NULL ,
--  `create_date` datet NOT NULL DEFAULT CAST(NOW() AS DATE) ,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`category_id`),
  KEY `idx_parent_category_id` (`parent_category_id`),
  CONSTRAINT `fk_parent_category_id` FOREIGN KEY (`parent_category_id`) REFERENCES `theme_category` (`category_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=301 DEFAULT CHARSET=utf8;

CREATE TABLE `theme` (
  `theme_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `category_id` smallint(5) unsigned NOT NULL,
  `file_path` varchar(200) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
--  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`theme_id`),
  KEY `idx_category_id` (`category_id`),
  CONSTRAINT `fk_category_id` FOREIGN KEY (`category_id`) REFERENCES `theme_category` (`category_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=401 DEFAULT CHARSET=utf8;

CREATE TABLE `customer` (
  `customer_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `encrypt_key` varchar(200) NOT NULL,
  `theme_id` smallint(5) unsigned DEFAULT NULL,
  `first_name` varchar(45),
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `active` tinyint(1) DEFAULT '1',
--  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update` timestamp DEFAULT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `self_description` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `idx_last_name` (`last_name`),
  CONSTRAINT `fk_customer_theme_id` FOREIGN KEY (`theme_id`) REFERENCES `theme` (`theme_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

CREATE TABLE `address` (
  `account_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `customer_id` smallint(5) unsigned NOT NULL,
  `address_type` varchar(15) DEFAULT NULL,  -- Office, Branch-1, Branch-2, 
  `door_num` varchar(50) DEFAULT NULL,
  `landmark` varchar(150) DEFAULT NULL,
  `street` varchar(50) DEFAULT NULL,
  `area_name` varchar(25) DEFAULT NULL,
  `district` varchar(25) DEFAULT NULL,
  `city` varchar(25) DEFAULT NULL,
  `postal_code` varchar(10) DEFAULT NULL,
  `phone1` varchar(20) DEFAULT NULL,
  `phone2` varchar(20) DEFAULT NULL,
--  `location` geometry DEFAULT NULL,
--  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`account_id`),
  KEY `idx_fk_city` (`city`),
--  SPATIAL KEY `idx_location` (`location`),
  CONSTRAINT `fk_customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8;

CREATE TABLE `question` (
  `question_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
 -- `category` varchar(25) NOT NULL,
  `question` varchar(500) NOT NULL,
--  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`question_id`)
--  KEY `idx_fk_category` (`category`)
 ) ENGINE=InnoDB AUTO_INCREMENT=501 DEFAULT CHARSET=utf8;

CREATE TABLE `question_options` (
  `option_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `question_id` smallint(5) unsigned NOT NULL,
  `option_key` varchar(3) NOT NULL, -- It is like a, b, c... .
  `option_description` varchar(500) NOT NULL,
--  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`option_id`),
  KEY `idx_fk_op_question_id` (`question_id`),
--  KEY `idx_fk_op_option_id` (`option_id`),
  CONSTRAINT `fk_op_question_id` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`) ON UPDATE CASCADE
 ) ENGINE=InnoDB AUTO_INCREMENT=601 DEFAULT CHARSET=utf8;

CREATE TABLE `customer_options` (
  `customer_id` smallint(5) unsigned NOT NULL,
  `question_id` smallint(5) unsigned NOT NULL,
  `option_id` smallint(5) unsigned NOT NULL,
--  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`question_id`, `customer_id`, `option_id`),
  KEY `idx_fk_customer_id` (`customer_id`),
  KEY `idx_fk_question_id` (`question_id`),
--  KEY `idx_fk_option_id` (`option_id`),
  CONSTRAINT `fk_co_customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_co_question_id` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_co_option_id` FOREIGN KEY (`option_id`) REFERENCES `question_options` (`option_id`) ON UPDATE CASCADE
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- SET sql_mode='NO_AUTO_VALUE_ON_ZERO';

-- HELP 
-- USE Databasename: This will be used to select a particular database in MySQL workarea. 
-- SHOW DATABASES: Lists the databases that are accessible by the MySQL DBMS. 
-- SHOW TABLES: Shows the tables in the database once a database has been selected with the use command. 
-- SHOW COLUMNS FROM tablename: Shows the attributes, types of attributes, key information, whether NULL is permitted, defaults, and other information for a table. 
-- SHOW INDEX FROM tablename: Presents the details of all indexes on the table, including the PRIMARY KEY. 
-- SHOW TABLE STATUS LIKE tablename\G: Reports details of the MySQL DBMS performance and statistics.  
 
 
 -- TESTING TABLE
 CREATE TABLE `emp_theme` (
  `theme_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `file_path` varchar(200) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
--  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`theme_id`)
) ENGINE=InnoDB AUTO_INCREMENT=401 DEFAULT CHARSET=utf8;
 
INSERT INTO emp_theme(`name`,`description`)VALUES("theme1","theme1");
INSERT INTO emp_theme(`name`,`description`)VALUES("theme2","theme2");


 CREATE TABLE IF NOT EXISTS `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
   `theme_id` smallint(5) unsigned,
   `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_emp_theme_id` FOREIGN KEY (`theme_id`) REFERENCES `emp_theme` (`theme_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

INSERT INTO `employee` (`id`, `first_name`, `last_name`, `email`, `phone`) VALUES
 (2, 'Hoston', 'lindey', 'hl@gmail.com', '90908989899');
 
 CREATE TABLE `addr` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `emp_id` bigint(20),
--  `emp_id` bigint(20) NOT NULL,
  `add1`  varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_emp_id` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8;

INSERT INTO `addr` (`emp_id`, `add1`) VALUES (2,'Hoston1');
INSERT INTO `addr` (`emp_id`,`add1`) VALUES (2,'Hoston2');
INSERT INTO `addr` (`add1`) VALUES ('Hoston3');
INSERT INTO `addr` (`add1`) VALUES ('Hoston4');
-- INSERT INTO `addr` (`emp_id`,`add1`) VALUES (3,'Hoston2');
