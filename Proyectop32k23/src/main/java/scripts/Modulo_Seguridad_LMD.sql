USE `proyectop312023` ;
-- Volcado de datos para la tabla `tbl_aplicacion`
--
INSERT INTO `tbl_aplicacion` (`aplid`, `aplnombre`, `aplestatus`) VALUES(1, 'login', 't');
INSERT INTO `tbl_aplicacion` (`aplid`, `aplnombre`, `aplestatus`) VALUES(10, 'Mantenimiento Usuarios', 'T');
-- --------------------------------------------------------
--
-- Volcado de datos para la tabla `tbl_tipousuario`
--
INSERT INTO `tbl_tipousuario` (`tipuid`, `tipunombre`, `tipuestatus`) VALUES(1, 'administrador', 't');
INSERT INTO `tbl_tipousuario` (`tipuid`, `tipunombre`, `tipuestatus`) VALUES(2, 'empleado', 't');
-- --------------------------------------------------------
--
-- Volcado de datos para la tabla `tbl_usuario`
--
INSERT INTO `tbl_usuario` (`usuid`, `usunombre`, `usucontrasena`, `usuultimasesion`, `usuestatus`, `usunombrereal`, `usucorreoe`, `usutelefono`, `usudireccion`, `tipuid`) VALUES(7, 'admin', 'MTIz', '2005-05-23', 'T', 'g', 'gh', '4545', 'gua', 2);





