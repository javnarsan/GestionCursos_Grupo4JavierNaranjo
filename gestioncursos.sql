-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-12-2022 a las 22:59:17
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 7.4.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestioncursos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `email` varchar(45) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `nombre` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `apellidos`, `email`, `enabled`, `foto`, `nombre`, `password`, `role`) VALUES
(8, 'Reyes', 'felix@gmail.com', b'1', '', 'Felix', '$2a$10$LkmWpNpoSmbYgOGaZppK4.68rlkK7syqb/kAqMQYDoMcFox1ukqlW', 'ROLE_PROFESOR'),
(6, '', 'admin@gmail.com', b'1', '', '', '$2a$10$SbV93vwvghIi0V8UUne88.Kp3Ioqh6iaar2nEyW8y8wYYvGX93cdi', 'ROLE_ADMIN'),
(7, 'Junquera Manrique', 'alejandro@gmail.com', b'1', 'Captura de pantalla_20221209_180006.png', 'Alejandro', '$2a$10$Dgz./iHmTBQztr6bq7uG7u4HK/iNUhOSMiOOrYRXC1WPCFAG3QM8m', 'ROLE_ALUMNO');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
