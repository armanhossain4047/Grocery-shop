-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 28, 2024 at 04:18 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `grocery_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `accountinfo`
--

CREATE TABLE `accountinfo` (
  `CDate` varchar(19) DEFAULT current_timestamp(),
  `AccountType` varchar(50) DEFAULT NULL,
  `LadgerName` varchar(50) DEFAULT NULL,
  `Address` varchar(18) DEFAULT NULL,
  `Mobile` varchar(11) DEFAULT NULL,
  `OpenBalance` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Triggers `accountinfo`
--
DELIMITER $$
CREATE TRIGGER `customerdueinsert` BEFORE INSERT ON `accountinfo` FOR EACH ROW BEGIN
    IF NEW.AccountType = 'Customer' THEN
        INSERT INTO customerdue VALUES (CURRENT_DATE, NEW.LadgerName, NEW.Address, NEW.Mobile, NEW.OpenBalance);
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `accountnameall`
--

CREATE TABLE `accountnameall` (
  `AccountType` varchar(12) DEFAULT NULL,
  `AccountName` varchar(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `accountnameall`
--

INSERT INTO `accountnameall` (`AccountType`, `AccountName`) VALUES
('Cash Account', 'Cash'),
('Bank Account', 'DBBL Bank'),
('Bank Account', 'UCB Bank'),
('Cash Account', 'Cash'),
('Bank Account', 'DBBL Bank'),
('Bank Account', 'UCB Bank');

-- --------------------------------------------------------

--
-- Table structure for table `bankaccount`
--

CREATE TABLE `bankaccount` (
  `CDate` date DEFAULT current_timestamp(),
  `Name` varchar(50) DEFAULT NULL,
  `Description` varchar(100) DEFAULT NULL,
  `Debit` float DEFAULT NULL,
  `Credit` float DEFAULT NULL,
  `Balance` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `barcode`
--

CREATE TABLE `barcode` (
  `Barcode` varchar(15) DEFAULT NULL,
  `Item` varchar(100) DEFAULT NULL,
  `rate` varchar(10) NOT NULL,
  `qty` varchar(12) NOT NULL,
  `User` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `barcodeprint`
--

CREATE TABLE `barcodeprint` (
  `Pri1` varchar(0) DEFAULT NULL,
  `Na2` varchar(0) DEFAULT NULL,
  `Col2` varchar(0) DEFAULT NULL,
  `Des2` varchar(0) DEFAULT NULL,
  `Pri2` varchar(0) DEFAULT NULL,
  `Na3` varchar(0) DEFAULT NULL,
  `Col3` varchar(0) DEFAULT NULL,
  `Des3` varchar(0) DEFAULT NULL,
  `Pri3` varchar(0) DEFAULT NULL,
  `Na4` varchar(0) DEFAULT NULL,
  `Col4` varchar(0) DEFAULT NULL,
  `Des4` varchar(0) DEFAULT NULL,
  `Pri4` varchar(0) DEFAULT NULL,
  `Na5` varchar(0) DEFAULT NULL,
  `Col5` varchar(0) DEFAULT NULL,
  `Des5` varchar(0) DEFAULT NULL,
  `Pri5` varchar(0) DEFAULT NULL,
  `Na6` varchar(0) DEFAULT NULL,
  `Col6` varchar(0) DEFAULT NULL,
  `Des6` varchar(0) DEFAULT NULL,
  `Pri6` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `barcodeprint_single`
--

CREATE TABLE `barcodeprint_single` (
  `Row` tinyint(4) DEFAULT NULL,
  `Na1` smallint(6) DEFAULT NULL,
  `Col1` varchar(6) DEFAULT NULL,
  `Des1` varchar(17) DEFAULT NULL,
  `Pri1` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `barcodeprint_single`
--

INSERT INTO `barcodeprint_single` (`Row`, `Na1`, `Col1`, `Des1`, `Pri1`) VALUES
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60),
(0, 1221, '*1221*', 'Banana Milk Shake', 60);

-- --------------------------------------------------------

--
-- Table structure for table `budget_analysis`
--

CREATE TABLE `budget_analysis` (
  `Receiver` varchar(21) DEFAULT NULL,
  `Amount` tinyint(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `budget_analysis`
--

INSERT INTO `budget_analysis` (`Receiver`, `Amount`) VALUES
('Shop Rent', 0),
('Electric Shop', 0),
('Telephone', 0),
('Mobile', 0),
('Godown Rent', 0),
('Electric Godown', 0),
('News Paper', 0),
('Market Service Charge', 0),
('Shop Rent', 0),
('Electric Shop', 0),
('Telephone', 0),
('Mobile', 0),
('Godown Rent', 0),
('Electric Godown', 0),
('News Paper', 0),
('Market Service Charge', 0);

-- --------------------------------------------------------

--
-- Table structure for table `businessanalysis`
--

CREATE TABLE `businessanalysis` (
  `CDate` varchar(19) DEFAULT NULL,
  `Establishment` tinyint(4) DEFAULT NULL,
  `StockValue` mediumint(9) DEFAULT NULL,
  `CustomerDue` tinyint(4) DEFAULT NULL,
  `BankBalance` tinyint(4) DEFAULT NULL,
  `AssetPlainLoan` tinyint(4) DEFAULT NULL,
  `PetiCash` smallint(6) DEFAULT NULL,
  `SupplierDue` mediumint(9) DEFAULT NULL,
  `Advance` tinyint(4) DEFAULT NULL,
  `LiaPlainLoan` tinyint(4) DEFAULT NULL,
  `CCSLoan` tinyint(4) DEFAULT NULL,
  `CCLoan` tinyint(4) DEFAULT NULL,
  `SalaryDue` tinyint(4) DEFAULT NULL,
  `BillDue` tinyint(4) DEFAULT NULL,
  `Asset` mediumint(9) DEFAULT NULL,
  `Liabilities` mediumint(9) DEFAULT NULL,
  `Position` mediumint(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `cash_balance`
--

CREATE TABLE `cash_balance` (
  `c_date` varchar(19) DEFAULT NULL,
  `bf` mediumint(9) DEFAULT NULL,
  `dailyrec` mediumint(9) DEFAULT NULL,
  `dailyexp` mediumint(9) DEFAULT NULL,
  `balance` mediumint(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ccloandetail`
--

