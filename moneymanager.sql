-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 04, 2020 at 01:53 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `moneymanager`
--

-- --------------------------------------------------------

--
-- Table structure for table `pendapatan`
--

CREATE TABLE `pendapatan` (
  `id_pendapatan` char(11) NOT NULL,
  `tanggal` date NOT NULL,
  `jumlah` int(100) NOT NULL,
  `catatan` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pendapatan`
--

INSERT INTO `pendapatan` (`id_pendapatan`, `tanggal`, `jumlah`, `catatan`) VALUES
('PDN-002', '2020-01-02', 2000, 'untuk beli satu cireng'),
('PDN-004', '2020-01-04', 3000, 'untuk beli cireng'),
('PDN-005', '2020-01-04', 10000, 'untuk beli seblak');

-- --------------------------------------------------------

--
-- Table structure for table `pengeluaran`
--

CREATE TABLE `pengeluaran` (
  `id_pengeluaran` char(11) NOT NULL,
  `tanggal_pilih` date NOT NULL,
  `transportasi` int(100) NOT NULL,
  `makanan` int(100) NOT NULL,
  `kesehatan` int(100) NOT NULL,
  `kecantikan` int(100) NOT NULL,
  `pakaian` int(100) NOT NULL,
  `komunikasi` int(100) NOT NULL,
  `lainnya` int(100) NOT NULL,
  `jumlah` int(100) NOT NULL,
  `catatan` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengeluaran`
--

INSERT INTO `pengeluaran` (`id_pengeluaran`, `tanggal_pilih`, `transportasi`, `makanan`, `kesehatan`, `kecantikan`, `pakaian`, `komunikasi`, `lainnya`, `jumlah`, `catatan`) VALUES
('PGN-001', '2020-01-04', 0, 1000, 0, 0, 0, 0, 0, 1000, '-'),
('PGN-002', '2020-01-04', 500, 200, 1000, 0, 0, 0, 0, 1700, 'makan rada elit dikit,\nsakit ceunah'),
('PGN-003', '2020-01-05', 0, 5000, 0, 0, 0, 0, 0, 5000, 'jajan seblak');

-- --------------------------------------------------------

--
-- Table structure for table `saldobalance`
--

CREATE TABLE `saldobalance` (
  `id` int(11) NOT NULL,
  `id_pendapatan` char(11) DEFAULT NULL,
  `id_pengeluaran` char(11) DEFAULT NULL,
  `jumlah` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `saldobalance`
--

INSERT INTO `saldobalance` (`id`, `id_pendapatan`, `id_pengeluaran`, `jumlah`) VALUES
(33, 'PDN-002', NULL, 2000),
(36, NULL, 'PGN-001', 1000),
(37, NULL, 'PGN-002', 1700),
(39, 'PDN-004', NULL, 3000),
(40, 'PDN-005', NULL, 10000),
(41, NULL, 'PGN-003', 5000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pendapatan`
--
ALTER TABLE `pendapatan`
  ADD PRIMARY KEY (`id_pendapatan`);

--
-- Indexes for table `pengeluaran`
--
ALTER TABLE `pengeluaran`
  ADD PRIMARY KEY (`id_pengeluaran`);

--
-- Indexes for table `saldobalance`
--
ALTER TABLE `saldobalance`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_pendapatan` (`id_pendapatan`),
  ADD KEY `id_pengeluaran` (`id_pengeluaran`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `saldobalance`
--
ALTER TABLE `saldobalance`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `saldobalance`
--
ALTER TABLE `saldobalance`
  ADD CONSTRAINT `saldobalance_ibfk_1` FOREIGN KEY (`id_pendapatan`) REFERENCES `pendapatan` (`id_pendapatan`),
  ADD CONSTRAINT `saldobalance_ibfk_2` FOREIGN KEY (`id_pengeluaran`) REFERENCES `pengeluaran` (`id_pengeluaran`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
