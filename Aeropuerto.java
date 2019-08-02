package proyectoAeropuerto;

public class Aeropuerto {

	private String nombre;
	private String ciudad;
	private String pais;
	private Compa�ia listaCompanias[]= new Compa�ia[10];
	private Integer numCompania;

	public Aeropuerto(String nombre, String ciudad, String pais) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pais = pais;
		this.numCompania =0;
	}

	public Aeropuerto(String nombre, String ciudad, String pais, Compa�ia listaCompanias[]) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pais = pais;
		this.listaCompanias=listaCompanias;
		this.numCompania = listaCompanias.length;
	}

	public void insertarCompania(Compa�ia c) {
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

	public Compa�ia[] getListaCompa�ias() {

		return this.listaCompanias;
	}

	public Integer getNumeroCompa�ias() {
		return this.numCompania;
	}

	public Compa�ia getCompa�ia(int i) {
		return this.listaCompanias[i];
	}

	public Compa�ia getCompa�ia(String nombre) {
		Boolean encontrado = false;
		Compa�ia c = null;
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
