package consola;
/**
 * Esta clase main
 * 
 * @creado en Eclipse
 * @author Jessie Uribe 
 *
 */
import java.lang.reflect.Array;
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
		private static ArrayList<Cliente> clientes = new ArrayList<>();
		// constantes para el menu
		public final static int OPCION_MENU_AGREGAR_CLIENTE = 1;
		public final static int OPCION_MENU_ELIMINAR_CLIENTE = 2;
		public final static int OPCION_MENU_AGREGAR_MANTENCIONES = 3;
		public final static int OPCION_MENU_LISTA_MANTENCIONES = 4;
		public final static int OPCION_MENU_RECAUDACIONES = 5;
		private final static int OPCION_MENU_VER_CLIENTES = 6;
		public final static int OPCION_MENU_SALIR = 0;
    
		public static void main(String[] args) {
			//LLAMAMOS AL METODO QUE POSEE TODO EL EJERCICIO
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
				System.out.println("[3.] AGREGAR MANTENCION ");
				System.out.println("[4.] LISTA DE MANTENCIONES ");
				System.out.println("[5.] VENTAS RECAUDADAS");
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
	     			case OPCION_MENU_VER_CLIENTES:
						verClientes();
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
		private static void verClientes() {
			for (Cliente cliente : clientes) {		
				System.out.printf("NOMBRE CLIENTE: %s %s%n"
								+ "RUT CLIENTE: %s%n"
								+ "FONO CLIENTE: %s%n"
								+ "CORREO CLIENTE: %s%n"
								+ "AUTOS REGISTRADOS: %n%n",
								cliente.getNombres(), cliente.getApellidos(),
								cliente.getRut(),
								cliente.getFono(),
								cliente.getCorreo());
				
				System.out.println(cliente.vehiculosCliente());
			}	
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
				
				// BUSCA EL AUTO SEGUN PPU EN ARRAYLIST vehiculos, CUANDO LO ENCUENTRA, LO ASIGNA A VARIABLE ANTES DECLARADA (vehiculoMantencion)
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
	
	private static void verRecaudacion() {
		// Declara int para recaudaciones y vehiculos mantenidos, aumentaran de valor por cada mantencion exitosa
				int recaudaciones = 0;
				int autosMantenidos = 0;
				
				for(Mantencion mantencion : mantenciones) {
					recaudaciones += mantencion.getMontoServicio();
					autosMantenidos++;
				}
				// Llama al metodo listarMantenciones para mostrar un listado de los autos a los que se les hizo mantencion
				listaMantenciones();
				System.out.printf("Recaudaciones totales: $%d%n "
								+ "Vehiculos mantenidos: %d %n%n",
								recaudaciones,
								vehiculosMantenidos);		
		}
		
	private static void listaMantenciones() {
	System.out.println("Listado de mantenciones realizadas: \n===================================================");
		
		// Por cada mantencion realizada, muestra los datos en la consola
		for(Mantencion mantencion : mantenciones) {
			System.out.println("PPU VEHICULO MANTENIDO: "+mantencion.getVehiculo().getPpu());
			System.out.println("DUEÑO DE AUTO MANTENIDO: "+mantencion.getVehiculo().getPoseedor().getNombres()+" "+mantencion.getVehiculo().getPoseedor().getApellidos());
			System.out.println("TIPO MANTENCION: "+mantencion.getMantencionRealizada());
			System.out.println("OBSERVACIONES: "+mantencion.getObservaciones());
			System.out.println("MONTO: "+mantencion.getMontoServicio());
			System.out.println("===================================================\n");
		}		
	}

	//TODO
	private static void eliminarCliente() {
			scanner.nextLine();
		
		   //Busca al cliente segun rut y si lo encuentra, elimina todos los autos asociados y luego al mismo cliente.
		   //Pero si uno de los autos asociados ya ha pasado por mantencion, no elimina el auto en cuestion por motivos de registro.
		   System.out.println("Escriba el rut del cliente a eliminar: ");
		   String rut = scanner.nextLine();
		
		   for (Cliente cli : clientes) {
			   if(rut.equalsIgnoreCase(cli.getRut())) {
				
				   for (Vehiculo vehiculo : vehiculos) {
					   if(vehiculo.getPoseedor().getRut().equalsIgnoreCase(rut) && vehiculo.isMantenido() == false) {
						System.out.println("Se ha eliminado el vehiculo (PPU): "+vehiculo.getPpu());
						vehiculos.remove(vehiculo);
					   }
				   }
				
				   System.out.printf("Se ha eliminado el cliente: %s %n%n", cli.getNombres());
				   clientes.remove(cli);
				   break;
			}
		}		
	}
	private static void agregarCliente() {
		scanner.nextLine(); //ATAJA ERRORES
		
		//PIDE DATOS CLIENTE
		System.out.println("Ingrese RUT del cliente");
		String rutCliente = scanner.nextLine();
		//Busca al cliente con el rut proporcionado, si este existe en los registros, se salta el resto del metodo y pasa directo a añadir vehiculos.
				for(Cliente cli : clientes) {
					if (cli.getRut().equalsIgnoreCase(rutCliente)) {
						agregarVehiculos(cli);	
						break;
					}
				}
				System.out.println("Cliente no registrado. Ingrese datos del nuevo cliente.\n");
				
				System.out.println("Ingrese nombres del cliente");
				String nombresCliente = scanner.nextLine();
				
				System.out.println("Ingrese apellidos del cliente");
				String apellidosCliente = scanner.nextLine();
					
				System.out.println("Ingrese correo del cliente");
				String correoCliente = scanner.nextLine();

				System.out.println("Ingrese telefono del cliente");
				String fonoCliente = scanner.nextLine();
		
		//CREACION CLIENTE CON DATOS PEDIDOS
		Cliente cliente = new Cliente(nombresCliente,apellidosCliente,rutCliente,correoCliente,fonoCliente);
		clientes.add(cliente);
		agregarVehiculos(cliente);
	}
		
		// Se repite las veces que sea necesaria, segun la cantidad de autos del cliente
			
	private static void agregarVehiculos(Cliente cliente) {
		//DATOS VEHICULO
				// Se repite las veces que sea necesaria, segun la cantidad de autos del cliente
				boolean agregarVehiculos = true;
				try {
				do {
					System.out.println("Ingrese PPU del vehiculo");
					String ppuVehiculo = scanner.nextLine().toUpperCase();
					
					System.out.println("Ingrese marca del vehiculo");
					String marcaVehiculo = scanner.nextLine();
					
					System.out.println("Ingrese modelo del vehiculo");
					String modeloVehiculo = scanner.nextLine();
					
					System.out.println("Ingrese año de fabricacion del vehiculo");
					int yearVehiculo = scanner.nextInt();
					if (yearVehiculo < 1960 || String.valueOf(yearVehiculo).length() > 4) {
						throw new Exception("PARAMETROS INVALIDOS. INTENTE DE NUEVO");
					}
								
					// Crea el objeto Vehiculo con los datos proporcionados.
					Vehiculo vehiculo = new Vehiculo(ppuVehiculo,marcaVehiculo,modeloVehiculo,LocalDate.of(yearVehiculo, 01, 01),agregarVehiculos, cliente);
					vehiculos.add(vehiculo); // AÑADE AL ARRAY PARA USO FUTURO
					cliente.addVehiculo(vehiculo); // AÑADE EL VEHICULO REGISTRADO AL CLIENTE
					
					scanner.nextLine(); // ATAJA ERRORES
					
					System.out.println("¿Desea seguir añadiendo vehiculos? (si/no)");
					String decision = scanner.nextLine();
					
					if(decision.equalsIgnoreCase("NO")) {
						agregarVehiculos = false;
						break;
					}	
				}while(agregarVehiculos);
				}catch(Exception e) {
					System.out.println("Parametros invalidos. Intente de nuevo");
				}
		}
	}

