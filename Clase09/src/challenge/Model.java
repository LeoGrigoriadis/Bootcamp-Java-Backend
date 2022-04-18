package challenge;
import java.sql.*;

public class Model {
	//atributos para conectar a la base de datos
	protected Statement st;
	protected PreparedStatement pr;
	protected ResultSet rs;
	protected Connection conectado;
	private String script;
	
	//vendedor, cliente, producto, venta, detalles de venta y facturacion
	private String nombre, apellido, direccion;
	private java.sql.Date fechaNacimiento , fechaFactura;
	private int cliente_id, vendedor_id, venta_id, producto_id, factura_id, dni, cantidadProd, cantidadVendida, stockMin;
	private double precioUnitario, subtotal, total;
	
	//constructor
	public Model(Connection conectado) { this.conectado=conectado; }
	
	//setters y getters
	public String getScript() { return script; }
	public void setScript(String script) { this.script = script; }
	
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	
	public String getApellido() { return apellido; }
	public void setApellido(String apellido) { this.apellido = apellido; }
	
	public String getDireccion() { return direccion; }
	public void setDireccion(String direccion) { this.direccion = direccion; }
	
	public Date getFechaNacimiento() { return fechaNacimiento; }
	public void setFechaNacimiento(String fecha) { this.fechaNacimiento=Date.valueOf(fecha); }
	public void setFechaNacimiento(Date fecha) { this.fechaNacimiento=fecha; }
	
	public Date getFechaFactura() { return fechaFactura; }
	public void setFechaFactura(String fecha) { this.fechaFactura=Date.valueOf(fecha); }
	public void setFechaFactura(Date fecha) { this.fechaFactura=fecha; }
	
	public int getCliente_id() { return cliente_id; }
	public void setCliente_id(int id) { this.cliente_id = id; }
	
	public int getDni() { return dni; }
	public void setDni(int dni) { this.dni = dni; }

	public int getProducto_id() { return producto_id; }
	public void setProducto_id(int producto_id) { this.producto_id = producto_id; }

	public int getCantidadProd() { return cantidadProd; }
	public void setCantidadProd(int cantidad) { this.cantidadProd = cantidad; }

	public int getStockMin() { return stockMin; }
	public void setStockMin(int stockMin) { this.stockMin = stockMin; }

	public double getPrecioUnitario() { return precioUnitario; }
	public void setPrecioUnitario(double precioUnitario) { this.precioUnitario = precioUnitario; }

	public int getVendedor_id() { return vendedor_id; }
	public void setVendedor_id(int vendedor_id) { this.vendedor_id = vendedor_id; }

	public int getVenta_id() { return venta_id; }
	public void setVenta_id(int venta_id) { this.venta_id = venta_id; }

	public int getFactura_id() { return factura_id; }
	public void setFactura_id(int factura_id) { this.factura_id = factura_id; }

	public int getCantidadVendida() { return cantidadVendida; }
	public void setCantidadVendida(int cantidadDet) { this.cantidadVendida = cantidadDet; }

	public double getSubtotal() { return subtotal; }
	public void setSubtotal(double subtotal) { this.subtotal = subtotal; }

	public double getTotal() { return total; }
	public void setTotal(double total) { this.total = total; }	
}