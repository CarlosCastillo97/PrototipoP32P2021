-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema FilmMagic
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema FilmMagic
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `FilmMagic` ;
USE `FilmMagic` ;

-- -----------------------------------------------------
-- Table `FilmMagic`.`Clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FilmMagic`.`Clientes` (
  `Membresia` VARCHAR(100) NOT NULL,
  `Nombre_Cliente` VARCHAR(45) NOT NULL,
  `Dpi_Cliente` VARCHAR(45) NOT NULL,
  `Telefono_Cliente` VARCHAR(45) NOT NULL,
  `Direccion_Cliente` VARCHAR(45) NOT NULL,
  `Correo_Cliente` VARCHAR(45) NOT NULL,
  `Mora_Acumulada` VARCHAR(45) NULL,
  `Renta_Acumulada` VARCHAR(45) NULL,
  PRIMARY KEY (`Membresia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FilmMagic`.`Empleados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FilmMagic`.`Empleados` (
  `Codigo_Empleado` VARCHAR(100) NOT NULL,
  `Nombre_Empleado` VARCHAR(45) NOT NULL,
  `Estado_Empleado` VARCHAR(45) NOT NULL,
  `User_Empleado` VARCHAR(45) NOT NULL,
  `Pass_Empleado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Codigo_Empleado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FilmMagic`.`Renta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FilmMagic`.`Renta` (
  `Codigo_Renta` VARCHAR(100) NOT NULL,
  `Membresia` VARCHAR(45) NULL,
  `Cantidad_Peliculas` VARCHAR(45) NULL,
  `Fecha_Inicio` VARCHAR(45) NULL,
  `Fecha_Vencimiento` VARCHAR(45) NULL,
  `Mora` VARCHAR(45) NULL,
  PRIMARY KEY (`Codigo_Renta`),
  CONSTRAINT `FK_Membresia`
    FOREIGN KEY (`Membresia`)
    REFERENCES `FilmMagic`.`Clientes` (`Membresia`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
