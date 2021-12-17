package sn.ugb.gdil.appResto.controleurs;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.ugb.gdil.appResto.modeles.Plat;
import sn.ugb.gdil.appResto.modeles.Restaurant;
import sn.ugb.gdil.appResto.service.PlatService;
@CrossOrigin(maxAge=3600)
@RestController
@RequestMapping("/plat")

public class PlatControleur {
	private final PlatService service;
	
	public PlatControleur(PlatService service) {
		this.service = service;
	}
	
	@GetMapping("/plats")
	public ResponseEntity<List<Plat>> getAllPlats(){
		List<Plat> plat = service.getAllPlats();
		return new ResponseEntity<List<Plat>>(plat, HttpStatus.OK);
		
	}
	@PostMapping("/ajouter")
	public ResponseEntity<Plat> ajouterPlat(@RequestBody Plat resto){
		Plat plat = service.ajouterPlat(resto);
		return new ResponseEntity<Plat>(plat, HttpStatus.CREATED);
	}
	
	@GetMapping("/chercher/{id}")
	public ResponseEntity<Plat> chercherPlatParId(@PathVariable("id") Long id){
		Plat plat = service.trouverPlatParID(id);
		return new ResponseEntity<Plat>(plat, HttpStatus.OK);
	}
	
//	@DeleteMapping("/supprimer/{id}")
//	public ResponseEntity<Plat> supprimerPlat(@PathVariable("id") Long id){
//		service.supprimerPlat(id);
//		return new ResponseEntity<Plat>(HttpStatus.OK);
//	}
//	
	@PutMapping("/miseajour")
	public ResponseEntity<Plat> miseajourPlat(@RequestBody Plat p){
		Plat updateplat = service.updatePlat(p);
		return new ResponseEntity<Plat>(updateplat, HttpStatus.OK);
		
	}
	
	
	
	
}


