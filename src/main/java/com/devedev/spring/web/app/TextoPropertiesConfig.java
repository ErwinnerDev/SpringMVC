/**
 * 
 */
package com.devedev.spring.web.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @author dimen
 * @date 5 jun. 2021
 * @version 1.0.0 
 */
 @Configuration
 @PropertySources(
		 {
			 @PropertySource("ControllerInyeccionValues.properties")
		 }
)
public class TextoPropertiesConfig {

}
