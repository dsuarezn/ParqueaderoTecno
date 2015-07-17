package co.edu.udistrital.entidades;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;


/**
 * The persistent class for the vehiculos database table.
 * 
 */
@Entity
@Table(name="vehiculos")
@NamedQueries({
	@NamedQuery(name="Vehiculo.findAll", query="SELECT v FROM Vehiculo v"),
	@NamedQuery(name="Vehiculo.findByCedula", query="SELECT v FROM Vehiculo v WHERE v.propietario.cedula = :cedula"),
	@NamedQuery(name="Vehiculo.findByPlaca", query="SELECT v FROM Vehiculo v WHERE v.placa = :placa")
})
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, length=10)
	private String placa;

	@Column(nullable=false, length=45)
	private String linea;

	@Column(nullable=false, length=45)
	private String marca;

	@Column(nullable=false, length=20)
	private String tipovehiculo;
	
	//bi-directional many-to-one association to Ingreso
	@OneToMany(mappedBy="vehiculo")
	private List<Ingreso> ingresos;

	//bi-directional many-to-one association to Propietario
	@ManyToOne(fetch=FetchType.LAZY)	
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="cedula", nullable=false)
	private Propietario propietario;

	public Vehiculo() {
	}

	public Vehiculo(String placa, String marca, String linea,Propietario propietario,String tipoVehiculo) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.linea = linea;
		this.propietario = propietario;
		this.tipovehiculo = tipoVehiculo;
	}
	
	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getLinea() {
		return this.linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public List<Ingreso> getIngresos() {
		return this.ingresos;
	}

	public void setIngresos(List<Ingreso> ingresos) {
		this.ingresos = ingresos;
	}

	public Ingreso addIngreso(Ingreso ingreso) {
		getIngresos().add(ingreso);
		ingreso.setVehiculo(this);

		return ingreso;
	}

	public Ingreso removeIngreso(Ingreso ingreso) {
		getIngresos().remove(ingreso);
		ingreso.setVehiculo(null);

		return ingreso;
	}

	public Propietario getPropietario() {
		return this.propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}



	public String getTipovehiculo() {
		return tipovehiculo;
	}

	public void setTipovehiculo(String tipovehiculo) {
		this.tipovehiculo = tipovehiculo;
	}
	
	

}