package org.microservice.greeting;

import java.util.logging.Logger;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * A RESTFul controller for accessing greeting.
 * 
 * @author Roberto Crespo
 */
@RestController
public class GreetingController {
	
	protected Logger logger = Logger.getLogger(GreetingController.class
			.getName());
	
	private static final String template = "Hello, %s!";
	
	/**
	 * Say Hello
	 * 
	 * @param name
	 * @return a greeting "Hello" + name	
	 */	
	@RequestMapping("/greeting/{name}")
    public Greeting greeting(@PathVariable("name") String name) {
        return new Greeting(String.format(template, name));		
    }

}
