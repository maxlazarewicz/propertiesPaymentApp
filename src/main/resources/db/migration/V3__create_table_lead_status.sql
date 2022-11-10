DROP TABLE IF EXISTS `lead_status`;

CREATE TABLE `lead_status` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `full_name` varchar(50) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
