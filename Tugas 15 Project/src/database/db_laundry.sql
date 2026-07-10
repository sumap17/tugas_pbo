-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 10, 2026 at 07:53 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_laundry`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `tambah_transaksi` (IN `p_id_pelanggan` INT, IN `p_berat` DOUBLE, IN `p_jenis_layanan` VARCHAR(100), IN `p_total_harga` DOUBLE)   BEGIN
    INSERT INTO transaksi
    (id_pelanggan, berat, jenis_layanan, total_harga)
    VALUES
    (p_id_pelanggan, p_berat, p_jenis_layanan, p_total_harga);
END$$

--
-- Functions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `totalPendapatan` () RETURNS DOUBLE DETERMINISTIC BEGIN
    DECLARE total DOUBLE;

    SELECT IFNULL(SUM(total_harga), 0)
    INTO total
    FROM transaksi;

    RETURN total;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in structure for view `laundry_belum_selesai`
-- (See below for the actual view)
--
CREATE TABLE `laundry_belum_selesai` (
`id_transaksi` int(11)
,`id_pelanggan` int(11)
,`berat` double
,`jenis_layanan` varchar(30)
,`status` varchar(30)
);

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` int(11) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `no_hp` varchar(20) DEFAULT NULL,
  `alamat` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `nama`, `no_hp`, `alamat`) VALUES
(1, 'Sukma', '121212', 'Sukabumi'),
(4, 'praja', '454578', 'Salbin');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `id_pelanggan` int(11) DEFAULT NULL,
  `berat` double DEFAULT NULL,
  `jenis_layanan` varchar(30) DEFAULT NULL,
  `total_harga` double DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `id_pelanggan`, `berat`, `jenis_layanan`, `total_harga`, `status`) VALUES
(1, 1, 20, 'Cuci Kering', 140000, 'Diproses'),
(2, 4, 5, 'cuci saja', 35000, 'Diproses');

--
-- Triggers `transaksi`
--
DELIMITER $$
CREATE TRIGGER `status_default` BEFORE INSERT ON `transaksi` FOR EACH ROW BEGIN

SET NEW.status='Diproses';

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure for view `laundry_belum_selesai`
--
DROP TABLE IF EXISTS `laundry_belum_selesai`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `laundry_belum_selesai`  AS SELECT `transaksi`.`id_transaksi` AS `id_transaksi`, `transaksi`.`id_pelanggan` AS `id_pelanggan`, `transaksi`.`berat` AS `berat`, `transaksi`.`jenis_layanan` AS `jenis_layanan`, `transaksi`.`status` AS `status` FROM `transaksi` WHERE `transaksi`.`status` = 'Diproses' ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_pelanggan` (`id_pelanggan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pelanggan`
--
ALTER TABLE `pelanggan`
  MODIFY `id_pelanggan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id_pelanggan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
