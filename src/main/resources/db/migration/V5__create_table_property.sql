DROP TABLE IF EXISTS `property`;
CREATE TABLE `property` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apartment_number` int NOT NULL,
  `city` varchar(20) DEFAULT NULL,
  `house_number` int NOT NULL,
  `postal_code` varchar(6) DEFAULT NULL,
  `province` varchar(30) DEFAULT NULL,
  `street` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
