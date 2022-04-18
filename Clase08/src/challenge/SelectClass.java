package challenge;
import java.sql.*;
import java.util.Scanner;

public class SelectClass extends Model{
	
	public SelectClass(Connection conectado) { super(conectado);
		Scanner teclado = new Scanner(System.in);
		int op=1;
		while(op!=0) {
			System.out.println( "\nElija la tabla que quiere ver: "
				+ "\n 1- Cliente. \n 2- Vendedor. \n 3- Producto. \n 4- Ventas. \n 5- Filtrar ventas donde clientes contenga la letra 'a'. "
				+ "\n 6- Productos vendidos. \n 7- Filtrar ventas por vendedor. \n 8- Filtrar ventas por Fecha. \n 0- Salir.");
			System.out.print("Opcion= ");
			op = teclado.nextInt();
			switch(op) {
			case 1: SelectCliente();break;
			case 2: SelectVendedor();break;
			case 3: SelectProducto();break;
			case 4: SelectVenta();break;
			case 5: SelectClienteConA();break;
			case 6: SelectProductoVendidos(); break;
			case 7: SelectVentasPorVendedor(); break;
			case 8: System.out.println("\nIngrese la fecha: ");
			setFechaFactura(teclado.next());
			SelectVentaFecha();break;
			default: System.out.print("Esta opción no es válida.");break;
			}
		}
	}
	public void SelectCliente(){
		setScript("SELECT * FROM clientes");
		try {
			super.st=conectado.createStatement();
			super.rs=st.executeQuery(getScript());
			
			while(rs.next()) {
				setCliente_id(rs.getInt("cliente_id"));
				setNombre(rs.getString("nombre"));
				setApellido(rs.getString("apellido"));
				setDni(rs.getInt("dni"));
				setDireccion(rs.getString("direccion"));
				setFechaNacimiento(rs.getDate("fechaNacimiento"));
				System.out.print("\n");
				System.out.format("%s, %s, %s, %s, %s, %s", getCliente_id(),getNombre(),getApellido(), getDni(),getDireccion(),getFechaNacimiento());
			}
		}catch (SQLException e) { e.printStackTrace(); System.out.println("ERROR."); }
		System.out.print("\n");
	}
	
	public void SelectVendedor(){
		setScript("SELECT * from vendedores");
		try {
			super.st=conectado.createStatement();
			super.rs=st.executeQuery(getScript());
			
			while(rs.next()) {
				setCliente_id(rs.getInt("id_vendedor"));
				setNombre(rs.getString("nombre"));
				setApellido(rs.getString("apellido"));
				setDni(rs.getInt("dni"));
				setDireccion(rs.getString("direccion"));
				setFechaNacimiento(rs.getDate("fechaNacimiento"));
				System.out.print("\n");
				System.out.format("%s, %s, %s, %s, %s, %s", getCliente_id(),getNombre(),getApellido(), getDni(),getDireccion(),getFechaNacimiento());
			}
		}catch (SQLException e) { e.printStackTrace(); System.out.println("ERROR."); }
	}	
	
