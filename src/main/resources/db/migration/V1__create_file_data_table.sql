DROP TABLE IF EXISTS `file_data`;

CREATE TABLE `file_data` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `added_day` datetime DEFAULT NULL,
  `content_type` varchar(255) DEFAULT NULL,
  `file_data` tinyblob,
  `original_file_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
