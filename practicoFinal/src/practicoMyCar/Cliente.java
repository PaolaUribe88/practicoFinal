package practicoMyCar;

public class Cliente {
	private String nombres;
	private String apellidos;
	private String rut;
	private String correo;
	private String fono;
	
	
	public Cliente() {
		super();
	}
	public Cliente(String nombres, String apellidos, String rut, String correo, String fono) {
		super();
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
	
	
}
