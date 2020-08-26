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
			arreglo.agregar(""+i);
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
	public void testDarElemento() 
	{
		setUp2();
		// TODO
		assertEquals("No se da el elemento esperado", 100, arreglo.darElemento(100));
		
	}
	
	public void testAgregar()
	{
		setUp1();
		arreglo.agregar(1);
		assertEquals("El elemento no se agrego correctamente", 1, arreglo.darElemento(0));
	}
	
	public void testDarCapacidad()
	{
		setUp1();
		assertEquals("La capacidad no coincide", TAMANO, arreglo.darCapacidad());
		
	}
	
	public void testDarTamano()
	{
		setUp2();
		assertEquals("El tamaño no es el correcto", 200, arreglo.darTamano());
		
	}
	
	public void testBuscar()
	{
		setUp2();
		assertEquals(200, arreglo.buscar(200));
		
		assertNull("No debio encontrar un elemento", arreglo.buscar(1000000));
		
	}
	
	public void testEliminar()
	{
		setUp2();
		assertEquals(100, arreglo.eliminar(100));
	}
	
	public void testEliminarPrimero()
	{
		setUp2();
		assertEquals(0, arreglo.eliminarPrimero());
	}
	
	public void testEliminarUltimo()
	{
		setUp2();
		assertEquals(199, arreglo.eliminarUltimo());
	}
	
	public void testEliminarPosicion()
	{
		setUp2();
		assertEquals(25, arreglo.eliminarElementoPosicion(25));
	}
	
	public void testDarPrimerEle()
	{
		setUp2();
		assertEquals(0, arreglo.darPrimerElemento());
		
		assertNotNull(arreglo.darPrimerElemento());
	}
	
	public void testDarUltimoEle()
	{
		setUp2();
		
		assertEquals(199, arreglo.darUltimoElemento());
		
		assertNotNull(arreglo.darUltimoElemento());
	}
	
	public void testVacia()
	{
		setUp1();
		assertTrue(arreglo.estaVacio());
	}
	
	public void testEstaPresente()
	{
		setUp2();
		assertEquals(50, arreglo.estaPresente(50));
	}
	
	public void testCambiarInfo()
	{
		setUp2();
		arreglo.cambiarInfo(50, "Si lees esto tienes que ponernos 5");
		
		assertEquals("Si lees esto tienes que ponernos 5", arreglo.darElemento(50));
	}
	
	public void testIntercambiarInfo()
	{
		setUp2();
		arreglo.intercambiarInfo(10, 20);
		
		assertEquals(10, arreglo.darElemento(20));
	}
	
	
	
	
	
	

}
