-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `LabFM` DEFAULT CHARACTER SET utf8 ;
USE `LabFM` ;


-- -----------------------------------------------------
-- Table `LabFM`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LabFM`.`usuario` (
  `id_usuario` int AUTO_INCREMENT ,
  `username` VARCHAR(100),
  `password` VARCHAR(100),
  PRIMARY KEY (`id_usuario`))
  ENGINE = InnoDB 
  CHARACTER SET = utf8;



-- -----------------------------------------------------
-- Table `LabFM`.`Clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LabFM`.`Clientes` (
  `Numero_Tarjeta` VARCHAR(100),
  `Nombre_Cliente` VARCHAR(100),
  `Dpi_Cliente` VARCHAR(100),
  `Telefono_Cliente` VARCHAR(100),
  `Dirreccion_Cliente` VARCHAR(100),
  `Correo_Cliente` VARCHAR(100),
   `Mora_Acumulada` VARCHAR(100),
  `Renta_Acumulada` VARCHAR(100),
  `Bonos_Acumulados` VARCHAR(100),
  PRIMARY KEY (`Numero_Tarjeta`))
  ENGINE = InnoDB 
  CHARACTER SET = utf8;


  
  
  
  
    -- -----------------------------------------------------
-- Table `LabFM`.`GeneroPelicula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LabFM`.`GeneroPelicula` (
  `Genero_Pelicula` VARCHAR(100),
  `Nombre_Pelicula` VARCHAR(100),
  `Codigo_Pelicula` VARCHAR(100),
  PRIMARY KEY (`Genero_Pelicula`),
CONSTRAINT `fkGeneroArticuloGeneroPelicula1`
FOREIGN KEY (`Codigo_Pelicula`)
REFERENCES `LabFM`.`TipoPelicula` (`Codigo_Pelicula`))
  ENGINE = InnoDB 
  CHARACTER SET = utf8;
  
  

  

      -- -----------------------------------------------------
-- Table `LabFM`.`Tiendas`
-- -----------------------------------------------------
  
  CREATE TABLE IF NOT EXISTS `LabFM`.`Tiendas` (
  `Codigo_Tienda` VARCHAR(100),
  `Nombre_Tienda` VARCHAR(100),
  `Ubicacion_Tienda` VARCHAR(100),
  `Estado_Tienda` VARCHAR(100),
  PRIMARY KEY (`Codigo_Tienda`))
  ENGINE = InnoDB 
  CHARACTER SET = utf8;
  
  
  
  -- -----------------------------------------------------
-- Table `LabFM`.`TipoPelicula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LabFM`.`TipoPelicula` (
  `Codigo_Pelicula` VARCHAR(100),
  `Nombre_Pelicula` VARCHAR(100),
  PRIMARY KEY (`Codigo_Pelicula`))
  ENGINE = InnoDB 
  CHARACTER SET = utf8;
  

        -- -----------------------------------------------------
-- Table `LabFM`.`Empleados`
-- -----------------------------------------------------
  
  
    CREATE TABLE IF NOT EXISTS `LabFM`.`Empleados` (
  `Codigo_Empleado` VARCHAR(100),
  `Codigo_Tienda` VARCHAR(100),
  `Nombre_Empleado` VARCHAR(100),
  `Estado_Empleado` VARCHAR(100),
  PRIMARY KEY (`Codigo_Empleado`),
CONSTRAINT `fkEmpleadosTiendas1`
FOREIGN KEY (`Codigo_Tienda`)
REFERENCES `LabFM`.`Tiendas` (`Codigo_Tienda`))
  ENGINE = InnoDB 
  CHARACTER SET = utf8;
  
  
     -- -----------------------------------------------------
-- Table `LabFM`.`Peliculas`
-- -----------------------------------------------------
  
  
    CREATE TABLE IF NOT EXISTS `LabFM`.`Pelicula` (
  `Codigo_Pelicula` VARCHAR(100),
  `Nombre_Pelicula` VARCHAR(100),
  `Autor_Pelicula` VARCHAR(100),
  `Genero_Pelicula` VARCHAR(100),
`Clasificacion_Pelicula` VARCHAR(100),
  `Duracion_Pelicula` VARCHAR(100),
  `Precio_Pelicula` VARCHAR(100),
  `Existencias` VARCHAR(100),
  `Tienda` VARCHAR(100),
  PRIMARY KEY (`Codigo_Pelicula`),
CONSTRAINT `fkPeliculaGeneroPelicula1`
FOREIGN KEY (`Genero_Pelicula`)
REFERENCES `LabFM`.`GeneroPelicula` (`Genero_Pelicula`),
CONSTRAINT `fkPeliculaClasificacioPelicula1`
FOREIGN KEY (`Clasificacion_Pelicula`)
REFERENCES `LabFM`.`ClasificacioPelicula` (`CodigoClasificacion_Pelicula`),
CONSTRAINT `fkPeliculaTiendas1`
FOREIGN KEY (`Tienda`)
REFERENCES `LabFM`.`Tiendas` (`Codigo_Tienda`))
  ENGINE = InnoDB 
  CHARACTER SET = utf8;
  
  
       -- -----------------------------------------------------
-- Table `LabFM`.`Rentas`
-- -----------------------------------------------------
  
  
    CREATE TABLE IF NOT EXISTS `LabFM`.`Rentas` (
  `Codigo_Renta` VARCHAR(100),
  `Codigo_Tienda` VARCHAR(100),
  `Codigo_Tarjeta` VARCHAR(100),
  `Codigo_Pelicula` VARCHAR(100),
`Cantidad_Peliculas` VARCHAR(100),
  `Total_Renta` VARCHAR(100),
  `Mora` VARCHAR(100),
  `Fecha_Inicio` VARCHAR(100),
`Fecha_Vencimiento` VARCHAR(100),
  PRIMARY KEY (`Codigo_Renta`),
CONSTRAINT `fkRentasClientes1`
FOREIGN KEY (`Codigo_Tarjeta`)
REFERENCES `LabFM`.`Clientes` (`Numero_Tarjeta`),
CONSTRAINT `fkRentasPelicula1`
FOREIGN KEY (`Codigo_Pelicula`)
REFERENCES `LabFM`.`Pelicula` (`Codigo_Pelicula`),
CONSTRAINT `fkRentasTiendas1`
FOREIGN KEY (`Codigo_Tienda`)
REFERENCES `LabFM`.`Tiendas` (`Codigo_Tienda`))
  ENGINE = InnoDB 
  CHARACTER SET = utf8;
  
  
  
       -- -----------------------------------------------------
-- Table `LabFM`.`Rentas`
-- -----------------------------------------------------
  
  
    CREATE TABLE IF NOT EXISTS `LabFM`.`Devoluciones` (
  `Codigo_Devolucion` VARCHAR(100),
  `Codigo_Renta` VARCHAR(100),
  `Fecha_Devolucion` VARCHAR(100),
  PRIMARY KEY (`Codigo_Devolucion`),
CONSTRAINT `fkDevolucionesRentas1`
FOREIGN KEY (`Codigo_Renta`)
REFERENCES `LabFM`.`Rentas` (`Codigo_Renta`))
  ENGINE = InnoDB 
  CHARACTER SET = utf8;
