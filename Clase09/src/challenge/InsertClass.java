package challenge;
import java.sql.*;
import java.util.Scanner;

public class InsertClass extends Model{
	public InsertClass(Connection conectado) {super(conectado);
		int op=1;
		Scanner teclado = new Scanner(System.in);
		while(op!=0) {
			System.out.println( "\nElija a que tabla quiere agregar un dato: "
				+ "\n 1- Cliente. \n 2- Vendedor. \n 3- Producto. \n 4- Venta. \n 0- Salir.");
			System.out.print("Opcion= ");
			op = teclado.nextInt();
			switch(op) {
			case 1: 
				System.out.println("\nIngrese el nombre: ");
				setNombre(teclado.next());
				System.out.println("Ingrese el apellido: ");
				setApellido(teclado.next());
				System.out.println("Ingrese el DNI: ");
				setDni(teclado.nextInt());
				System.out.println("Ingrese la direccion: ");
				setDireccion(teclado.next());
				System.out.println("Ingrese la fecha de nacimiento: ");
				setFechaNacimiento(teclado.next());
				InsertCliente(); break;
			case 2:
				System.out.println("\nIngrese el nombre: ");
				setNombre(teclado.next());
				System.out.println("Ingrese el apellido: ");
				setApellido(teclado.next());
				System.out.println("Ingrese el DNI: ");
				setDni(teclado.nextInt());
				System.out.println("Ingrese la direccion: ");
				setDireccion(teclado.next());
				System.out.println("Ingrese la fecha de nacimiento: ");
				setFechaNacimiento(teclado.next());
				InsertVendedor(); break;
			case 3:
				System.out.println("\nIngrese el precio por unidad: ");
				setPrecioUnitario(teclado.nextDouble());
				System.out.println("Ingrese la cantidad: ");
				setCantidadProd(teclado.nextInt());
				System.out.println("Ingrese el stock minimo: ");
				setStockMin(teclado.nextInt());
				InsertProductos(); break;
			case 4:
				System.out.println("\nIngrese el id del vendedor: ");
				setVendedor_id(teclado.nextInt());
				System.out.println("Ingrese el id del cliente: ");
				setCliente_id(teclado.nextInt());
				System.out.println("Ingrese el id del producto: ");
				setProducto_id(teclado.nextInt());
				System.out.println("Ingrese la cantidad de unidades: ");
				setCantidadVendida(teclado.nextInt());
				InsertVentas(); break;
			case 0: break;
			default: System.out.print("Esta opción no es válida."); break;
			}
		}
	
	}
	public void InsertCliente() {
		setScript("INSERT INTO clientes values (null, ?, ?, ?, ?, ?)");
		try {
			super.pr=conectado.prepareStatement(getScript());
			pr.setString(1, getNombre());
			pr.setString(2, getApellido());
			pr.setInt(3, getDni());
			pr.setString(4, getDireccion());
			pr.setDate(5, getFechaNacimiento());
			pr.executeUpdate();
		}catch (SQLException e) { e.printStackTrace(); System.out.println("ERROR."); }
	}
	public void InsertVendedor() {
		setScript("INSERT INTO vendedores values (null, ?, ?, ?, ?, ?)");
		try {
			super.pr=conectado.prepareStatement(getScript()); 
			pr.setString(1, getNombre());
			pr.setString(2, getApellido());
			pr.setInt(3, getDni());
			pr.setString(4, getDireccion());
			pr.setDate(5, (Date) getFechaNacimiento());
			pr.executeUpdate();
		}catch (SQLException e) { e.printStackTrace(); System.out.println("ERROR."); }
	}
	public void InsertProductos() {
		setScript("INSERT INTO productos values (null, ?, ?, ?)");
		try {
			super.pr=conectado.prepareStatement(getScript()); 
			pr.setDouble(1, getPrecioUnitario());
			pr.setInt(2, getCantidadProd());
			pr.setInt(3, getStockMin());
			pr.executeUpdate();
		}catch (SQLException e) { e.printStackTrace(); System.out.println("ERROR."); }
	}
	public void InsertVentas() {
		setScript("INSERT INTO ventas values (null, ?, ?, ?, ?, null);");
		try {
			super.pr=conectado.prepareStatement(getScript()); 
			pr.setDouble(1, getVendedor_id());
			pr.setInt(2, getCliente_id());
			pr.setInt(3, getProducto_id());
			pr.setInt(4, getCantidadVendida());
			pr.executeUpdate();
			
			setScript("UPDATE ventas INNER JOIN productos ON ventas.producto_id=productos.id_producto SET ventas.total = ventas.cantidad_vendida*productos.precioUnitario WHERE ventas.producto_id=?;");
			super.pr=conectado.prepareStatement(getScript()); 
			pr.setInt(1, getProducto_id());
			pr.executeUpdate();
			
		}catch (SQLException e) { e.printStackTrace(); System.out.println("ERROR."); }
	}
}