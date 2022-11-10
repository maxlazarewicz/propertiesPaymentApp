DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `translated_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
