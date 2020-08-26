package model.data_structures;

import java.lang.reflect.Array;

import javax.swing.Box;

import model.logic.Movies;

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

		public int darCapacidad() {
			return tamanoMax;
		}

		public int darTamano() {
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



		

		
}
