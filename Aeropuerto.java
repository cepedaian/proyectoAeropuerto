package proyectoAeropuerto;

public class Aeropuerto {

	private String nombre;
	private String ciudad;
	private String pais;
	private Compañia listaCompanias[]= new Compañia[10];
	private Integer numCompania;

	public Aeropuerto(String nombre, String ciudad, String pais) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pais = pais;
		this.numCompania =0;
	}

	public Aeropuerto(String nombre, String ciudad, String pais, Compañia listaCompanias[]) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pais = pais;
		this.listaCompanias=listaCompanias;
		this.numCompania = listaCompanias.length;
	}

	public void insertarCompania(Compañia c) {
		this.listaCompanias[numCompania] = c;
		this.numCompania++;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getPais() {
		return pais;
	}

	public Compañia[] getListaCompañias() {

		return this.listaCompanias;
	}

	public Integer getNumeroCompañias() {
		return this.numCompania;
	}

	public Compañia getCompañia(int i) {
		return this.listaCompanias[i];
	}

	public Compañia getCompañia(String nombre) {
		Boolean encontrado = false;
		Compañia c = null;
		int i = 0;

		while ((!encontrado) && (i < this.listaCompanias.length)) {
			if (nombre.equals(this.listaCompanias[i].getNombre())) {
				encontrado = true;
				c = this.listaCompanias[i];
			}else 
				
			i++;
		}
		return c;
	}

}
