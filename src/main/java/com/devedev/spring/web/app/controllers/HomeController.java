/**
 * 
 */
package com.devedev.spring.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author dimen
 * @date 12 jun. 2021
 * @version 1.0.0 
 */
@Controller
public class HomeController {
	
	
	//La palabra redirect es una palabra reserverdad que redireccina a la ruta declarada
	// el redirect; muestra esa tura en el navehador
	// la ruta /app/index se encuetra en el controller: IndexController
	@GetMapping("/")
	public String home() {
		return "redirect:/app/index";
	}
	
	//Con forward tambien redirige pero no muestra a ruta en el navegador a la que reduregir
	@GetMapping("/home")
	public String homeW() {
		return "forward:/app/index";
	}

}
