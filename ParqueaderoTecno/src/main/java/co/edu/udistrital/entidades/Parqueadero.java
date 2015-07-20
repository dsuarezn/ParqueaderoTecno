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
@NamedQueries({
	@NamedQuery(name="Parqueadero.findAll", query="SELECT p FROM Parqueadero p"),
	@NamedQuery(name="Parqueadero.findByTipo", query="SELECT u FROM Parqueadero u WHERE u.tipoParqueadero = :tipo")
})
public class Parqueadero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, length=20)
	private String tipoParqueadero;

	@Column(nullable=false)
	private Integer espacios;

	//bi-directional many-to-one association to Ingreso
	@OneToMany(mappedBy="parqueadero")
	private List<Ingreso> ingresos;

	private Boolean estado;

	public Parqueadero() {
	}
	
	public Parqueadero(String tipo, Integer espacios) {
		this.tipoParqueadero=tipo;
		this.espacios=espacios;
	}

	
	
	public Parqueadero(String tipoParqueadero, int espacios,
			List<Ingreso> ingresos, Boolean estado) {
		super();
		this.tipoParqueadero = tipoParqueadero;
		this.espacios = espacios;
		this.ingresos = ingresos;
		this.estado = estado;
	}



	public String getTipoParqueadero() {
		return this.tipoParqueadero;
	}

	public void setTipoParqueadero(String tipoParqueadero) {
		this.tipoParqueadero = tipoParqueadero;
	}

	public Integer getEspacios() {
		return this.espacios;
	}

	public void setEspacios(Integer espacios) {
		this.espacios = espacios;
	}

	public List<Ingreso> getIngresos() {
		return this.ingresos;
	}

	public void setIngresos(List<Ingreso> ingresos) {
		this.ingresos = ingresos;
	}

	public Boolean getEstado() {
		return estado;
	}
	
	public void setEstado(Boolean estado) {
		this.estado = estado;
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
