package co.edu.udistrital.web.controladores;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.edu.udistrital.business.services.CustomUserDetailsService;
import co.edu.udistrital.business.services.RoleService;
import co.edu.udistrital.entidades.Role;
import co.edu.udistrital.entidades.User;
import co.edu.udistrital.web.dto.UserWebDTO;


@Controller
@RequestMapping(value="/usuarios")
public class UsuariosController extends CommonController{

	private static final Logger logger = LoggerFactory.getLogger(UsuariosController.class);

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		logger.info("Devolviendo la vista de listar usuarios");
		
		List<User> listauser = customUserDetailsServiceImpl.findAllUsers();
		List<UserWebDTO> listaUserForm=new ArrayList<UserWebDTO>();
		for (User user : listauser) {
			UserWebDTO form = new UserWebDTO();
			form.setUsername(user.getUsername());
			form.setEnable(user.getEnable());
			form.setRolename(user.getRole().getDescripcion());
			listaUserForm.add(form);
		}			
		
		model.addAttribute("listUser", listaUserForm);
		
		return "listarUsuarios";
	}

	@RequestMapping(value = "/crear", method = RequestMethod.GET)
	public String vistaCrear(Model model) {
		logger.info("Devolviendo la vista de crear usuarios");
		UserWebDTO userDTO=new UserWebDTO();
		userDTO.setEsCrear(true);			
		List<Role> listaRoles = roleServiceImpl.buscarTodosRoles();
		model.addAttribute("roleslist",listaRoles);
		model.addAttribute("user",userDTO);		
		return "crearUsuarios";
	}
	
	@RequestMapping(value = "/modificarAction", method = RequestMethod.POST)
	public String modificar(UserWebDTO usuario, Model model) {
		logger.info("Entrando a modificar usuario en modo "+(usuario.getEsCrear()?"Creaci�n":"Modificaci�n"));
		if(usuario.getEsCrear()){
			crearUser(usuario);
			model.addAttribute("exito","Se ha creado el usuario exitosamente");
		}
		else{
			modificarUser(usuario);
			model.addAttribute("exito","Se ha editado el usuario exitosamente");
		}
		return listar(model);
	}
	
	@RequestMapping(value = "/editar/{usuario}", method = RequestMethod.GET)
	public String editarUsuario(@PathVariable String usuario, Model model) {		
		logger.info("Entrando a editar usuario");
		User user=customUserDetailsServiceImpl.buscarUsuarioPorNombre(usuario);
		UserWebDTO usuarioDTO=new UserWebDTO();
		usuarioDTO.setUsername(user.getUsername());
		List<Role> listaRoles = roleServiceImpl.buscarTodosRoles();
		usuarioDTO.setRolename(user.getRole().getNombre());
		usuarioDTO.setEnable(user.getEnable());
		usuarioDTO.setEsCrear(false);
		model.addAttribute("roleslist",listaRoles);
		model.addAttribute("user",usuarioDTO);		
		return "crearUsuarios";
	}
	
	@RequestMapping(value = "/eliminar/{usuario}", method = RequestMethod.GET)
	public String eliminarUsuario(@PathVariable String usuario, Model model) {
		logger.info("Entrando a eliminar usuario");
		User user=customUserDetailsServiceImpl.buscarUsuarioPorNombre(usuario);
		customUserDetailsServiceImpl.borrarUsuario(user);
		model.addAttribute("exito","Se ha eliminado el usuario exitosamente");
		return listar(model);
	}
	
	
	private User crearUser(UserWebDTO usuario){
		return customUserDetailsServiceImpl.crearUsuario(new User(usuario.getUsername(),usuario.getEnable(),usuario.getPassword(),new Role(usuario.getRolename())));
	}
	
	private User modificarUser(UserWebDTO usuario){
		return customUserDetailsServiceImpl.actualizarUsuario(new User(usuario.getUsername(),usuario.getEnable(),usuario.getPassword(),new Role(usuario.getRolename())));
	}
	
}
