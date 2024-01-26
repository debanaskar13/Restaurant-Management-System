CREATE TABLE `restaurant`.`restaurants`( 
	`id` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
	`name` varchar(50) NOT NULL, 
	`address` varchar(200) NOT NULL, 
	`phone_number` varchar(20) NOT NULL, 
	`email` varchar(50) NOT NULL, 
	`manager_id` BIGINT NOT NULL, 
	`created_at` DATETIME NOT NULL, 
	`updated_at` DATETIME, 
	CONSTRAINT `fk_restaurant_table`
	    FOREIGN KEY (`manager_id`)
	    REFERENCES `restaurant`.`users` (`id`)
);
