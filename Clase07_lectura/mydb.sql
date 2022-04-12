-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-04-2022 a las 21:45:06
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `mydb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `album`
--

CREATE TABLE `album` (
  `idalbum` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `numCanciones` int(11) DEFAULT NULL,
  `artista_idartista` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `album`
--

INSERT INTO `album` (`idalbum`, `nombre`, `numCanciones`, `artista_idartista`) VALUES
(1, 'Brother in Arms', 9, 2),
(2, 'Hello Cotto', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artista`
--

CREATE TABLE `artista` (
  `idartista` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `artista`
--

INSERT INTO `artista` (`idartista`, `nombre`) VALUES
(1, 'Duko'),
(2, 'Dire Straits');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cancion`
--

CREATE TABLE `cancion` (
  `idcancion` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `duracion` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cancion`
--

INSERT INTO `cancion` (`idcancion`, `nombre`, `duracion`) VALUES
(1, 'Brothers in arms', 7),
(2, 'Hello Cotto', 4.5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cancion_has_album`
--

CREATE TABLE `cancion_has_album` (
  `cancion_idcancion` int(11) NOT NULL,
  `album_idalbum` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cancion_has_album`
--

INSERT INTO `cancion_has_album` (`cancion_idcancion`, `album_idalbum`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cancion_has_artista`
--

CREATE TABLE `cancion_has_artista` (
  `cancion_idcancion` int(11) NOT NULL,
  `artista_idartista` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cancion_has_artista`
--

INSERT INTO `cancion_has_artista` (`cancion_idcancion`, `artista_idartista`) VALUES
(1, 2),
(2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `playlist`
--

CREATE TABLE `playlist` (
  `idplaylist` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `public` tinyint(4) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `playlist`
--

INSERT INTO `playlist` (`idplaylist`, `nombre`, `public`) VALUES
(1, 'Enganchados 2020', 1),
(2, 'Rock classic', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `playlist_has_cancion`
--

CREATE TABLE `playlist_has_cancion` (
  `playlist_idplaylist` int(11) NOT NULL,
  `cancion_idcancion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `playlist_has_cancion`
--

INSERT INTO `playlist_has_cancion` (`playlist_idplaylist`, `cancion_idcancion`) VALUES
(1, 2),
(2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `idusuario` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `premium` tinyint(4) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idusuario`, `nombre`, `premium`) VALUES
(1, 'Eduardo', 0),
(2, 'Mariadb', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios_has_playlist`
--

CREATE TABLE `usuarios_has_playlist` (
  `usuarios_idusuario` int(11) NOT NULL,
  `playlist_idplaylist` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios_has_playlist`
--

INSERT INTO `usuarios_has_playlist` (`usuarios_idusuario`, `playlist_idplaylist`) VALUES
(1, 2),
(2, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`idalbum`),
  ADD KEY `fk_album_artista1_idx` (`artista_idartista`);

--
-- Indices de la tabla `artista`
--
ALTER TABLE `artista`
  ADD PRIMARY KEY (`idartista`);

--
-- Indices de la tabla `cancion`
--
ALTER TABLE `cancion`
  ADD PRIMARY KEY (`idcancion`);

--
-- Indices de la tabla `cancion_has_album`
--
ALTER TABLE `cancion_has_album`
  ADD PRIMARY KEY (`cancion_idcancion`,`album_idalbum`),
  ADD KEY `fk_cancion_has_album_album1_idx` (`album_idalbum`),
  ADD KEY `fk_cancion_has_album_cancion1_idx` (`cancion_idcancion`);

--
-- Indices de la tabla `cancion_has_artista`
--
ALTER TABLE `cancion_has_artista`
  ADD PRIMARY KEY (`cancion_idcancion`,`artista_idartista`),
  ADD KEY `fk_cancion_has_artista_artista1_idx` (`artista_idartista`),
  ADD KEY `fk_cancion_has_artista_cancion_idx` (`cancion_idcancion`);

--
-- Indices de la tabla `playlist`
--
ALTER TABLE `playlist`
  ADD PRIMARY KEY (`idplaylist`);

--
-- Indices de la tabla `playlist_has_cancion`
--
ALTER TABLE `playlist_has_cancion`
  ADD PRIMARY KEY (`playlist_idplaylist`,`cancion_idcancion`),
  ADD KEY `fk_playlist_has_cancion_cancion1_idx` (`cancion_idcancion`),
  ADD KEY `fk_playlist_has_cancion_playlist1_idx` (`playlist_idplaylist`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idusuario`);

--
-- Indices de la tabla `usuarios_has_playlist`
--
ALTER TABLE `usuarios_has_playlist`
  ADD PRIMARY KEY (`usuarios_idusuario`,`playlist_idplaylist`),
  ADD KEY `fk_usuarios_has_playlist_playlist1_idx` (`playlist_idplaylist`),
  ADD KEY `fk_usuarios_has_playlist_usuarios1_idx` (`usuarios_idusuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `album`
--
ALTER TABLE `album`
  MODIFY `idalbum` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `artista`
--
ALTER TABLE `artista`
  MODIFY `idartista` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `cancion`
--
ALTER TABLE `cancion`
  MODIFY `idcancion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `playlist`
--
ALTER TABLE `playlist`
  MODIFY `idplaylist` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `album`
--
ALTER TABLE `album`
  ADD CONSTRAINT `fk_album_artista1` FOREIGN KEY (`artista_idartista`) REFERENCES `artista` (`idartista`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `cancion_has_album`
--
ALTER TABLE `cancion_has_album`
  ADD CONSTRAINT `fk_cancion_has_album_album1` FOREIGN KEY (`album_idalbum`) REFERENCES `album` (`idalbum`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_cancion_has_album_cancion1` FOREIGN KEY (`cancion_idcancion`) REFERENCES `cancion` (`idcancion`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `cancion_has_artista`
--
ALTER TABLE `cancion_has_artista`
  ADD CONSTRAINT `fk_cancion_has_artista_artista1` FOREIGN KEY (`artista_idartista`) REFERENCES `artista` (`idartista`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_cancion_has_artista_cancion` FOREIGN KEY (`cancion_idcancion`) REFERENCES `cancion` (`idcancion`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `playlist_has_cancion`
--
ALTER TABLE `playlist_has_cancion`
  ADD CONSTRAINT `fk_playlist_has_cancion_cancion1` FOREIGN KEY (`cancion_idcancion`) REFERENCES `cancion` (`idcancion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_playlist_has_cancion_playlist1` FOREIGN KEY (`playlist_idplaylist`) REFERENCES `playlist` (`idplaylist`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuarios_has_playlist`
--
ALTER TABLE `usuarios_has_playlist`
  ADD CONSTRAINT `fk_usuarios_has_playlist_playlist1` FOREIGN KEY (`playlist_idplaylist`) REFERENCES `playlist` (`idplaylist`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_usuarios_has_playlist_usuarios1` FOREIGN KEY (`usuarios_idusuario`) REFERENCES `usuarios` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
