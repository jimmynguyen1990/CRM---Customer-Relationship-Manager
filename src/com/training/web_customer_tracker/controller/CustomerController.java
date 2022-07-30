package com.training.web_customer_tracker.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.web_customer_tracker.dao.CustomerDAO;
import com.training.web_customer_tracker.entity.Customer;
import com.training.web_customer_tracker.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//Inject CustomerService
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	private String showCustomer(Model theModel) {
		
		//Retrieve the list of customer
		List<Customer>theCustomers = customerService.getCustomers();
		
		//Create model attribute
		theModel.addAttribute("customers", theCustomers);
		
		return "customer-list";
	}
	
	@GetMapping("/showAddingForm")
	private String showCustomerForm(Model theModel) {
		
		//Create a new Customer object
		Customer newCustomer = new Customer();
		
		//Create model attribute
		theModel.addAttribute("customer", newCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	private String saveCustomer(
			@ModelAttribute(name = "customer") Customer newCustomer) {
		
		//Save the new customer to the database
		customerService.saveCustomer(newCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showUpdateForm")
	private String updateCustomer(@RequestParam("customerId") int theId,
								  Model theModel) {
		
		//Retrieve the customer with id
		Customer theCustomer = customerService.getCustomer(theId);
		
		//Set up the model attribute
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	private String deleteCustomer(@RequestParam("customerId") int theId) {
		
		//Delete customer from the database
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
	
	@PostMapping("/searchCustomer")
	private String searchCustomer(@RequestParam("theSearchName") String theName,
								  Model theModel) {
		
		//Retrieve customers with the search name from the database
		List<Customer>theCustomers = customerService.searchCustomers(theName);
		
		//Set up model attribute
		theModel.addAttribute("customers", theCustomers);
		
		return "customer-list";
	}
}
