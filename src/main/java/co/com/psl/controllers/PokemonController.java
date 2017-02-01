package co.com.psl.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.psl.config.PokemonSetUp;
import co.com.psl.models.Pokemon;
import co.com.psl.models.PokemonTypes;

@RestController
public class PokemonController {
	
	@Autowired
	PokemonSetUp pokemonRepository;
		
	@RequestMapping(path="/pokemons", method=RequestMethod.GET)
	public @ResponseBody ArrayList<Pokemon> listAvaiblePokemons(@RequestParam(value="id", required=false) Integer id){
		if(id != null){
			for (Pokemon currentPokemon : pokemonRepository.getAvaiblePokemons()) {
				if(currentPokemon.getId() == id){
					ArrayList<Pokemon> responce = new ArrayList<Pokemon>();
					{
						responce.add(currentPokemon);
					}
					return responce;
				}
			}
			return null;
		}
		
		return pokemonRepository.getAvaiblePokemons();
	}
	
	@RequestMapping(value="/pokemons/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Pokemon getPokemonById(@PathVariable("id") int id){
		for (Pokemon currentPokemon : pokemonRepository.getAvaiblePokemons()) {
			if(currentPokemon.getId() == id){
				return currentPokemon;
			}
		}
		return null;
	}
	
	@RequestMapping(path="/types", method=RequestMethod.GET)
	public @ResponseBody ArrayList<PokemonTypes> listAvaiblePokemonTypes(@RequestParam(value="id", required=false) Integer id){
		if(id != null){
			for (PokemonTypes currentPokemonType : pokemonRepository.getAvaibleTypes()) {
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
		return pokemonRepository.getAvaibleTypes();
	}
	
	@RequestMapping(value="/types/{id}", method=RequestMethod.GET)
	@ResponseBody
	public PokemonTypes getPokemonTypeById(@PathVariable("id") int id){
		for (PokemonTypes currentPokemonType : pokemonRepository.getAvaibleTypes()) {
			if(currentPokemonType.getId() == id){
				return currentPokemonType;
			}
		}
		return null;
	}
}
