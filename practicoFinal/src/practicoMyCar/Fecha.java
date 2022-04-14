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
	
	private static void validacionFechas() {
		// Contexto fecha ingresada por el usuario;
		//suponemos que ud limpio un String y lo convirtio a int
		int year = 2022;
		int mes = 2;
		int dia = 29;
		System.out.println("Procesando Fecha...");
		try {
		LocalDate.of(year, mes, dia); 
		//procesamiento de la fecha
		
		}catch(Exception e) {
			System.out.println("Fecha Invalida!!!");
		}
	}
}
