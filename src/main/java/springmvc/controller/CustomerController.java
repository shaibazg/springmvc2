package springmvc.controller;

import net.webservicex.ConversionRate;
import net.webservicex.ConversionRateResponse;
import net.webservicex.Currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.ws.client.core.WebServiceTemplate;

import springmvc.domain.Customer;
import springmvc.validator.CustomerValidator;

@Controller
@SessionAttributes("customer")
@RequestMapping("/customerForm")
public class CustomerController {
	
	@Autowired
	CustomerValidator validator;
	
	@Autowired
	WebServiceTemplate wsTemplate;
	
	@RequestMapping(value="show", method=RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customerForm";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String submitForm(@ModelAttribute("customer") Customer customer, BindingResult result, 
			SessionStatus sessionStatus) {
		validator.validate(customer, result);
		ConversionRate rate = new ConversionRate();
		rate.setFromCurrency(Currency.USD);
		rate.setToCurrency(Currency.INR);
		ConversionRateResponse response = (ConversionRateResponse)wsTemplate.marshalSendAndReceive(rate);
		System.out.println("The rate is; " + response.getConversionRateResult());
		if (result.hasErrors()) {
			return "customerForm";
		} else {
			return "redirect:showCustomer";
		}
	}
	
	
	@RequestMapping(value="showCustomer", method=RequestMethod.GET)
	public String showCustomer(@ModelAttribute("customer") Customer customer, SessionStatus status) {
		System.out.println("After submission: " + customer.getFirstName());
		status.setComplete();
		return "customerSuccess";
	}
	
	
	
}
