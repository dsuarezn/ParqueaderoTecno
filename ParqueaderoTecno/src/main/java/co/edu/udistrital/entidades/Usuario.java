package co.edu.udistrital.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, precision=10)
	private Long cedula;

	@Column(nullable=false, length=45)
	private String apellido;

	@Column(length=200)
	private String foto;

	@Column(nullable=false, length=45)
	private String nombre;

	@Column(length=15)
	private String telFijo;

	@Column(length=15)
	private String telMovil;

	//bi-directional many-to-one association to Ingreso
	@OneToMany(mappedBy="usuario")
	private List<Ingreso> ingresos;

	//bi-directional many-to-one association to Tipousuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idTipo", nullable=false)
	private Tipousuario tipousuario;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="usuario")
	private List<Vehiculo> vehiculos;

	public Usuario() {
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

	public List<Ingreso> getIngresos() {
		return this.ingresos;
	}

	public void setIngresos(List<Ingreso> ingresos) {
		this.ingresos = ingresos;
	}

	public Ingreso addIngreso(Ingreso ingreso) {
		getIngresos().add(ingreso);
		ingreso.setUsuario(this);

		return ingreso;
	}

	public Ingreso removeIngreso(Ingreso ingreso) {
		getIngresos().remove(ingreso);
		ingreso.setUsuario(null);

		return ingreso;
	}

	public Tipousuario getTipousuario() {
		return this.tipousuario;
	}

	public void setTipousuario(Tipousuario tipousuario) {
		this.tipousuario = tipousuario;
	}

	public List<Vehiculo> getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Vehiculo addVehiculo(Vehiculo vehiculo) {
		getVehiculos().add(vehiculo);
		vehiculo.setUsuario(this);

		return vehiculo;
	}

	public Vehiculo removeVehiculo(Vehiculo vehiculo) {
		getVehiculos().remove(vehiculo);
		vehiculo.setUsuario(null);

		return vehiculo;
	}

}