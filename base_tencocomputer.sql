-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3307
-- Tiempo de generación: 21-10-2024 a las 23:46:41
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `base_tencocomputer`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `ID` int(3) NOT NULL,
  `Nombre_Completo` varchar(50) NOT NULL,
  `Usuario` varchar(50) NOT NULL,
  `Contrasena` varchar(50) NOT NULL,
  `correo_electronico` varchar(50) NOT NULL DEFAULT 'NOT NULL'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`ID`, `Nombre_Completo`, `Usuario`, `Contrasena`, `correo_electronico`) VALUES
(2, 'haider', 'camorna', '12345', 'haider123@gmail.com'),
(3, 'qeq', 'NOT NULL', 'qeqe', 'qewqe'),
(4, 'qweqe', 'qeqeq', 'eqewq', 'eqe'),
(5, 'Jaider Andres Carmona Rodriguez', 'jaider123', '1234', 'haider@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pagina_web`
--

CREATE TABLE `pagina_web` (
  `Cuentas_usuarios` tinyint(4) NOT NULL,
  `Añadir_contenido` varchar(45) NOT NULL,
  `Reportes` varchar(45) NOT NULL,
  `Numeros de cuentas` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitud`
--

CREATE TABLE `solicitud` (
  `ID_cliente` int(11) NOT NULL,
  `Dato_cliente` date NOT NULL,
  `Dato_dispositivo` date NOT NULL,
  `Fecha_entrega` date NOT NULL,
  `Fecha_Finalizada` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `pagina_web`
--
ALTER TABLE `pagina_web`
  ADD PRIMARY KEY (`Cuentas_usuarios`);

--
-- Indices de la tabla `solicitud`
--
ALTER TABLE `solicitud`
  ADD PRIMARY KEY (`ID_cliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `ID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
