package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springmvc.domain.Customer;

@Controller
public class RestController {
	
	@RequestMapping("/customer")
	public String getRestCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "memberTemplate";
	}
	
}
