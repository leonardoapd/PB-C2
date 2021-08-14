-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-08-2021 a las 06:28:09
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `administracionproductos`
--
CREATE DATABASE IF NOT EXISTS `administracionproductos` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `administracionproductos`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_clientes`
--

CREATE TABLE `tb_clientes` (
  `idCliente` int(11) NOT NULL,
  `nombre` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `direccion` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` varchar(12) COLLATE utf8_spanish_ci DEFAULT NULL,
  `correo` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ciudad` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `departamento` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tipoDocumento` varchar(5) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nroDocumento` int(11) DEFAULT NULL,
  `fechaNacimiento` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tb_clientes`
--

INSERT INTO `tb_clientes` (`idCliente`, `nombre`, `direccion`, `telefono`, `correo`, `ciudad`, `departamento`, `tipoDocumento`, `nroDocumento`, `fechaNacimiento`) VALUES
(1, 'Leonardo Perdomo', 'Calle 47 No 30 29 Urbanizacion Las Casas', '573053052313', 'leonardo@gmail.com', 'Santa Marta', 'Magdalena', 'C.C', 1082951361, '17/01/1992'),
(2, 'Liz Ospino Pertuz', 'Calle 47 No 30 29 Urbanizacion Las Casas', '3117613384', 'liz@gmail.com', 'Santa Marta', 'Magdalena', 'C.C', 1083025554, '07/06/1997'),
(3, 'Charlotte Parra', 'Mz 4 Casa 5 Urb Las Casas', '3006768791', 'nerismaria@hotmail.es', 'Santa Marta', 'Magdalena', 'Otro', 1083087678, '11/08/2011'),
(4, 'Mario Casas', 'Calle 24 No 90 21', '0348288922', 'mcasas@correo.com', 'Barranquilla', 'Atlantico', 'C.C', 1082222653, '14/09/1993'),
(5, 'John Felix', 'Cra 45 No 30 28', '3008927653', 'jfelix@correo.com', 'Ontario', 'Toronto', 'C.C', 34787222, '1/09/1993'),
(6, 'Carlos Carrillo', 'Mz 8 Casa 43', '3142568734', 'ccarrillo@correo.com', 'Oakville', 'Toronto', 'C.C', 45098345, '13/05/1987');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_pedidos`
--

CREATE TABLE `tb_pedidos` (
  `idPedido` int(10) NOT NULL,
  `idCliente` int(10) DEFAULT 0,
  `idVendedor` int(10) DEFAULT 0,
  `estadoPedido` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `descuento` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tb_pedidos`
--

