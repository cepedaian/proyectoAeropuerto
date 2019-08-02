package proyectoAeropuerto;

import java.util.Scanner;

public class Principal {
	static Scanner entrada = new Scanner(System.in);
	final static int numAeropuertos = 3;
	static Aeropuerto aeropuertos[] = new Aeropuerto[numAeropuertos];

	public static void main(String[] args) throws Exception {
		// insertando datos aeropuerto
		insertarDatosAeropuerto(aeropuertos);
		menu();

	}

	public static void insertarDatosAeropuerto(Aeropuerto aero[]) {
		aero[0] = new AeropuertoPublico("Jorge Chavez", "Lima", "Peru", 80000.0);
		aero[0].insertarCompania(new Compañia("AeroPeru"));
		aero[0].insertarCompania(new Compañia("Latam"));
		aero[0].getCompañia("AeroPeru").insertarVuelo(new Vuelo("IB20", "Lima", "Mexico", 150.90, 150));
		aero[0].getCompañia("Latam").insertarVuelo(new Vuelo("IC25", "Lima", "Buenos Aires", 180.50, 125));
		aero[0].getCompañia("AeroPeru").getVuelo("IB20").insertarPasajero(new Pasajero("Ian", "38072453", "Argentino"));
		aero[0].getCompañia("Latam").getVuelo("IC25").insertarPasajero(new Pasajero("Pedro", "3965453", "Uruguayo"));

		aero[1] = new AeropuertoPrivado("Aeropuerto Mendoza", "Mendoza", "Argentina");
		String empresas[] = { "Petrobras", "YPF" };
		((AeropuertoPrivado) aero[1]).insertarEmpresas(empresas);
		aero[1].insertarCompania(new Compañia("Turkish Airlines"));
		aero[1].insertarCompania(new Compañia("Latam"));
		aero[1].getCompañia("Turkish Airlines").insertarVuelo(new Vuelo("IJ52", "Lima", "Mexico", 120.80, 145));
		aero[1].getCompañia("Latam").insertarVuelo(new Vuelo("CG75", "Berazategui", "Congo", 1000.50, 50));
		aero[1].getCompañia("Turkish Airlines").getVuelo("IJ52")
				.insertarPasajero(new Pasajero("Pablo", "3889553", "Cordobes"));
		aero[1].getCompañia("Latam").getVuelo("CG75")
				.insertarPasajero(new Pasajero("Ricardo", "32234453", "Senegales"));

		aero[2] = new AeropuertoPublico("Ezeiza", "Buenos Aires", "Argentina", 10000.0);
		aero[2].insertarCompania(new Compañia("Aerolineas Argentinas"));
		aero[2].insertarCompania(new Compañia("Turkish Airlines"));
		aero[2].getCompañia("Aerolineas Argentinas")
				.insertarVuelo(new Vuelo("ZD85", "Sinaloa", "Vancouver", 198.90, 160));
		aero[2].getCompañia("Turkish Airlines").insertarVuelo(new Vuelo("HI98", "Lima", "Buenos Aires", 180.50, 125));
		aero[2].getCompañia("Aerolineas Argentinas").getVuelo("ZD85")
				.insertarPasajero(new Pasajero("Lucas", "38982453", "Brasilero"));
		aero[2].getCompañia("Turkish Airlines").getVuelo("HI98")
				.insertarPasajero(new Pasajero("Matias", "35658453", "Venezolano"));

	}// filah,new york filah,NY daya;kunsei ;;;

	public static void menu() {
		int opcion = 0;
		String nombreAeropuerto, nombreCompañia, origen, destino;
		Aeropuerto aero;
		Compañia compa;
		Vuelo vuelo;
		Vuelo vuelos[] = new Vuelo[10];

		System.out.println("Bienvenidos al gestionador de Aeropuertos: ");
		do {
			System.out.println();

			System.out.println(" Menu: ");
			System.out.println("1.Consultar los aeropuertos gestionados");
			System.out.println("2.Visualizar empresas patrocinantes o subvencion estatal.");
			System.out.println("3.Visualizar listado de compañias.");
			System.out.println("4.Mostrar vuelos que ofrece una compañia.");
			System.out.println("5.Mostrar vuelos disponibles a ciudad destino.");
			System.out.println("6.Salir");
			System.out.print("Digite la opcion: ");
			opcion = entrada.nextInt();

			switch (opcion) {
			case 1:
				mostrarDatosAeropuertos(aeropuertos);
				break;
			case 2:
				visualizarPatrocinio(aeropuertos);
				break;
			case 3:
				entrada.nextLine();
				System.out.println("Que aeropuerto desea consultar: ");
				nombreAeropuerto = entrada.nextLine();

				aero = buscarAeropuerto(nombreAeropuerto, aeropuertos);

				if (aero == null) {
					System.out.println("Aeropuerto inexistente.");
				} else {
					mostrarListaCompañias(aero);
				}
				break;
			case 4:
				entrada.nextLine();
				System.out.println("Que aeropuerto desea consultar: ");
				nombreAeropuerto = entrada.nextLine();
				aero = buscarAeropuerto(nombreAeropuerto, aeropuertos);
				if (aero == null) {
					System.out.println("El aeropuerto no existe.");
				} else {
					System.out.println("Que compañia desea consultar: ");
					nombreCompañia = entrada.nextLine();
					compa = aero.getCompañia(nombreCompañia);
					if (compa == null) {
						System.out.println("La compañia no existe.");
					} else {
						mostrarVuelos(compa);
					}

				}
				break;
			case 5:
				entrada.nextLine();
				System.out.println("Digite ciudad de origen: ");
				origen = entrada.nextLine();
				System.out.println("Digite la ciudad de destino: ");
				destino = entrada.nextLine();

				vuelos = buscarVuelos(origen, destino, aeropuertos);

				mostrarVuelos(vuelos);
			}

		} while (opcion != 6);
	}

