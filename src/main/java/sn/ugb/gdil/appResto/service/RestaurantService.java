package sn.ugb.gdil.appResto.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.ugb.gdil.appResto.exceptions.RestaurantNotFoundException;
import sn.ugb.gdil.appResto.modeles.Plat;
import sn.ugb.gdil.appResto.modeles.Restaurant;
import sn.ugb.gdil.appResto.repo.RestaurantRepo;

@Service
public class RestaurantService {
	private final RestaurantRepo restaurantRepo;

	@Autowired
	public RestaurantService(RestaurantRepo restaurantRepo) {
		super();
		this.restaurantRepo = restaurantRepo;
	}
	
	public List<Restaurant> getAllRestaurants(){
		return restaurantRepo.findAll();
	}
	
	public Restaurant ajouterRestaurant(Restaurant r) {
		return restaurantRepo.save(r);
	}
	
	public void supprimerRestaurant(Long id) {
		restaurantRepo.deleteById(id);
	}
	
	public Restaurant trouverRestaurantParID(Long id) {
		return restaurantRepo.findById(id).
			orElseThrow(()-> new RestaurantNotFoundException("Restaurant non trouve !"));
	}
	
	
	
	public Restaurant ajouterPlatRestaurant(Restaurant r, Plat plat) {
		r.ajouterPlat(plat);
		return restaurantRepo.save(r);
	}
	
	public List<Plat> getPlats(Long id){
		Restaurant resto = trouverRestaurantParID(id);
		return  resto.getPlats();
								
	}
	

	public Restaurant updateRestaurant(Restaurant resto) {
		return restaurantRepo.save(resto);
	}
	
	
}
		 
								
	
	

	


