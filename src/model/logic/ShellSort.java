package model.logic;

import model.data_structures.ArregloDinamico;
import model.data_structures.ListaEncadenada;

public class ShellSort 
{
	
	
	 public static void sort(Comparable[]  array,String tipoOrden, String as_decendente)
	 {
	
		 
		 
			 int N = array.length;
			 int h = 1;
			 while (h < N/3) 
				 h = 3*h + 1;
				 while (h >= 1)
				 {
					 for (int i = h; i < N; i++) 
					 {
						 if (as_decendente.equals("ascendente"))
						 {
							 for (int j = i; j >= h && less(array[j],array[j-h],tipoOrden); j -= h)
							 exch(array, j, j-h);
							 
							
						 }
						 
						 else 
						 {
							 for (int j = i; j >= h && !less(array[j],array[j-h],tipoOrden); j -= h)
								 exch(array, j, j-h);
						 }
						 
					 }
						 h = h/3; 
				 }
				 
			 
				 	 
	 }
	 
	 private static boolean less(Comparable v, Comparable w, String tipoOrden)
	 {
		 boolean respuesta=false;
		 Movies A= (Movies) v;
		 Movies B= (Movies) w;
		 
		if (A.compareToRequerimiento(B,tipoOrden ) < 0)
		{
			respuesta=true;
		}
	 return respuesta;
	 }
	 

	 


	 private static void exch(Comparable[] a, int i, int j)
	 {
	 Comparable t = a[i];
	 a[i] = a[j];
	 a[j] = t;
	 }
}
