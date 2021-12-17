package sn.ugb.gdil.appResto.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.ugb.gdil.appResto.modeles.Restaurant;

public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {

}