INSERT INTO `tb_pedidos` (`idPedido`, `idCliente`, `idVendedor`, `estadoPedido`, `descuento`) VALUES
(1, 1, 1, 'PENDIENTE', 20),
(2, 3, 2, NULL, NULL),
(3, 3, 2, NULL, NULL),
(4, 3, 2, NULL, NULL),
(5, 1, 2, NULL, NULL),
(6, 2, 2, NULL, NULL),
(7, 3, 1, NULL, NULL),
(8, 3, 2, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_pedido_producto`
--

CREATE TABLE `tb_pedido_producto` (
  `idPedidoProducto` int(11) NOT NULL,
  `idPedido` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT 0,
  `precioDeVenta` int(11) NOT NULL DEFAULT 0,
  `totalDeVenta` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Tabla maestro detalle, destinada a combinar la informacion entre los productos y los pedidos.';

--
-- Volcado de datos para la tabla `tb_pedido_producto`
--

INSERT INTO `tb_pedido_producto` (`idPedidoProducto`, `idPedido`, `idProducto`, `cantidad`, `precioDeVenta`, `totalDeVenta`) VALUES
(19, 6, 2, 0, 0, 0),
(20, 6, 4, 0, 0, 0),
(21, 6, 5, 0, 0, 0),
(22, 6, 7, 0, 0, 0),
(23, 1, 3, 0, 0, 0),
(24, 1, 12, 0, 0, 0),
(25, 2, 3, 0, 0, 0),
(26, 3, 4, 0, 0, 0),
(27, 3, 2, 0, 0, 0),
(28, 3, 5, 0, 0, 0),
(29, 4, 12, 0, 0, 0),
(30, 5, 12, 0, 0, 0),
(31, 5, 3, 0, 0, 0),
(32, 5, 5, 0, 0, 0),
(33, 5, 7, 0, 0, 0),
(34, 5, 9, 0, 0, 0),
(35, 2, 11, 0, 0, 0),
(36, 2, 4, 0, 0, 0),
(37, 2, 6, 0, 0, 0),
(38, 2, 8, 0, 0, 0),
(39, 5, 2, 0, 0, 0),
(40, 5, 8, 0, 0, 0),
(41, 5, 12, 0, 0, 0),
(42, 5, 11, 0, 0, 0),
(43, 7, 2, 0, 0, 0),
(44, 7, 5, 0, 0, 0),
(45, 7, 1, 0, 0, 0),
(46, 7, 3, 0, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_productos`
--

CREATE TABLE `tb_productos` (
  `idProducto` int(11) NOT NULL,
  `nombre` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `descripcion` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `unidadMedida` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `precio` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `idProveedor` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT 0,
  `precioPromedio` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tb_productos`
--

INSERT INTO `tb_productos` (`idProducto`, `nombre`, `descripcion`, `unidadMedida`, `precio`, `cantidad`, `idProveedor`, `total`, `precioPromedio`) VALUES
(1, 'Fosfato Monoamónico', 'KCl Granular.', 'Ton', 1800, 40, 1, 76000, 1900),
(2, 'Cloruro de Potasio', '1 kg de Cloruro de potasio.', 'Ton', 2000, 20, 2, 50000, 2500),
(3, 'Urea', 'Urea para cultivos agrícolas.', 'Kg', 0, 80, NULL, 6000, 75),
(4, 'Sulfato de potasio', 'Comprado en sacos de 50kg.', 'Kg', 2000, 60, NULL, 140000, 2333),
(5, 'Empaques de 50 Kg', 'Sacos para reempacar productos sueltos.', 'Unidad', 0, 0, NULL, NULL, NULL),
(6, 'Amonio', 'Producto para cultivos agrícolas.', 'Ton', NULL, NULL, NULL, NULL, NULL),
(7, 'Cloruro de sodio', 'Sal refinada.', 'Kg', NULL, NULL, NULL, NULL, NULL),
(8, 'Empaques XXL', 'Empaques para productos varios.', 'Unidad', NULL, NULL, NULL, NULL, NULL),
(9, 'Limpido ', 'Limpiador desinfectante.', 'cm3', NULL, NULL, NULL, NULL, NULL),
(11, 'Cereal de Centeno', 'Cereal hecho a base de centeno.', 'Kg', NULL, NULL, NULL, NULL, NULL),
(12, 'Miel de abejas', 'Envase de miel de abejas puras.', 'cm3', NULL, NULL, NULL, NULL, NULL),
(13, 'Caramelo Raro', 'Caramelo muy extraño que te hace aumentar de nivel.', 'Kg', NULL, NULL, NULL, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_proveedores`
--

CREATE TABLE `tb_proveedores` (
  `idProveedor` int(11) NOT NULL,
  `nombre` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `direccion` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` varchar(12) COLLATE utf8_spanish_ci DEFAULT NULL,
  `correo` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ciudad` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `departamento` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tipoDocumento` varchar(5) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nroDocumento` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tb_proveedores`
--

INSERT INTO `tb_proveedores` (`idProveedor`, `nombre`, `direccion`, `telefono`, `correo`, `ciudad`, `departamento`, `tipoDocumento`, `nroDocumento`) VALUES
(1, 'Disan Colombia SAS', 'Patio 3 Bodega 45 Parque Industrial', '0315673894', 'info@disan.com', 'Bogota', 'Cundinamarca', 'C.C', 70087289),
(2, 'Fosfatos SAS', 'Patio 5 Bodega 4 Puerto Maritimo', '0314569364', 'info@fosfatos.com', 'Tesalia', 'Cundinamarca', 'NIT', 78987234),
(3, 'Petroquimicos LTDA', 'Calle 120 No 34-12', '0347658943', 'info@quimicos.com', 'Santa Marta', 'Magdalena', 'NIT', 78987356),
(4, 'Team Rocket', 'Edificio R No 1', '1800876348', 'info@teamrocket.com', 'Pueblo Lavanda', 'Kanto', 'NIT', 890627821);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_vendedores`
--

CREATE TABLE `tb_vendedores` (
  `idVendedor` int(11) NOT NULL,
  `nombre` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `direccion` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` varchar(12) COLLATE utf8_spanish_ci DEFAULT NULL,
  `correo` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ciudad` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `departamento` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tipoDocumento` varchar(5) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nroDocumento` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tb_vendedores`
--

INSERT INTO `tb_vendedores` (`idVendedor`, `nombre`, `direccion`, `telefono`, `correo`, `ciudad`, `departamento`, `tipoDocumento`, `nroDocumento`) VALUES
(1, 'Pepito Perez', 'Calle 45 No 98 200', '3044657898', 'pperez@empresa.com', 'Itagui', 'Antioquia', 'C.C', 12876345),
(2, 'Salma Rosales', 'Calle 47 No 30 29', '0354251779', 'srosales@empresa.com', 'Santa Marta', 'Magdalena', 'C.C', 1098728821);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tb_clientes`
--
ALTER TABLE `tb_clientes`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `tb_pedidos`
--
ALTER TABLE `tb_pedidos`
  ADD PRIMARY KEY (`idPedido`),
  ADD KEY `idCliente` (`idCliente`),
  ADD KEY `idVendedor` (`idVendedor`);

--
-- Indices de la tabla `tb_pedido_producto`
--
ALTER TABLE `tb_pedido_producto`
  ADD PRIMARY KEY (`idPedidoProducto`),
  ADD KEY `idPedido` (`idPedido`),
  ADD KEY `idProducto` (`idProducto`);

--
-- Indices de la tabla `tb_productos`
--
ALTER TABLE `tb_productos`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `idProveedor` (`idProveedor`);

--
-- Indices de la tabla `tb_proveedores`
--
ALTER TABLE `tb_proveedores`
  ADD PRIMARY KEY (`idProveedor`);

--
-- Indices de la tabla `tb_vendedores`
--
ALTER TABLE `tb_vendedores`
  ADD PRIMARY KEY (`idVendedor`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tb_clientes`
--
ALTER TABLE `tb_clientes`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `tb_pedidos`
--
ALTER TABLE `tb_pedidos`
  MODIFY `idPedido` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `tb_pedido_producto`
--
ALTER TABLE `tb_pedido_producto`
  MODIFY `idPedidoProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT de la tabla `tb_productos`
--
ALTER TABLE `tb_productos`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `tb_proveedores`
--
ALTER TABLE `tb_proveedores`
  MODIFY `idProveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tb_vendedores`
--
ALTER TABLE `tb_vendedores`
  MODIFY `idVendedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tb_pedidos`
--
ALTER TABLE `tb_pedidos`
  ADD CONSTRAINT `tb_pedidos_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `tb_clientes` (`idCliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_pedidos_ibfk_2` FOREIGN KEY (`idVendedor`) REFERENCES `tb_vendedores` (`idVendedor`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tb_pedido_producto`
--
ALTER TABLE `tb_pedido_producto`
  ADD CONSTRAINT `tb_pedido_producto_ibfk_1` FOREIGN KEY (`idPedido`) REFERENCES `tb_pedidos` (`idPedido`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_pedido_producto_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `tb_productos` (`idProducto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tb_productos`
--
ALTER TABLE `tb_productos`
  ADD CONSTRAINT `tb_productos_ibfk_1` FOREIGN KEY (`idProveedor`) REFERENCES `tb_proveedores` (`idProveedor`) ON DELETE CASCADE ON UPDATE CASCADE;


--
-- Metadatos
--
USE `phpmyadmin`;

--
-- Metadatos para la tabla tb_clientes
--

--
-- Metadatos para la tabla tb_pedidos
--

--
-- Volcado de datos para la tabla `pma__table_uiprefs`
--

INSERT INTO `pma__table_uiprefs` (`username`, `db_name`, `table_name`, `prefs`, `last_update`) VALUES
('root', 'administracionproductos', 'tb_pedidos', '{\"sorted_col\":\"`tb_pedidos`.`idPedido`  ASC\"}', '2021-08-06 01:02:19');

--
-- Metadatos para la tabla tb_pedido_producto
--

--
-- Volcado de datos para la tabla `pma__table_uiprefs`
--

INSERT INTO `pma__table_uiprefs` (`username`, `db_name`, `table_name`, `prefs`, `last_update`) VALUES
('root', 'administracionproductos', 'tb_pedido_producto', '{\"sorted_col\":\"`tb_pedido_producto`.`idPedido` ASC\"}', '2021-08-12 22:14:22');

--
-- Metadatos para la tabla tb_productos
--

--
-- Metadatos para la tabla tb_proveedores
--

--
-- Metadatos para la tabla tb_vendedores
--

--
-- Metadatos para la base de datos administracionproductos
--
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
