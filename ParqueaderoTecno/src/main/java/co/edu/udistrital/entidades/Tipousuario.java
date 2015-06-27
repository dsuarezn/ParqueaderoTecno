package co.edu.udistrital.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipousuario database table.
 * 
 */
@Entity
@Table(name="tipousuario")
@NamedQuery(name="Tipousuario.findAll", query="SELECT t FROM Tipousuario t")
public class Tipousuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer idTipo;

	@Column(nullable=false, length=20)
	private String nombreTipo;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="tipousuario")
	private List<Usuario> usuarios;

	public Tipousuario() {
	}

	public Integer getIdTipo() {
		return this.idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	public String getNombreTipo() {
		return this.nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setTipousuario(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setTipousuario(null);

		return usuario;
	}

}