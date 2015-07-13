package co.edu.udistrital.web.dto;

import java.util.List;

public class RegistroDTO {
	
	private boolean esIngreso;
	private List<String> listaVehiculos;
	private String vehiculoSeleccionado;
	private String nombresyApellidos;
	private Long cedula;
	
	

	public Long getCedula() {
		return cedula;
	}

	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}

	public String getNombresyApellidos() {
		return nombresyApellidos;
	}

	public void setNombresyApellidos(String nombresyApellidos) {
		this.nombresyApellidos = nombresyApellidos;
	}

	public String getVehiculoSeleccionado() {
		return vehiculoSeleccionado;
	}

	public void setVehiculoSeleccionado(String vehiculoSeleccionado) {
		this.vehiculoSeleccionado = vehiculoSeleccionado;
	}

	public boolean isEsIngreso() {
		return esIngreso;
	}

	public void setEsIngreso(boolean esIngreso) {
		this.esIngreso = esIngreso;
	}

	public List<String> getListaVehiculos() {
		return listaVehiculos;
	}

	public void setListaVehiculos(List<String> listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}
	
	
	

}
