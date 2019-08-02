package proyectoAeropuerto;

public class AeropuertoPublico extends Aeropuerto {

	private Double subvencion;

	public AeropuertoPublico(String nombre, String ciudad, String pais, Compañia[] listaCompanias, Double subvencion) {
		super(nombre, ciudad, pais, listaCompanias);
		this.subvencion = subvencion;
	}

	public AeropuertoPublico(String nombre, String ciudad, String pais) {
		super(nombre, ciudad, pais);

	}

	public AeropuertoPublico(String nombre, String ciudad, String pais, Double subvencion) {
		super(nombre, ciudad, pais);
		this.subvencion = subvencion;
	}

	public Double getSubvencion() {
		return this.subvencion;
	}
}
