package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import model.data_structures.ListaEncadenada;

/**
 * Definicion del modelo del mundo
 *
 */

public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private ArregloDinamico datos;
	private ListaEncadenada lista;
	
	public final static int TAMANO = 2000;
	
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		datos =  new ArregloDinamico(7);
		
		
	}
	
	public void cargarPeliculas()
	{
		FileReader arhcCVS=null;
		CSVReader csvReader=null;
		
		FileReader arhcCVS2=null;
		CSVReader csvReader2=null;
		
	
		
		
		try
		{
			/*
			 * arhcCVS= new FileReader("data/prueba.csv");
			 * 
			 */
			arhcCVS= new FileReader("data/SmallMoviesDetailsCleaned.csv");
			CSVParser conPuntoYComa= new CSVParserBuilder().withSeparator(';').build();
			csvReader =new CSVReaderBuilder(arhcCVS).withCSVParser(conPuntoYComa).build();
			
			String[] palabra=csvReader.readNext();
			
			/*
			 * arhcCVS2= new FileReader("data/prueba2.csv");
			 * 
			 */
			arhcCVS2= new FileReader("data/MoviesCastingRaw-small.csv");
			CSVParser conPuntoYComa2= new CSVParserBuilder().withSeparator(';').build();
			csvReader2 =new CSVReaderBuilder(arhcCVS2).withCSVParser(conPuntoYComa2).build();
			
			String[] palabra2=csvReader2.readNext();
			
					
				while ((palabra=csvReader.readNext())!=null)
				{	
					palabra2=csvReader2.readNext();
					
					int id=Integer.parseInt(palabra[0]);
					int budget =Integer.parseInt(palabra[1]);
					String genero=palabra[2];
					String imbd=palabra[3];
					String lenguajeOrignal=palabra[4];
					String orginalTitle=palabra[5];
					String overview=palabra[6];
					String popularity=palabra[7];
					String productionCompany=palabra[8];
					String productionCountry=palabra[9];
					String date=palabra[10];
					int revenue=Integer.parseInt(palabra[11]);
					int runtime=Integer.parseInt(palabra[12]);
					String spokenLenguage=palabra[13];
					String status=palabra[14];
					String tagLine=palabra[15];
					String title=palabra[16];
					double votosPromedio=Double.parseDouble(palabra[17]);
					int numeroVotos=Integer.parseInt(palabra[18]);
					int pCompanyNumber=Integer.parseInt(palabra[19]);
					int pCountryNumber=Integer.parseInt(palabra[20]);
					int pLenguageNumber=Integer.parseInt(palabra[21]);
					
					String actor1=palabra2[1];
					int generoActor1=Integer.parseInt(palabra2[2]);
					String actor2=palabra2[3];
					int generoActor2=Integer.parseInt(palabra2[4]);
					String actor3=palabra2[5];
					int generoActor3=Integer.parseInt(palabra2[6]);
					String actor4=palabra2[7];
					int generoActor4=Integer.parseInt(palabra2[8]);
					String actor5=palabra2[9];
					int generoActor5=Integer.parseInt(palabra2[10]);
					int numeroActores=Integer.parseInt(palabra2[11]);
					String director=palabra2[12];
					int generoDirector=Integer.parseInt(palabra2[13]);
					int numeroDirectores=Integer.parseInt(palabra2[14]);
					String producer=palabra2[15];
					int numeroProducer=Integer.parseInt(palabra2[16]);
					String screePlay=palabra2[17];
					String nombreEditor=palabra2[18];
					
					
					Movies nuevaPelicula=new Movies(id ,0, genero,"","","","","","","",date,0,0,spokenLenguage,"","",title,votosPromedio,0,0,0,0,actor1,generoActor1,actor2,generoActor2,actor3,generoActor3,actor4,generoActor4,actor5,generoActor5,0,director,0,0,"",0,"","");
					datos.addLast(nuevaPelicula);						
					
				}
				
				
					
					
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (CsvValidationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	public void cargarPeliculasEncadenadas()
	{
		FileReader arhcCVS=null;
		CSVReader csvReader=null;
		
		FileReader arhcCVS2=null;
		CSVReader csvReader2=null;
		
		int contador=1;
		
		
		try
		{
			/*
			 * arhcCVS= new FileReader("data/prueba.csv");
			 * 
			 */
			arhcCVS= new FileReader("data/SmallMoviesDetailsCleaned.csv");
			CSVParser conPuntoYComa= new CSVParserBuilder().withSeparator(';').build();
			csvReader =new CSVReaderBuilder(arhcCVS).withCSVParser(conPuntoYComa).build();
			
			String[] palabra=csvReader.readNext();
			
			/*
			 * arhcCVS2= new FileReader("data/prueba2.csv");
			 * 
			 */
			arhcCVS2= new FileReader("data/MoviesCastingRaw-small.csv");
			CSVParser conPuntoYComa2= new CSVParserBuilder().withSeparator(';').build();
			csvReader2 =new CSVReaderBuilder(arhcCVS2).withCSVParser(conPuntoYComa2).build();
			
			String[] palabra2=csvReader2.readNext();
			
					
				while ((palabra=csvReader.readNext())!=null)
				{	
					palabra2=csvReader2.readNext();
					
					int id=Integer.parseInt(palabra[0]);
					int budget =Integer.parseInt(palabra[1]);
					String genero=palabra[2];
					String imbd=palabra[3];
					String lenguajeOrignal=palabra[4];
					String orginalTitle=palabra[5];
					String overview=palabra[6];
					String popularity=palabra[7];
					String productionCompany=palabra[8];
					String productionCountry=palabra[9];
					String date=palabra[10];
					int revenue=Integer.parseInt(palabra[11]);
					int runtime=Integer.parseInt(palabra[12]);
					String spokenLenguage=palabra[13];
					String status=palabra[14];
					String tagLine=palabra[15];
					String title=palabra[16];
					double votosPromedio=Double.parseDouble(palabra[17]);
					int numeroVotos=Integer.parseInt(palabra[18]);
					int pCompanyNumber=Integer.parseInt(palabra[19]);
					int pCountryNumber=Integer.parseInt(palabra[20]);
					int pLenguageNumber=Integer.parseInt(palabra[21]);
					
					String actor1=palabra2[1];
					int generoActor1=Integer.parseInt(palabra2[2]);
					String actor2=palabra2[3];
					int generoActor2=Integer.parseInt(palabra2[4]);
					String actor3=palabra2[5];
					int generoActor3=Integer.parseInt(palabra2[6]);
					String actor4=palabra2[7];
					int generoActor4=Integer.parseInt(palabra2[8]);
					String actor5=palabra2[9];
					int generoActor5=Integer.parseInt(palabra2[10]);
					int numeroActores=Integer.parseInt(palabra2[11]);
					String director=palabra2[12];
					int generoDirector=Integer.parseInt(palabra2[13]);
					int numeroDirectores=Integer.parseInt(palabra2[14]);
					String producer=palabra2[15];
					int numeroProducer=Integer.parseInt(palabra2[16]);
					String screePlay=palabra2[17];
					String nombreEditor=palabra2[18];
					
					
					Movies nuevaPelicula=new Movies(id ,0, genero,"","","","","","","",date,0,0,spokenLenguage,"","",title,votosPromedio,0,0,0,0,actor1,generoActor1,actor2,generoActor2,actor3,generoActor3,actor4,generoActor4,actor5,generoActor5,0,director,0,0,"",0,"","");
				
					if (contador==1)
					{
						lista=new ListaEncadenada(nuevaPelicula);
					}
					else
					{
						lista.addLast(nuevaPelicula);
					}
					
					contador++;
				}
				
				
				
					
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (CsvValidationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String buenasPeliculasDirector(String nombre, double calificacion) throws Exception
	{
		String respuesta="Peliculas buenas del director "+nombre;
		int tamano=datos.size();
		
		for(int i=0;i<tamano;i++)
		{
			Movies actual=(Movies) datos.get(i);
			if (actual.darDirector().equals(nombre)&&actual.darPromedioVotos()>=calificacion)
			{
				respuesta=respuesta+"\nTitulo: "+actual.darTitulo()+" \nID: "+actual.darId()+" \nGenero: "+actual.darGenero()+" \nDia de Lanzamiento: " +actual.darDate()+" \nPromedio votos: "+actual.darPromedioVotos()+" \nActor1: "+actual.darActor1()+" \nActor2: "+actual.darActor2()+" \nActor3: "+actual.darActor3()+" \nActor4: "+actual.darActor4()+" \nActor5: "+actual.darActor5()+"\n\n";

				
			}
		}
		
		return respuesta;
	}
	
	public String rankingPeliculas(String pTipoRanking, int pNumeroPeliculas, String pOrden)
	{
		String respuesta = "";
		return respuesta;
	}
	
	public String escribirPrimerYUltimaPelicula() throws Exception
	{
		String respuesta="";
		
			Movies primera=(Movies) datos.get(1);
			int posicionUltima=datos.size();
			Movies ultima=(Movies) datos.get(posicionUltima);
			int totalPeliculas=datos.size();
			respuesta="Primera Pelicula \nTitulo: "+primera.darTitulo()+" \ndirector: "+primera.darDirector()+" \nID: "+primera.darId()+" \nGenero: "+primera.darGenero()+" \nDia de Lanzamiento: " +primera.darDate()+" \nPromedio votos: "+primera.darPromedioVotos()+" \nLenguaje: "+primera.darSpokenLenguage();
			respuesta=respuesta+"\n\n"+"Ultima Pelicula \nTitulo: "+ultima.darTitulo()+" \ndirector: "+ultima.darDirector()+" \nID: "+ultima.darId()+" \nGenero: "+ultima.darGenero()+" \nDia de Lanzamiento: " +ultima.darDate()+" \nPromedio votos: "+ultima.darPromedioVotos()+" \nLenguaje: "+ultima.darSpokenLenguage();
			respuesta=respuesta+"\n\nTotal Peliculas: "+totalPeliculas+"\n\n";
		return respuesta;
	}
	
	public String escribirPrimerYUltimaPeliculaEncadenada() throws Exception
	{
		String respuesta="";
		
			Movies primera=(Movies) lista.get(1);
			int posicionUltima=lista.size();
			Movies ultima=(Movies) lista.get(posicionUltima);
			int totalPeliculas=lista.size();
			respuesta="Primera Pelicula \nTitulo: "+primera.darTitulo()+" \ndirector: "+primera.darDirector()+" \nID: "+primera.darId()+" \nGenero: "+primera.darGenero()+" \nDia de Lanzamiento: " +primera.darDate()+" \nPromedio votos: "+primera.darPromedioVotos()+" \nLenguaje: "+primera.darSpokenLenguage();
			respuesta=respuesta+"\n\n"+"Ultima Pelicula \nTitulo: "+ultima.darTitulo()+" \ndirector: "+ultima.darDirector()+" \nID: "+ultima.darId()+" \nGenero: "+ultima.darGenero()+" \nDia de Lanzamiento: " +ultima.darDate()+" \nPromedio votos: "+ultima.darPromedioVotos()+" \nLenguaje: "+ultima.darSpokenLenguage();
			respuesta=respuesta+"\n\nTotal Peliculas: "+totalPeliculas+"\n\n";
		return respuesta;
	}
	
	
	public String malasPeliculas() throws Exception
	{
		String respuesta="las peores peliculas";
		
		Comparable[] x= new Comparable[2000];
		
		for (int i=0;i<2000;i++)
		{
			x[i]=datos.get(i+1);	
		}
		
		
		ShellSort.sort(x);
		
		for(int i=0;i<20;i++)
		{
			Movies actual=(Movies) x[i];
			
				respuesta=respuesta+"\nTitulo: "+actual.darTitulo()+" \nID: "+actual.darId()+" \nGenero: "+actual.darGenero()+" \nDia de Lanzamiento: " +actual.darDate()+" \nPromedio votos: "+actual.darPromedioVotos()+" \nActor1: "+actual.darActor1()+" \nActor2: "+actual.darActor2()+" \nActor3: "+actual.darActor3()+" \nActor4: "+actual.darActor4()+" \nActor5: "+actual.darActor5()+"\n\n";

				
			
		}
		
		return respuesta;
	}
	
	public String conocerDirector(String pDirector) throws Exception
	{
		String rta = "Informacion del director " + pDirector;
		int cont = 0;
		int suma = 0;
		int promedio = 0; 
		for(int i= 0; i < TAMANO; i++)
		{
			Movies pelicula = (Movies) datos.get(i+1);
			if(pelicula.darDirector().compareTo(pDirector) == 0)
			{
				rta = rta + "\nTitulo: " + pelicula.darTitulo() + pelicula.darId()+" \nGenero: "+pelicula.darGenero()+" \nDia de Lanzamiento: " +pelicula.darDate()+" \nPromedio votos: "+pelicula.darPromedioVotos()+" \nActor1: "+pelicula.darActor1()+" \nActor2: "+pelicula.darActor2()+" \nActor3: "+pelicula.darActor3()+" \nActor4: "+pelicula.darActor4()+" \nActor5: "+pelicula.darActor5();
				cont++;
				suma += pelicula.darPromedioVotos();
			}
		}
		if (cont != 0) 
		{
			promedio = suma/cont;	
		}
		
		rta += "\nNumero de peliculas: " + cont + "\nPromedio: " + promedio;
		
		return rta; 
	}
	
	
	public String conocerActor(String pActor) throws Exception
	{
		String rta = "Información de " + pActor;
		int pelis = 0;
		int suma = 0;
		int prom = 0; 
		for(int i= 0; i < datos.size() ; i++)
		{
			Movies peli = (Movies) datos.get(i+1);
			if(peli.darActor1().compareTo(pActor) == 0 || peli.darActor2().compareTo(pActor) == 0 || peli.darActor3().compareTo(pActor) == 0 || peli.darActor4().compareTo(pActor) == 0 || peli.darActor5().compareTo(pActor) == 0)
			{
				rta = rta + "\nTitulo: " + peli.darTitulo() + "\nId: " + peli.darId();
				pelis++;
				suma += peli.darPromedioVotos();
			}
		}
		if (pelis != 0) 
		{
			prom = suma/pelis;	
		}
		
		rta += "\nNumero de peliculas en las que ha participado: " + pelis + "\nPromedio de votos en las películas: " + prom;
		
		return rta; 
	}
	
	public String conocerGenero(String pGenero) throws Exception
	{
		String rta = "Informacion del genero " + pGenero;
		int cont = 0;
		int suma = 0;
		int promedio = 0; 
		for(int i= 0; i < TAMANO; i++)
		{
			Movies pelicula = (Movies) datos.get(i+1);
			if(pelicula.darGenero().compareTo(pGenero) == 0)
			{
				rta = rta + "\nTitulo: " + pelicula.darTitulo() + pelicula.darId()+" \nDia de Lanzamiento: " +pelicula.darDate()+" \nPromedio votos: "+pelicula.darPromedioVotos()+" \nActor1: "+pelicula.darActor1()+" \nActor2: "+pelicula.darActor2()+" \nActor3: "+pelicula.darActor3()+" \nActor4: "+pelicula.darActor4()+" \nActor5: "+pelicula.darActor5();
				cont++;
				suma += pelicula.darPromedioVotos();
			}
		}
		if (cont != 0) 
		{
			promedio = suma/cont;	
		}
		
		rta += "\nNumero de peliculas: " + cont + "\nPromedio: " + promedio;
		
		return rta; 
	}
	
	public String rankingGenero(int pNumeroPeliculas, String pGenero, String pTipoRanking, String pOrden)
	{
		String rta = "";
		return rta;
	}
	
	
	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public Modelo(int capacidad)
	{
		datos = new ArregloDinamico(capacidad);
	}
	
	public void probar() throws Exception
	{
		
		ListaEncadenada lista2 = new ListaEncadenada("perro1");
		lista2.addLast("perro2");
		lista2.addLast("perro3");
		lista2.removeLast();
		
		
		lista.addFirst("perro1");
		lista.addLast("perro4");
		lista.addLast("perro5");
		
		try 
		{
			lista.insertElement("perro2", 2);
			lista.giveLastElement();
			lista.get(2);
			lista.intercambiarInfo(1, 3);
			lista.cambiarInfo(1, "perro1");
			lista.cambiarInfo(3, "perro3");
			lista.removePosition(2);
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		lista.getFirtsElement();
		lista.isPresent("perra3");
		lista.removeFirst();
		lista.removeLast();
		
		
	}


}
