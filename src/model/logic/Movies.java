package model.logic;

public class Movies implements Comparable
{
	private int id;
	private int budget;
	private String genero;
	private String imbd;
	private String lenguajeOrignal;
	private String orginalTitle;
	private String overview;
	private String popularity;
	private String productionCompany;
	private String productionCountry;
	private String date;
	private int revenue;
	private int runtime;
	private String spokenLenguage;
	private String status;
	private String tagLine;
	private String title;
	private double votosPromedio;
	private int numeroVotos;
	private int pCompanyNumber;
	private int pCountryNumber;
	private int pLenguageNumber;
	
	private String actor1;
	private int generoActor1;
	private String actor2;
	private int generoActor2;
	private String actor3;
	private int generoActor3;
	private String actor4;
	private int generoActor4;
	private String actor5;
	private int generoActor5;
	private int numeroActores;
	private String director;
	private int generoDirector;
	private int numeroDirectores;
	private String producer;
	private int numeroProducer;
	private String screePlay;
	private String nombreEditor;
	
	public Movies(int pid,int pbudget,String pgenero,String pimbd,String plenguajeOrignal,String porginalTitle, String poverview, String ppopularity, String pproductionCompany, String pproductionCountry, String pdate, int prevenue, int pruntime, String pspokenLenguage, String pstatus, String ptagLine, String ptitle, double pvotosPromedio, int pnumeroVotos, int ppCompanyNumber, int ppCountryNumber, int ppLenguageNumber, String pactor1, int pgeneroActor1, String pactor2, int pgeneroActor2, String pactor3, int pgeneroActor3, String pactor4, int pgeneroActor4, String pactor5, int pgeneroActor5, int pnumeroActores, String pdirector, int pgeneroDirector, int pnumeroDirectores, String pproducer, int pnumeroProducer, String pscreePlay, String pnombreEditor)
	{
		id=pid;
		budget=pbudget;
		genero=pgenero;
		imbd=pimbd;
		lenguajeOrignal=plenguajeOrignal;
		orginalTitle=porginalTitle;
		overview=poverview;
		popularity=ppopularity;
		productionCompany=pproductionCompany;
		productionCountry=pproductionCountry;
		date=pdate;
		revenue=prevenue;
		runtime=pruntime;
		spokenLenguage=pspokenLenguage;
		status=pstatus;
		tagLine=ptagLine;
		title=ptitle;
		votosPromedio=pvotosPromedio;
		numeroVotos=pnumeroVotos;
		pCompanyNumber=ppCompanyNumber;
		pCountryNumber=ppCountryNumber;
		pLenguageNumber=ppLenguageNumber;
		
		actor1=pactor1;
		generoActor1=pgeneroActor1;
		actor2=pactor2;
		generoActor2=pgeneroActor2;
		actor3=pactor3;
		generoActor3=pgeneroActor3;
		actor4=pactor4;
		generoActor4=pgeneroActor4;
		actor5=pactor5;
		generoActor5=pgeneroActor5;
		numeroActores=pnumeroActores;
		director=pdirector;
		generoDirector=pgeneroDirector;
		numeroDirectores=pnumeroDirectores;
		producer=pproducer;
		numeroProducer=pnumeroProducer;
		screePlay=pscreePlay;
		nombreEditor=pnombreEditor;
	}

	public int darId()
	{
		return id;
	}
	
	public String darGenero()
	{
		return genero;
	}
	
	public String darDate()
	{
		return date;
	}
	
	public String darSpokenLenguage()
	{
		return spokenLenguage;
	}
	
	public String darTitulo()
	{
		return title;
	}
	
	public double darPromedioVotos()
	{
		return votosPromedio;
	}
	
	public String darActor1()
	{
		return actor1;
	}
	
	public String darActor2()
	{
		return actor2;
	}
	
	public String darActor3()
	{
		return actor3;
	}
	
	public String darActor4()
	{
		return actor4;
	}
	
	public String darActor5()
	{
		return actor5;
	}
	
	public String darDirector()
	{
		return director;
	}
	
	@Override
	public int compareTo(Object o) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
