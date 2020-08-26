package model.data_structures;

import java.lang.reflect.Array;

import javax.swing.Box;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */

public class ArregloDinamico  <T extends Comparable<T>> implements IArregloDinamico<T> {
	/**
	 * Capacidad maxima del arreglo
	 */
    private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
    private int tamanoAct;
    /**
     * Arreglo de elementos de tamaNo maximo
     */
    private Object elementos[];
    
    /**
     * Construir un arreglo con la capacidad maxima inicial.
     * @param max Capacidad maxima inicial
     */
	public ArregloDinamico( int max )
    {
           elementos =  new Object[max];
           tamanoMax = max;
           tamanoAct = 0;
           
    }
	
	
    
	public void agregar( T dato )
    {
           if ( tamanoAct == tamanoMax )
           {  // caso de arreglo lleno (aumentar tamaNo)
                tamanoMax = 2 * tamanoMax;
                Object [ ] copia = elementos;
                elementos = new Object [tamanoMax]; 
                for ( int i = 0; i < tamanoAct; i++)
                {
                 	 elementos[i] = copia[i];
                } 
        	    System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
           }	
           elementos[tamanoAct] = dato;
           tamanoAct++;
   }
	
	public void agregarPrimero(T dato)
	{
		if(elementos[0] == null)
		{
			elementos[0]= dato;
		}
		else
		{
			for(int i=tamanoAct; i>0;i--)
			{
				elementos[i]= elementos[i-1];
			}
			elementos[0]=dato;
		}
		 tamanoAct++;
	}
	
	
	public void insertarElemento(T dato, int pos)
	{
		
		boolean parar=false;
        for ( int i = 0; i < tamanoAct && parar==false; i++)
        {
        	T objeto= (T) elementos[i];
         	 if (  dato.compareTo(objeto)==0)
         	 {
         		
         		
         		for (int j=tamanoAct;j>i ;j--)
         		{
         			
         				elementos[j]=elementos[j-1];
         			
         		}
         		
         		elementos[i]=dato;
         		parar=true;
         		tamanoAct++;
         	 }
        } 
		
	}
	
	public void agregarUltimo(T dato)
	{
		elementos[tamanoAct] = dato; 
	}

	public int darCapacidad() 
	{
		return tamanoMax;
	}

	public int darTamano() 
	{
		return tamanoAct;
	}

	public  T darElemento(int j) {
		// TODO implementar

		return (T) elementos[j] ;
	}

	public <T extends Comparable<T>> T buscar(T dato) {
		// TODO implementar
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
		T respuesta=null;
		boolean parar=false;
        for ( int i = 0; i < tamanoAct && parar==false; i++)
        {
        	T objeto= (T) elementos[i];
         	 if (  dato.compareTo(objeto)==0)
         	 {
         		respuesta=objeto;
         		parar=true;
         	 }
        } 
		return respuesta;
	}

	public <T extends Comparable<T>> T eliminar(T dato) {
		// TODO implementar
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
		T respuesta=null;
		boolean parar=false;
        for ( int i = 0; i < tamanoAct && parar==false; i++)
        {
        	T objeto= (T) elementos[i];
         	 if (  dato.compareTo(objeto)==0)
         	 {
         		respuesta=objeto;
         		
         		for (int j=i;j< tamanoAct;j++)
         		{
         			if (j!=tamanoAct-1)
         				{
         				elementos[j]=elementos[j+1];
         				}
         			else
         			{
         				elementos[j]=null;
         			}
         		}
         		
         		parar=true;
         		tamanoAct=tamanoAct-1;
         	 }
        } 
		return respuesta;
		
	}
	
	public T eliminarPrimero()
	{
		T primero = (T) elementos[0];
		for(int i = 0; i < tamanoAct ; i++)
		{
			if (i!=tamanoAct-1)
				{
				elementos[i]=elementos[i+1];
				}
			else
			{
				elementos[i]=null;
			}
		}
		tamanoAct=tamanoAct-1;
		return primero;
	}

	public T eliminarUltimo()
	{
		T ultimo = (T) elementos[tamanoAct-1];
		elementos[tamanoAct-1] = null; 
		tamanoAct--;
		return ultimo;
	}
	
	public T eliminarElementoPosicion(int pos)
	{
		T eliminado = (T) elementos[pos]; 
		for(int i = pos  ; i <tamanoAct ; i++)
		{
			if (i!=tamanoAct-1)
				{
				elementos[i]=elementos[i+1];
				}
			else
			{
				elementos[i]=null;
			}
				
				
			
		}
		tamanoAct=tamanoAct-1;
		return eliminado;
	}
	
	public T darPrimerElemento()
	{
		return (T) elementos[0];
	}
	
	public T darUltimoElemento()
	{
		return (T) elementos[tamanoAct - 1];
	}
	
	public boolean estaVacio()
	{
		boolean rta = true;
		if(elementos[0] != null)
		{
			rta = false;
		}
		return rta;
	}
	
	public int estaPresente(T elemento)
	{
		int rta = -1;
		for(int i = 0; i < tamanoAct && rta == -1; i++)
		{
			T comparar = (T) elementos[i];
			if(elemento.compareTo(comparar) == 0)
			{
				rta = i;
			}
		}
		return rta; 
	}
	
	public void intercambiarInfo(int i, int j)
	{
		T copia = (T) elementos[i];
		elementos[i] = elementos[j];
		elementos[j] = copia; 
	}
	
	public void cambiarInfo(int i, T elemento)
	{
		elementos[i] = elemento; 			
	}
}
