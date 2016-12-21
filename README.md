# consol


CREATE SCHEMA `luxoft` ;


CREATE TABLE `luxoft`.`file` 
(
  `id` INT NOT NULL AUTO_INCREMENT,
 
 `fileName` VARCHAR(100) NOT NULL,
 
 `longWord` VARCHAR(100) NULL,
 
 `shortWord` VARCHAR(100) NULL,
 
 `lineLength` INT NULL,
  PRIMARY KEY (`idfile`));


CREATE TABLE `luxoft`.`line` 
(
  `id` INT NOT NULL AUTO_INCREMENT,
 
 `longWord` VARCHAR(100) NULL,
  
 `shortWord` VARCHAR(100) NULL,
 
 `lineLength` INT NULL,
  
 `idfile` INT NULL,
 
 `avgWord` DOUBLE NULL,
 
 PRIMARY KEY (`idline`));
