package co.edu.udistrital.accesoadatos;

public class DAOFactory {
	
	
	//TODO: evaluar porque se podria o no hacer estaticos los DAOs
	public DAOFactory() {
		super();
		ingresosDAO=new IngresosDAO();
		parqueaderoDAO = new ParqueaderoDAO();
		tipousuarioDAO = new TipoUsuarioDAO(); 
		usuarioDAO= new UsuarioDAO();
		vehiculosDAO = new VehiculosDAO();
	}
	private IngresosDAO ingresosDAO;
	private ParqueaderoDAO parqueaderoDAO;
	private TipoUsuarioDAO tipousuarioDAO;
	private UsuarioDAO usuarioDAO;
	private VehiculosDAO vehiculosDAO;
		
	public IngresosDAO getIngresosDAO() {
		return ingresosDAO;
	}
	public void setIngresosDAO(IngresosDAO ingresosDAO) {
		this.ingresosDAO = ingresosDAO;
	}
	public ParqueaderoDAO getParqueaderoDAO() {
		return parqueaderoDAO;
	}
	public void setParqueaderoDAO(ParqueaderoDAO parqueaderoDAO) {
		this.parqueaderoDAO = parqueaderoDAO;
	}
	public TipoUsuarioDAO getTipousuarioDAO() {
		return tipousuarioDAO;
	}
	public void setTipousuarioDAO(TipoUsuarioDAO tipousuarioDAO) {
		this.tipousuarioDAO = tipousuarioDAO;
	}
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	public VehiculosDAO getVehiculosDAO() {
		return vehiculosDAO;
	}
	public void setVehiculosDAO(VehiculosDAO vehiculosDAO) {
		this.vehiculosDAO = vehiculosDAO;
	}
	
	
	
	
	
}
