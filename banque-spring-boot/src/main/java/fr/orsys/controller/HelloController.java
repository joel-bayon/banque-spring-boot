package fr.orsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController {
	public HelloController() {
		System.out.println("** HelloController **");
	}
	
	@RequestMapping("/hello")
	public String hello(@RequestParam String nom, Model model) {
		System.out.println("** /hello **");
		nom = nom.toUpperCase(); // traitement métier ...
		model.addAttribute("nom", nom);
		return "helloView";
		
	}

}
