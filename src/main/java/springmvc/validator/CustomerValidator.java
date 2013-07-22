package springmvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import springmvc.domain.Customer;

@Component
public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Customer.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "firstName", "firstName.required");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "lastName.required");
		ValidationUtils.rejectIfEmpty(errors, "email", "email.required");
		Customer customer = (Customer)target;
		if ( customer.getAge() == 0) {
			System.out.println("Does it come over here.....");
			errors.reject("age.required");
		}
		
		// TODO Auto-generated method stub

	}

}
