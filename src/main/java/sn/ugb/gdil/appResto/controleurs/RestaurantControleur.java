package sn.ugb.gdil.appResto.controleurs;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.activation.FileTypeMap;

import org.apache.tomcat.util.http.parser.MediaType;
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
import sn.ugb.gdil.appResto.service.RestaurantService;
@CrossOrigin(maxAge=3600)
@RestController
@RequestMapping("/restaurant")

public class RestaurantControleur {
	private final RestaurantService service;
	private final PlatService pservice;
	
	public RestaurantControleur(RestaurantService service, PlatService pservice) {
		this.service = service;
		this.pservice = pservice;
	}
	
	@GetMapping("/restaurants")
	public ResponseEntity<List<Restaurant>> getAllRestaurants(){
		List<Restaurant> resto = service.getAllRestaurants();
		return new ResponseEntity<List<Restaurant>>(resto, HttpStatus.OK);
		
	}
	@PostMapping("/ajouter")
	public ResponseEntity<Restaurant> ajouterRestaurant(@RequestBody Restaurant resto){
		Restaurant restaurant = service.ajouterRestaurant(resto);
		return new ResponseEntity<Restaurant>(restaurant, HttpStatus.CREATED);
	}
	
	@GetMapping("/chercher/{id}")
	public ResponseEntity<Restaurant> chercherRestaurantParId(@PathVariable("id") Long id){
		Restaurant resto = service.trouverRestaurantParID(id);
		return new ResponseEntity<Restaurant>(resto, HttpStatus.OK);
	}
	
	@PostMapping("/{id}/ajouterPlat/{idr}")
	public ResponseEntity<Restaurant> ajouterPlatRestaurant(@PathVariable("id") Long id,@PathVariable("idr") Long idr){
		Plat plat = pservice.trouverPlatParID(idr);
		Restaurant restaurant = service.trouverRestaurantParID(id);
		restaurant = service.ajouterPlatRestaurant(restaurant, plat);
		return new ResponseEntity<Restaurant>(restaurant, HttpStatus.CREATED);
	}
	@GetMapping("/{id}/plats")
	public ResponseEntity<List<Plat>> getPlats(@PathVariable("id") Long id){
		List<Plat> plats = service.getPlats(id);
		
		return new ResponseEntity<List<Plat>>(plats, HttpStatus.OK);
	}
	
	@DeleteMapping("/supprimer/{id}")
	public ResponseEntity<Restaurant> supprimerRestaurant(@PathVariable("id") Long id){
		service.supprimerRestaurant(id);
		return new ResponseEntity<Restaurant>(HttpStatus.OK);
	}
	
	@PutMapping("/miseajour")
	public ResponseEntity<Restaurant> miseajourResto(@RequestBody Restaurant r){
		Restaurant updateresto = service.updateRestaurant(r);
		return new ResponseEntity<Restaurant>(updateresto, HttpStatus.OK);
		
	}
	
	
}


