-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema GestioneIstitutoScolastico
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema GestioneIstitutoScolastico
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `GestioneIstitutoScolastico` DEFAULT CHARACTER SET utf8 ;
USE `GestioneIstitutoScolastico` ;

-- -----------------------------------------------------
-- Table `GestioneIstitutoScolastico`.`Presidi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GestioneIstitutoScolastico`.`Presidi` (
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GestioneIstitutoScolastico`.`Classi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GestioneIstitutoScolastico`.`Classi` (
  `anno` VARCHAR(45) NOT NULL,
  `sezione` VARCHAR(45) NOT NULL,
  `Presidi_username` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`anno`, `sezione`),
  INDEX `fk_Classi_Presidi_idx` (`Presidi_username` ASC) VISIBLE,
  CONSTRAINT `fk_Classi_Presidi`
    FOREIGN KEY (`Presidi_username`)
    REFERENCES `GestioneIstitutoScolastico`.`Presidi` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GestioneIstitutoScolastico`.`Alunni`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GestioneIstitutoScolastico`.`Alunni` (
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL,
  `nome` VARCHAR(45) NULL,
  `cognome` VARCHAR(45) NULL,
  `nascita` VARCHAR(45) NULL,
  `residenza` VARCHAR(45) NULL,
  `cellulare` INT NULL,
  `codiceFiscale` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `matricola` VARCHAR(45) NULL,
  `Classi_anno` VARCHAR(45) NULL,
  `Classi_sezione` VARCHAR(45) NULL,
  PRIMARY KEY (`username`),
  INDEX `fk_Alunni_Classi1_idx` (`Classi_anno` ASC, `Classi_sezione` ASC) VISIBLE,
  CONSTRAINT `fk_Alunni_Classi1`
    FOREIGN KEY (`Classi_anno` , `Classi_sezione`)
    REFERENCES `GestioneIstitutoScolastico`.`Classi` (`anno` , `sezione`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GestioneIstitutoScolastico`.`Genitori`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GestioneIstitutoScolastico`.`Genitori` (
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL,
  `nome` VARCHAR(45) NULL,
  `cognome` VARCHAR(45) NULL,
  `nascita` VARCHAR(45) NULL,
  `residenza` VARCHAR(45) NULL,
  `cellulare` INT NULL,
  `codiceFiscale` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GestioneIstitutoScolastico`.`Docenti`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GestioneIstitutoScolastico`.`Docenti` (
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL,
  `nome` VARCHAR(45) NULL,
  `cognome` VARCHAR(45) NULL,
  `nascita` VARCHAR(45) NULL,
  `residenza` VARCHAR(45) NULL,
  `cellulare` INT NULL,
  `codiceFiscale` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GestioneIstitutoScolastico`.`RegistriElettronici`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GestioneIstitutoScolastico`.`RegistriElettronici` (
  `annoScolastico` VARCHAR(45) NULL,
  `Classi_anno` VARCHAR(45) NOT NULL,
  `Classi_sezione` VARCHAR(45) NOT NULL,
  INDEX `fk_RegistriElettronici_Classi1_idx` (`Classi_anno` ASC, `Classi_sezione` ASC) VISIBLE,
  PRIMARY KEY (`Classi_anno`, `Classi_sezione`),
  CONSTRAINT `fk_RegistriElettronici_Classi1`
    FOREIGN KEY (`Classi_anno` , `Classi_sezione`)
    REFERENCES `GestioneIstitutoScolastico`.`Classi` (`anno` , `sezione`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GestioneIstitutoScolastico`.`Pagelle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GestioneIstitutoScolastico`.`Pagelle` (
  `Alunni_username` VARCHAR(45) NOT NULL,
  `approvata` INT NOT NULL,
  PRIMARY KEY (`Alunni_username`),
  CONSTRAINT `fk_Pagelle_Alunni1`
    FOREIGN KEY (`Alunni_username`)
    REFERENCES `GestioneIstitutoScolastico`.`Alunni` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GestioneIstitutoScolastico`.`Medie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GestioneIstitutoScolastico`.`Medie` (
  `idMedie` INT NOT NULL,
  `valore` DOUBLE NULL,
  `materia` VARCHAR(45) NULL,
  `Pagelle_Alunni_username` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idMedie`),
  INDEX `fk_Medie_Pagelle1_idx` (`Pagelle_Alunni_username` ASC) VISIBLE,
  CONSTRAINT `fk_Medie_Pagelle1`
    FOREIGN KEY (`Pagelle_Alunni_username`)
    REFERENCES `GestioneIstitutoScolastico`.`Pagelle` (`Alunni_username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GestioneIstitutoScolastico`.`Genitori_has_Alunni`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GestioneIstitutoScolastico`.`Genitori_has_Alunni` (
  `Genitori_username` VARCHAR(45) NOT NULL,
  `Alunni_username` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Genitori_username`, `Alunni_username`),
  INDEX `fk_Genitori_has_Alunni_Alunni1_idx` (`Alunni_username` ASC) VISIBLE,
  INDEX `fk_Genitori_has_Alunni_Genitori1_idx` (`Genitori_username` ASC) VISIBLE,
  CONSTRAINT `fk_Genitori_has_Alunni_Genitori1`
    FOREIGN KEY (`Genitori_username`)
    REFERENCES `GestioneIstitutoScolastico`.`Genitori` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Genitori_has_Alunni_Alunni1`
    FOREIGN KEY (`Alunni_username`)
    REFERENCES `GestioneIstitutoScolastico`.`Alunni` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GestioneIstitutoScolastico`.`Docenti_has_Classi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GestioneIstitutoScolastico`.`Docenti_has_Classi` (
  `Docenti_username` VARCHAR(45) NOT NULL,
  `Classi_anno` VARCHAR(45) NOT NULL,
  `Classi_sezione` VARCHAR(45) NOT NULL,
  `materia` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Docenti_username`, `Classi_anno`, `Classi_sezione`, `materia`),
  INDEX `fk_Docenti_has_Classi_Classi1_idx` (`Classi_anno` ASC, `Classi_sezione` ASC) VISIBLE,
  INDEX `fk_Docenti_has_Classi_Docenti1_idx` (`Docenti_username` ASC) VISIBLE,
  CONSTRAINT `fk_Docenti_has_Classi_Docenti1`
    FOREIGN KEY (`Docenti_username`)
    REFERENCES `GestioneIstitutoScolastico`.`Docenti` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Docenti_has_Classi_Classi1`
    FOREIGN KEY (`Classi_anno` , `Classi_sezione`)
    REFERENCES `GestioneIstitutoScolastico`.`Classi` (`anno` , `sezione`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GestioneIstitutoScolastico`.`Attivita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GestioneIstitutoScolastico`.`Attivita` (
  `idAttivita` INT NOT NULL,
  `materia` VARCHAR(45) NULL,
  `descrizione` VARCHAR(45) NULL,
  `data` VARCHAR(45) NULL,
  `RegistriElettronici_Classi_anno` VARCHAR(45) NOT NULL,
  `RegistriElettronici_Classi_sezione` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAttivita`),
  INDEX `fk_Attivita_RegistriElettronici1_idx` (`RegistriElettronici_Classi_anno` ASC, `RegistriElettronici_Classi_sezione` ASC) VISIBLE,
  CONSTRAINT `fk_Attivita_RegistriElettronici1`
    FOREIGN KEY (`RegistriElettronici_Classi_anno` , `RegistriElettronici_Classi_sezione`)
    REFERENCES `GestioneIstitutoScolastico`.`RegistriElettronici` (`Classi_anno` , `Classi_sezione`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GestioneIstitutoScolastico`.`Voti`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GestioneIstitutoScolastico`.`Voti` (
  `idVoti` INT NOT NULL,
  `valore` INT NULL,
  `data` VARCHAR(45) NULL,
  `materia` VARCHAR(45) NULL,
  `RegistriElettronici_Classi_anno` VARCHAR(45) NOT NULL,
  `RegistriElettronici_Classi_sezione` VARCHAR(45) NOT NULL,
  `Alunni_username` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idVoti`),
  INDEX `fk_Voti_RegistriElettronici1_idx` (`RegistriElettronici_Classi_anno` ASC, `RegistriElettronici_Classi_sezione` ASC) VISIBLE,
  INDEX `fk_Voti_Alunni1_idx` (`Alunni_username` ASC) VISIBLE,
  CONSTRAINT `fk_Voti_RegistriElettronici1`
    FOREIGN KEY (`RegistriElettronici_Classi_anno` , `RegistriElettronici_Classi_sezione`)
    REFERENCES `GestioneIstitutoScolastico`.`RegistriElettronici` (`Classi_anno` , `Classi_sezione`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Voti_Alunni1`
    FOREIGN KEY (`Alunni_username`)
    REFERENCES `GestioneIstitutoScolastico`.`Alunni` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
