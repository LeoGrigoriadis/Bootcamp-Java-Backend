package creado;

public class Obra {
	private String fechaIngreso, nombre, fechaOriginal;
	private int ultimoMantenimiento;
	private boolean estado;
	
	public Obra(String fechaIngreso,String  nombre,String fechaOriginal, int ultimoMantenimiento, boolean estado) {}
	
	public boolean getEstado() {
		return estado;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public String getNombre() {
		return nombre;
	}
	public String getFechaOriginal() {
		return fechaOriginal;
	}
	public int getUltimoMantenimiento() {
		return ultimoMantenimiento;
	}
	
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setFechaOriginal(String fechaOriginal) {
		this.fechaOriginal = fechaOriginal;
	}
	public void setUltimoMantenimiento(int ultimoMantenimiento) {
		this.ultimoMantenimiento = ultimoMantenimiento;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
