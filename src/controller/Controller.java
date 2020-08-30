package controller;

import java.util.Scanner;

import model.logic.Modelo;
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
					modelo = new Modelo(2000); 
					modelo.probar();
					modelo.cargarPeliculas();
				try 
				{
					
					view.printMessage(modelo.escribirPrimerYUltimaPelicula());
				} 
				catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   break;

				case 2:
					view.printMessage("Nombre del director que desea buscar buenas peliculas:");
					while(respuesta.equals(""))
					{
					respuesta=lector.nextLine();
					}
						view.printMessage("Del 1 al 10 desde que calificacion es una buena pelicula (',' son decimales):");
						dato=lector.nextDouble();
				try 
				{
					view.printMessage(modelo.buenasPeliculasDirector(respuesta, dato));
				} 
				catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						break;	
					
					

				case 3:
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
