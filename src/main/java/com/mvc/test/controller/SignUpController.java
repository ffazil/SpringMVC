package com.mvc.test.controller;

import javax.validation.Valid;

import com.mvc.test.model.CustomerForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mvc.test.model.Customer;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SignUpController {

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String addCustomer(
			@Valid CustomerForm customerForm,
			BindingResult result) {
        System.out.println("Name = " + customerForm.getCustomers().size());

		/*for (Object object : result.getAllErrors()) {
			if (object instanceof FieldError) {
				FieldError fieldError = (FieldError) object;

				System.out.println(fieldError.getField() + ":"
						+ fieldError.getCode());

			}

			if (object instanceof ObjectError) {
				ObjectError objectError = (ObjectError) object;

			}
		}*/

		if (result.hasErrors()) {
			return "/index";
		} else {
			return "/done";
		}

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String displayCustomerForm(ModelMap model) {

		model.addAttribute("customer", new Customer());
		return "/index";

	}

}