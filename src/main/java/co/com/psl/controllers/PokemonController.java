package co.com.psl.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.psl.models.Pokemon;
import co.com.psl.models.PokemonTypes;

@RestController
public class PokemonController {
	
	private static ArrayList<PokemonTypes> avaibleTypes;
	{
		avaibleTypes = new ArrayList<PokemonTypes>();
		avaibleTypes.add(new PokemonTypes(0, "Electric"));
		avaibleTypes.add(new PokemonTypes(1, "Grass"));
		avaibleTypes.add(new PokemonTypes(3, "Poison"));
		avaibleTypes.add(new PokemonTypes(4, "Fire"));
		avaibleTypes.add(new PokemonTypes(5, "Flying"));
		avaibleTypes.add(new PokemonTypes(6, "Ice"));
		avaibleTypes.add(new PokemonTypes(7, "Physic"));
		avaibleTypes.add(new PokemonTypes(8, "Ground"));
	}
	
	private static ArrayList<Pokemon> avaiblePokemons;
	{
		avaiblePokemons = new ArrayList<Pokemon>();
		avaiblePokemons.add(new Pokemon(1, "Pikachu",new String[] {"Electric"}, new String[] {"Ground"}, 2, "https://goo.gl/T1rXHl"));
		avaiblePokemons.add(new Pokemon(2, "Bulbasaur",new String[] {"Grass", "Poison"}, new String[] {"Fire", "Ice", "Flying", "Physic"}, 0, "https://goo.gl/NSvqCU"));
		avaiblePokemons.add(new Pokemon(3, "Charizard",new String[] {"Fire", "Flying"}, new String[] {"Ground", "Water", "Rock", "Electric", "Ice"}, 3, "https://goo.gl/0EQHsC"));
		avaiblePokemons.add(new Pokemon(4, "Electabuzz",new String[] {"Electric"}, new String[] {"Ground"}, 2, "https://goo.gl/3dhOzV"));
		avaiblePokemons.add(new Pokemon(5, "Koffing",new String[] {"Posion"}, new String[] {"Ground", "Physic"}, 1, "https://goo.gl/0Qjktf"));
	}
	
	/*
	 * URL
	 */
	/*
	@RequestMapping(path="/pokemons", method=RequestMethod.GET)
	public ArrayList<Pokemon> listAvaiblePokemons(){
		return avaiblePokemons;
	}
	
	@RequestMapping(value="/pokemons/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Pokemon getPokemonById(@PathVariable("id") int id){
		for (Pokemon currentPokemon : avaiblePokemons) {
			if(currentPokemon.getId() == id){
				return currentPokemon;
			}
		}
		return null;
	}*/
	
	/*
	 * QUERY PARAMS
	 */
	@RequestMapping(path="/pokemons", method=RequestMethod.GET)
	public @ResponseBody ArrayList<Pokemon> listAvaiblePokemons(@RequestParam(value="id", required=false) Integer id){
		if(id != null){
			for (Pokemon currentPokemon : avaiblePokemons) {
				if(currentPokemon.getId() == id){
					ArrayList<Pokemon> responce = new ArrayList<Pokemon>();
					{
						responce.add(currentPokemon);
					}
					return responce;
				}
				return null;
			}
		}
		
		return avaiblePokemons;
	}
	
	/*
	 * URL
	 */
	/*
	@RequestMapping(path="/types", method=RequestMethod.GET)
	public ArrayList<PokemonTypes> listAvaibleTypes(){
		return avaibleTypes;
	}
	
	@RequestMapping(value="/types/{id}", method=RequestMethod.GET)
	@ResponseBody
	public PokemonTypes getPokemonTypeById(@PathVariable("id") int id){
		for (PokemonTypes currentPokemonType : avaibleTypes) {
			if(currentPokemonType.getId() == id){
				return currentPokemonType;
			}
		}
		return null;
	}*/
	
	/*
	 * QUERY PARAMS
	 */
	@RequestMapping(path="/types", method=RequestMethod.GET)
	public @ResponseBody ArrayList<PokemonTypes> listAvaiblePokemonTypes(@RequestParam(value="id", required=false) Integer id){
		if(id != null){
			for (PokemonTypes currentPokemonType : avaibleTypes) {
				if(currentPokemonType.getId() == id){
					ArrayList<PokemonTypes> responce = new ArrayList<PokemonTypes>();
					{
						responce.add(currentPokemonType);
					}
					return responce;
				}
			}
			return null;
		}
		return avaibleTypes;
	}
}
