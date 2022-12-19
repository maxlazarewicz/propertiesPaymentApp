create SCHEMA IF NOT EXISTS payment;

drop table IF EXISTS `file_data` cascade;
create TABLE `file_data` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `added_day` datetime DEFAULT NULL,
  `content_type` varchar(255) DEFAULT NULL,
  `file_data` tinyblob,
  `original_file_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
drop table IF EXISTS `lead_status` cascade;
create TABLE `lead_status` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `full_name` varchar(50) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
drop table IF EXISTS `property` cascade;
create TABLE `property` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apartment_number` int NOT NULL,
  `city` varchar(20) DEFAULT NULL,
  `house_number` int NOT NULL,
  `postal_code` varchar(6) DEFAULT NULL,
  `province` varchar(30) DEFAULT NULL,
  `street` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
drop table IF EXISTS `roles` cascade;
create TABLE `roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `translated_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
drop table IF EXISTS `users` cascade ;
create TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `password` varchar(120) DEFAULT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
drop table IF EXISTS `leads` cascade ;
create TABLE `leads` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `creation_date` datetime DEFAULT NULL,
  `ending_date` datetime DEFAULT NULL,
  `administrative_rent` varchar(255) DEFAULT NULL,
  `electricity_payment` varchar(255) DEFAULT NULL,
  `water_payment` varchar(255) DEFAULT NULL,
  `lead_status_id` bigint NOT NULL,
  `property_id` bigint NOT NULL,
  `owner` varchar(255) DEFAULT NULL,
  `tenant` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgrmtbagliqr9pxgqn6ricb7ie` (`lead_status_id`),
  KEY `FKlcxv0tfpl7y6p02njf18c6eu8` (`property_id`),
  CONSTRAINT `FKgrmtbagliqr9pxgqn6ricb7ie` FOREIGN KEY (`lead_status_id`) REFERENCES `lead_status` (`id`),
  CONSTRAINT `FKlcxv0tfpl7y6p02njf18c6eu8` FOREIGN KEY (`property_id`) REFERENCES `property` (`id`)
);




