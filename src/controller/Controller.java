package controller;

import java.util.Scanner;

import model.logic.Modelo;
import model.logic.Stopwatch;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}
		
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		

		while( !fin ){
			view.printMenu();
			modelo.cargarPeliculas();			
			int option = lector.nextInt();
			switch(option){
			
				case 1:	
					double dato = 0;
					String respuesta = "";						
					view.printMessage("Ingrese el nombre del director");
					while(respuesta.equals(""))
					{
						respuesta = lector.nextLine();
					}
					try
				{
					view.printMessage("Del 1 al 10 desde que calificacion es una buena pelicula (',' son decimales):");
					dato = lector.nextDouble();
					Stopwatch timer = new Stopwatch();
					view.printMessage(modelo.buenasPeliculasDirector(respuesta, dato));
					double time = timer.elapsedTime();
					view.printMessage("\nTiempo: " + time);
				}
				catch (Exception e1) 
				{
				
					e1.printStackTrace();
				}		
				break;					
				
				case 2:
					int numeroPelis = 0; 
					String criterio = ""; 
					String orden = "";
					view.printMessage("Escriba el numero de películas que quiere comparar");
					numeroPelis = lector.nextInt();
					view.printMessage("Escriba el criterio por el que quiere comparar las peliculas (COUNT, AVERAGE)");
					criterio = lector.nextLine();
					view.printMessage("Escriba las peliculas que quiere ver (BEST, WORST)");
					orden = lector.nextLine();
					Stopwatch timer = new Stopwatch(); 
					view.printMessage(modelo.rankingPeliculas(criterio, numeroPelis, orden));
					double time = timer.elapsedTime();
					view.printMessage("\nTiempo: " + time);
				   break;

				case 3:					
				try 
				{
					view.printMessage("Ingrese el nombre del director");
					String director = lector.nextLine();
					view.printMessage(modelo.conocerDirector(director));
				} 
				catch (Exception e) 
				{
					
					e.printStackTrace();
				}				
				
						break;	
					
				case 4:
					try 
					{
						view.printMessage("Ingrese el nombre del actor");
						String actor = lector.nextLine();
						view.printMessage(modelo.conocerActor(actor));
					} 
					catch (Exception e) 
					{
						
						e.printStackTrace();
					}					
				
				case 5:
					try 
					{
						view.printMessage("Ingrese el nombre del genero");
						String genero = lector.nextLine();
						view.printMessage(modelo.conocerGenero(genero));
					} 
					catch (Exception e) 
					{
						
						e.printStackTrace();
					}					
					
				case 6:
					int numeroPeliculas = 0; 
					String criterio2 = ""; 
					String orden2 = "";
					String genero = "";
					view.printMessage("Escriba el numero de películas que quiere comparar");
					numeroPeliculas = lector.nextInt();
					view.printMessage("Escriba el genero que quiere comparar");
					genero = lector.nextLine();
					view.printMessage("Escriba el criterio por el que quiere comparar las peliculas (COUNT, AVERAGE)");
					criterio2 = lector.nextLine();
					view.printMessage("Escriba las peliculas que quiere ver (BEST, WORST)");
					orden2 = lector.nextLine();
					view.printMessage(modelo.rankingGenero(numeroPeliculas, genero, criterio2, orden2));

				case 7:
					view.printMessage("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					break;

				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			
			
			}
			
			
		}
			
		
	}	
}
