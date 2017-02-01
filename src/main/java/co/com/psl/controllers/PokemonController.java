package co.com.psl.controllers;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.psl.models.Pokemon;

@RestController
public class PokemonController {
	
	private static ArrayList avaiblePokemons;
	{
		avaiblePokemons = new ArrayList();
		avaiblePokemons.add(new Pokemon(1, "Pikachu",new String[] {"Electric"}, new String[] {"Ground"}, 2, "https://goo.gl/T1rXHl"));
		avaiblePokemons.add(new Pokemon(2, "Bulbasaur",new String[] {"Grass", "Poison"}, new String[] {"Fire", "Ice", "Flying", "Physic"}, 0, "https://goo.gl/NSvqCU"));
		avaiblePokemons.add(new Pokemon(3, "Charizard",new String[] {"Fire", "Flying"}, new String[] {"Ground", "Water", "Rock", "Electric", "Ice"}, 3, "https://goo.gl/0EQHsC"));
		avaiblePokemons.add(new Pokemon(4, "Electabuzz",new String[] {"Electric"}, new String[] {"Ground"}, 2, "https://goo.gl/3dhOzV"));
		avaiblePokemons.add(new Pokemon(5, "Koffing",new String[] {"Posion"}, new String[] {"Ground", "Physic"}, 1, "https://goo.gl/0Qjktf"));
	}
	
	@RequestMapping("/pokemons")
	public ArrayList listAvaiblePokemons(){
		return avaiblePokemons;
	}
	
}
