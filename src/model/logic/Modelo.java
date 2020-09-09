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
			 * data/SmallMoviesDetailsCleaned.csv
			 */
			arhcCVS= new FileReader("data/AllMoviesDetailsCleaned.csv");
			CSVParser conPuntoYComa= new CSVParserBuilder().withSeparator(';').build();
			csvReader =new CSVReaderBuilder(arhcCVS).withCSVParser(conPuntoYComa).build();
			
			String[] palabra=csvReader.readNext();
			
			/*
			 * arhcCVS2= new FileReader("data/prueba2.csv");
			 * data/MoviesCastingRaw-small.csv
			 */
			arhcCVS2= new FileReader("data/AllMoviesCastingRaw.csv");
			CSVParser conPuntoYComa2= new CSVParserBuilder().withSeparator(';').build();
			csvReader2 =new CSVReaderBuilder(arhcCVS2).withCSVParser(conPuntoYComa2).build();
			
			String[] palabra2=csvReader2.readNext();
			
					
				while ((palabra=csvReader.readNext())!=null)
				{	
					palabra2=csvReader2.readNext();
					
					
					/*
					 * int budget =Integer.parseInt(palabra[1]);
					 * String imbd=palabra[3];
					 * String lenguajeOrignal=palabra[4];
					String orginalTitle=palabra[5];
					String overview=palabra[6];
					String popularity=palabra[7];
					String productionCompany=palabra[8];
					String productionCountry=palabra[9];
					int revenue=Integer.parseInt(palabra[11]);
					int runtime=Integer.parseInt(palabra[12]);
					String status=palabra[14];
					String tagLine=palabra[15];
					int pCompanyNumber=Integer.parseInt(palabra[19]);
					int pCountryNumber=Integer.parseInt(palabra[20]);
					int pLenguageNumber=Integer.parseInt(palabra[21]);
					int generoDirector=Integer.parseInt(palabra2[13]);
					int numeroDirectores=Integer.parseInt(palabra2[14]);
					String producer=palabra2[15];
					int numeroProducer=Integer.parseInt(palabra2[16]);
					String screePlay=palabra2[17];
					String nombreEditor=palabra2[18];
					int numeroActores=Integer.parseInt(palabra2[11]);
					
						int generoActor1=Integer.parseInt(palabra2[2]);
					
					int generoActor2=Integer.parseInt(palabra2[4]);
					
					int generoActor3=Integer.parseInt(palabra2[6]);
					
					int generoActor4=Integer.parseInt(palabra2[8]);
					
					int generoActor5=Integer.parseInt(palabra2[10]);
					
					
					Movies nuevaPelicula=new Movies(id ,0, genero,"","","","","","","",date,0,0,spokenLenguage,"","",title,votosPromedio,numeroVotos,0,0,0,actor1,generoActor1,actor2,generoActor2,actor3,generoActor3,actor4,generoActor4,actor5,generoActor5,0,director,0,0,"",0,"","");
					
					 */
					
					int id=Integer.parseInt(palabra[0]);
					String date=palabra[10];
					String spokenLenguage=palabra[13];
					String title=palabra[16];
					double votosPromedio=Double.parseDouble(palabra[17]);
					int numeroVotos=Integer.parseInt(palabra[18]);
					String genero=palabra[2];
					
					String actor1=palabra2[1];
					String actor2=palabra2[3];
					String actor3=palabra2[5];
					String actor4=palabra2[7];
					String actor5=palabra2[9];
					String director=palabra2[12];
					
					Movies nuevaPelicula=new Movies(id ,0, genero,"","","","","","","",date,0,0,spokenLenguage,"","",title,votosPromedio,numeroVotos,0,0,0,actor1,0,actor2,0,actor3,0,actor4,0,actor5,0,0,director,0,0,"",0,"","");
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
	

	
	
	
	
	
	
	
	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public Modelo(int capacidad)
	{
		datos = new ArregloDinamico(capacidad);
	}
	
	
	public String requerimiento1(String nombre, double calificacion) throws Exception
	{
		String respuesta="Peliculas buenas del director "+nombre+"\n";
		double votos=0;
		int nPeliculas=0;
		int tamano=datos.size();
		
		for(int i=0;i<tamano;i++)
		{
			Movies actual=(Movies) datos.get(i+1);
			if (actual.darDirector().equals(nombre)&&actual.darPromedioVotos()>=calificacion)
			{
				respuesta=respuesta+"\nTitulo: "+actual.darTitulo()+" \nID: "+actual.darId()+" \nGenero: "+actual.darGenero()+" \nDia de Lanzamiento: " +actual.darDate()+" \nPromedio votos: "+actual.darPromedioVotos()+" \nActor1: "+actual.darActor1()+" \nActor2: "+actual.darActor2()+" \nActor3: "+actual.darActor3()+" \nActor4: "+actual.darActor4()+" \nActor5: "+actual.darActor5()+"\n\n";
				votos=votos+actual.darPromedioVotos();
				nPeliculas++;
				
			}
		}
		
		double promedio=0;
		if (nPeliculas!=0)
		{
			promedio=(votos/nPeliculas);
		}
		return respuesta+"\n\nel numero de peliculas es: "+nPeliculas+"\nel promedio de estas peliculas es: "+promedio;
	}

	
	
	public String requerimiento2(int numeroPeliculas, String tipoOrden, String as_decendente) throws Exception
	{
		String respuesta="las "+numeroPeliculas+" peliculas ordenadas por "+tipoOrden+" "+as_decendente+"mente son:\n";
		
		ArregloDinamico provision= new ArregloDinamico(datos.size());
		int numeroGenero=0;
		
		for(int i=1;i<=datos.size();i++)
		{
			Movies actual=(Movies) datos.get(i);
			if(actual.darPromedioVotos()!=0 )
			{
				provision.addLast(actual);
				numeroGenero++;	
			}
		}
		
		 Comparable[] comparable= new Comparable[numeroGenero];
		
			for (int i=0;i<provision.size();i++)
			{
				
				comparable[i]=provision.get(i+1);
				
				
					
			}
		 
		
		if (numeroPeliculas>=10)
		{
			if(tipoOrden.equals("AVERAGE"))
			{
				ShellSort.sort(comparable,tipoOrden,as_decendente);
				for(int i=0;i<numeroPeliculas && i<comparable.length;i++)
				{
					Movies actual=(Movies) comparable[i];
					if(actual!=null) 
					{
					respuesta=respuesta+"Nombre: "+actual.darTitulo()+"\npromedio: "+actual.darPromedioVotos()+"\n\n";
				
					}
				}
			}
			else if(tipoOrden.equals("COUNT"))
			{
				ShellSort.sort(comparable,tipoOrden,as_decendente);
				for(int i=0;i<numeroPeliculas&& i<comparable.length;i++)
				{
					Movies actual=(Movies) comparable[i];
					
					if(actual!=null) 
					{
					respuesta=respuesta+"Nombre: "+actual.darTitulo()+" \nnumero de votos: "+actual.darNumeroVotos()+"\n\n";
				
					}
				}
			}
			else
			{
				respuesta="no selecciono una forma adecuada de ranking";
			}
		}
		else
		{
			respuesta="el numero de peliculas para hacer el ranking debe ser mayor o igual a 10";
		}
		
		return respuesta;
	}
	
	
	public String requerimiento3(String pDirector) throws Exception
	{
		String rta = "Informacion del director " + pDirector+"\n";
		int cont = 0;
		int suma = 0;
		int promedio = 0; 
		for(int i= 0; i < datos.size(); i++)
		{
			Movies pelicula = (Movies) datos.get(i+1);
			if(pelicula.darDirector().compareTo(pDirector) == 0)
			{
				rta = rta + "\nTitulo: " + pelicula.darTitulo() + pelicula.darId()+" \nGenero: "+pelicula.darGenero()+" \nDia de Lanzamiento: " +pelicula.darDate()+" \nPromedio votos: "+pelicula.darPromedioVotos()+" \nActor1: "+pelicula.darActor1()+" \nActor2: "+pelicula.darActor2()+" \nActor3: "+pelicula.darActor3()+" \nActor4: "+pelicula.darActor4()+" \nActor5: "+pelicula.darActor5()+"\n";
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
	
	
	public String requerimiento4(String pActor) throws Exception
	{
		String rta = "Información de " + pActor+"\n";
		int pelis = 0;
		int suma = 0;
		int prom = 0; 
		
		ArregloDinamico director=new ArregloDinamico(25);
		
		
		for(int i= 0; i < datos.size() ; i++)
		{
			Movies peli = (Movies) datos.get(i+1);
			if(peli.darActor1().compareTo(pActor) == 0 || peli.darActor2().compareTo(pActor) == 0 || peli.darActor3().compareTo(pActor) == 0 || peli.darActor4().compareTo(pActor) == 0 || peli.darActor5().compareTo(pActor) == 0)
			{
				rta = rta + "\nTitulo: " + peli.darTitulo() +"\n";
				pelis++;
				suma += peli.darPromedioVotos();
				director.addLast(peli.darDirector());
			}
		}
		if (pelis != 0) 
		{
			prom = suma/pelis;	
		}
		
		int numeroPeliculas=0;
		String respuesta="";
		for (int i=1;i<=director.size();i++)
		{
			int numeroPeliculasComparar=1;
			String actual=(String) director.get(i);
			
			for(int j=i+1;j<=director.size();j++)
			{
				String comparar=(String) director.get(j);
				if(actual.equals(comparar))
				{
					numeroPeliculasComparar++;
				}
			}
			
			if (numeroPeliculasComparar>numeroPeliculas)
			{
				numeroPeliculas=numeroPeliculasComparar;
				respuesta=actual;
			}
			
			
			
		
		}
		
		rta += "\nNumero de peliculas en las que ha participado: " + pelis + "\nPromedio de votos en las peliculas: " + prom+"\ndirector con mas colaboraciones: "+respuesta;
		
		return rta; 
	}
	
	public String conocerGenero(String pGenero) throws Exception
	{
		String rta = "Informacion del genero " + pGenero;
		int cont = 0;
		int suma = 0;
		int promedio = 0; 
		for(int i= 0; i < datos.size(); i++)
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
	
	
	public String requerimiento5(String genero) throws Exception
	{
		String respuestaPeliculas="las peliculas del genero "+genero+" son:\n";
		double sumaCalificaciones=0;
		int numeroPeliculas=0;
		
		for(int i=1;i<=datos.size();i++)
		{
			Movies actual=(Movies) datos.get(i);
			if(actual.darGenero().equals(genero))
			{
				respuestaPeliculas=respuestaPeliculas+actual.darTitulo()+"\n";
				sumaCalificaciones=sumaCalificaciones+actual.darPromedioVotos();
				numeroPeliculas++;
				
				
			}
		}
		double promedio=0;
			if (numeroPeliculas!=0)
			{
				promedio=sumaCalificaciones/numeroPeliculas;
			}
		
		return respuestaPeliculas+ "\n numero de peliculas: "+numeroPeliculas+"\n promedio de peliculas del genero: "+promedio;
		
	}

	public String requerimiento6(int numeroPeliculas, String tipoOrden, String as_decendente, String genero) throws Exception
	{
		String respuesta="las "+numeroPeliculas+" peliculas ordenadas por "+tipoOrden+" "+as_decendente+"mente del genero " +genero+ " son:\n";
		
		ArregloDinamico provision= new ArregloDinamico(datos.size());
		int numeroGenero=0;
		
		for(int i=1;i<=datos.size();i++)
		{
			Movies actual=(Movies) datos.get(i);
			if(actual.darGenero().equals(genero)&&actual.darPromedioVotos()!=0 )
			{
				provision.addLast(actual);
				numeroGenero++;	
			}
		}
		
		 Comparable[] comparable= new Comparable[numeroGenero];
		
			for (int i=0;i<provision.size();i++)
			{
				
				comparable[i]=provision.get(i+1);
				
				
					
			}
		
		if (numeroPeliculas>=10)
		{
			if(tipoOrden.equals("AVERAGE"))
			{
				ShellSort.sort(comparable,tipoOrden,as_decendente);
				for(int i=0;i<numeroPeliculas&& i<comparable.length;i++)
				{
					Movies actual=(Movies) comparable[i];
					if(actual!=null) 
					{
						respuesta=respuesta+"Nombre: "+actual.darTitulo()+"\npromedio: "+actual.darPromedioVotos()+"\n\n";
						
					}
				}
			}
			else if(tipoOrden.equals("COUNT"))
			{
				ShellSort.sort(comparable,tipoOrden,as_decendente);
				for(int i=0;i<numeroPeliculas&& i<comparable.length;i++)
				{
					Movies actual=(Movies) comparable[i];
					if(actual!=null) 
					{
						respuesta=respuesta+"Nombre: "+actual.darTitulo()+" \nnumero de votos: "+actual.darNumeroVotos()+"\n\n";
						
					}
				}
			}
			else
			{
				respuesta="no selecciono una forma adecuada de ranking";
			}
		}
		else
		{
			respuesta="el numero de peliculas para hacer el ranking debe ser mayor o igual a 10";
		}
		
		return respuesta;
	}
	



}
