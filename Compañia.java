package proyectoAeropuerto;

public class Compañia {
	private String nombre;
	private Vuelo listaVuelos[] = new Vuelo[10];
	private Integer numeroVuelos = 0;

	public Compañia(String nombre, Vuelo[] listaVuelos) {
		this.nombre = nombre;
		this.listaVuelos = listaVuelos;
		this.numeroVuelos = listaVuelos.length;
	}

	public Compañia(String nombre) {
		this.nombre = nombre;
	}

	public void insertarVuelo(Vuelo vuelo) {
		this.listaVuelos[numeroVuelos] = vuelo;
		this.numeroVuelos++;
	}

	public Vuelo[] getListaVuelos() {
		return this.listaVuelos;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getNumeroVuelos() {
		return numeroVuelos;
	}

	public Vuelo getVuelo(int i) {
		return this.listaVuelos[i];
	}

	public Vuelo getVuelo(String id) {
		Boolean encontrado = false;
		Vuelo vuel = null;
		int i = 0;
		while ((encontrado == false) && (i < this.listaVuelos.length)) {

			if (id.equals(this.listaVuelos[i].getIdentificador())) {
				vuel = this.listaVuelos[i];
				encontrado = true;
			}
			i++;
		}

		return vuel;
	}

}
