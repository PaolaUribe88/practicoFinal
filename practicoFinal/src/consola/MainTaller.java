package consola;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import practicoMyCar.Vehiculo;
import practicoMyCar.Cliente;
import practicoMyCar.Mantencion;
import practicoMyCar.Validacion;

public class MainTaller {
		//SE FUERZA UNA HERENCIA EN LA CLASE VEHICULO EXTENDS DE FECHA 
	
		//Scanner estatico para uso a lo largo del codigo
		static Scanner scanner = new Scanner(System.in);
		
		// ArrayList de los objetos que utilizaremos
		private static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
		private static ArrayList<Mantencion> mantenciones = new ArrayList<>();
		private static ArrayList<Validacion> validaciones = new ArrayList<>();
		
		// constantes para el menu
		public final static int OPCION_MENU_AGREGAR_CLIENTE = 1;
		public final static int OPCION_MENU_ELIMINAR_CLIENTE = 2;
		public final static int OPCION_MENU_LISTA_MANTENCIONES = 3;
		public final static int OPCION_MENU_RECAUDACIONES = 4;
		public final static int OPCION_MENU_AGREGAR_MANTENCIONES = 5;
		public final static int OPCION_MENU_SALIR = 0;
    
		public static void main(String[] args) {
			//LLAMAMOS AL METODO QUE POSEE TODO EL 
			menu();

	}
		private static void menu() {
			// Declara variable opcion para uso y asignacion en menu
			int opcion;		
			// Encierra el menu en un ciclo while hasta que el usuario presione SALIR
			do {
				System.out.println("\nMENU TALLER MYCAR \n**********************");
				System.out.println("[1.] AGREGAR CLIENTE ");
				System.out.println("[2.] ELIMINAR CLIENTE ");
				System.out.println("[3.] LISTA DE MANTENCIONES ");
				System.out.println("[4.] VENTAS RECAUDADAS");
				System.out.println("[5.] AGREGAR MANTENCION ");
				System.out.println("[0.] SALIR ");
				System.out.println("==================================\n");
				System.out.println("[Seleccione su opción]\n");
					        
				// Toma un int del usuario, si esta entre las opciones, hara lo que corresponda, sino, volvera a pedir.
	     			opcion = scanner.nextInt();
	     			System.out.printf("Ha seleccionado la opcion : %d \n \n",opcion);
	          				
	     	switch(opcion) {
	     			case OPCION_MENU_AGREGAR_CLIENTE:
	     					agregarCliente();
	     					break;
	     			case OPCION_MENU_ELIMINAR_CLIENTE:
	     					eliminarCliente();
	     					break;
	     			case OPCION_MENU_LISTA_MANTENCIONES:
	     					listaMantenciones();
	     					break;
	     			case OPCION_MENU_RECAUDACIONES:
	     					verRecaudacion();
	     					break;
	     			case OPCION_MENU_AGREGAR_MANTENCIONES:
	     					agregarMantencion();
	     					break;
	     			case OPCION_MENU_SALIR:
	     					System.out.println("Saliendo...");
	     					break;
	     			default:
	     					System.out.println("Opcion escogida no valida... Vuelva a intentarlo!");
	     					break;
			}
		}while(opcion!= OPCION_MENU_SALIR);
					
	}
	
