package irrfmvsg.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import irrfmvsg.model.IRRFModel;

@Controller
public class IRRFController {
		
	@GetMapping("/")
	public String showForm(Model model) {
		
		IRRFModel irrf=new IRRFModel();
		
		model.addAttribute("IRRF",irrf);
		return "irrfForm";
	}
	
	@PostMapping("/")
	public String showData(@ModelAttribute("IRRF") IRRFModel irrf){
		return "irrfdata";
	}
}
