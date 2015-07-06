package co.edu.udistrital.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the parqueadero database table.
 * 
 */
@Entity
@Table(name="parqueadero")
@NamedQuery(name="Parqueadero.findAll", query="SELECT p FROM Parqueadero p")
public class Parqueadero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, length=20)
	private String tipoParqueadero;

	@Column(nullable=false)
	private int espacios;

	//bi-directional many-to-one association to Ingreso
	@OneToMany(mappedBy="parqueadero")
	private List<Ingreso> ingresos;

	public Parqueadero() {
	}

	public String getTipoParqueadero() {
		return this.tipoParqueadero;
	}

	public void setTipoParqueadero(String tipoParqueadero) {
		this.tipoParqueadero = tipoParqueadero;
	}

	public int getEspacios() {
		return this.espacios;
	}

	public void setEspacios(int espacios) {
		this.espacios = espacios;
	}

	public List<Ingreso> getIngresos() {
		return this.ingresos;
	}

	public void setIngresos(List<Ingreso> ingresos) {
		this.ingresos = ingresos;
	}

	public Ingreso addIngreso(Ingreso ingreso) {
		getIngresos().add(ingreso);
		ingreso.setParqueadero(this);

		return ingreso;
	}

	public Ingreso removeIngreso(Ingreso ingreso) {
		getIngresos().remove(ingreso);
		ingreso.setParqueadero(null);

		return ingreso;
	}

}