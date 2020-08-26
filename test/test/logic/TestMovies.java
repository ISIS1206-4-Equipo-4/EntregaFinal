package test.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import model.logic.Movies;

public class TestMovies 
{		
	private Movies pelicula;
	
	public void setUp()
	{
		pelicula = new Movies(15, 0, "Comedia", null, null, null, null, null, null, null, "25/06/2010", 0, 0, "Italiano", null, null, "Estructura", 7.8, 0, 0, 0, 0, "Leo", 0, "Maria", 0, "Nicolas", 0, "Andres", 0, "Mateo", 0, 0, "Quentin", 0, 0, null, 0, null, null);
	}
	
	public void testId()
	{
		setUp();
		
		assertEquals(15, pelicula.darId());
		
		assertNotNull(pelicula.darId());
	}
	
	public void testGenero()
	{	

		setUp();
		
		assertEquals("Comedia", pelicula.darGenero());
		
		assertNotNull(pelicula.darGenero());
	}
	
	public void testDate()
	{

		setUp();
		
		assertEquals("25/06/2010", pelicula.darDate());
		
		assertNotNull(pelicula.darDate());
	}
	
	public void testIdioma()
	{
		setUp();
	
		assertEquals("Italiano", pelicula.darSpokenLenguage());		
	
		assertNotNull(pelicula.darSpokenLenguage());
		
	}
	
	public void testTitulo() 
	{

		setUp();
		
		assertEquals("Estructura", pelicula.darTitulo());
		
		assertNotNull(pelicula.darTitulo());
		
	}
	
	public void testVotos()
	{

		setUp();
		
		assertEquals(7.8, pelicula.darPromedioVotos());
		
		assertNotNull(pelicula.darPromedioVotos());
	}
	
	public void testActor1()
	{
		setUp();
		
		assertEquals("Leo", pelicula.darActor1());
		
		assertNotNull(pelicula.darActor1());
	}
	
	public void testActor2()
	{
		setUp();
		
		assertEquals("Maria", pelicula.darActor2());
		
		assertNotNull(pelicula.darActor2());
	}
	
	public void testActor3()
	{
		setUp();
		
		assertEquals("Nicolas", pelicula.darActor3());
		
		assertNotNull(pelicula.darActor3());
	}
	
	public void testActor4()
	{
		setUp();
		
		assertEquals("Andres", pelicula.darActor2());
		
		assertNotNull(pelicula.darActor4());
	}
	
	public void testActor5()
	{
		setUp();
		
		assertEquals("Mateo", pelicula.darActor2());
		
		assertNotNull(pelicula.darActor5());
	}
	
	public void testDirector()
	{
		setUp();
		
		assertEquals("Quentin", pelicula.darDirector());
		
		assertNotNull(pelicula.darDirector());
	}
	
	

}


