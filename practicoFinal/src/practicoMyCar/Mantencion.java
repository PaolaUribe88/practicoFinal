package practicoMyCar;

public class Mantencion {

	private String mantencionRealizada;
	private String observaciones;
	private int montoServicio;
	
	private Vehiculo vehiculo;
	
	public Mantencion() {
		
	}
	
	public Mantencion(String mantencionRealizada, String observaciones, int montoServicio, Vehiculo vehiculo) {
		this.mantencionRealizada = mantencionRealizada;
		this.observaciones = observaciones;
		this.montoServicio = montoServicio;
		this.setVehiculo(vehiculo);
	}

	public String getMantencionRealizada() {
		return mantencionRealizada;
	}

	public void setMantencionRealizada(String mantencionRealizada) {
		this.mantencionRealizada = mantencionRealizada;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public int getMontoServicio() {
		return montoServicio;
	}

	public void setMontoServicio(int montoServicio) {
		this.montoServicio = montoServicio;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo= vehiculo;
	}
	
	
	
}