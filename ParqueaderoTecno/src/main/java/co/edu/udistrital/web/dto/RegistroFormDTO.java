package co.edu.udistrital.web.dto;


public class RegistroFormDTO {
	
	private String placa;
	
	private String cedula;
	
	private Boolean estado;
	
	private String fechaInicio;
	
	private String fechaFin;
	
//	private Date fechaInicio;
//	
//	private Date fechaFin;

	
	
	public String getPlaca() {
		return placa;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}



	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

//	public Date getFechaInicio() {
//		return fechaInicio;
//	}
//
//	public void setFechaInicio(Date fechaInicio) {
//		this.fechaInicio = fechaInicio;
//	}
//
//	public Date getFechaFin() {
//		return fechaFin;
//	}
//
//	public void setFechaFin(Date fechaFin) {
//		this.fechaFin = fechaFin;
//	}
	
	

}
