DELIMITER $$
CREATE TRIGGER `restarCantidad` AFTER INSERT ON `ventas`
 FOR EACH ROW BEGIN

UPDATE productos inner JOIN ventas on ventas.producto_id=productos.id_producto
set productos.cantidad=(productos.cantidad-ventas.cantidad_vendida)
where ventas.producto_id=productos.id_producto;

END $$

CREATE TRIGGER `agregarFactura` AFTER INSERT ON `ventas`
 FOR EACH ROW 
INSERT into factura (factura.factura_id,factura.venta_id,factura.fecha)
values(null, new.id_venta,CURDATE())

DELIMITER ;