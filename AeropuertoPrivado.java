package proyectoAeropuerto;

public class AeropuertoPrivado extends Aeropuerto {

	private String listaEmpresas[] = new String[10];
	private Integer numEmpresa;

	public AeropuertoPrivado(String nombre, String ciudad, String pais) {
		super(nombre, ciudad, pais);
		this.numEmpresa = 0;
	}

	public AeropuertoPrivado(String nombre, String ciudad, String pais, Compañia c[], String e[]) {
		super(nombre, ciudad, pais, c);
		this.listaEmpresas = e;
		this.numEmpresa = e.length;
	}

	public void insertarEmpresas(String e[]) {
		this.listaEmpresas = e;
		this.numEmpresa = e.length;
	}

	public void insertarEmpresa(String empresa) {
		this.listaEmpresas[numEmpresa] = empresa;
		this.numEmpresa++;
	}

	public String[] getEmpresas() {
		return this.listaEmpresas;
	}

	public Integer getNumEmpresa() {
		return this.numEmpresa;
	}

}
