SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`campus`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`campus` ;

CREATE TABLE IF NOT EXISTS `mydb`.`campus` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `campusname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `CampusName_UNIQUE` (`campusname` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`trip`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`trip` ;

CREATE TABLE IF NOT EXISTS `mydb`.`trip` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `tripname` VARCHAR(45) NOT NULL,
  `campus` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`user` ;

CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `studentid` INT UNSIGNED NOT NULL,
  `campus` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `studentid_UNIQUE` (`studentid` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tripbag`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`tripbag` ;

CREATE TABLE IF NOT EXISTS `mydb`.`tripbag` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `trip` INT UNSIGNED NOT NULL,
  `user` INT UNSIGNED NOT NULL,
  `quantity` INT UNSIGNED NULL,
  INDEX `fk_tripbag_user_idx` (`user` ASC),
  INDEX `fk_tripbag_trip_idx` (`trip` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_tripbag_user`
    FOREIGN KEY (`user`)
    REFERENCES `mydb`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_tripbag_trip`
    FOREIGN KEY (`trip`)
    REFERENCES `mydb`.`trip` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mydb`.`trip`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`trip` (`id`, `tripname`, `campus`) VALUES (NULL, 'Happy Terrils', 'Valenciennes');
INSERT INTO `mydb`.`trip` (`id`, `tripname`, `campus`) VALUES (NULL, 'Gastronomic', 'Paris');
INSERT INTO `mydb`.`trip` (`id`, `tripname`, `campus`) VALUES (NULL, 'Versailles', 'Paris');
INSERT INTO `mydb`.`trip` (`id`, `tripname`, `campus`) VALUES (NULL, 'MegaZorb', 'NY');
INSERT INTO `mydb`.`trip` (`id`, `tripname`, `campus`) VALUES (NULL, 'Shield', 'NY');

COMMIT;

