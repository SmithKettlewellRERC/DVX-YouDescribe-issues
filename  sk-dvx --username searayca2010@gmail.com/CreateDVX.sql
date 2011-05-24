# SQL Manager 2010 for MySQL 4.6.0.5
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : SK_DVX


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES latin1 */;

SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `sk_dvx`;

CREATE DATABASE `SK_DVX`
    CHARACTER SET 'latin1'
    COLLATE 'latin1_swedish_ci';

USE `sk_dvx`;

#
# Structure for the `user` table : 
#

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` text,
  `user_password` text,
  `user_last_login` datetime DEFAULT NULL,
  `user_active` tinyint(1) NOT NULL DEFAULT '1',
  `user_type` int(11) NOT NULL DEFAULT '0',
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `author` table : 
#

CREATE TABLE `author` (
  `author_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_fk` int(11) DEFAULT NULL,
  `created` int(11) DEFAULT NULL,
  `modified` int(11) DEFAULT NULL,
  PRIMARY KEY (`author_id`),
  KEY `user_fk` (`user_fk`),
  CONSTRAINT `author_fk` FOREIGN KEY (`user_fk`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `continent` table : 
#

CREATE TABLE `continent` (
  `continent_id` int(11) NOT NULL AUTO_INCREMENT,
  `continent_name` text,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  PRIMARY KEY (`continent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `country` table : 
#