		private static void agregarMantencion() {
			
		// MUESTRA AUTOS REGISTRADOS Y SUS DATOS
				System.out.println("AUTOS REGISTRADOS");
				for (Vehiculo vehiculo : vehiculos){
					System.out.println("=======================================");
					System.out.println("PPU AUTO: "+vehiculo.getPpu());
					System.out.println("MARCA AUTO: "+vehiculo.getMarca());
					System.out.println("MODELO AUTO: "+vehiculo.getModelo());
					System.out.println("FABRICACION AUTO: "+vehiculo.getFecha());
					System.out.println("DUEÑO AUTO: "+vehiculo.getPoseedor().getNombres()+" "+vehiculo.getPoseedor().getApellidos());
					System.out.println("=======================================\n");
				}
				
				scanner.nextLine(); // Ataja error 
				
				// Pide la PPU del auto al que se le hizo mantencion
				System.out.println("Escriba PPU del auto al que se ha hecho mantencion");
				String ppuMantencion = scanner.nextLine();
				
				// Declara un Auto como nulo para futura asignacion
				Vehiculo vehiculoMantencion = null;
				
				// BUSCA EL AUTO SEGUN PPU EN ARRAYLIST autos, CUANDO LO ENCUENTRA, LO ASIGNA A VARIABLE ANTES DECLARADA (autoMantencion)
				for(Vehiculo vehiculo : vehiculos) {
					if(ppuMantencion.equalsIgnoreCase(vehiculo.getPpu())) {
						vehiculoMantencion = vehiculo;
					}
				}
				
				// Pide el resto de datos para la creacion de un objeto Mantencion
				System.out.println("Escriba el tipo de mantencion realizado");
				String tipoMantencion = scanner.nextLine();
				
				System.out.println("Escriba observaciones realizadas");
				String observacionesMantencion = scanner.nextLine();
				
				System.out.println("Escriba monto cobrado");
				int montoMantencion = scanner.nextInt(); 
				

				//CREA EL OBJETO MANTENCION Y LO AGREGA A ARRALIST MANTENCIONES
				Mantencion mantencion = new Mantencion(tipoMantencion,observacionesMantencion,montoMantencion,vehiculoMantencion);
				mantenciones.add(mantencion);
				
			}

			//TODO
	
	private static void verRecaudacion() {
		System.out.println("");
		
		}
		
	private static void listaMantenciones() {
	System.out.println("Listado de mantenciones realizadas: \n===================================================");
		
		// Por cada mantencion realizada, muestra los datos en la consola
		for(Mantencion mantencion : mantenciones) {
			System.out.println("PPU AUTO MANTENIDO: "+mantencion.getVehiculo().getPpu());
			System.out.println("DUEÑO DE AUTO MANTENIDO: "+mantencion.getVehiculo().getPoseedor().getNombres()+" "+mantencion.getVehiculo().getPoseedor().getApellidos());
			System.out.println("TIPO MANTENCION: "+mantencion.getMantencionRealizada());
			System.out.println("OBSERVACIONES: "+mantencion.getObservaciones());
			System.out.println("MONTO: "+mantencion.getMontoServicio());
			System.out.println("===================================================\n");
		}		
	}

	//TODO
	private static void eliminarCliente() {
		System.out.println("");
		
	}
	private static void agregarCliente() {
		scanner.nextLine(); //ATAJA ERRORES
		
		//PIDE DATOS CLIENTE
		System.out.println("Ingrese nombres del cliente");
		String nombresCliente = scanner.nextLine();
		
		System.out.println("Ingrese apellidos del cliente");
		String apellidosCliente = scanner.nextLine();
		
		System.out.println("Ingrese RUT del cliente");
		String rutCliente = scanner.nextLine();
		
		System.out.println("Ingrese correo del cliente");
		String correoCliente = scanner.nextLine();

		System.out.println("Ingrese telefono del cliente");
		String fonoCliente = scanner.nextLine();
		
		//CREACION CLIENTE CON DATOS PEDIDOS
		Cliente cliente = new Cliente(nombresCliente,apellidosCliente,rutCliente,correoCliente,fonoCliente);
		
		
		//DATOS AUTO
		// Se repite las veces que sea necesaria, segun la cantidad de autos del cliente
			boolean agregarVehiculos = true;
		
		do {
			System.out.println("Ingrese PATENTE del Vehiculo");
			String ppuAuto = scanner.nextLine();
			
			System.out.println("Ingrese MARCA del Vehiculo");
			String marcaAuto = scanner.nextLine();
			
			System.out.println("Ingrese MODELO del Vehiculo");
			String modeloAuto = scanner.nextLine();
			
			System.out.println("Ingrese AÑO de Fabricacion del Vehiculo");
			int yearAuto = scanner.nextInt();
						
			Vehiculo vehiculo = new Vehiculo(ppuAuto,marcaAuto,modeloAuto,LocalDate.of(yearAuto, 01, 01),cliente);
			vehiculos.add(vehiculo); // AÑADE AL ARRAY PARA USO FUTURO
			
			scanner.nextLine(); // ATAJA ERRORES
			
			System.out.println("¿Desea seguir añadiendo Vehiculos? (si/no)");
			String decision = scanner.nextLine();
			
			if(decision.equalsIgnoreCase("NO")) {
				agregarVehiculos = false;
				break;
			}	
		}while(agregarVehiculos);	
	}
		
	}

