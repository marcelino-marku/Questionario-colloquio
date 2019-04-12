package questionario.controller;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import questionario.validation.Admin;

@Controller
public class LoginController {

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/login")
	public String Login(Model model) {
		model.addAttribute("admin", new Admin());
		return "login";

	}

	@RequestMapping("/processLogin")
	public String processLogin(@Valid @ModelAttribute("admin") Admin admin, BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "login";
		} else {
			return "newdomanda";
		}
	}
}
