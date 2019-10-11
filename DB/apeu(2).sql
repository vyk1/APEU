-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 11-Out-2019 às 14:48
-- Versão do servidor: 10.4.6-MariaDB
-- versão do PHP: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `apeu`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `alunos`
--

CREATE TABLE `alunos` (
  `id` bigint(11) NOT NULL,
  `dataNasc` date NOT NULL,
  `status` varchar(11) NOT NULL,
  `estadoCivil` varchar(11) NOT NULL,
  `raca` varchar(11) NOT NULL,
  `distancia` bigint(11) NOT NULL,
  `formaIngresso` varchar(11) NOT NULL,
  `RFPC` varchar(11) NOT NULL,
  `trabalho` varchar(11) NOT NULL,
  `reservaVaga` varchar(11) NOT NULL,
  `idade` int(11) DEFAULT NULL,
  `intervaloIdade` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `alunos`
--

INSERT INTO `alunos` (`id`, `dataNasc`, `status`, `estadoCivil`, `raca`, `distancia`, `formaIngresso`, `RFPC`, `trabalho`, `reservaVaga`, `idade`, `intervaloIdade`) VALUES
(1, '1983-12-22', '1', '1', '1', 0, '1', '2', '2', '1', 33, 3),
(2, '1998-07-22', '1', '1', '1', 0, '1', '2', '1', '2', 18, 1),
(3, '1996-06-25', '1', '1', '1', 0, '1', '2', '1', '1', 20, 1),
(4, '1999-04-08', '1', '1', '1', 0, '1', '3', '1', '1', 17, 1),
(5, '1998-03-29', '1', '1', '1', 0, '1', '4', '1', '2', 18, 1),
(6, '1997-12-15', '1', '1', '1', 0, '1', '4', '1', '1', 19, 1),
(7, '1998-02-25', '1', '1', '1', 0, '1', '3', '1', '1', 19, 1),
(8, '1997-11-07', '1', '1', '1', 0, '1', '3', '1', '1', 19, 1),
(9, '1978-10-19', '1', '2', '1', 0, '1', '2', '2', '1', 38, 4),
(10, '1998-01-13', '1', '1', '1', 0, '1', '1', '1', '1', 19, 1),
(11, '1998-07-27', '0', '1', '1', 0, '1', '1', '1', '2', 18, 1),
(12, '1979-06-17', '0', '2', '2', 0, '1', '1', '2', '2', 37, 4),
(13, '1991-05-24', '0', '3', '1', 0, '2', '2', '6', '1', 25, 2),
(14, '1999-01-11', '0', '1', '1', 0, '1', '2', '2', '2', 18, 1),
(15, '1991-09-16', '0', '1', '1', 0, '1', '4', '1', '2', 25, 2),
(17, '1986-04-07', '0', '2', '1', 115, '5', '2', '4', '3', 30, 3),
(18, '1984-04-25', '0', '2', '1', 0, '1', '5', '4', '1', 32, 3),
(19, '1995-07-14', '0', '1', '2', 0, '1', '2', '3', '1', 21, 1),
(20, '1982-02-15', '0', '2', '1', 0, '3', '4', '1', '1', 35, 4),
(21, '1964-10-26', '0', '2', '1', 14, '1', '2', '2', '2', 52, 6),
(22, '1970-01-21', '0', '2', '1', 0, '1', '2', '6', '2', 47, 6),
(23, '1998-07-03', '0', '1', '1', 14, '1', '2', '2', '1', 18, 1),
(24, '1993-03-06', '0', '3', '1', 0, '1', '1', '2', '2', 23, 2),
(25, '1998-09-01', '0', '1', '1', 0, '1', '1', '1', '2', 18, 1),
(26, '1989-02-12', '0', '1', '1', 0, '1', '3', '2', '1', 28, 2),
(27, '1975-12-21', '0', '4', '1', 50, '1', '3', '3', '2', 41, 5),
(28, '1993-09-16', '0', '1', '1', 0, '1', '2', '1', '2', 23, 2);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `alunos`
--
ALTER TABLE `alunos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `alunos`
--
ALTER TABLE `alunos`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
