package org.microservice.clientgreeting;

import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Client controller, fetches User info from the microservice via
 * {@link ClientGreetingService}.
 * 
 * @author Roberto Crespo
 */
@Controller
public class ClientGreetingController {


	protected ClientGreetingService helloWorldService;

	protected Logger logger = Logger.getLogger(ClientGreetingController.class
			.getName());

	//constructor
	public ClientGreetingController(ClientGreetingService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@RequestMapping("/greeting")
	public String goHome() {
		return "index";
	}
	
	@RequestMapping("/greeting/{name}")
	public String greeting(Model model, @PathVariable("name") String name) {
	
		logger.info("helloWorld-service greeting() invoked: " + name);

		Greeting greeting = helloWorldService.greeting(name);
		
		logger.info("helloWorld-service greeting() found: " + greeting.getContent());
	
		model.addAttribute("greeting", greeting.getContent());
	
		return "greeting";
		
	}
	
}
