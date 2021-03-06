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
		modelo = new Modelo(32000);
		modelo.cargarPeliculas();

		while( !fin ){
			view.printMenu();
			
			int option = lector.nextInt();
			switch(option){
			
				case 1:	
					double dato2 = 0;
					String respuesta2 = "";						
					view.printMessage("Ingrese el nombre del director");
					while(respuesta2.equals(""))
					{
						respuesta2 = lector.nextLine();
					}
					try
				{
					view.printMessage("Del 1 al 10 desde que calificacion es una buena pelicula (',' son decimales):");
					dato2 = lector.nextDouble();
					view.printMessage(modelo.requerimiento1(respuesta2, dato2));
					
				}
				catch (Exception e1) 
				{
				
					e1.printStackTrace();
				}		
				break;
					
				
				case 2:
					 
					
					
					view.printMessage("escriba el numero de peliculas que desea conformar el ranking");
					int numero=0;
					numero=lector.nextInt();
					
					view.printMessage("desea organizarlas por 'AVERAGE'o 'COUNT'");
					String orden="";
					orden=lector.next();
					
					
					view.printMessage("desea que sea 'ascendente' o 'descendente' ");
					String forma="";
					forma=lector.next();
				try 
				{
					
					view.printMessage(modelo.requerimiento2(numero, orden, forma));
					

					
					
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
						view.printMessage("Ingrese el nombre del director");
						String director = "";
						while(director.equals(""))
						{
							director = lector.nextLine();
						}
						view.printMessage(modelo.requerimiento3(director));
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
							String actor = "";
							while(actor.equals(""))
							{
								actor = lector.nextLine();
							}
							 
							view.printMessage(modelo.requerimiento4(actor));
						} 
						catch (Exception e) 
						{
							
							e.printStackTrace();
						}	
						break;
					
						
				case 5:
					
					view.printMessage("escriba el genero que desea buscar peliculas");
					String genero="";
					
					genero=lector.next();
					
				try 
				{
					
					view.printMessage(modelo.requerimiento5(genero));
					

					
					
				} 
				catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   break;
				   
				case 6:
					
					
					view.printMessage("cual es el genero del cual se desea hacer el ranking");
					String genero1="";
					genero1=lector.next();
					
					view.printMessage("escriba el numero de peliculas que desea conformar el ranking");
					int numero1=0;
					numero1=lector.nextInt();
					
					view.printMessage("desea organizarlas por 'AVERAGE'o 'COUNT'");
					String orden1="";
					orden1=lector.next();
					
					view.printMessage("desea que sea 'ascendente' o 'descendente' ");
					String forma1="";
					forma1=lector.next();
					
					
				try 
				{
					
					view.printMessage(modelo.requerimiento6(numero1, orden1, forma1,genero1));
					

					
					
				} 
				catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   break;
					
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
