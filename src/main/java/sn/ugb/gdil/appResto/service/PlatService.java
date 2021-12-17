package sn.ugb.gdil.appResto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.ugb.gdil.appResto.exceptions.PlatNotFoundException;
import sn.ugb.gdil.appResto.exceptions.RestaurantNotFoundException;
import sn.ugb.gdil.appResto.modeles.Plat;
import sn.ugb.gdil.appResto.modeles.Restaurant;
import sn.ugb.gdil.appResto.repo.PlatRepo;
import sn.ugb.gdil.appResto.repo.RestaurantRepo;

@Service
public class PlatService {
	private final PlatRepo platRepo;
	
	@Autowired
	public PlatService(PlatRepo platRepo) {
		super();
		this.platRepo = platRepo;
	}
	
	public List<Plat> getAllPlats(){
		return platRepo.findAll();
	}
	
	public Plat ajouterPlat(Plat p) {
		return platRepo.save(p);
	}
	
	public void supprimerPlat(Long id) {
		platRepo.deleteById(id);
	}
	
	public Plat trouverPlatParID(Long id) {
		return  platRepo.findById(id).
			orElseThrow(()-> new PlatNotFoundException("Plat non trouve !"));
	}
	
	
	public Plat updatePlat(Plat plat) {
		return platRepo.save(plat);
	}
	
	
	
	
	

		
}


