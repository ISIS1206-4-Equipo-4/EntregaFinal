package test.data_structures;

import model.data_structures.ArregloDinamico;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestArregloDinamico {

	private ArregloDinamico arreglo;
	private static int TAMANO=100;
	
	@Before
	public void setUp1() 
	{
		arreglo= new ArregloDinamico(TAMANO);
	}

	public void setUp2() 
	{
		for(int i =0; i< TAMANO*2; i++){
			arreglo.addLast(""+i);
		}
	}

	@Test
	public void testArregloDinamico() 
	{
		// TODO
		setUp1();
		assertNotNull("La lista no deberia ser null", arreglo);		
		
	}

	@Test
	public void testDarElemento() throws Exception 
	{
		setUp2();
		// TODO
		assertEquals("No se da el elemento esperado", 100, arreglo.get(100));
		
	}
	
	public void testAgregar() throws Exception
	{
		setUp1();
		arreglo.addFirst(1);;
		assertEquals("El elemento no se agrego correctamente", 1, arreglo.get(0));
	}
	
	public void testDarCapacidad()
	{
		setUp1();
		assertEquals("La capacidad no coincide", TAMANO, arreglo.size());
		
	}
	
	public void testDarTamano()
	{
		setUp2();
		assertEquals("El tamaño no es el correcto", 200, arreglo.size());
		
	}

	
	public void testEliminar()
	{
		setUp2();
		assertEquals(100, arreglo.removePosition(100));
	}
	
	public void testEliminarPrimero()
	{
		setUp2();
		assertEquals(0, arreglo.removeFirst());
	}
	
	public void testEliminarUltimo()
	{
		setUp2();
		assertEquals(199, arreglo.removeLast());
	}
	
	public void testEliminarPosicion()
	{
		setUp2();
		assertEquals(25, arreglo.removePosition(25));
	}
	
	public void testDarPrimerEle()
	{
		setUp2();
		assertEquals(0, arreglo.getFirtsElement());
		
		assertNotNull(arreglo.getFirtsElement());
	}
	
	public void testDarUltimoEle()
	{
		setUp2();
		
		assertEquals(199, arreglo.giveLastElement());
		
		assertNotNull(arreglo.giveLastElement());
	}
	
	public void testVacia()
	{
		setUp1();
		assertTrue(arreglo.isEmpty());
	}
	
	public void testEstaPresente()
	{
		setUp2();
		assertEquals(50, arreglo.isPresent(50));
	}
	
	public void testCambiarInfo() throws Exception
	{
		setUp2();
		arreglo.cambiarInfo(50, "Si lees esto tienes que ponernos 5");
		
		assertEquals("Si lees esto tienes que ponernos 5", arreglo.get(50));
	}
	
	public void testIntercambiarInfo() throws Exception
	{
		setUp2();
		arreglo.intercambiarInfo(10, 20);
		
		assertEquals(10, arreglo.get(10));
	}
	
	
	
	
	
	

}
