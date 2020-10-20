-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 20, 2020 at 04:09 PM
-- Server version: 5.7.26
-- PHP Version: 7.2.18

SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `trialcal`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
  `accId` varchar(255) NOT NULL,
  `accNo` varchar(250) NOT NULL,
  `accType` varchar(200) NOT NULL,
  `pId` varchar(200) NOT NULL,
  `balance` double NOT NULL,
  PRIMARY KEY (`accId`)
) ;

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
  `pId` varchar(200) NOT NULL,
  `fName` varchar(200) NOT NULL,
  `lName` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `contacNo` varchar(100) NOT NULL,
  PRIMARY KEY (`pId`)
) ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
