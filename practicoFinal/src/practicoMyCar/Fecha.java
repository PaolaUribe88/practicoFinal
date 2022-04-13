package practicoMyCar;

import java.time.LocalDate;

public class Fecha {
	protected LocalDate fecha;

	public Fecha() {
		super();
	}

	public Fecha(LocalDate fecha) {
		super();
		this.fecha = fecha;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	

}
