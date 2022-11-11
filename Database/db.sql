-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bnc_rest_api
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bnc_rest_api
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bnc_rest_api` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `bnc_rest_api` ;

-- -----------------------------------------------------
-- Table `bnc_rest_api`.`distribution`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bnc_rest_api`.`distribution` (
  `distribution_id` INT NOT NULL AUTO_INCREMENT,
  `order_id` INT NULL DEFAULT NULL,
  `delivery_cost` DOUBLE NULL DEFAULT NULL,
  `shipping` VARCHAR(45) NULL DEFAULT NULL,
  `date_` VARCHAR(45) NULL DEFAULT NULL,
  `location` VARCHAR(45) NULL DEFAULT NULL,
  `time_` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`distribution_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bnc_rest_api`.`funding_management`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bnc_rest_api`.`funding_management` (
  `fund_id` INT NOT NULL AUTO_INCREMENT,
  `funding_provider_name` VARCHAR(45) NULL DEFAULT NULL,
  `contact_no` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `amount` DOUBLE NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`fund_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bnc_rest_api`.`order_management`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bnc_rest_api`.`order_management` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(45) NULL DEFAULT NULL,
  `quantity` INT NULL DEFAULT NULL,
  `customer_name` VARCHAR(45) NULL DEFAULT NULL,
  `customer_address` VARCHAR(45) NULL DEFAULT NULL,
  `contact_no` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bnc_rest_api`.`payment_management`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bnc_rest_api`.`payment_management` (
  `payment_id` INT NOT NULL AUTO_INCREMENT,
  `name_on_card` VARCHAR(45) NULL DEFAULT NULL,
  `card_number` VARCHAR(45) NULL DEFAULT NULL,
  `cvv` VARCHAR(45) NULL DEFAULT NULL,
  `exp_day` VARCHAR(45) NULL DEFAULT NULL,
  `amout` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`payment_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bnc_rest_api`.`product_management`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bnc_rest_api`.`product_management` (
  `product_id` INT NOT NULL AUTO_INCREMENT,
  `product_code` VARCHAR(45) NULL DEFAULT NULL,
  `product_name` VARCHAR(45) NULL DEFAULT NULL,
  `product_price` DOUBLE NULL DEFAULT NULL,
  `quantity` INT NULL DEFAULT NULL,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`product_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
