package co.edu.udistrital.web.controladores;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;
import javax.sql.DataSource;

import net.sf.jasperreports.engine.JREmptyDataSource;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import co.edu.udistrital.entidades.Propietario;
import co.edu.udistrital.web.dto.PropietarioDTO;




@Controller
@RequestMapping(value="/propietarios")
public class PropietariosController extends CommonController {

	private static final Logger logger = LoggerFactory.getLogger(PropietariosController.class);	
		
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		logger.info("Devolviendo la vista de listar propietarios");
		List<Propietario> listapropietario = propietarioServiceImpl.findAllPropietarios();
		List<PropietarioDTO> listaPropietarioForm=new ArrayList<PropietarioDTO>();
		for (Propietario propietario : listapropietario) {
			PropietarioDTO form = new PropietarioDTO();
			form.setFoto(propietario.getFoto());
			form.setTipoPropietario(propietario.getTipoPropietario());
			form.setCedula(propietario.getCedula());
			form.setNombre(propietario.getNombre());
			form.setApellido(propietario.getApellido());
			form.setEstado(propietario.getEstado());
			listaPropietarioForm.add(form);
		}			

		model.addAttribute("listPropietario", listaPropietarioForm);
		return "listarPropietarios";
	}

	@RequestMapping(value = "/crear", method = RequestMethod.GET)
	public String vistaCrear(Model model) {
		logger.info("Devolviendo la vista de crear propietarios");
		PropietarioDTO propietarioDTO = new PropietarioDTO();
		propietarioDTO.setEsCrear(true);
		model.addAttribute("propietario",propietarioDTO);		
		return "crearPropietarios";
	}
	
	@RequestMapping(value = "/modificarAction", method = RequestMethod.POST)
	public String modificar(PropietarioDTO propietario, Model model,  @RequestParam("file") MultipartFile file) {
		logger.info("Entrando a modificar propietario en modo "+(propietario.getEsCrear()?"Creación":"Modificación"));
		Propietario resultPropietario = null;
		try {
			resultPropietario = propietarioServiceImpl.buscarPropietarioPorCedula(propietario.getCedula());
		} catch (PersistenceException e) {
			logger.info("Propietario existente");
		}
		
		if(propietario.getEsCrear() && resultPropietario!=null){
			model.addAttribute("error","Actualmente ya existe un propietario con ese número de cédula, por favor inténtelo de nuevo...");
		} else if(!propietario.getEsCrear() && file.isEmpty() && resultPropietario.getFoto() != null){
			propietario.setFoto(resultPropietario.getFoto());
			modificarPropietario(propietario);
			model.addAttribute("exito","Se ha editado el propietario exitosamente");
		} else {
			while (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();
					String rootPath = servletContext.getRealPath("/resources/photos/");
			        File serverFile = new File(rootPath + File.separator + propietario.getCedula() + "." + FilenameUtils.getExtension(file.getOriginalFilename()));
			        propietario.setFoto(serverFile.getName());
			        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			        stream.write(bytes);
			        stream.close();
			        logger.info("Server File Location=" + serverFile.getAbsolutePath());
			    } catch (Exception e) {
			      	logger.info("No se ha podido cargar la foto!");
			    }
				break;
			}					
			if(propietario.getEsCrear()){
				System.out.println("nombrefoto:"+propietario.getFoto());
				crearPropietario(propietario);
				model.addAttribute("exito","Se ha creado el propietario exitosamente");
			} else {
				modificarPropietario(propietario);
				model.addAttribute("exito","Se ha editado el propietario exitosamente");
			}
		}
		return listar(model);
	}
	
	@RequestMapping(value = "/editar/{cedula}", method = RequestMethod.GET)
	public String editarPropietario(@PathVariable long cedula, Model model) {		
		logger.info("Entrando a editar propietario");
		Propietario propietario = propietarioServiceImpl.buscarPropietarioPorCedula(cedula);
		PropietarioDTO propietarioDTO = new PropietarioDTO();		
		propietarioDTO.setCedula(propietario.getCedula());
		propietarioDTO.setNombre(propietario.getNombre());
		propietarioDTO.setApellido(propietario.getApellido());
		propietarioDTO.setTelFijo(propietario.getTelFijo());
		propietarioDTO.setTelMovil(propietario.getTelMovil());
		propietarioDTO.setFoto(propietario.getFoto());
		propietarioDTO.setEstado(propietario.getEstado());
		propietarioDTO.setTipoPropietario(propietario.getTipoPropietario());
		propietarioDTO.setEsCrear(false);
		model.addAttribute("propietario", propietarioDTO);
		return "crearPropietarios";
	}
	
	@RequestMapping(value = "/eliminar/{cedula}", method = RequestMethod.GET)
	public String eliminarPropietario(@PathVariable long cedula, Model model) {
		logger.info("Entrando a eliminar propietario");
		Propietario propietario = propietarioServiceImpl.buscarPropietarioPorCedula(cedula);
		propietarioServiceImpl.borrarPropietario(propietario);
		String path = servletContext.getRealPath("/resources/photos/");		
		File archivo = new File(path + File.separator + propietario.getFoto());
		if (archivo.delete())
			logger.info("El fichero ha sido borrado satisfactoriamente");
		else
			logger.info("El fichero no puede ser borrado, ubicacion=" + archivo.getAbsolutePath());
	
		model.addAttribute("exito","Se ha eliminado el propietario exitosamente");
		return listar(model);
	}

	
	@RequestMapping(value = "/carne/{cedula}", method = RequestMethod.GET)
	public ModelAndView generarCarne(@PathVariable long cedula, ModelAndView modelAndView) {
		logger.info("Generando Reporte");		
		Map<String,Object> parameters = new HashMap<String,Object>();
		String basepath = servletContext.getRealPath("/resources/jasper/");
		String photopath =servletContext.getRealPath("/resources/photos/");
		
					
		Propietario propietario = propietarioServiceImpl.buscarPropietarioPorCedula(cedula);		
		parameters.put("P_CEDULA", propietario.getCedula().toString());
		parameters.put("P_NOMBRES", propietario.getNombre()+" "+propietario.getApellido());		
		parameters.put("P_TELFIJO", propietario.getTelFijo());
		parameters.put("P_TIPO", propietario.getTipoPropietario());
		parameters.put("P_BASEPATH", basepath);
		
		String fotonombre=(!StringUtils.isEmpty(propietario.getFoto())? File.separator +propietario.getFoto() : File.separator + "default.gif" );
		InputStream photostream = null;
		try {
			photostream = new FileInputStream(photopath+fotonombre);
//			BufferedInputStream buffer = new BufferedInputStream(photostream);
//			buffer.read();
			parameters.put("P_PHOTOSTREAM", photostream);
//			buffer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}					 
		JasperReportsPdfView view = new JasperReportsPdfView();			    
	    view.setApplicationContext(appContext);
	    modelAndView = new ModelAndView("pdfReport", parameters);		   
		return modelAndView;		
	}
	

	private Propietario crearPropietario(PropietarioDTO propietario){
		return propietarioServiceImpl.crearPropietario(new Propietario(Long.valueOf(propietario.getCedula()),propietario.getApellido(),propietario.getEstado(),propietario.getFoto(),propietario.getNombre(),propietario.getTelFijo(),propietario.getTelMovil(),propietario.getTipoPropietario()));
	}
	
	private Propietario modificarPropietario(PropietarioDTO propietario){
		return propietarioServiceImpl.actualizarPropietario(new Propietario(Long.valueOf(propietario.getCedula()),propietario.getApellido(),propietario.getEstado(),propietario.getFoto(),propietario.getNombre(),propietario.getTelFijo(),propietario.getTelMovil(),propietario.getTipoPropietario()));
	}
}
