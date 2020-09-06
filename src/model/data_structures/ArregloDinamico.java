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

public   class ArregloDinamico  <T extends Comparable<T>> implements Lista<T> {
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
	
	


	
	public void addFirst(T dato)
	{
		if(elementos[0] == null)
		{
			elementos[0]= dato;
		}
		else
		{
			if ( tamanoMax == tamanoAct )
			{
			expandArray();
			}
			for(int i=tamanoAct; i>0;i--)
			{
				elementos[i]= elementos[i-1];
			}
			elementos[0]=dato;
		}
		 tamanoAct++;
	}
	
	public void expandArray() 
	{
		T[] expanded = (T[]) new Object[5+tamanoAct]; ;
		for (int i = 0; i < elementos.length; i++)
		{
		expanded[i] = (T) elementos[i];
		}
		tamanoMax=5+tamanoAct;
		elementos = null;
		elementos = expanded;
		}
	
	public void insertElement(T dato, int pos) throws Exception
	{
		if (pos < 1 || pos > tamanoAct)
		{
			throw new Exception("no se puede eliminar el objeto de la posicion"+pos);
		}
		
		if ( tamanoMax == tamanoAct )
		{
		expandArray();
		}
		
        for ( int i = tamanoAct; i > pos-1; i--)
        {
        	
         			
         	elementos[i]=elementos[i-1];
         			
         }
         		
         elementos[pos]=dato;
         		
         tamanoAct++;
         	 
         
		
	}
	
	public void addLast(T dato)
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



	public int size() 
	{
		return tamanoAct;
	}

	public  T get(int j) throws Exception 
	{
		// TODO implementar

		if (j < 1 || j > tamanoAct)
		 {
		 throw new Exception("no se puede obtener el objeto de la posicion "+j);
		 }
		 return (T) elementos[j-1];
		//return (T) elementos[j-1];
	}




	


	public T removeLast()
	{
		T ultimo = (T) elementos[tamanoAct-1];
		elementos[tamanoAct-1] = null; 
		tamanoAct--;
		return ultimo;
	}
	
	public T removePosition(int pos)
	{
		T eliminado = (T) elementos[pos-1]; 
		for(int i = pos-1  ; i <tamanoAct ; i++)
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
	
	public T getFirtsElement()
	{
		return (T) elementos[0];
	}
	
	public T giveLastElement()
	{
		return (T) elementos[tamanoAct - 1];
	}
	

	
	public int isPresent(T elemento)
	{
		int rta = -1;
		for(int i = 0; i < tamanoAct && rta == -1; i++)
		{
			T comparar = (T) elementos[i];
			if(elemento.compareTo(comparar) == 0)
			{
				rta = i+1;
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
		elementos[i-1] = elemento; 			
	}



	



	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		boolean x=true;
		if (tamanoAct==0) 
		{
			x=false;
		}
		return x;
	}



	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
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












	}
















