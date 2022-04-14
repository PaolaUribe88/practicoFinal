package practicoMyCar;

import java.time.LocalDate;

public class Vehiculo extends Fecha {
	private String ppu;
	private String marca;
	private String modelo;
	private LocalDate fecha;
	private boolean mantenido;
	//AUTO SOLO PERTENECE A 1 CLIENTE
	private Cliente poseedor;
	
	public Vehiculo() {
		super();
		
	}

	public Vehiculo(String ppu, String marca, String modelo, LocalDate fecha, boolean mantenido, Cliente poseedor) {
		super();
		this.ppu = ppu;
		this.marca = marca;
		this.modelo = modelo;
		this.fecha = fecha;
		this.poseedor= poseedor;
		this.setMantenido(mantenido);
	}
	
	public String getPpu() {
		return ppu;
	}

	public void setPpu(String ppu) {
		this.ppu = ppu;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Cliente getPoseedor() {
		return poseedor;
	}

	public void setPoseedor(Cliente poseedor) {
		this.poseedor = poseedor;
	}
	
	public boolean isMantenido() {
		return mantenido;
	}

	public void setMantenido(boolean mantenido) {
		this.mantenido = mantenido;
	}
	

}

