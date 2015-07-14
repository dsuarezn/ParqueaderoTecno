package co.edu.udistrital.web.dto;


public class PropietarioDTO {
	
	private Long cedula;
	
	private String nombre;
	
	private String apellido;
	
	private String telFijo;
	
	private String telMovil;
	
	private String foto;

	private boolean estado;
	
	private String tipoPropietario;
	
	private boolean esCrear;
	
	public Long getCedula() {
		return cedula;
	}

	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getTelFijo() {
		return telFijo;
	}

	public void setTelFijo(String telFijo) {
		this.telFijo = telFijo;
	}
	
	public String getTelMovil() {
		return telMovil;
	}

	public void setTelMovil(String telMovil) {
		this.telMovil = telMovil;
	}
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getTipoPropietario() {
		return tipoPropietario;
	}

	public void setTipoPropietario(String tipoPropietario) {
		this.tipoPropietario = tipoPropietario;
	}

	public boolean getEsCrear() {
		return esCrear;
	}

	public void setEsCrear(boolean esCrear) {
		this.esCrear = esCrear;
	}

	@Override
	public String toString() {
		return "PropietarioDTO [cedula=" + cedula + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", telFijo=" + telFijo
				+ ", telMovil=" + telMovil + ", foto=" + foto
				+ ", estado=" + estado + ", tipoPropietario=" + tipoPropietario
				+ ", esCrear=" + esCrear + "]";
	}

}
