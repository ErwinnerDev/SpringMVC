/**
 * 
 */
package com.devedev.spring.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author dimen
 * @date 16 may. 2021
 * @version 1.0.0 
 */
@Controller
@RequestMapping("/params")
public class EjemploParamsController {
	
	
	
	@RequestMapping("/")
	public String index() {
		return "params/home";
	}

	
	
	@GetMapping("/departamento")
	public String params(@RequestParam(name="mensaje",required = false,defaultValue = "Home!!") String mensaje, Model model) {
		model.addAttribute("resultado","Bienvenido al área de: "+mensaje);
		return "params/ver";
		//Para sonsumirlo sería:
		// http://localhost:8080/params/departamento?mensaje=Bienvenidos al departamento
	}
	
	// se puede no colocar las propiedades del RequestParam
	// Se puede agregar mas de un atributo como parametro
	// Si no se le pasa el parametro por defalt se le asigna un null
	@GetMapping("/mix-param")
	public String params(@RequestParam String saludo,Integer numero, Model model) {
		model.addAttribute("resultado","Saludos a: "+saludo +" que cumple "+numero+" anios!!");
		return "params/ver";
	}
	
	
	// esto es itra forma de hacer lo mismo que el de arriba pero está forma es más antigua
	@GetMapping("/mix-param-httpServlet")
	public String params(HttpServletRequest servletRequest, Model model) {
		String saludo= servletRequest.getParameter("saludo");
		Integer numero= null;
		//los getParameter por default regresan de tipo String
		try {
			numero=Integer.parseInt(servletRequest.getParameter("numero"));
		}catch (Exception e) {
			numero=0;
		}
		
		model.addAttribute("resultado","Saludos a: "+saludo +" que cumple "+numero+" anios!!");
		return "params/ver";
		
		
	}
	
	
	

}
