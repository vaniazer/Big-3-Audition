-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 21 Mei 2020 pada 18.56
-- Versi Server: 10.1.13-MariaDB
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbaudition`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `data`
--

CREATE TABLE `data` (
  `id_data` int(11) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `usia` int(3) NOT NULL,
  `vokal` int(3) NOT NULL,
  `dance` int(3) NOT NULL,
  `rap` int(3) NOT NULL,
  `visual` int(3) NOT NULL,
  `company` varchar(30) NOT NULL,
  `status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `data`
--

INSERT INTO `data` (`id_data`, `nama`, `usia`, `vokal`, `dance`, `rap`, `visual`, `company`, `status`) VALUES
(2, 'Mina', 16, 4, 8, 2, 7, 'JYP', 'Lolos'),
(3, 'Irene', 18, 4, 7, 8, 10, 'SM', 'Lolos'),
(4, 'Jisoo', 16, 7, 4, 2, 8, 'YG', 'Lolos'),
(5, 'Taeyeon', 15, 9, 4, 1, 6, 'SM', 'Lolos'),
(6, 'Yoona', 12, 4, 8, 1, 10, 'SM', 'Lolos'),
(7, 'Jennie', 14, 3, 7, 9, 7, 'YG', 'Lolos'),
(8, 'Jihyo', 8, 8, 4, 3, 5, 'JYP', 'Lolos'),
(11, 'Jinny Park', 15, 1, 1, 1, 1, 'YG', 'Tidak Lolos'),
(12, 'Hyeji', 17, 1, 1, 1, 1, 'JYP', 'Tidak Lolos'),
(13, 'Dean', 16, 6, 4, 3, 5, 'JYP', 'Tidak Lolos'),
(14, 'Ho-seok', 15, 1, 7, 6, 3, 'JYP', 'Tidak Lolos'),
(15, 'Ji-hoon', 17, 6, 5, 1, 4, 'YG', 'Tidak Lolos'),
(16, 'Park Jin-young', 20, 5, 3, 1, 3, 'SM', 'Tidak Lolos'),
(17, 'Do Kyungsoo', 16, 7, 5, 1, 5, 'SM', 'Lolos');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(8) NOT NULL,
  `role` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `role`) VALUES
(1, 'rifkac', 'aaaa', 'admin'),
(2, 'vaniazer', '1111', 'user'),
(5, 'anjar', 'aaaa', 'user'),
(6, 'vania', 'qqqq', 'admin'),
(7, 'saya', 'aaaa', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data`
--
ALTER TABLE `data`
  ADD PRIMARY KEY (`id_data`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `data`
--
ALTER TABLE `data`
  MODIFY `id_data` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