	public void SelectProducto(){
		setScript("SELECT * from productos");
		try {
			super.st=conectado.createStatement();
			super.rs=st.executeQuery(getScript());
			
			while(rs.next()) {
				setProducto_id(rs.getInt("id_producto"));
				setPrecioUnitario(rs.getDouble("precioUnitario"));
				setCantidadProd(rs.getInt("cantidad"));
				setStockMin(rs.getInt("stockMin"));
				System.out.print("\n");
				System.out.format("%s, %s, %s, %s", getProducto_id(),getPrecioUnitario(),getCantidadProd(), getStockMin());
			}
		}catch (SQLException e) { e.printStackTrace(); System.out.println("ERROR."); }
	}
	public void SelectVenta(){
		setScript("SELECT * from ventas");
		try {
			super.st=conectado.createStatement();
			super.rs=st.executeQuery(getScript());
			
			while(rs.next()) {
				setVenta_id(rs.getInt("id_venta"));
				setVendedor_id(rs.getInt("vendedor_id"));
				setCliente_id(rs.getInt("cliente_id"));
				setProducto_id(rs.getInt("producto_id"));
				setCantidadVendida(rs.getInt("cantidad_vendida"));
				setTotal(rs.getDouble("total"));
				System.out.print("\n");
				System.out.format("%s, %s, %s, %s, %s, %s", getVenta_id(),getVendedor_id(),getCliente_id(), getProducto_id(), getCantidadVendida(), getTotal());
			}
		}catch (SQLException e) { e.printStackTrace(); System.out.println("ERROR."); }
	}
	public void SelectClienteConA(){
		setScript("SELECT * from clientes where nombre like '%a%'");
		try {
			super.st=conectado.createStatement();
			super.rs=st.executeQuery(getScript());
			
			while(rs.next()) {
				setCliente_id(rs.getInt("cliente_id"));
				setNombre(rs.getString("nombre"));
				setApellido(rs.getString("apellido"));
				setDni(rs.getInt("dni"));
				setDireccion(rs.getString("direccion"));
				setFechaNacimiento(rs.getDate("fechaNacimiento"));
				System.out.print("\n");
				System.out.format("%s, %s, %s, %s, %s, %s", getCliente_id(),getNombre(),getApellido(), getDni(),getDireccion(),getFechaNacimiento());
			}
		}catch (SQLException e) { e.printStackTrace(); System.out.println("ERROR."); }
		System.out.print("\n");
	}
	
	public void SelectProductoVendidos(){
		setScript("SELECT productos.* from productos inner join ventas on productos.id_producto=ventas.producto_id where productos.id_producto=ventas.producto_id");
		try {
			super.st=conectado.createStatement();
			super.rs=st.executeQuery(getScript());
			
			while(rs.next()) {
				setProducto_id(rs.getInt("id_producto"));
				setPrecioUnitario(rs.getDouble("precioUnitario"));
				setCantidadProd(rs.getInt("cantidad"));
				setStockMin(rs.getInt("stockMin"));
				System.out.print("\n");
				System.out.format("%s, %s, %s, %s", getProducto_id(),getPrecioUnitario(),getCantidadProd(), getStockMin());
			}
		}catch (SQLException e) { e.printStackTrace(); System.out.println("ERROR."); }
	}
	public void SelectVentasPorVendedor(){
		setScript("SELECT vendedores.* from ventas inner join vendedores on ventas.vendedor_id=vendedores.id_vendedor where ventas.vendedor_id=vendedores.id_vendedor");
		try {
			super.st=conectado.createStatement();
			super.rs=st.executeQuery(getScript());
			
			while(rs.next()) {
				setCliente_id(rs.getInt("id_vendedor"));
				setNombre(rs.getString("nombre"));
				setApellido(rs.getString("apellido"));
				setDni(rs.getInt("dni"));
				setDireccion(rs.getString("direccion"));
				setFechaNacimiento(rs.getDate("fechaNacimiento"));
				System.out.print("\n");
				System.out.format("%s, %s, %s, %s, %s, %s", getCliente_id(),getNombre(),getApellido(), getDni(),getDireccion(),getFechaNacimiento());
			}
		}catch (SQLException e) { e.printStackTrace(); System.out.println("ERROR."); }
	}
	public void SelectVentaFecha(){
		setScript("SELECT ventas.*,factura.fecha from ventas inner join factura on factura.venta_id=ventas.id_venta where factura.fecha='"+getFechaFactura()+"'");
		try {
			super.st=conectado.createStatement();
			super.rs=st.executeQuery(getScript());
			while(rs.next()) {
				setVenta_id(rs.getInt("id_venta"));
				setVendedor_id(rs.getInt("vendedor_id"));
				setCliente_id(rs.getInt("cliente_id"));
				setProducto_id(rs.getInt("producto_id"));
				setCantidadVendida(rs.getInt("cantidad_vendida"));
				setTotal(rs.getDouble("total"));
				setFechaFactura(rs.getDate("fecha"));
				System.out.print("\n");
				System.out.format("%s, %s, %s, %s, %s, %s, %s", getVenta_id(),getVendedor_id(),getCliente_id(), getProducto_id(), getCantidadVendida(), getTotal(), getFechaFactura());
			}
		}catch (SQLException e) { e.printStackTrace(); System.out.println("ERROR."); }
	}
}
