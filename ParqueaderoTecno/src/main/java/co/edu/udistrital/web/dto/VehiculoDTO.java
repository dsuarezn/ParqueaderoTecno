package co.edu.udistrital.web.dto;


public class VehiculoDTO {
	
	private String placa;
	
	private String marca;
	
	private String linea;
	
	private Long cedula;
	
	private String nombre;
	
	private String apellido;
	
	private String nombreCompletoPropietario;

	public String getNombreCompletoPropietario() {
		return nombreCompletoPropietario;
	}

	public void setNombreCompletoPropietario(String nombreCompletoPropietario) {
		this.nombreCompletoPropietario = nombreCompletoPropietario;
	}

	private String tipovehiculo;
		
	private boolean esCrear;
	

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

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public Long getCedula() {
		return cedula;
	}

	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}

	public String getTipovehiculo() {
		return tipovehiculo;
	}

	public void setTipovehiculo(String tipovehiculo) {
		this.tipovehiculo = tipovehiculo;
	}

	public boolean getEsCrear() {
		return esCrear;
	}

	public void setEsCrear(boolean esCrear) {
		this.esCrear = esCrear;
	}

	@Override
	public String toString() {
		return "VehiculoDTO [placa=" + placa + ", marca=" + marca
				+ ", linea=" + linea + ", cedula=" + cedula +" Tipo= " + tipovehiculo
				+ ", esCrear=" + esCrear + "]";
	}

}
