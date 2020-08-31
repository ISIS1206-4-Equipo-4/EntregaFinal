package test.data_structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.ListaEncadenada;

public class TestListaEncadenada 
{
	
	private ListaEncadenada lista; 
	
	@Before
	public void setUp1()
	{
		lista = new ListaEncadenada<>();
	}
	
	public void setUp2()
	{
		for(int i = 0; i < 500; i++)
		{
			lista.addLast(i);
		}
	}
	
	@Test
	public void testListaEncadenada()
	{
		setUp1();
		assertNotNull(lista);
	}
	
	public void testAddFirst()
	{
		setUp2();
		lista.addFirst("Prueba");
		try 
		{
			assertEquals("Prueba", lista.get(0));
		}
		catch (Exception e) 
		{
		
			e.printStackTrace();
		}
	}
	
	public void testAddLast()
	{
		setUp2();
		lista.addLast("Estructura");
		try 
		{
			assertEquals("Estructua", lista.giveLastElement());
		}
		catch (Exception e) 
		{
		
			e.printStackTrace();
		}
	}
	
	public void testInsertElement()
	{
		setUp2();
		try {
			lista.insertElement(1000, 5);
			assertEquals(1000, lista.get(5));
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testRemoveFirst()
	{
		setUp2();
		lista.removeFirst();
		assertEquals(1, lista.getFirtsElement());
	}
	
	public void testRemoveLast()
	{
		setUp2();
		lista.removeLast();
		try
		{
			assertEquals(498, lista.giveLastElement());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testRemovePosition()
	{
		setUp2();
		try {
			lista.removePosition(5);
			assertEquals(6, lista.get(5));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void testGetFirstElement()
	{
		setUp2();
		assertEquals(0, lista.getFirtsElement());
	}
	
	public void testGetLastElement()
	{
		setUp2();
		try {
			assertEquals(499, lista.giveLastElement());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testGet()
	{
		setUp2();
		try {
			assertEquals(66, lista.get(66));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testSize()
	{
		setUp2();
		assertEquals(500, lista.size());
	}
	
	public void testEmpty()
	{
		setUp1();
		assertTrue(lista.isEmpty());
	}
	
	public void isPresent()
	{
		setUp2();
		assertEquals(88, lista.isPresent(88));
	}
	
	public void testIntercambiar()
	{
		setUp2();
		try {
			lista.intercambiarInfo(5, 200);
			assertEquals(5, lista.get(200));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void cambiar()
	{
		setUp2();
		try {
			lista.cambiarInfo(100, "2020");
			assertEquals("2020", lista.get(100));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
