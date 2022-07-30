CREATE DATABASE  IF NOT EXISTS `web_customer_tracker`;

USE `web_customer_tracker`;

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `customer` VALUES 
	(1,'David','Adams','david@training.com'),
	(2,'John','Doe','john@training.com'),
	(3,'Ajay','Rao','ajay@training.com'),
	(4,'Mary','Public','mary@training.com'),
	(5,'Maxwell','Dixon','max@training.com');

