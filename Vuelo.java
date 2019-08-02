package proyectoAeropuerto;

public class Vuelo {
	private String identificador;
	private String ciudadOrigen;
	private String ciudadDestino;
	private Double precioVuelo;
	private Integer numMaxPasajeros;
	private Integer numActualPasajeros;
	private Pasajero listaPasajeros[];

	public Vuelo(String identificador, String ciudadOrigen, String ciudadDestino, Double precioVuelo,
			Integer numMaxPasajeros) {
		this.identificador = identificador;
		this.ciudadOrigen = ciudadOrigen;
		this.ciudadDestino = ciudadDestino;
		this.precioVuelo = precioVuelo;
		this.numMaxPasajeros = numMaxPasajeros;
		this.listaPasajeros = new Pasajero[numMaxPasajeros];
		this.numActualPasajeros = 0;
	}
	
	@Override
	public String toString() {
		return "Vuelo [identificador=" + identificador + ", ciudadOrigen=" + ciudadOrigen + ", ciudadDestino="
				+ ciudadDestino + ", precioVuelo=" + precioVuelo + "]";
	}

	public void insertarPasajero(Pasajero pasajero) {
		listaPasajeros[numActualPasajeros] = pasajero;
		numActualPasajeros++;

	}

	public String getIdentificador() {
		return identificador;
	}

	public String getCiudadOrigen() {
		return ciudadOrigen;
	}

	public String getCiudadDestino() {
		return ciudadDestino;
	}

	public Double getPrecioVuelo() {
		return precioVuelo;
	}

	public Integer getNumMaxPasajeros() {
		return numMaxPasajeros;
	}

	public Integer getNumActualPasajeros() {
		return numActualPasajeros;
	}

	public Pasajero getPasajero(int i) {
		return listaPasajeros[i];
	}

	public Pasajero getPasajero(String pasaporte) {
		boolean encontrado = false;
		int i = 0;
		Pasajero pas = null;

		while ((!encontrado) && (i < listaPasajeros.length)) {
			if (pasaporte.equals(listaPasajeros[i].getPasaporte())) {
				encontrado = true;
				pas = listaPasajeros[i];
			}
			i++;
		}
		return pas;
	}
}
