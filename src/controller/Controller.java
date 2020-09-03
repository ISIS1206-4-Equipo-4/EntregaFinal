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
		double dato = 0;
		String respuesta = "";

		while( !fin ){
			view.printMenu();
			
			int option = lector.nextInt();
			switch(option){
			
				case 1:
					modelo.cargarPeliculasEncadenadas();
					try 
					{
						Stopwatch timer = new Stopwatch();
						view.printMessage(modelo.escribirPrimerYUltimaPeliculaEncadenada());
						double time = timer.elapsedTime();
						view.printMessage("el tiempo fue "+time);
						
						
					} 
					catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					   break;
					
				
				case 2:
					modelo = new Modelo(2000); 
					
					modelo.cargarPeliculas();
				try 
				{
					Stopwatch timer = new Stopwatch();
					view.printMessage(modelo.escribirPrimerYUltimaPelicula());
					double time = timer.elapsedTime();
					view.printMessage("el tiempo fue "+time);

					
					
				} 
				catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   break;

				case 3:
					
				try 
				{
					view.printMessage(modelo.malasPeliculas());
				} 
				catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						break;	
					
				case 4:
					String director = lector.nextLine();
				try {
					view.printMessage(modelo.conocerDirector(director));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

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
