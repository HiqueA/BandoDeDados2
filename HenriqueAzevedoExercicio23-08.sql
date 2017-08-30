

"Resposta do exercicio
SELECT professores.Nome, titulacoes.Descricao,turmas.Descricao,disciplinas.Descricao,
	disciplinas.Cargahoraria FROM professores, titulacoes,turmas, disciplinas, professor_disciplina_ 
	WHERE professores.ID =  professor_disciplina_.IDprofessor AND turmas.ID = professor_disciplina_.IDTurma 
    AND disciplinas.ID = professor_disciplina_.IDDisciplina AND titulacoes.ID = professores.IDTitulacao
	ORDER BY turmas.Descricao;
"





CREATE DATABASE  IF NOT EXISTS `exercicio2308` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `exercicio2308`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: exercicio2308
-- ------------------------------------------------------
-- Server version	5.5.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `disciplinas`
--

DROP TABLE IF EXISTS `disciplinas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disciplinas` (
  `ID` int(11) NOT NULL,
  `Descricao` varchar(45) DEFAULT NULL,
  `CargaHoraria` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplinas`
--

LOCK TABLES `disciplinas` WRITE;
/*!40000 ALTER TABLE `disciplinas` DISABLE KEYS */;
INSERT INTO `disciplinas` VALUES (1,'Programação de Banco de Dados',84),(2,'Programação Orientada a Objetos ',84),(3,'Padrões de Projeto',84),(4,'Sistemas Operacionais',84),(5,'Algoritmos',130),(6,'Matemática Discreta',84),(7,'Teoria da Computação',84),(8,'Estrutura de Dados',84),(9,'Álgebra Booleana',84),(10,'Inteligência Artificial',84),(11,'Eletrônica para Computação',84),(12,'Robótica',84),(13,'Redes de Computadores',84),(14,'Sistemas Distribuídos',84);
/*!40000 ALTER TABLE `disciplinas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor_disciplina_`
--

DROP TABLE IF EXISTS `professor_disciplina_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professor_disciplina_` (
  `IDProfessor` int(11) DEFAULT NULL,
  `IDDisciplina` int(11) DEFAULT NULL,
  `IDTurma` int(11) DEFAULT NULL,
  KEY `IDProfessor_idx` (`IDProfessor`),
  KEY `IDDisciplina_idx` (`IDDisciplina`),
  KEY `IDTurma_idx` (`IDTurma`),
  CONSTRAINT `IDDisciplina` FOREIGN KEY (`IDDisciplina`) REFERENCES `disciplinas` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `IDProfessor` FOREIGN KEY (`IDProfessor`) REFERENCES `professores` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `IDTurma` FOREIGN KEY (`IDTurma`) REFERENCES `turmas` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor_disciplina_`
--

LOCK TABLES `professor_disciplina_` WRITE;
/*!40000 ALTER TABLE `professor_disciplina_` DISABLE KEYS */;
INSERT INTO `professor_disciplina_` VALUES (1,1,2),(1,2,1),(1,2,3),(1,4,2),(2,7,3),(2,9,2),(2,10,3),(3,5,1),(3,6,1);
/*!40000 ALTER TABLE `professor_disciplina_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professores`
--

DROP TABLE IF EXISTS `professores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professores` (
  `ID` int(11) NOT NULL,
  `Matricula` varchar(45) DEFAULT NULL,
  `Nome` varchar(45) DEFAULT NULL,
  `IdTitulacao` int(11) DEFAULT NULL,
  `Endereco` varchar(45) DEFAULT NULL,
  `Cidade` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IdTitulacao_idx` (`IdTitulacao`),
  CONSTRAINT `IdTitulacao` FOREIGN KEY (`IdTitulacao`) REFERENCES `titulacoes` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='				';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professores`
--

LOCK TABLES `professores` WRITE;
/*!40000 ALTER TABLE `professores` DISABLE KEYS */;
INSERT INTO `professores` VALUES (1,'32458-9','Cristiano Roberto Franco',4,'Rua xv de novembro','2','crfranco@fameg.edu.br'),(2,'5247-9','Jose Roque Vo',2,'Rua Tobias Barreto','2','roque@terra.com.br'),(3,'12548-9','Roberto Heisle',1,'Rua Hermann Schultz','3','hermann@gmail.com');
/*!40000 ALTER TABLE `professores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `titulacoes`
--

DROP TABLE IF EXISTS `titulacoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `titulacoes` (
  `ID` int(11) NOT NULL,
  `Descricao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `titulacoes`
--

LOCK TABLES `titulacoes` WRITE;
/*!40000 ALTER TABLE `titulacoes` DISABLE KEYS */;
INSERT INTO `titulacoes` VALUES (1,'Especialização Incompleta'),(2,'Especialização Completa'),(3,'Mestrado Incompleto'),(4,'Mestrado Completo'),(5,'Doutorado Incompleto'),(6,'Doutorado Completo');
/*!40000 ALTER TABLE `titulacoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turmas`
--

DROP TABLE IF EXISTS `turmas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turmas` (
  `ID` int(11) NOT NULL,
  `Descricao` varchar(45) DEFAULT NULL,
  `Semestre` varchar(45) DEFAULT NULL,
  `NumeroAlunos` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turmas`
--

LOCK TABLES `turmas` WRITE;
/*!40000 ALTER TABLE `turmas` DISABLE KEYS */;
INSERT INTO `turmas` VALUES (1,'BCC','2008-2',34),(2,'SIG','1999-1',28),(3,'LC','1998-1',20),(4,'BCC','2001-1',7);
/*!40000 ALTER TABLE `turmas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-30 11:52:10






