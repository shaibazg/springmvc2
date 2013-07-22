package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloWorldController {
	
	@RequestMapping("/hello")
	public String display() {
		return "hello";
	}

}
