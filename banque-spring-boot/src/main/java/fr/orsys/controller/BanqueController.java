package fr.orsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.orsys.service.Banque;


@Controller
@RequestMapping("/compte")
public class BanqueController {
	@Autowired
	Banque banque;
	
	@RequestMapping("")
	public String getCompteAll(Model model) {; 
		model.addAttribute("listeDesComptes", banque.getLesComptes()); // traitement métier ...
		return "listeCompteView";
		
	}

}