CREATE TABLE `ccloandetail` (
  `cdate` varchar(0) DEFAULT NULL,
  `cbank` varchar(0) DEFAULT NULL,
  `previous_balance` varchar(0) DEFAULT NULL,
  `drawtoday` varchar(0) DEFAULT NULL,
  `totaldraw` varchar(0) DEFAULT NULL,
  `dep_today` varchar(0) DEFAULT NULL,
  `final_balance` varchar(0) DEFAULT NULL,
  `int_today` varchar(0) DEFAULT NULL,
  `previous_int` varchar(0) DEFAULT NULL,
  `total_int` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ccsaccount`
--

CREATE TABLE `ccsaccount` (
  `BankName` varchar(0) DEFAULT NULL,
  `LoanType` varchar(0) DEFAULT NULL,
  `WithAmount` varchar(0) DEFAULT NULL,
  `PaySch` varchar(0) DEFAULT NULL,
  `PayFig` varchar(0) DEFAULT NULL,
  `MonInt` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `companyinfo`
--

CREATE TABLE `companyinfo` (
  `Name` varchar(10) DEFAULT NULL,
  `Address` varchar(46) DEFAULT NULL,
  `Telephone` varchar(0) DEFAULT NULL,
  `Mobile` bigint(20) DEFAULT NULL,
  `EMail` varchar(0) DEFAULT NULL,
  `WebAddress` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `customerdue`
--

CREATE TABLE `customerdue` (
  `CDate` date DEFAULT current_timestamp(),
  `Name` varchar(100) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `Mobile` varchar(20) DEFAULT NULL,
  `Blance` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `customer_statement`
--

CREATE TABLE `customer_statement` (
  `Date` date NOT NULL DEFAULT current_timestamp(),
  `Name` varchar(50) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `Mobile` varchar(15) DEFAULT NULL,
  `Debit` varchar(15) NOT NULL,
  `Credit` varchar(15) NOT NULL,
  `Description` varchar(50) DEFAULT 'None',
  `InvoiceNO` varchar(15) NOT NULL DEFAULT 'None',
  `Balance` varchar(15) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Triggers `customer_statement`
--
DELIMITER $$
CREATE TRIGGER `updateladgertrigger` BEFORE INSERT ON `customer_statement` FOR EACH ROW UPDATE ladger SET Blance = new.Balance WHERE AccountType = 'Customer' AND Name = new.Name AND Mobile = new.Mobile
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `dailybackup_p`
--

CREATE TABLE `dailybackup_p` (
  `a` varchar(13) DEFAULT NULL,
  `b` varchar(18) DEFAULT NULL,
  `c` varchar(6) DEFAULT NULL,
  `d` varchar(13) DEFAULT NULL,
  `e` varchar(5) DEFAULT NULL,
  `f` varchar(0) DEFAULT NULL,
  `g` varchar(0) DEFAULT NULL,
  `h` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `daily_allowence`
--

CREATE TABLE `daily_allowence` (
  `cdate` varchar(0) DEFAULT NULL,
  `reason` varchar(0) DEFAULT NULL,
  `receiver` varchar(0) DEFAULT NULL,
  `amount` varchar(0) DEFAULT NULL,
  `remarks` varchar(0) DEFAULT NULL,
  `deo` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `daily_profit_memo`
--

CREATE TABLE `daily_profit_memo` (
  `cdate` varchar(19) DEFAULT NULL,
  `total` mediumint(9) DEFAULT NULL,
  `cost` smallint(6) DEFAULT NULL,
  `discount` tinyint(4) DEFAULT NULL,
  `g_porfit` smallint(6) DEFAULT NULL,
  `month` varchar(8) DEFAULT NULL,
  `sYear` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `director`
--

CREATE TABLE `director` (
  `s_no` varchar(0) DEFAULT NULL,
  `nic_name` varchar(0) DEFAULT NULL,
  `Investment` varchar(0) DEFAULT NULL,
  `noofshaheld` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `employee_appoint`
--

CREATE TABLE `employee_appoint` (
  `s_no` tinyint(4) DEFAULT NULL,
  `nic_name` varchar(5) DEFAULT NULL,
  `salary` tinyint(4) DEFAULT NULL,
  `j_date` varchar(19) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `errorinformation`
--

CREATE TABLE `errorinformation` (
  `CDate` varchar(0) DEFAULT NULL,
  `CTime` varchar(0) DEFAULT NULL,
  `ErrNo` varchar(0) DEFAULT NULL,
  `ErrDes` varchar(0) DEFAULT NULL,
  `ErrSource` varchar(0) DEFAULT NULL,
  `ErrHelpID` varchar(0) DEFAULT NULL,
  `ErrHelpFile` varchar(0) DEFAULT NULL,
  `ErrDll` varchar(0) DEFAULT NULL,
  `FrmNam` varchar(0) DEFAULT NULL,
  `ErrEvent` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `establishment`
--

CREATE TABLE `establishment` (
  `cdate` varchar(0) DEFAULT NULL,
  `cfrom` varchar(0) DEFAULT NULL,
  `reason` varchar(0) DEFAULT NULL,
  `amount` varchar(0) DEFAULT NULL,
  `remarks` varchar(0) DEFAULT NULL,
  `deo` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `findpurchasesupplair`
--

CREATE TABLE `findpurchasesupplair` (
  `supplliermemo` varchar(20) DEFAULT NULL,
  `SupllierName` varchar(50) DEFAULT NULL,
  `Amount` varchar(12) DEFAULT NULL,
  `User` varchar(20) DEFAULT NULL,
  `Date` date DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `groupname`
--

CREATE TABLE `groupname` (
  `Date` date NOT NULL DEFAULT current_timestamp(),
  `GroupName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `interest`
--

CREATE TABLE `interest` (
  `bankname` varchar(0) DEFAULT NULL,
  `interest` varchar(0) DEFAULT NULL,
  `CreditLimit` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `invaudit`
--

CREATE TABLE `invaudit` (
  `serial_no` int(6) NOT NULL,
  `invoiceNo` varchar(20) DEFAULT NULL,
  `CName` varchar(50) DEFAULT NULL,
  `DueAmount` varchar(12) DEFAULT NULL,
  `Barcode` varchar(50) DEFAULT NULL,
  `item` varchar(50) DEFAULT NULL,
  `rate` varchar(12) DEFAULT NULL,
  `qty` varchar(12) DEFAULT NULL,
  `price` varchar(12) DEFAULT NULL,
  `PaidAmount` varchar(12) NOT NULL,
  `DiscountTk` varchar(12) NOT NULL,
  `Status` varchar(12) NOT NULL,
  `VAT` varchar(12) DEFAULT NULL,
  `cdate` date DEFAULT current_timestamp(),
  `TotalBlance` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Triggers `invaudit`
--
DELIMITER $$
CREATE TRIGGER `purchasetrigger` BEFORE INSERT ON `invaudit` FOR EACH ROW UPDATE purchase SET Qty = Qty-new.qty WHERE Barcode = new.Barcode
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `invmaster`
--

CREATE TABLE `invmaster` (
  `mdate` varchar(19) DEFAULT NULL,
  `memono` smallint(6) DEFAULT NULL,
  `orderno` tinyint(4) DEFAULT NULL,
  `name` varchar(14) DEFAULT NULL,
  `address` varchar(0) DEFAULT NULL,
  `total` smallint(6) DEFAULT NULL,
  `VAT` tinyint(4) DEFAULT NULL,
  `SalesReturn` tinyint(4) DEFAULT NULL,
  `Discount` smallint(6) DEFAULT NULL,
  `Balance` smallint(6) DEFAULT NULL,
  `Paid` smallint(6) DEFAULT NULL,
  `CreditCard` tinyint(4) DEFAULT NULL,
  `due` smallint(6) DEFAULT NULL,
  `ReturnTk` smallint(6) DEFAULT NULL,
  `SoldBy` varchar(5) DEFAULT NULL,
  `Telephone` varchar(0) DEFAULT NULL,
  `SalesmanName` varchar(3) DEFAULT NULL,
  `cTime` varchar(19) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `invprint`
--

CREATE TABLE `invprint` (
  `memono` varchar(20) DEFAULT NULL,
  `sno` varchar(50) DEFAULT NULL,
  `itembrand` varchar(50) DEFAULT NULL,
  `rate` varchar(10) DEFAULT NULL,
  `qty` varchar(10) DEFAULT NULL,
  `price` varchar(10) DEFAULT NULL,
  `User` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `invtemp`
--

CREATE TABLE `invtemp` (
  `invoiceNo` varchar(15) DEFAULT NULL,
  `cdate` varchar(50) DEFAULT current_timestamp(),
  `sno` varchar(50) DEFAULT NULL,
  `item` varchar(50) DEFAULT NULL,
  `rate` varchar(11) DEFAULT NULL,
  `qty` varchar(11) DEFAULT NULL,
  `price` varchar(11) DEFAULT NULL,
  `serial_no` int(50) NOT NULL,
  `User` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `journal`
--

CREATE TABLE `journal` (
  `CreaditAcountType` varchar(50) NOT NULL,
  `CreaditLadger` varchar(50) NOT NULL,
  `DebitAcountType` varchar(50) NOT NULL,
  `DebitLadger` varchar(50) NOT NULL,
  `Description` varchar(50) DEFAULT NULL,
  `Amount` varchar(12) NOT NULL,
  `Cdate` date NOT NULL DEFAULT current_timestamp(),
  `S/L` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ladger`
--

CREATE TABLE `ladger` (
  `AccountType` varchar(50) DEFAULT NULL,
  `Name` varchar(50) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Mobile` varchar(11) NOT NULL,
  `Blance` float NOT NULL,
  `Date` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `leave_sanction`
--

CREATE TABLE `leave_sanction` (
  `cdate` varchar(0) DEFAULT NULL,
  `name` varchar(0) DEFAULT NULL,
  `l_from` varchar(0) DEFAULT NULL,
  `l_to` varchar(0) DEFAULT NULL,
  `dayes` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `loanbalance`
--

CREATE TABLE `loanbalance` (
  `Name` varchar(5) DEFAULT NULL,
  `Debit` tinyint(4) DEFAULT NULL,
  `Credit` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `loandetail`
--

CREATE TABLE `loandetail` (
  `Sno` tinyint(4) DEFAULT NULL,
  `CDate` varchar(19) DEFAULT NULL,
  `Name` varchar(5) DEFAULT NULL,
  `Description` varchar(23) DEFAULT NULL,
  `Credit` smallint(6) DEFAULT NULL,
  `Debit` smallint(6) DEFAULT NULL,
  `Balance` mediumint(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `logininfo`
--

CREATE TABLE `logininfo` (
  `name` varchar(5) DEFAULT NULL,
  `User_ID` varchar(5) DEFAULT NULL,
  `Log_Date` varchar(19) DEFAULT NULL,
  `Log_In` varchar(11) DEFAULT NULL,
  `Log_Out` varchar(11) DEFAULT NULL,
  `Status` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `memberinformation`
--

CREATE TABLE `memberinformation` (
  `Cdate` varchar(0) DEFAULT NULL,
  `CardNumber` varchar(0) DEFAULT NULL,
  `Name` varchar(0) DEFAULT NULL,
  `Address` varchar(0) DEFAULT NULL,
  `Mobile` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `memberinformation_tesco`
--

CREATE TABLE `memberinformation_tesco` (
  `Cdate` varchar(19) DEFAULT NULL,
  `CardNumber` mediumint(9) DEFAULT NULL,
  `Name` varchar(27) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Mobile` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `member_information`
--

CREATE TABLE `member_information` (
  `AutoNo` varchar(0) DEFAULT NULL,
  `cDate` varchar(0) DEFAULT NULL,
  `MID` varchar(0) DEFAULT NULL,
  `MemberName` varchar(0) DEFAULT NULL,
  `Address` varchar(0) DEFAULT NULL,
  `MemberMobile` varchar(0) DEFAULT NULL,
  `DEO` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `member_ledger`
--

CREATE TABLE `member_ledger` (
  `AutoNo` varchar(0) DEFAULT NULL,
  `cDate` varchar(0) DEFAULT NULL,
  `MID` varchar(0) DEFAULT NULL,
  `MemberName` varchar(0) DEFAULT NULL,
  `MemoNo` varchar(0) DEFAULT NULL,
  `Debit` varchar(0) DEFAULT NULL,
  `Credit` varchar(0) DEFAULT NULL,
  `Balance` varchar(0) DEFAULT NULL,
  `DEO` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `merbershipcard`
--

CREATE TABLE `merbershipcard` (
  `Type` varchar(25) NOT NULL,
  `CustomerName` varchar(50) NOT NULL,
  `cDate` varchar(50) NOT NULL DEFAULT current_timestamp(),
  `Address` varchar(50) NOT NULL,
  `Phone` int(11) NOT NULL,
  `CardNo` varchar(25) NOT NULL,
  `Discounts` float NOT NULL,
  `SerialNo` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `merchantbank`
--

CREATE TABLE `merchantbank` (
  `cDate` varchar(0) DEFAULT NULL,
  `Name` varchar(0) DEFAULT NULL,
  `Link_Account_Name` varchar(0) DEFAULT NULL,
  `Status` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `moneyreceipt`
--

CREATE TABLE `moneyreceipt` (
  `CDate` varchar(0) DEFAULT NULL,
  `MRNo` varchar(0) DEFAULT NULL,
  `Name` varchar(0) DEFAULT NULL,
  `Address` varchar(0) DEFAULT NULL,
  `PMode` varchar(0) DEFAULT NULL,
  `TotAmount` varchar(0) DEFAULT NULL,
  `Remarks` varchar(0) DEFAULT NULL,
  `User` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `moneyreceiptchqdetail`
--

CREATE TABLE `moneyreceiptchqdetail` (
  `CDate` varchar(0) DEFAULT NULL,
  `MRNo` varchar(0) DEFAULT NULL,
  `CustomerName` varchar(0) DEFAULT NULL,
  `ChqDate` varchar(0) DEFAULT NULL,
  `BName` varchar(0) DEFAULT NULL,
  `ChqNo` varchar(0) DEFAULT NULL,
  `ChqAmu` varchar(0) DEFAULT NULL,
  `Status` varchar(0) DEFAULT NULL,
  `User` varchar(0) DEFAULT NULL,
  `Remarks` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `money_expense`
--

CREATE TABLE `money_expense` (
  `cdate` varchar(19) DEFAULT current_timestamp(),
  `Reason` varchar(16) DEFAULT NULL,
  `Receiver` varchar(19) DEFAULT NULL,
  `Amount` varchar(9) DEFAULT NULL,
  `AcCredit` varchar(50) DEFAULT NULL,
  `Description` varchar(25) DEFAULT NULL,
  `deo` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `money_received`
--

CREATE TABLE `money_received` (
  `cdate` varchar(19) DEFAULT current_timestamp(),
  `cfrom` varchar(18) DEFAULT NULL,
  `reason` varchar(16) DEFAULT NULL,
  `amount` mediumint(9) DEFAULT NULL,
  `remarks` varchar(23) DEFAULT NULL,
  `deo` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `monthly_backup_print`
--

CREATE TABLE `monthly_backup_print` (
  `a` varchar(0) DEFAULT NULL,
  `b` varchar(0) DEFAULT NULL,
  `c` varchar(0) DEFAULT NULL,
  `d` varchar(0) DEFAULT NULL,
  `e` varchar(0) DEFAULT NULL,
  `f` varchar(0) DEFAULT NULL,
  `g` varchar(0) DEFAULT NULL,
  `h` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `monthly_memo_profit`
--

CREATE TABLE `monthly_memo_profit` (
  `UpDate` varchar(19) DEFAULT NULL,
  `month` varchar(9) DEFAULT NULL,
  `sYear` smallint(6) DEFAULT NULL,
  `total` mediumint(9) DEFAULT NULL,
  `cost` mediumint(9) DEFAULT NULL,
  `g_porfit` mediumint(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `movementanalysis`
--

CREATE TABLE `movementanalysis` (
  `SN` varchar(0) DEFAULT NULL,
  `serialno` varchar(0) DEFAULT NULL,
  `item` varchar(0) DEFAULT NULL,
  `brand` varchar(0) DEFAULT NULL,
  `Purchase` varchar(0) DEFAULT NULL,
  `Sale` varchar(0) DEFAULT NULL,
  `PReturn` varchar(0) DEFAULT NULL,
  `Stock` varchar(0) DEFAULT NULL,
  `User` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `options`
--

CREATE TABLE `options` (
  `FixedPrice` varchar(3) DEFAULT NULL,
  `AutoPrint` varchar(3) DEFAULT NULL,
  `Single_Col_Barcode` varchar(3) DEFAULT NULL,
  `Salesman_Select` varchar(2) DEFAULT NULL,
  `Order_System_Enable` varchar(2) DEFAULT NULL,
  `Auto_SMS_Send_INV` varchar(2) DEFAULT NULL,
  `SMS_Text` tinyint(4) DEFAULT NULL,
  `False_Sales_Report` varchar(2) DEFAULT NULL,
  `Show_Return_Qty_Box` varchar(2) DEFAULT NULL,
  `Member_Point_System` varchar(2) DEFAULT NULL,
  `PerPointAmount` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `options`
--

INSERT INTO `options` (`FixedPrice`, `AutoPrint`, `Single_Col_Barcode`, `Salesman_Select`, `Order_System_Enable`, `Auto_SMS_Send_INV`, `SMS_Text`, `False_Sales_Report`, `Show_Return_Qty_Box`, `Member_Point_System`, `PerPointAmount`) VALUES
('Yes', 'Yes', 'Yes', 'No', 'No', 'No', 0, 'No', 'No', 'No', 100);

-- --------------------------------------------------------

--
-- Table structure for table `order_advance_datagrid`
--

CREATE TABLE `order_advance_datagrid` (
  `cdate` varchar(0) DEFAULT NULL,
  `o_no` varchar(0) DEFAULT NULL,
  `name` varchar(0) DEFAULT NULL,
  `add` varchar(0) DEFAULT NULL,
  `Tele` varchar(0) DEFAULT NULL,
  `advance` varchar(0) DEFAULT NULL,
  `totaltk` varchar(0) DEFAULT NULL,
  `del_dt` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `order_master`
--

CREATE TABLE `order_master` (
  `cdate` varchar(0) DEFAULT NULL,
  `o_no` varchar(0) DEFAULT NULL,
  `s_no` varchar(0) DEFAULT NULL,
  `item` varchar(0) DEFAULT NULL,
  `brend` varchar(0) DEFAULT NULL,
  `qty` varchar(0) DEFAULT NULL,
  `rate` varchar(0) DEFAULT NULL,
  `price` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `order_name_master`
--

CREATE TABLE `order_name_master` (
  `cdate` varchar(0) DEFAULT NULL,
  `o_no` varchar(0) DEFAULT NULL,
  `name` varchar(0) DEFAULT NULL,
  `add` varchar(0) DEFAULT NULL,
  `Tele` varchar(0) DEFAULT NULL,
  `advance` varchar(0) DEFAULT NULL,
  `totaltk` varchar(0) DEFAULT NULL,
  `del_dt` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `order_no`
--

CREATE TABLE `order_no` (
  `or_no` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `order_temp_datagrid`
--

CREATE TABLE `order_temp_datagrid` (
  `cdate` varchar(0) DEFAULT NULL,
  `o_no` varchar(0) DEFAULT NULL,
  `s_no` varchar(0) DEFAULT NULL,
  `item` varchar(0) DEFAULT NULL,
  `brend` varchar(0) DEFAULT NULL,
  `qty` varchar(0) DEFAULT NULL,
  `rate` varchar(0) DEFAULT NULL,
  `price` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `party_balance`
--

CREATE TABLE `party_balance` (
  `sno` tinyint(4) DEFAULT NULL,
  `cdate` varchar(9) DEFAULT NULL,
  `party` varchar(16) DEFAULT NULL,
  `Balance` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `party_due`
--

CREATE TABLE `party_due` (
  `sno` smallint(6) DEFAULT NULL,
  `cdate` varchar(19) DEFAULT NULL,
  `party` varchar(18) DEFAULT NULL,
  `inv_no` varchar(4) DEFAULT NULL,
  `Description` varchar(18) DEFAULT NULL,
  `Credit` int(11) DEFAULT NULL,
  `Debit` smallint(6) DEFAULT NULL,
  `Balance` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `passwordtbl`
--

CREATE TABLE `passwordtbl` (
  `cDate` varchar(19) DEFAULT current_timestamp(),
  `UserName` varchar(50) DEFAULT NULL,
  `UserId` varchar(10) DEFAULT NULL,
  `Password` varchar(8) DEFAULT NULL,
  `NewProductEntry` varchar(20) DEFAULT NULL,
  `Purchase` varchar(20) DEFAULT NULL,
  `AccountType` varchar(20) DEFAULT NULL,
  `daily_report` varchar(10) NOT NULL DEFAULT 'No'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `passwordtbl`
--

INSERT INTO `passwordtbl` (`cDate`, `UserName`, `UserId`, `Password`, `NewProductEntry`, `Purchase`, `AccountType`, `daily_report`) VALUES
('2024-06-28 20:15:39', 'Indrajeet Das Utpol', 'utpol', ' 2211', NULL, NULL, 'Admin', 'No');

-- --------------------------------------------------------

--
-- Table structure for table `paymentstatement`
--

CREATE TABLE `paymentstatement` (
  `Reasone` varchar(50) NOT NULL,
  `Receiver` varchar(50) NOT NULL,
  `Amount` float NOT NULL,
  `Credit` varchar(50) NOT NULL,
  `Description` varchar(100) NOT NULL,
  `Date` date NOT NULL DEFAULT current_timestamp(),
  `Status` varchar(10) NOT NULL,
  `User` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Triggers `paymentstatement`
--
DELIMITER $$
CREATE TRIGGER `paymenttrigger` AFTER INSERT ON `paymentstatement` FOR EACH ROW BEGIN
    DECLARE newbalance INT;

    -- Get the current balance
    SELECT Blance INTO newbalance
    FROM ladger
    WHERE AccountType = NEW.Reasone AND Name = NEW.Receiver;

    -- Check the status of the new transaction
    IF NEW.Status = 'Payment' THEN 
        -- Update the balance for a payment
        UPDATE ladger
        SET Blance = Blance + NEW.Amount
        WHERE AccountType = NEW.Reasone AND Name = NEW.Receiver;
        
        -- Insert into supplier_statement if the reason is 'Supplier'
        IF NEW.Reasone = 'Supplier' THEN
            INSERT INTO supplier_statement 
            VALUES (CURRENT_DATE, 'None', NEW.Receiver, 'Payment', NEW.Amount, '0', newbalance - NEW.Amount, NEW.User);
        END IF;
        -- Insert into customer_statement if the reason is 'Customer'
        IF NEW.Reasone = 'Customer' THEN
            INSERT INTO customer_statement 
            VALUES (CURRENT_DATE, new.Receiver, 'None', 'None', '0',new.Amount, new.Status,'None',newbalance + NEW.Amount);
        END IF;

    ELSEIF NEW.Status = 'Recive' THEN  
        -- Update the balance for a receive
        UPDATE ladger
        SET Blance = Blance - NEW.Amount
        WHERE AccountType = NEW.Reasone AND Name = NEW.Receiver;
        
        -- Insert into supplier_statement if the reason is 'Supplier'
        IF NEW.Reasone = 'Supplier' THEN
            INSERT INTO supplier_statement 
            VALUES (CURRENT_DATE, 'None', NEW.Receiver, 'Recive', NEW.Amount, '0', newbalance + NEW.Amount, NEW.User);
        END IF;
        
        -- Insert into customer_statement if the reason is 'Customer'
        IF NEW.Reasone = 'Customer' THEN
            INSERT INTO customer_statement 
            VALUES (CURRENT_DATE, new.Receiver, 'None', 'None',new.Amount, '0', new.Status,'None',newbalance - NEW.Amount);
        END IF;
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `profit_memo`
--

CREATE TABLE `profit_memo` (
  `cdate` varchar(19) DEFAULT NULL,
  `memo_no` smallint(6) DEFAULT NULL,
  `total` smallint(6) DEFAULT NULL,
  `cost` smallint(6) DEFAULT NULL,
  `g_profit` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `profit_share`
--

CREATE TABLE `profit_share` (
  `name` varchar(0) DEFAULT NULL,
  `amount` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `purchase`
--

CREATE TABLE `purchase` (
  `Date` date NOT NULL DEFAULT current_timestamp(),
  `InvoiceNo` varchar(20) DEFAULT NULL,
  `SupplierName` varchar(50) DEFAULT NULL,
  `Barcode` varchar(50) NOT NULL,
  `ItemName` varchar(50) NOT NULL,
  `GroupName` varchar(50) NOT NULL,
  `Qty` float DEFAULT NULL,
  `Rate` float DEFAULT NULL,
  `Vat` float DEFAULT NULL,
  `SalePrice` float DEFAULT NULL,
  `Status` varchar(12) DEFAULT NULL,
  `User` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `purchasereturntemp`
--

CREATE TABLE `purchasereturntemp` (
  `cdate` varchar(0) DEFAULT NULL,
  `memono` varchar(0) DEFAULT NULL,
  `CName` varchar(0) DEFAULT NULL,
  `sno` varchar(0) DEFAULT NULL,
  `item` varchar(0) DEFAULT NULL,
  `brand` varchar(0) DEFAULT NULL,
  `rate` varchar(0) DEFAULT NULL,
  `qty` varchar(0) DEFAULT NULL,
  `price` varchar(0) DEFAULT NULL,
  `serial_no` varchar(0) DEFAULT NULL,
  `User` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `purchase_statement`
--

CREATE TABLE `purchase_statement` (
  `Date` date NOT NULL DEFAULT current_timestamp(),
  `InvoiceNo` varchar(20) DEFAULT NULL,
  `SupplierName` varchar(50) DEFAULT NULL,
  `Barcode` varchar(50) NOT NULL,
  `ItemName` varchar(50) NOT NULL,
  `GroupName` varchar(50) NOT NULL,
  `Qty` float DEFAULT NULL,
  `Rate` float DEFAULT NULL,
  `Vat` float DEFAULT NULL,
  `SalePrice` float DEFAULT NULL,
  `Status` varchar(12) DEFAULT NULL,
  `User` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Triggers `purchase_statement`
--
DELIMITER $$
CREATE TRIGGER `purchase` BEFORE INSERT ON `purchase_statement` FOR EACH ROW IF NOT EXISTS (SELECT 1 FROM purchase WHERE Barcode = NEW.Barcode) THEN
        INSERT INTO purchase
        VALUES (new.Date, new.InvoiceNo, new.SupplierName,new.Barcode, new.ItemName, new.GroupName, new.Qty, new.Rate, new.Vat,new.SalePrice,new.Status,new.User);
    ELSE
        UPDATE purchase
        SET Qty = Qty + NEW.Qty, Rate=new.Rate, SalePrice=new.SalePrice
        WHERE Barcode = NEW.Barcode;
    END IF
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `qmaster`
--

CREATE TABLE `qmaster` (
  `Name` varchar(0) DEFAULT NULL,
  `Address` varchar(0) DEFAULT NULL,
  `QDate` varchar(0) DEFAULT NULL,
  `Deal` varchar(0) DEFAULT NULL,
  `SNo` varchar(0) DEFAULT NULL,
  `QNo` varchar(0) DEFAULT NULL,
  `Processor` varchar(0) DEFAULT NULL,
  `MotherBoard` varchar(0) DEFAULT NULL,
  `RAM` varchar(0) DEFAULT NULL,
  `HDD` varchar(0) DEFAULT NULL,
  `AGP` varchar(0) DEFAULT NULL,
  `Floppy` varchar(0) DEFAULT NULL,
  `Monitor` varchar(0) DEFAULT NULL,
  `CD` varchar(0) DEFAULT NULL,
  `SoundCard` varchar(0) DEFAULT NULL,
  `Keyboard` varchar(0) DEFAULT NULL,
  `Mouse` varchar(0) DEFAULT NULL,
  `Casing` varchar(0) DEFAULT NULL,
  `Speaker` varchar(0) DEFAULT NULL,
  `UPS` varchar(0) DEFAULT NULL,
  `Printer` varchar(0) DEFAULT NULL,
  `Modem` varchar(0) DEFAULT NULL,
  `NIC` varchar(0) DEFAULT NULL,
  `TV` varchar(0) DEFAULT NULL,
  `Scanner` varchar(0) DEFAULT NULL,
  `Desk` varchar(0) DEFAULT NULL,
  `Other` varchar(0) DEFAULT NULL,
  `ProcessorTk` varchar(0) DEFAULT NULL,
  `MotherBoardTk` varchar(0) DEFAULT NULL,
  `RAMTk` varchar(0) DEFAULT NULL,
  `HDDTk` varchar(0) DEFAULT NULL,
  `AGPTk` varchar(0) DEFAULT NULL,
  `FloppyTk` varchar(0) DEFAULT NULL,
  `MonitorTk` varchar(0) DEFAULT NULL,
  `CDTk` varchar(0) DEFAULT NULL,
  `SoundCardTk` varchar(0) DEFAULT NULL,
  `KeyboardTk` varchar(0) DEFAULT NULL,
  `MouseTk` varchar(0) DEFAULT NULL,
  `CasingTk` varchar(0) DEFAULT NULL,
  `SpeakerTk` varchar(0) DEFAULT NULL,
  `SystemPrice` varchar(0) DEFAULT NULL,
  `UPSTk` varchar(0) DEFAULT NULL,
  `PrinterTk` varchar(0) DEFAULT NULL,
  `ModemTk` varchar(0) DEFAULT NULL,
  `NICTk` varchar(0) DEFAULT NULL,
  `TVTk` varchar(0) DEFAULT NULL,
  `ScannerTk` varchar(0) DEFAULT NULL,
  `DeskTk` varchar(0) DEFAULT NULL,
  `OtherTk` varchar(0) DEFAULT NULL,
  `TotalPrice` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `recall`
--

CREATE TABLE `recall` (
  `invoiceNo` varchar(50) NOT NULL,
  `cdate` date NOT NULL DEFAULT current_timestamp(),
  `sno` varchar(50) DEFAULT NULL,
  `item` varchar(50) NOT NULL,
  `rate` varchar(50) NOT NULL,
  `qty` varchar(50) NOT NULL,
  `price` varchar(50) NOT NULL,
  `serial_no` int(11) NOT NULL,
  `User` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `returnpayment`
--

CREATE TABLE `returnpayment` (
  `MemoNo` varchar(0) DEFAULT NULL,
  `Taka` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `return_audit`
--

CREATE TABLE `return_audit` (
  `cdate` varchar(0) DEFAULT NULL,
  `memono` varchar(0) DEFAULT NULL,
  `CName` varchar(0) DEFAULT NULL,
  `sno` varchar(0) DEFAULT NULL,
  `item` varchar(0) DEFAULT NULL,
  `brand` varchar(0) DEFAULT NULL,
  `rate` varchar(0) DEFAULT NULL,
  `qty` varchar(0) DEFAULT NULL,
  `price` varchar(0) DEFAULT NULL,
  `VAT` varchar(0) DEFAULT NULL,
  `serial_no` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `return_purchase`
--

CREATE TABLE `return_purchase` (
  `cdate` date DEFAULT current_timestamp(),
  `Memo` varchar(20) DEFAULT NULL,
  `Barcode` varchar(20) DEFAULT NULL,
  `item` varchar(100) DEFAULT NULL,
  `brand` varchar(30) DEFAULT NULL,
  `rate` varchar(12) DEFAULT NULL,
  `Qty` varchar(10) DEFAULT NULL,
  `price` varchar(12) DEFAULT NULL,
  `User` varchar(20) DEFAULT NULL,
  `supllier` varchar(50) DEFAULT NULL,
  `Reasone` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Triggers `return_purchase`
--
DELIMITER $$
CREATE TRIGGER `purchasereturn` BEFORE INSERT ON `return_purchase` FOR EACH ROW UPDATE purchase
        SET Qty = Qty - NEW.Qty
        WHERE Barcode = NEW.Barcode
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `return_temp`
--

CREATE TABLE `return_temp` (
  `memono` varchar(0) DEFAULT NULL,
  `cdate` varchar(0) DEFAULT NULL,
  `sno` varchar(0) DEFAULT NULL,
  `item` varchar(0) DEFAULT NULL,
  `brand` varchar(0) DEFAULT NULL,
  `rate` varchar(0) DEFAULT NULL,
  `qty` varchar(0) DEFAULT NULL,
  `price` varchar(0) DEFAULT NULL,
  `VAT` varchar(0) DEFAULT NULL,
  `serial_no` varchar(0) DEFAULT NULL,
  `User` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `roll`
--

CREATE TABLE `roll` (
  `cdate` varchar(19) DEFAULT NULL,
  `name` varchar(5) DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL,
  `in_time` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `roll_grid`
--

CREATE TABLE `roll_grid` (
  `cdate` varchar(0) DEFAULT NULL,
  `name` varchar(0) DEFAULT NULL,
  `status` varchar(0) DEFAULT NULL,
  `in_time` varchar(0) DEFAULT NULL,
  `rem` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `salary`
--

CREATE TABLE `salary` (
  `name` varchar(5) DEFAULT NULL,
  `d_salary` tinyint(4) DEFAULT NULL,
  `due` tinyint(4) DEFAULT NULL,
  `s_over` tinyint(4) DEFAULT NULL,
  `j_date` varchar(19) DEFAULT NULL,
  `balance` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `salary_change_temp`
--

CREATE TABLE `salary_change_temp` (
  `name` varchar(0) DEFAULT NULL,
  `dsalary` varchar(0) DEFAULT NULL,
  `cdate` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `salary_temp`
--

CREATE TABLE `salary_temp` (
  `name` varchar(5) DEFAULT NULL,
  `cdate` varchar(19) DEFAULT NULL,
  `DaySal` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `saledaily`
--

CREATE TABLE `saledaily` (
  `CDate` varchar(19) DEFAULT NULL,
  `Taka` mediumint(9) DEFAULT NULL,
  `monn` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `salemonthly`
--

CREATE TABLE `salemonthly` (
  `Sno` tinyint(4) DEFAULT NULL,
  `CUpDate` varchar(19) DEFAULT NULL,
  `CMonth` varchar(9) DEFAULT NULL,
  `Taka` mediumint(9) DEFAULT NULL,
  `CYear` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `saleyearly`
--

CREATE TABLE `saleyearly` (
  `CYear` smallint(6) DEFAULT NULL,
  `Taka` mediumint(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sale_return`
--

CREATE TABLE `sale_return` (
  `Barcode` varchar(11) DEFAULT NULL,
  `Item` varchar(100) NOT NULL,
  `Rate` varchar(12) NOT NULL,
  `Qty` varchar(12) NOT NULL,
  `Amount` varchar(12) NOT NULL,
  `Date` date NOT NULL DEFAULT current_timestamp(),
  `invoiceNo` varchar(20) DEFAULT NULL,
  `User` varchar(20) DEFAULT 'Admin'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Triggers `sale_return`
--
DELIMITER $$
CREATE TRIGGER `before_salereturn_insert` BEFORE INSERT ON `sale_return` FOR EACH ROW BEGIN
     UPDATE purchase 
    SET Qty = Qty + NEW.Qty
    WHERE Barcode = NEW.Barcode;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `searchproduct`
--

CREATE TABLE `searchproduct` (
  `Barcode` varchar(50) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `Rate` varchar(10) NOT NULL,
  `Qty` varchar(10) NOT NULL,
  `Amount` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `searchproductreturn`
--

CREATE TABLE `searchproductreturn` (
  `Barcode` varchar(50) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `Rate` varchar(10) NOT NULL,
  `Qty` varchar(10) NOT NULL,
  `Amount` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `serial`
--

CREATE TABLE `serial` (
  `Director` tinyint(4) DEFAULT NULL,
  `Employe` tinyint(4) DEFAULT NULL,
  `BarCode` smallint(6) DEFAULT NULL,
  `PurchaseVoucher` smallint(6) DEFAULT NULL,
  `INVSerial` smallint(6) DEFAULT NULL,
  `PurchaseReturn` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `stockbarcode`
--

CREATE TABLE `stockbarcode` (
  `Desc` varchar(0) DEFAULT NULL,
  `CodeNo` varchar(0) DEFAULT NULL,
  `Price` varchar(0) DEFAULT NULL,
  `User` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `stockreport`
--

CREATE TABLE `stockreport` (
  `SN` varchar(0) DEFAULT NULL,
  `serialno` varchar(0) DEFAULT NULL,
  `item` varchar(0) DEFAULT NULL,
  `brand` varchar(0) DEFAULT NULL,
  `rate` varchar(0) DEFAULT NULL,
  `qty` varchar(0) DEFAULT NULL,
  `price` varchar(0) DEFAULT NULL,
  `SalePrice` varchar(0) DEFAULT NULL,
  `GP` varchar(0) DEFAULT NULL,
  `Status` varchar(0) DEFAULT NULL,
  `User` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `stockview`
--

CREATE TABLE `stockview` (
  `cdate` varchar(0) DEFAULT NULL,
  `inv` varchar(0) DEFAULT NULL,
  `sup` varchar(0) DEFAULT NULL,
  `serialno` varchar(0) DEFAULT NULL,
  `serial` varchar(0) DEFAULT NULL,
  `item` varchar(0) DEFAULT NULL,
  `brand` varchar(0) DEFAULT NULL,
  `qty` varchar(0) DEFAULT NULL,
  `rate` varchar(0) DEFAULT NULL,
  `price` varchar(0) DEFAULT NULL,
  `DEO` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `stock_enrty`
--

CREATE TABLE `stock_enrty` (
  `Serial No` int(11) NOT NULL,
  `VoucherNo` double DEFAULT NULL,
  `Barcode` varchar(50) NOT NULL,
  `Date` date NOT NULL DEFAULT current_timestamp(),
  `InvoiceNo` double DEFAULT NULL,
  `SupplierName` varchar(50) DEFAULT NULL,
  `ItemName` varchar(120) NOT NULL,
  `GroupName` varchar(50) NOT NULL,
  `Qty` varchar(50) DEFAULT NULL,
  `Rate` varchar(50) DEFAULT NULL,
  `Total` varchar(50) DEFAULT NULL,
  `Vat` varchar(50) DEFAULT NULL,
  `SalePrice` varchar(50) DEFAULT NULL,
  `Status` varchar(12) DEFAULT NULL,
  `DEO` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `stock_master`
--

CREATE TABLE `stock_master` (
  `VoucherNo` varchar(20) DEFAULT NULL,
  `Barcode` varchar(50) NOT NULL,
  `Date` date NOT NULL DEFAULT current_timestamp(),
  `InvoiceNo` float DEFAULT NULL,
  `SupplierName` varchar(50) DEFAULT NULL,
  `ItemName` varchar(50) NOT NULL,
  `GroupName` varchar(50) NOT NULL,
  `brand` varchar(20) DEFAULT NULL,
  `Qty` float DEFAULT NULL,
  `Rate` float DEFAULT NULL,
  `Vat` float DEFAULT NULL,
  `SalePrice` float DEFAULT NULL,
  `Status` varchar(12) DEFAULT NULL,
  `DEO` varchar(50) DEFAULT NULL,
  `ProductUpdateStatus` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Triggers `stock_master`
--
DELIMITER $$
CREATE TRIGGER `stickstatemetn2` BEFORE UPDATE ON `stock_master` FOR EACH ROW IF new.ProductUpdateStatus ='ProductEntry' THEN
INSERT INTO stock_statement VALUES(new.VoucherNo, new.Barcode, new.Date, new.InvoiceNo, new.SupplierName, new.ItemName, new.GroupName, new.brand, new.Qty, new.Rate, new.Vat, new.SalePrice, new.Status, new.DEO);
END IF
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `stockstatement` BEFORE INSERT ON `stock_master` FOR EACH ROW INSERT INTO stock_statement VALUES(new.VoucherNo, new.Barcode, new.Date, new.InvoiceNo, new.SupplierName, new.ItemName, new.GroupName, new.brand, new.Qty, new.Rate, new.Vat, new.SalePrice, new.Status, new.DEO)
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `stock_report`
--

CREATE TABLE `stock_report` (
  `VoucherNo` varchar(20) DEFAULT NULL,
  `Barcode` varchar(50) NOT NULL,
  `Date` date NOT NULL DEFAULT current_timestamp(),
  `InvoiceNo` float DEFAULT NULL,
  `SupplierName` varchar(50) DEFAULT NULL,
  `ItemName` varchar(50) NOT NULL,
  `GroupName` varchar(50) NOT NULL,
  `Qty` float DEFAULT NULL,
  `Rate` float DEFAULT NULL,
  `Vat` float DEFAULT NULL,
  `SalePrice` float DEFAULT NULL,
  `Status` varchar(12) DEFAULT NULL,
  `DEO` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `stock_statement`
--

CREATE TABLE `stock_statement` (
  `VoucherNo` varchar(20) DEFAULT NULL,
  `Barcode` varchar(50) NOT NULL,
  `Date` date NOT NULL DEFAULT current_timestamp(),
  `InvoiceNo` float DEFAULT NULL,
  `SupplierName` varchar(50) DEFAULT NULL,
  `ItemName` varchar(50) NOT NULL,
  `GroupName` varchar(50) NOT NULL,
  `brand` varchar(20) DEFAULT NULL,
  `Qty` float DEFAULT NULL,
  `Rate` float DEFAULT NULL,
  `Vat` float DEFAULT NULL,
  `SalePrice` float DEFAULT NULL,
  `Status` varchar(12) DEFAULT NULL,
  `DEO` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `stock_temp`
--

CREATE TABLE `stock_temp` (
  `serialno` mediumint(9) DEFAULT NULL,
  `VoucherNo` tinyint(4) DEFAULT NULL,
  `serial` tinyint(4) DEFAULT NULL,
  `cdate` varchar(19) DEFAULT NULL,
  `inv` tinyint(4) DEFAULT NULL,
  `sup` varchar(14) DEFAULT NULL,
  `item` varchar(4) DEFAULT NULL,
  `brand` varchar(16) DEFAULT NULL,
  `qty` smallint(6) DEFAULT NULL,
  `rate` smallint(6) DEFAULT NULL,
  `price` mediumint(9) DEFAULT NULL,
  `VAT` tinyint(4) DEFAULT NULL,
  `SalePrice` smallint(6) DEFAULT NULL,
  `DEO` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `st_dt`
--

CREATE TABLE `st_dt` (
  `start_date` varchar(19) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `supplairinfo`
--

CREATE TABLE `supplairinfo` (
  `CDate` varchar(0) DEFAULT NULL,
  `invoiceNo` varchar(20) DEFAULT NULL,
  `M1Name` varchar(0) DEFAULT NULL,
  `Bank1` varchar(0) DEFAULT NULL,
  `Bank1Name` varchar(0) DEFAULT NULL,
  `Bank1No` varchar(0) DEFAULT NULL,
  `Bank2` varchar(0) DEFAULT NULL,
  `Bank2Name` varchar(0) DEFAULT NULL,
  `Bank2No` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `supplier_balance`
--

CREATE TABLE `supplier_balance` (
  `S/L` int(12) NOT NULL,
  `Date` date NOT NULL DEFAULT current_timestamp(),
  `Supplier` varchar(50) NOT NULL,
  `Balance` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `supplier_due`
--

CREATE TABLE `supplier_due` (
  `Date` date DEFAULT current_timestamp(),
  `Supplier` varchar(50) DEFAULT NULL,
  `Description` varchar(50) DEFAULT NULL,
  `Credit` float DEFAULT NULL,
  `Debit` float DEFAULT NULL,
  `Balance` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `supplier_statement`
--

CREATE TABLE `supplier_statement` (
  `Date` date NOT NULL DEFAULT current_timestamp(),
  `InvoiceNO` varchar(20) DEFAULT 'None',
  `Name` varchar(50) DEFAULT NULL,
  `Description` varchar(100) DEFAULT 'None',
  `Debit` varchar(15) DEFAULT '0',
  `Credit` varchar(15) DEFAULT '0',
  `Blance` varchar(15) NOT NULL DEFAULT '0',
  `User` varchar(20) DEFAULT 'Admin'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Triggers `supplier_statement`
--
DELIMITER $$
CREATE TRIGGER `Ladger_supplier` BEFORE INSERT ON `supplier_statement` FOR EACH ROW UPDATE ladger SET Blance = new.Blance WHERE AccountType = 'Supplier' AND Name = new.Name
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `invaudit`
--
ALTER TABLE `invaudit`
  ADD PRIMARY KEY (`serial_no`);

--
-- Indexes for table `invtemp`
--
ALTER TABLE `invtemp`
  ADD PRIMARY KEY (`serial_no`);

--
-- Indexes for table `journal`
--
ALTER TABLE `journal`
  ADD PRIMARY KEY (`S/L`);

--
-- Indexes for table `merbershipcard`
--
ALTER TABLE `merbershipcard`
  ADD PRIMARY KEY (`SerialNo`);

--
-- Indexes for table `recall`
--
ALTER TABLE `recall`
  ADD PRIMARY KEY (`serial_no`);

--
-- Indexes for table `stock_enrty`
--
ALTER TABLE `stock_enrty`
  ADD PRIMARY KEY (`Serial No`),
  ADD UNIQUE KEY `uk_stock_entry_barcode` (`Barcode`);

--
-- Indexes for table `supplier_balance`
--
ALTER TABLE `supplier_balance`
  ADD PRIMARY KEY (`S/L`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `invaudit`
--
ALTER TABLE `invaudit`
  MODIFY `serial_no` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=147;

--
-- AUTO_INCREMENT for table `invtemp`
--
ALTER TABLE `invtemp`
  MODIFY `serial_no` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=529;

--
-- AUTO_INCREMENT for table `journal`
--
ALTER TABLE `journal`
  MODIFY `S/L` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `merbershipcard`
--
ALTER TABLE `merbershipcard`
  MODIFY `SerialNo` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `recall`
--
ALTER TABLE `recall`
  MODIFY `serial_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=440;

--
-- AUTO_INCREMENT for table `stock_enrty`
--
ALTER TABLE `stock_enrty`
  MODIFY `Serial No` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT for table `supplier_balance`
--
ALTER TABLE `supplier_balance`
  MODIFY `S/L` int(12) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
