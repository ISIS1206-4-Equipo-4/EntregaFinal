package model.logic;

import model.data_structures.ArregloDinamico;
import model.data_structures.ListaEncadenada;

public class ShellSort 
{
	
	
	 public static void sort(Comparable[]  array)
	 {
	
		 
		 
			 int N = array.length;
			 int h = 1;
			 while (h < N/3) 
			 {
				 h = 3*h + 1;
				 
				 while (h >= 1)
				 {
					 for (int i = h; i < N; i++) 
					 {
						 for (int j = i; j >= h && array[j].compareTo(array[j-h])<0; j -= h)
						 {
						 exch(array, j, j-h);
						 }
					 }
						 h = h/3; 
				 }
				 
			 }
				 	 
	 }
	 
	 private static void exch(Comparable[] a, int i, int j)
	 {
	 Comparable t = a[i];
	 a[i] = a[j];
	 a[j] = t;
	 }
}
