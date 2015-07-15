package co.edu.udistrital.web.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RegistroDTO {
	
	private String esIngreso;
	private List<String> listaVehiculos;
	private String vehiculoSeleccionado;
	private String nombresyApellidos;
	private String observacion;
	private Long cedula;
	private String placa;
	private String campoEnviado;
	private Boolean estado;
	
	private Date fechaIngreso;
	private Date fechaSalida;
	
	private String fechaStrIngreso;	
	private String tipoParqueo;
	
	
	
	public String getTipoParqueo() {
		return tipoParqueo;
	}

	public void setTipoParqueo(String tipoParqueo) {
		this.tipoParqueo = tipoParqueo;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getFechaStrIngreso() {
		return fechaStrIngreso;
	}

	public void setFechaStrIngreso(String fechaStrIngreso) {
		this.fechaStrIngreso = fechaStrIngreso;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
		
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getEsIngreso() {
		return esIngreso;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Long getCedula() {
		return cedula;
	}

	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCampoEnviado() {
		return campoEnviado;
	}

	public void setCampoEnviado(String campoEnviado) {
		this.campoEnviado = campoEnviado;
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

	public String isEsIngreso() {
		return esIngreso;
	}

	public void setEsIngreso(String esIngreso) {
		this.esIngreso = esIngreso;
	}

	public List<String> getListaVehiculos() {
		return listaVehiculos;
	}

	public void setListaVehiculos(List<String> listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}

	@Override
	public String toString() {
		return "RegistroDTO [esIngreso=" + esIngreso + ", listaVehiculos="
				+ listaVehiculos + ", vehiculoSeleccionado="
				+ vehiculoSeleccionado + ", nombresyApellidos="
				+ nombresyApellidos + ", observacion=" + observacion
				+ ", cedula=" + cedula + ", placa=" + placa + ", campoEnviado="
				+ campoEnviado + "]";
	}
	
	
	

}
