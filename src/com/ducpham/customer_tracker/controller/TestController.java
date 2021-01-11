package com.ducpham.customer_tracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/customer")
	public String getList(Model model) {
		return "list-customer";
	}

}
