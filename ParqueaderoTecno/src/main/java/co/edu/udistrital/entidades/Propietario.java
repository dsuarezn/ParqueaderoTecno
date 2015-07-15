package co.edu.udistrital.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the propietario database table.
 * 
 */
@Entity
@Table(name="propietario")
@NamedQueries({
		@NamedQuery(name="Propietario.findAll", query="SELECT p FROM Propietario p"),
		@NamedQuery(name="Propietario.findByCC", query="SELECT p FROM Propietario p WHERE p.cedula = :cedula")
})

public class Propietario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, precision=10)
	private Long cedula;

	@Column(nullable=false, length=45)
	private String apellido;

	private Boolean estado;

	@Column(length=200)
	private String foto;

	@Column(nullable=false, length=45)
	private String nombre;

	@Column(length=15)
	private String telFijo;

	@Column(length=15)
	private String telMovil;

	@Column(length=20)
	private String tipoPropietario;

	//bi-directional many-to-one association to Ingreso
	@OneToMany(mappedBy="propietario")
	private List<Ingreso> ingresos;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="propietario")
	private List<Vehiculo> vehiculos;

	public Propietario() {
		
	}
	
	public Propietario(Long cedula, String apellido, boolean estado, String foto, String nombre, String telFijo, String telMovil, String tipoPropietario) {
		super();
		this.cedula = cedula;
		this.apellido = apellido;
		this.estado = estado;
		this.foto = foto;
		this.nombre = nombre;
		this.telFijo = telFijo;
		this.telMovil = telMovil;
		this.tipoPropietario = tipoPropietario;
	}

	public Long getCedula() {
		return this.cedula;
	}

	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelFijo() {
		return this.telFijo;
	}

	public void setTelFijo(String telFijo) {
		this.telFijo = telFijo;
	}

	public String getTelMovil() {
		return this.telMovil;
	}

	public void setTelMovil(String telMovil) {
		this.telMovil = telMovil;
	}

	public String getTipoPropietario() {
		return this.tipoPropietario;
	}

	public void setTipoPropietario(String tipoPropietario) {
		this.tipoPropietario = tipoPropietario;
	}

	public List<Ingreso> getIngresos() {
		return this.ingresos;
	}

	public void setIngresos(List<Ingreso> ingresos) {
		this.ingresos = ingresos;
	}

	public Ingreso addIngreso(Ingreso ingreso) {
		getIngresos().add(ingreso);
		ingreso.setPropietario(this);

		return ingreso;
	}

	public Ingreso removeIngreso(Ingreso ingreso) {
		getIngresos().remove(ingreso);
		ingreso.setPropietario(null);

		return ingreso;
	}

	public List<Vehiculo> getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Vehiculo addVehiculo(Vehiculo vehiculo) {
		getVehiculos().add(vehiculo);
		vehiculo.setPropietario(this);

		return vehiculo;
	}

	public Vehiculo removeVehiculo(Vehiculo vehiculo) {
		getVehiculos().remove(vehiculo);
		vehiculo.setPropietario(null);

		return vehiculo;
	}

}