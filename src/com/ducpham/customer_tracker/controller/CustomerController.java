package com.ducpham.customer_tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ducpham.customer_tracker.entity.Customer;
import com.ducpham.customer_tracker.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/list")
	public String getCustomer(Model model) {
		List<Customer> list = customerService.getCustomer();
		model.addAttribute("customers", list);
		return "list-customer";
	}

	@GetMapping("showFromForAdd")
	public String getAddForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer",customer);
		return	"show-form-for-add";
	}
	
	@PostMapping("processAddForm")
	public String postMapping(@ModelAttribute("student") Customer customer) {
		System.out.println(customer.toString());
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("showFormForUpdate")
	public String getUpdateForm(@RequestParam("customerId") int id, Model model){		
		Customer customer = customerService.getTheCustomer(id);
		model.addAttribute("customer", customer);
		return "show-form-for-add";
	}
	
	@GetMapping("delete")
	public String postDelete(@RequestParam("customerId") int id){
		Customer customer  = customerService.getTheCustomer(id);
		customerService.deleteCustomer(customer);
		return "redirect:/customer/list";
	}
	
}
