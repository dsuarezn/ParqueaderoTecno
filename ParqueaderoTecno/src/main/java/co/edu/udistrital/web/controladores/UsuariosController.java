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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.edu.udistrital.business.services.CustomUserDetailsService;
import co.edu.udistrital.business.services.RoleService;
import co.edu.udistrital.entidades.Role;
import co.edu.udistrital.entidades.User;
import co.edu.udistrital.web.dto.UserDTO;


@Controller
@RequestMapping(value="/usuarios")
public class UsuariosController extends CommonController{

	private static final Logger logger = LoggerFactory.getLogger(UsuariosController.class);
	
	@Autowired
	private CustomUserDetailsService customUserDetailsServiceImpl; 
	
	@Autowired
	private RoleService roleServiceImpl;
	
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		logger.info("Devolviendo la vista de listar usuarios");
		
		List<User> listauser = customUserDetailsServiceImpl.findAllUsers();
		List<UserDTO> listaUserForm=new ArrayList<UserDTO>();
		for (User user : listauser) {
			UserDTO form = new UserDTO();
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
		UserDTO userDTO=new UserDTO();
		userDTO.setEsCrear(true);			
		List<Role> listaRoles = roleServiceImpl.buscarTodosRoles();
		model.addAttribute("roleslist",listaRoles);
		model.addAttribute("user",userDTO);		
		return "crearUsuarios";
	}
	
	@RequestMapping(value = "/modificarAction", method = RequestMethod.POST)
	public String modificar(UserDTO usuario, Model model) {
		logger.info("Entrando a modificar usuario en modo "+(usuario.getEsCrear()?"Creaci�n":"Modificaci�n"));
		if(usuario.getEsCrear()){
			crearUser(usuario);
		}
		else{
			modificarUser(usuario);
		}

		return listar(model);
	}
	
	private User crearUser(UserDTO usuario){
		return customUserDetailsServiceImpl.crearUsuario(new User(usuario.getUsername(),usuario.getEnable(),usuario.getPassword(),new Role(usuario.getRolename())));
	}
	
	private User modificarUser(UserDTO usuario){
		return customUserDetailsServiceImpl.actualizarUsuario(new User(usuario.getUsername(),usuario.getEnable(),usuario.getPassword(),new Role(usuario.getRolename())));
	}
	
}