CREATE TABLE `country` (
  `country_id` int(11) NOT NULL AUTO_INCREMENT,
  `country_name` text,
  `country_name_short` text,
  `continent_id_fk` int(11) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  PRIMARY KEY (`country_id`),
  KEY `contenet_id_fk` (`continent_id_fk`),
  CONSTRAINT `country_fk` FOREIGN KEY (`continent_id_fk`) REFERENCES `continent` (`continent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `state` table : 
#

CREATE TABLE `state` (
  `state_id` int(11) NOT NULL AUTO_INCREMENT,
  `state_name` int(11) DEFAULT NULL,
  `state_country_fk` int(11) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` date DEFAULT NULL,
  PRIMARY KEY (`state_id`),
  KEY `state_country_fk` (`state_country_fk`),
  CONSTRAINT `state_fk` FOREIGN KEY (`state_country_fk`) REFERENCES `country` (`country_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `city` table : 
#

CREATE TABLE `city` (
  `city_id` int(11) NOT NULL AUTO_INCREMENT,
  `city_name` text,
  `state_fk` int(11) DEFAULT NULL,
  `city_country_fk` int(11) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  PRIMARY KEY (`city_id`),
  KEY `state_fk` (`state_fk`),
  KEY `city_country_fk` (`city_country_fk`),
  CONSTRAINT `city_fk1` FOREIGN KEY (`state_fk`) REFERENCES `state` (`state_id`),
  CONSTRAINT `city_fk` FOREIGN KEY (`city_country_fk`) REFERENCES `country` (`country_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `crew_cast` table : 
#

CREATE TABLE `crew_cast` (
  `crew_cast_id` int(11) NOT NULL AUTO_INCREMENT,
  `crew_cast_full_name` text,
  `crew_cast_first_name` text,
  `crew_cast_middle_name` text,
  `crew_cast_last_name` text,
  `crew_cast_birthday` date DEFAULT NULL,
  `crew_cast_description` text,
  `crew_cast_biography` text,
  `crew_cast_author_fk` int(11) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`crew_cast_id`),
  KEY `crew_cast_author_fk` (`crew_cast_author_fk`),
  CONSTRAINT `crew_cast_fk` FOREIGN KEY (`crew_cast_author_fk`) REFERENCES `author` (`author_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `rating` table : 
#

CREATE TABLE `rating` (
  `rating_id` int(11) NOT NULL,
  `rating_name` text,
  `rating_name_short` text,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  PRIMARY KEY (`rating_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `status` table : 
#

CREATE TABLE `status` (
  `status_id` int(11) NOT NULL,
  `status_description` text,
  `created` int(11) DEFAULT NULL,
  `modified` int(11) DEFAULT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `movie` table : 
#

CREATE TABLE `movie` (
  `movie_id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_name` text,
  `movie_sbn_number` text,
  `movie_released` date DEFAULT NULL,
  `movie_rated_fk` int(11) DEFAULT NULL,
  `movie_rating` int(11) DEFAULT '10',
  `movie_quote` text,
  `movie_description` text,
  `movie_status_fk` int(11) DEFAULT '1',
  `movie_runtime` int(11) DEFAULT NULL,
  `movie_budget` int(11) DEFAULT NULL,
  `movie_revenue` int(11) DEFAULT NULL,
  `movie_webpage` text,
  `movie_country_of_origin_fk` int(11) DEFAULT NULL,
  `created` int(11) DEFAULT NULL,
  `modified` int(11) DEFAULT NULL,
  PRIMARY KEY (`movie_id`),
  KEY `movie_rated_fk` (`movie_rated_fk`),
  KEY `movie_status_fk` (`movie_status_fk`),
  KEY `movie_country_of_origin_fk` (`movie_country_of_origin_fk`),
  CONSTRAINT `movie_fk2` FOREIGN KEY (`movie_country_of_origin_fk`) REFERENCES `country` (`country_id`),
  CONSTRAINT `movie_fk` FOREIGN KEY (`movie_rated_fk`) REFERENCES `rating` (`rating_id`),
  CONSTRAINT `movie_fk1` FOREIGN KEY (`movie_status_fk`) REFERENCES `status` (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `description` table : 
#

CREATE TABLE `description` (
  `description_id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_fk` int(11) DEFAULT NULL,
  `author_fk` int(11) DEFAULT NULL,
  `description_long` text,
  `description_short` text,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  PRIMARY KEY (`description_id`),
  KEY `movie_fk` (`movie_fk`),
  KEY `author_fk` (`author_fk`),
  CONSTRAINT `description_fk1` FOREIGN KEY (`author_fk`) REFERENCES `author` (`author_id`),
  CONSTRAINT `description_fk` FOREIGN KEY (`movie_fk`) REFERENCES `movie` (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `geocode` table : 
#

CREATE TABLE `geocode` (
  `geocode_id` int(11) NOT NULL,
  `geocode_latitude` float(9,3) DEFAULT NULL,
  `geocode_longitude` float(9,3) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  PRIMARY KEY (`geocode_id`)
  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `language` table : 
#

CREATE TABLE `language` (
  `language_id` int(11) NOT NULL AUTO_INCREMENT,
  `language_name` text,
  `language_name_short` text,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  PRIMARY KEY (`language_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `movie_cast` table : 
#

CREATE TABLE `movie_cast` (
  `movie_cast_id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_cast_movie_id_fk` int(11) DEFAULT NULL,
  `movie_cast_crew_cast_id_fk` int(11) DEFAULT NULL,
  `movie_cast_role_order` int(11) DEFAULT NULL,
  `movie_cast_role_name` text,
  `movie_cast_role_description` text,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  PRIMARY KEY (`movie_cast_id`),
  KEY `movie_cast_movie_id_fk` (`movie_cast_movie_id_fk`),
  KEY `movie_cast_crew_cast_id_fk` (`movie_cast_crew_cast_id_fk`),
  CONSTRAINT `movie_cast_fk1` FOREIGN KEY (`movie_cast_crew_cast_id_fk`) REFERENCES `crew_cast` (`crew_cast_id`),
  CONSTRAINT `movie_cast_fk` FOREIGN KEY (`movie_cast_movie_id_fk`) REFERENCES `movie` (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `movie_chapter` table : 
#

CREATE TABLE `movie_chapter` (
  `movie_chapter_id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_fk` int(11) DEFAULT NULL,
  `movie_chapter_description` text,
  `movie_chapter_name` text,
  `movie_chapter_start_time` time DEFAULT NULL,
  `movie_chapter_end_time` time DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  PRIMARY KEY (`movie_chapter_id`),
  KEY `movie_fk` (`movie_fk`),
  CONSTRAINT `movie_chapter_fk` FOREIGN KEY (`movie_fk`) REFERENCES `movie` (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `movie_genre` table : 
#

CREATE TABLE `movie_genre` (
  `movie_genre_id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_genre_description` text,
  `movie_genre_description_long` text,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  PRIMARY KEY (`movie_genre_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `movie_trailer` table : 
#

CREATE TABLE `movie_trailer` (
  `movie_trailer_id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_id_fk` int(11) DEFAULT NULL,
  `movie_trailer_uri` text,
  `movie_trailer_index` int(11) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  PRIMARY KEY (`movie_trailer_id`),
  KEY `movie_id_fk` (`movie_id_fk`),
  CONSTRAINT `movie_trailer_fk` FOREIGN KEY (`movie_id_fk`) REFERENCES `movie` (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `poster` table : 
#

CREATE TABLE `poster` (
  `poster_id` int(11) NOT NULL AUTO_INCREMENT,
  `poster_movie_id_fk` int(11) DEFAULT NULL,
  `poster_name` text,
  `poster_url` text,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  PRIMARY KEY (`poster_id`),
  KEY `poster_movie_id_fk` (`poster_movie_id_fk`),
  CONSTRAINT `poster_fk` FOREIGN KEY (`poster_movie_id_fk`) REFERENCES `movie` (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `zip_code` table : 
#

CREATE TABLE `zip_code` (
  `zip_code_id` int(11) NOT NULL AUTO_INCREMENT,
  `zip_code` int(11) DEFAULT NULL,
  `zip_code_extended` int(11) DEFAULT NULL,
  `zip_code_geocode_fk` int(11) DEFAULT NULL,
  `zip_code_city_fk` int(11) DEFAULT NULL,
  `zip_code_state_fk` int(11) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  PRIMARY KEY (`zip_code_id`),
  KEY `zip_code_geocode_fk` (`zip_code_geocode_fk`),
  KEY `zip_code_city_fk` (`zip_code_city_fk`),
  KEY `zip_code_state_fk` (`zip_code_state_fk`),
  CONSTRAINT `zip_code_fk2` FOREIGN KEY (`zip_code_state_fk`) REFERENCES `state` (`state_id`),
  CONSTRAINT `zip_code_fk` FOREIGN KEY (`zip_code_geocode_fk`) REFERENCES `geocode` (`geocode_id`),
  CONSTRAINT `zip_code_fk1` FOREIGN KEY (`zip_code_city_fk`) REFERENCES `city` (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `user_detail` table : 
#

CREATE TABLE `user_detail` (
  `user_detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_detail_user_fk` int(11) NOT NULL,
  `user_detail_first_name` text,
  `user_detail_last_name` text,
  `user_detail_email` text,
  `user_detail_address_1` text,
  `user_detail_address_2` text,
  `user_detail_city_fk` int(11) DEFAULT NULL,
  `user_detail_state_fk` int(11) DEFAULT NULL,
  `user_detail_zip_code_fk` int(11) DEFAULT NULL,
  `user_detail_country_fk` int(11) DEFAULT NULL,
  `user_detail_work_phone_number` text,
  `user_detail_home_phone_number` text,
  `user_detail_mobil_phone_number` text,
  `user_detail_subscription_start` date DEFAULT '2011-05-23',
  `user_detail_subscription_end_date` date DEFAULT '2020-05-23',
  `user_detail_active` tinyint(1) DEFAULT '1',
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  PRIMARY KEY (`user_detail_id`),
  KEY `user_fk` (`user_detail_user_fk`),
  KEY `user_city_fk` (`user_detail_city_fk`),
  KEY `user_state_fk` (`user_detail_state_fk`),
  KEY `user_zip_code_fk` (`user_detail_zip_code_fk`),
  KEY `user_detail_home_phone_number` (`user_detail_home_phone_number`(1)),
  KEY `user_detail_country_fk` (`user_detail_country_fk`),
  CONSTRAINT `user_detail_fk4` FOREIGN KEY (`user_detail_country_fk`) REFERENCES `country` (`country_id`),
  CONSTRAINT `user_detail_fk` FOREIGN KEY (`user_detail_user_fk`) REFERENCES `user` (`user_id`),
  CONSTRAINT `user_detail_fk1` FOREIGN KEY (`user_detail_city_fk`) REFERENCES `city` (`city_id`),
  CONSTRAINT `user_detail_fk2` FOREIGN KEY (`user_detail_state_fk`) REFERENCES `state` (`state_id`),
  CONSTRAINT `user_detail_fk3` FOREIGN KEY (`user_detail_zip_code_fk`) REFERENCES `zip_code` (`zip_code_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `user_profile` table : 
#

CREATE TABLE `user_profile` (
  `user_profile_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_fk` int(11) DEFAULT NULL,
  `user_detail_fk` int(11) DEFAULT NULL,
  `user_profile_vision_impared` int(11) DEFAULT NULL,
  `user_profile_motion_impared` int(11) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  PRIMARY KEY (`user_profile_id`),
  KEY `user_fk` (`user_fk`),
  KEY `user_detail_fk` (`user_detail_fk`),
  CONSTRAINT `user_profile_fk` FOREIGN KEY (`user_fk`) REFERENCES `user` (`user_id`),
  CONSTRAINT `user_profile_fk1` FOREIGN KEY (`user_detail_fk`) REFERENCES `user_detail` (`user_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;