/**
 * 
 */
package com.devedev.spring.web.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dimen
 * @date 5 jun. 2021
 * @version 1.0.0 
 */

@Controller
@RequestMapping(value= {"/appValue"})
public class EjemploInyeccionValues {
	
	// el contenido dentro de $ se encuentra en el .properties
	// y es como si igualara la varable con con valor del .properties
	// por defaul se toma del application.properties, pero ese es más para los datos de cnexiones BD, etc.
	@Value("${titulo.EjemploInyeccionValues.index.titulo}")
	private String titulo;
	
	//Este otro texto biene desde mi propio properties - ControllerInyeccionValue.properties
	//Para que el proyecto reconosca este nuevo properties se creo la clase TextoPropertiesConfig en el web.app
	@Value("${titulo.EjemploInyeccionValues.index.subtitulo:}")
	private String subtitulo;
	
	
	@GetMapping({"/Bienvenido"})
	private String index(Model model) {
		model.addAttribute("titulo", titulo);
		model.addAttribute("subtitulo", subtitulo);
		return "/valueProperties/index";
	}

}
