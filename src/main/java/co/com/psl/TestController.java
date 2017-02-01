package co.com.psl;

import static org.junit.Assert.*;

import java.net.URL;
import java.net.URLConnection;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

import co.com.psl.config.PokemonSetUp;
import co.com.psl.controllers.PokemonController;

public class TestController {
	
	@Autowired
	PokemonSetUp pokemonRepository;
	
	PokemonController pokemon;
	
	@Before
	public void init(){
		pokemon = new PokemonController();
	}
	
	@Test
	public void test() throws Exception {
		Resource resource = appContext.getResource("file:c:\\testing.txt");
		 
	}

}