	public static void mostrarDatosAeropuertos(Aeropuerto aero[]) {
		for (int i = 0; i < aero.length; i++) {
			if (aero[i] instanceof AeropuertoPublico) {
				System.out.println("Aeropuerto publico: ");
				System.out.println(aero[i].getNombre());
				System.out.println(aero[i].getCiudad());
				System.out.println(aero[i].getPais());
			} else {
				System.out.println("Aeropuerto Privado: ");
				System.out.println(aero[i].getNombre());
				System.out.println(aero[i].getCiudad());
				System.out.println(aero[i].getPais());
			}
		}
	}

	public static void visualizarPatrocinio(Aeropuerto aero[]) {

		String empresas[];

		for (int i = 0; i < aero.length; i++) {
			if (aero[i] instanceof AeropuertoPrivado) {
				System.out.println("El Aeropuerto Privado " + aero[i].getNombre() + " lo patrocinan las empresas: ");
				empresas = ((AeropuertoPrivado) aero[i]).getEmpresas();

				for (int j = 0; j < empresas.length; j++) {
					System.out.println(empresas[j]);
				}
			} else {
				System.out.println("El aeropuerto publico" + aero[i].getNombre() + "recibe una subvencion de: ");
				System.out.println(((AeropuertoPublico) aero[i]).getSubvencion());
			}
		}

	}

	public static Aeropuerto buscarAeropuerto(String nombreAeropuerto, Aeropuerto lista[]) {
		Boolean encontrado = false;
		Aeropuerto aero = null;
		int i = 0;

		while ((!encontrado) && (i < lista.length)) {
			if (nombreAeropuerto.equals(lista[i].getNombre())) {
				encontrado = true;
				aero = lista[i];
			}
			i++;
		}

		return aero;
	}

	public static void mostrarListaCompañias(Aeropuerto aero) {

		for (int i = 0; i < aero.getNumeroCompañias(); i++) {
			System.out.println(aero.getCompañia(i).getNombre());
		}

	}

	public static void mostrarVuelos(Compañia compa) {
		for (int i = 0; i < compa.getNumeroVuelos(); i++) {
			System.out.println("Vuelo: ");
			System.out.println("Identificador: " + compa.getVuelo(i).getIdentificador());
			System.out.println("Ciudad de origen: " + compa.getVuelo(i).getCiudadOrigen());
			System.out.println("Ciudad destino: " + compa.getVuelo(i).getCiudadDestino());
			System.out.println("Precio: " + compa.getVuelo(i).getPrecioVuelo());
		}

	}

	public static Vuelo[] buscarVuelos(String origen, String destino, Aeropuerto aero[]) {
		Vuelo vuelo = null;
		int contador = 0;

		for (int i = 0; i < aeropuertos.length; i++) {
			for (int j = 0; j < aeropuertos[i].getNumeroCompañias(); j++) {
				for (int k = 0; k < aeropuertos[i].getCompañia(j).getNumeroVuelos(); k++) {
					vuelo = aeropuertos[i].getCompañia(j).getVuelo(k);
					if ((origen.equals(vuelo.getCiudadOrigen()) && (destino.equals(vuelo.getCiudadDestino())))) {
						contador++;
					}
				}

			}
		}

		Vuelo vuelos[] = new Vuelo[contador];
		int q = 0;

		for (int i = 0; i < aeropuertos.length; i++) {
			for (int j = 0; j < aeropuertos[i].getNumeroCompañias(); j++) {
				for (int k = 0; k < aeropuertos[i].getCompañia(j).getNumeroVuelos(); k++) {
					vuelo = aeropuertos[i].getCompañia(j).getVuelo(k);
					if ((origen.equals(vuelo.getCiudadOrigen()) && (destino.equals(vuelo.getCiudadDestino())))) {
						vuelos[q] = vuelo;
						q++;
					}
				}
			}
		}
		return vuelos;
	}

	public static void mostrarVuelos(Vuelo vuelos[]) {
		for (int i = 0; i < vuelos.length; i++) {
			System.out.println(vuelos[i].getIdentificador());
			System.out.println(vuelos[i].getCiudadOrigen());
			System.out.println(vuelos[i].getCiudadDestino());
			System.out.println(vuelos[i].getPrecioVuelo());
		}
	}

}
