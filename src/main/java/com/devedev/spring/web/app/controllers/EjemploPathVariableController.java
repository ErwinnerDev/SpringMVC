/**
 * 
 */
package com.devedev.spring.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dimen
 * @date 29 may. 2021
 * @version 1.0.0 
 */
  @Controller
  @RequestMapping("/variables")
public class EjemploPathVariableController {

	  //La onotación de PathVariable es muy similar a la de RequestParam
	  @GetMapping("/string/{texto}")
	  public String params(@PathVariable String texto,Model modelo) {
		  modelo.addAttribute("titulo","Recibir parametros  de la ruta (@PathVariable)");
		  modelo.addAttribute("resultado", "El texto enviado por la URL es: "+texto);
		  
		  return "variables/ver";
	  }
}
