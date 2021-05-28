/**
 * 
 */
package com.devedev.spring.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.devedev.spring.web.app.models.Usuario;

/**
 * @author dimen
 * @date 16 may. 2021
 * @version 1.0.0 
 */
@Controller
@RequestMapping(value="/app") // esta sería la ruta Raíz del controlador
//@RequestMapping("/app") tambien se puede de esta forma
public class IndexController {
	
	@GetMapping({"/index","/","","/home"})
	public String index(Model model) {
		model.addAttribute("mensaje","Hola Mundo con Spring Famework con Model");
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Erwin");
		usuario.setApellido("Cruz Mayo");
		usuario.setCorreo("dimesnion_e007@hotmail.com");
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo","Perfil de usuario:".concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		
		/*List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario("Erwin","Cruz Mayo","erwin.sistemas@gmail.com"));
		usuarios.add(new Usuario("Juan","Martinez","juan@gmail.com"));
		usuarios.add(new Usuario("Maria","soledad","maria@gmail.com")); */
		//model.addAttribute("usuarios",usuarios);
		model.addAttribute("titulo","Lista de usuario");
		return "listar";
	}
	
	
	//Si se necesita utilizar en más de una pestaña
	@ModelAttribute("usuarios")
	public List<Usuario> poblarusuarios() {	
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario("Erwin","Cruz Mayo","erwin.sistemas@gmail.com"));
		usuarios.add(new Usuario("Juan","Martinez","juan@gmail.com"));
		usuarios.add(new Usuario("Maria","soledad","maria@gmail.com"));
		return usuarios;
	}
	
	
	
	//==========================================================================================
	//================Deferentes formas de hacer los metodos Get y los Map======================
	//==========================================================================================
	
	//Se puede hacer así para que sea de una forma de tipo get, por defaul es get si no se pone
	//El values contiene el nombre de la ruta
	@RequestMapping(value="/index1",method = RequestMethod.GET)
	public String index1(ModelMap model) {
		//Se pude agregar mensjes utilizando ModelMap, iyectanselo al HTML
		model.addAttribute("mensaje", "Hola Mundo spring");
		return "index";
	}
	
	//O sería lo mismo que hacer
	@GetMapping(value="/index2")
	public String index2(Model model) {
		//Se puede ocupar tambien la importacion Model envez de ModelMap
		model.addAttribute("mensaje", "Hola Mundo Spring");
		return "index";
	}
	
	//Un método puede estar mapeado a más de una ruta
	@GetMapping({"/index3","/","/home"})
	public String index3() {
		return "index";
	}
	
		// esta es otra forma de asociar los modelos con los view, se tiene que retormar un tipo Modelandview
		@GetMapping({"/index4"})
		public ModelAndView index4(ModelAndView mv) {
			//Se agrega los mensajes con add
			mv.addObject("mensaje","Hola mundo Spring");
			// pasa saber el nombre del template o vista
			mv.setViewName("index4");
			return mv;
		}

}
