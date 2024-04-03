package fr.univrouen.cv24.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import util.*;

@RestController
public class GetController {
	
	@Autowired
    private Fichier fichier;
	
	
	@GetMapping("/resume")
	public String getListCVinXML() {
	return "Envoi de la liste des CV";
	}
	@GetMapping("/cvid")
	public String getCVinXML(
	@RequestParam(value = "texte") String texte) {
	return ("Détail du CV n°" + texte);
	}
	@GetMapping("/test")
    public String testEndpoint(
            @RequestParam(value = "id") int id,
            @RequestParam(value = "titre") String titre) {
        return "Test : \nid = " + id + "\ntitre = " + titre;
    }
	
	@RequestMapping(value = "/testpost", method = RequestMethod.POST, 
			consumes = "application/xml")
			public String postTest(@RequestBody String flux) {
			return ("<result><response>Message reçu : </response>" 
			+ flux + "</result>");
			}
	


    @GetMapping("/testfic")
    public String afficherContenuFichier() {
        return fichier.loadFileXML();
    }
	}

