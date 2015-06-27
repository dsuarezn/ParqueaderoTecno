package co.edu.udistrital.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ingresos database table.
 * 
 */
@Entity
@Table(name="ingresos")
@NamedQuery(name="Ingreso.findAll", query="SELECT i FROM Ingreso i")
public class Ingreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long idEntrada;

	private Object estado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date fechaEntrada;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaSalida;

	@Column(length=500)
	private String observacion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cedula", nullable=false)
	private Usuario usuario;

	//bi-directional many-to-one association to Vehiculo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="placa", nullable=false)
	private Vehiculo vehiculo;

	//bi-directional many-to-one association to Parqueadero
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tipoParqueadero", nullable=false)
	private Parqueadero parqueadero;

	public Ingreso() {
	}

	public Long getIdEntrada() {
		return this.idEntrada;
	}

	public void setIdEntrada(Long idEntrada) {
		this.idEntrada = idEntrada;
	}

	public Object getEstado() {
		return this.estado;
	}

	public void setEstado(Object estado) {
		this.estado = estado;
	}

	public Date getFechaEntrada() {
		return this.fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Parqueadero getParqueadero() {
		return this.parqueadero;
	}

	public void setParqueadero(Parqueadero parqueadero) {
		this.parqueadero = parqueadero;
	}

}