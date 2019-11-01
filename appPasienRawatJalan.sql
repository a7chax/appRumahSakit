-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 31, 2019 at 12:12 PM
-- Server version: 8.0.17-0ubuntu2
-- PHP Version: 7.3.11-0ubuntu0.19.10.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `appPasienRawatJalan`
--

-- --------------------------------------------------------

--
-- Table structure for table `dbDataPasien`
--

CREATE TABLE `dbDataPasien` (
  `namaPasien` varchar(50) NOT NULL,
  `kartuIdentitasPasien` int(30) NOT NULL,
  `noKartuIdentitasPasien` int(30) NOT NULL,
  `jenisKelaminPasien` varchar(15) NOT NULL,
  `tempatTanggalLahirPasien` date NOT NULL,
  `statusPasien` varchar(15) NOT NULL,
  `namaWaliPasien` varchar(30) NOT NULL,
  `noTelpPasien` varchar(15) NOT NULL,
  `namaPenjaminPasien` varchar(30) NOT NULL,
  `noTelpPenjaminPasien` varchar(15) NOT NULL,
  `namaPetugasPasien` varchar(30) NOT NULL,
  `shiftPetugasPasien` varchar(15) NOT NULL,
  `checkUpPasien` varchar(20) NOT NULL,
  `dokterPasien` varchar(30) NOT NULL,
  `jenisRawatPasien` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dbDataPasien`
--
ALTER TABLE `dbDataPasien`
  ADD PRIMARY KEY (`kartuIdentitasPasien`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
