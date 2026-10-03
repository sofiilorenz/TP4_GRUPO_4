package dominio;

public class Seguro {
	private int idSeguro;
	private String descripcion;
	private int idTipo;
	private int costoContratacion;
	private int costoAsegurado;
	private String descripcionTipo;

	public Seguro() {

	}

	public Seguro(int idSeguro, String descripcion, int idTipo, int costoContratacion, int costoAsegurado) {
		this.idSeguro=idSeguro;
		this.descripcion=descripcion;
		this.idTipo=idTipo;
		this.costoContratacion=costoContratacion;
		this.costoAsegurado=costoAsegurado;
	}

	public int getIdSeguro() {
		return idSeguro;
	}

	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public int getCostoContratacion() {
		return costoContratacion;
	}
	
	public String getDescripcionTipo() {
		return descripcionTipo;
	}

	public void setCostoContratacion(int costoContratacion) {
		this.costoContratacion = costoContratacion;
	}
	
	public void setDescripcionTipo(String descripcionTipo) {
		this.descripcionTipo = descripcionTipo;
	}

	public int getCostoAsegurado() {
		return costoAsegurado;
	}

	public void setCostoAsegurado(int costoAsegurado) {
		this.costoAsegurado = costoAsegurado;
	}

	@Override
	public String toString() {
		return "Seguro [idSeguro=" + idSeguro + ", descripcion=" + descripcion + ", idTipo=" + idTipo
				+ ", costoContratacion=" + costoContratacion + ", costoAsegurado=" + costoAsegurado + "]";
	}
	
}
