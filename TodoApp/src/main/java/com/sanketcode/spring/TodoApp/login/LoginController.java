package com.sanketcode.spring.TodoApp.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {
	
	@RequestMapping("login")
	public String gotoLoginPage() {
		return "login";
	}
	
}
