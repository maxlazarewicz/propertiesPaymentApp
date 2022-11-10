DROP TABLE IF EXISTS `leads`;
CREATE TABLE `leads` (
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
)

