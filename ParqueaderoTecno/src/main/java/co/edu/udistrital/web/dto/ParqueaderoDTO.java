package co.edu.udistrital.web.dto;

import java.util.List;

import co.edu.udistrital.entidades.Ingreso;

public class ParqueaderoDTO {
	
	private String tipoParqueadero;
	private int espacios;
	private Boolean estado;
	private List<Ingreso> ingresos;
	private boolean esCrear;
	
	
	public String getTipoParqueadero() {
		return tipoParqueadero;
	}
	public int getEspacios() {
		return espacios;
	}
	public Boolean getEstado() {
		return estado;
	}
	public List<Ingreso> getIngresos() {
		return ingresos;
	}
	public void setTipoParqueadero(String tipoParqueadero) {
		this.tipoParqueadero = tipoParqueadero;
	}
	public void setEspacios(int espacios) {
		this.espacios = espacios;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public void setIngresos(List<Ingreso> ingresos) {
		this.ingresos = ingresos;
	}

	public boolean getEsCrear() {
		return esCrear;
	}

	public void setEsCrear(boolean esCrear) {
		this.esCrear = esCrear;
	}

}
