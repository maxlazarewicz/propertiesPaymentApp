DROP TABLE IF EXISTS `file_data`;

CREATE TABLE `file_data` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `added_day` datetime DEFAULT NULL,
  `content_type` varchar(255) DEFAULT NULL,
  `file_data` tinyblob,
  `original_file_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

