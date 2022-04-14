package practicoMyCar;

import java.util.ArrayList;

public class Cliente {
	
	private String nombres;
	private String apellidos;
	private String rut;
	private String correo;
	private String fono;
	private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
	
	public Cliente() {
		
	}
	
	public Cliente(String nombres, String apellidos, String rut, String correo, String fono) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.rut = rut;
		this.correo = correo;
		this.fono = fono;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFono() {
		return fono;
	}

	public void setFono(String fono) {
		this.fono = fono;
	}

	public ArrayList<Vehiculo> getVehiculo() {
		return vehiculos;
	}

	public void setVehiculo(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	public String vehiculosCliente() {
		// Declara un String autosCliente que ira sumando los autos del cliente
		String vehiculosCliente = "";
		for (Vehiculo vehiculo : this.vehiculos) {
			vehiculosCliente += "| PPU: "+vehiculo.getPpu()+" |\n"
						  + "| Marca: "+vehiculo.getMarca()+" |\n"
						  + "| Modelo: "+vehiculo.getModelo()+" |\n"
						  + "| Año: "+vehiculo.getFecha()+" |\n"
						  + "___________________________\n";
		}
		return vehiculosCliente;
	}
	public void addVehiculo(Vehiculo vehiculo) {
		this.vehiculos.add(vehiculo);
	}
	public class Validaciones {
		//Clase helper clase ayuda
		public static boolean emailValido(String correo) {
			String emailLimpio = correo.strip();
			
			String regexCorreo="^[a-zA-Z0-9_.]+@[a-zA-Z0-9_]+\\.(cl|com|es)$";//EXPRESION REGULAR
			
			
			return emailLimpio.matches(regexCorreo);
		}
	}
}
