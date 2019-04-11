package questionario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import questionario.validation.Admin;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public String Login(@ModelAttribute("admin") Admin admin) {
		
		
		return "login";
	}
}
