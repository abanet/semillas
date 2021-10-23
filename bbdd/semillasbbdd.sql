-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema Semillas
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Semillas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Semillas` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `Semillas` ;

-- -----------------------------------------------------
-- Table `Semillas`.`Altitud`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Semillas`.`Altitud` ;

CREATE TABLE IF NOT EXISTS `Semillas`.`Altitud` (
  `idAltitud` INT NOT NULL AUTO_INCREMENT,
  `metros` INT NOT NULL,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idAltitud`),
  UNIQUE INDEX `metros_UNIQUE` (`metros` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Semillas`.`Especie`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Semillas`.`Especie` ;

CREATE TABLE IF NOT EXISTS `Semillas`.`Especie` (
  `idEspecie` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`idEspecie`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Semillas`.`Variedad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Semillas`.`Variedad` ;

CREATE TABLE IF NOT EXISTS `Semillas`.`Variedad` (
  `idVariedad` INT NOT NULL AUTO_INCREMENT,
  `codigo` INT NULL DEFAULT NULL,
  `variedad` VARCHAR(255) NOT NULL,
  `nombre` VARCHAR(255) NOT NULL,
  `url` VARCHAR(255) NULL,
  `profundidad` INT NULL COMMENT 'profundidad a la que se planta en cm',
  `germina` INT NULL COMMENT 'Tiempo que tarda en germinar en días.',
  `sizetransplante` INT NULL COMMENT 'Tamaño con el que se puede transplantar en cm.',
  `distancia` INT NULL COMMENT 'Distancia entre plantas en la misma fila en cm',
  `distinciafilas` INT NULL COMMENT 'Distancia entre filas',
  `recoleccion` INT NULL COMMENT 'Tiempo desde q se planta hasta que se puede comer en días.',
  `tiemposemillas` INT NULL COMMENT 'Tiempo q se tarda en dar semillas en meses.',
  `temperaturaideal` INT NULL COMMENT 'Temperatura ideal para la planta en grados centígrados.',
  `temperaturaminima` INT NULL COMMENT 'Temperatura mínima para la planta en grados centígrados',
  `temperaturamaxima` INT NULL COMMENT 'Temperatura máxima para la planta en grados centígrados',
  `fechacontrolgerminacion` DATETIME NOT NULL COMMENT 'Fecha de control de germinación (es como la fecha de caducidad)',
  `porcentajegerminacion` INT NOT NULL COMMENT 'Porcentaje de semillas que germinan.',
  `phoptimo` VARCHAR(45) NULL COMMENT 'Ph óptimo de la tierra en la que se planta',
  `idEspecie` INT NOT NULL,
  PRIMARY KEY (`idVariedad`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE,
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC) VISIBLE,
  INDEX `fk_Variedad_Especie1_idx` (`idEspecie` ASC) VISIBLE,
  CONSTRAINT `fk_Variedad_Especie1`
    FOREIGN KEY (`idEspecie`)
    REFERENCES `Semillas`.`Especie` (`idEspecie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Semillas`.`Latitud`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Semillas`.`Latitud` ;

CREATE TABLE IF NOT EXISTS `Semillas`.`Latitud` (
  `idLatitud` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`idLatitud`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Semillas`.`Zona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Semillas`.`Zona` ;

CREATE TABLE IF NOT EXISTS `Semillas`.`Zona` (
  `idAltitud` INT NOT NULL,
  `idLatitud` INT NOT NULL,
  `idZona` INT NOT NULL AUTO_INCREMENT,
  INDEX `fk_Zona_Altitud1_idx` (`idAltitud` ASC) VISIBLE,
  INDEX `fk_Zona_Latitud1_idx` (`idLatitud` ASC) VISIBLE,
  PRIMARY KEY (`idZona`),
  CONSTRAINT `fk_Zona_Altitud1`
    FOREIGN KEY (`idAltitud`)
    REFERENCES `Semillas`.`Altitud` (`idAltitud`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Zona_Latitud1`
    FOREIGN KEY (`idLatitud`)
    REFERENCES `Semillas`.`Latitud` (`idLatitud`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Semillas`.`Mes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Semillas`.`Mes` ;

CREATE TABLE IF NOT EXISTS `Semillas`.`Mes` (
  `idMes` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idMes`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Semillas`.`Luna`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Semillas`.`Luna` ;

CREATE TABLE IF NOT EXISTS `Semillas`.`Luna` (
  `idLuna` INT NOT NULL AUTO_INCREMENT,
  `fase` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idLuna`),
  UNIQUE INDEX `fase_UNIQUE` (`fase` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Semillas`.`Guardian`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Semillas`.`Guardian` ;

CREATE TABLE IF NOT EXISTS `Semillas`.`Guardian` (
  `idGuardian` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `mail` VARCHAR(45) NOT NULL,
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE,
  UNIQUE INDEX `telefono_UNIQUE` (`telefono` ASC) VISIBLE,
  UNIQUE INDEX `mail_UNIQUE` (`mail` ASC) VISIBLE,
  PRIMARY KEY (`idGuardian`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Semillas`.`FormasPlantacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Semillas`.`FormasPlantacion` ;

CREATE TABLE IF NOT EXISTS `Semillas`.`FormasPlantacion` (
  `idFormasPlantacion` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idFormasPlantacion`),
  UNIQUE INDEX `descripcion_UNIQUE` (`descripcion` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Semillas`.`Glosario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Semillas`.`Glosario` ;

CREATE TABLE IF NOT EXISTS `Semillas`.`Glosario` (
  `termino` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(1024) NULL,
  PRIMARY KEY (`termino`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Semillas`.`Origen`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Semillas`.`Origen` ;

CREATE TABLE IF NOT EXISTS `Semillas`.`Origen` (
  `idOrigen` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL COMMENT 'Descripción del lugar que es origen de una especie',
  PRIMARY KEY (`idOrigen`),
  UNIQUE INDEX `descripcion_UNIQUE` (`descripcion` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Semillas`.`GuardianOrigen`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Semillas`.`GuardianOrigen` ;

CREATE TABLE IF NOT EXISTS `Semillas`.`GuardianOrigen` (
  `idGuardian` INT NULL,
  `idOrigen` INT NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  INDEX `fk_Guardian_has_Origen_Origen1_idx` (`idOrigen` ASC) VISIBLE,
  INDEX `fk_Guardian_has_Origen_Guardian1_idx` (`idGuardian` ASC) VISIBLE,
  CONSTRAINT `fk_Guardian_has_Origen_Guardian1`
    FOREIGN KEY (`idGuardian`)
    REFERENCES `Semillas`.`Guardian` (`idGuardian`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Guardian_has_Origen_Origen1`
    FOREIGN KEY (`idOrigen`)
    REFERENCES `Semillas`.`Origen` (`idOrigen`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Semillas`.`Plantacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Semillas`.`Plantacion` ;

CREATE TABLE IF NOT EXISTS `Semillas`.`Plantacion` (
  `idPlantacion` INT NOT NULL AUTO_INCREMENT,
  `idMes` INT NOT NULL,
  `idLuna` INT NOT NULL,
  `idFormasPlantacion` INT NOT NULL,
  `idGuardian` INT NOT NULL,
  `idVariedad` INT NOT NULL,
  `idZona` INT NOT NULL,
  PRIMARY KEY (`idPlantacion`),
  INDEX `fk_Plantacion_Mes1_idx` (`idMes` ASC) VISIBLE,
  INDEX `fk_Plantacion_Luna1_idx` (`idLuna` ASC) VISIBLE,
  INDEX `fk_Plantacion_FormasPlantacion1_idx` (`idFormasPlantacion` ASC) VISIBLE,
  INDEX `fk_Plantacion_Guardian1_idx` (`idGuardian` ASC) VISIBLE,
  INDEX `fk_Plantacion_Variedad1_idx` (`idVariedad` ASC) VISIBLE,
  INDEX `fk_Plantacion_Zona1_idx` (`idZona` ASC) VISIBLE,
  CONSTRAINT `fk_Plantacion_Mes1`
    FOREIGN KEY (`idMes`)
    REFERENCES `Semillas`.`Mes` (`idMes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Plantacion_Luna1`
    FOREIGN KEY (`idLuna`)
    REFERENCES `Semillas`.`Luna` (`idLuna`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Plantacion_FormasPlantacion1`
    FOREIGN KEY (`idFormasPlantacion`)
    REFERENCES `Semillas`.`FormasPlantacion` (`idFormasPlantacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Plantacion_Guardian1`
    FOREIGN KEY (`idGuardian`)
    REFERENCES `Semillas`.`Guardian` (`idGuardian`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Plantacion_Variedad1`
    FOREIGN KEY (`idVariedad`)
    REFERENCES `Semillas`.`Variedad` (`idVariedad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Plantacion_Zona1`
    FOREIGN KEY (`idZona`)
    REFERENCES `Semillas`.`Zona` (`idZona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Semillas`.`Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Semillas`.`Cliente` ;

CREATE TABLE IF NOT EXISTS `Semillas`.`Cliente` (
  `idCliente` INT NOT NULL,
  `identificador` VARCHAR(45) NULL COMMENT 'número o código que permite q cuando entra el cliente le muestre la búsqueda por defecto.',
  `email` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
