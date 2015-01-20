import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainProgram {
	
	static String [] prepositions= {" a ", " ante ", " bajo ", " cabe ", " con ", " contra ", " de ", " desde ", 
			" durante ", " en ", " entre ", " hacia ", " hasta ", " mediante ", " para ", " por ", 
			" según ", " sin ", " so ", " sobre ", " tras ", " versus ", " vía ", "la ", " si "};		

	static String [] determinantes = { " su ", " al ", " esta ", " ese " , " mi ", " la ", " el ", 
					" lo ", " las ", " los " , " l@s ", " tus ", " ellos ", " ellas ", 
					" tu ", " un ", " una ", " del ", " y ", " o ", " nuestras ", " nuestros ", " cualquier ", " nuestra", " cada "};
	
	static String [] pronombres = { " me ", " te ", " se ", " nos ", " os " };
	
	static String [] signosDePuntacion = { ";", "¿", ": ", " ? ", " : ", " ¿ ", "\\? ", " +"};
	
	static String [] diasDeLaSemana = { " lunes ", " martes ", " miercoles ", " jueves ", " viernes ", " sabado ", " domingo " };
	
	static String [] stopWords = { " unas ", " unos ", " un ", " del ", " al "," de ", " en ", " sobre ", " por ", " dentro ", " hacia ", " desde ", " fuera ", " como ", " así ", " tal ", " esos ", " esas ", " este ", " aquellas ", " aquellos ", " esa ",
	" para ", " es ", " fue ", " era ",  " soy ", " eres ", " sido ", " eras " };

	public static void main(String[] args) {
		
		ReadCSV reader=new ReadCSV();
		List<Tuit>publicidad=reader.run("Publicidad.csv");
		List<Tuit>noPublicidad=reader.run("NoPublicidad.csv");
		
		reemplazarValores ( publicidad );
		reemplazarValores( noPublicidad );

		for ( Tuit tuit : publicidad )
		{
			obtenerNumeroDeCorrespondencias( tuit );
		}
		
		for ( Tuit tuit : noPublicidad )
		{
			obtenerNumeroDeCorrespondencias( tuit );
		}
		
		getNumberOfUrls(publicidad);
		getNumberOfUrls(noPublicidad);
		
		getNumberOfMentions(publicidad);
		getNumberOfMentions(noPublicidad);
		
		for ( Tuit tuit : publicidad )
		{
			System.out.println(tuit.getTexto());
			System.out.println(tuit.getHashMap());
			System.out.println(tuit.getNumberOfNumbers());
			System.out.println(tuit.getNumberOfMentions());
		}
		PrintWriter writer;
		try {
			writer = new PrintWriter("FinalText.txt", "UTF-8");
			escribirEnFichero(writer, publicidad, true );
			escribirEnFichero(writer, noPublicidad, false );
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}
	
	public static void escribirEnFichero ( PrintWriter writer, List<Tuit> tuits, boolean publicidad )
	{
		for ( Tuit tuit : tuits )
		{
			String linea = "";
			for ( String keyWord : tuit.getHashMap().keySet() )
			{
				linea += keyWord + " " + tuit.getHashMap().get(keyWord) + ",";
			}
			linea += tuit.getNumberOfMentions() + ",";
			linea += tuit.getNumberOfURLs() + ",";
			linea += tuit.getNumberOfNumbers() + ",";
			//linea += tuit.getSeguidores() + ",";
			//linea += tuit.getSiguiendo() + ",";
			//linea += tuit.getTweets() + ",";
			if ( publicidad )
				linea += "1";
			else
				linea += "0";
			writer.println(linea);
		}
	}
	
	public static void reemplazarValores ( List<Tuit> tuits )
	{
		for ( Tuit tuit : tuits )
		{
			reemplazarValores ( tuit, prepositions );
			reemplazarValores(tuit, determinantes );
			reemplazarValores(tuit, pronombres);
			reemplazarValores(tuit, signosDePuntacion);
			reemplazarValores(tuit, diasDeLaSemana);
			reemplazarValores(tuit, stopWords);
		}
	}
	public static void obtenerNumeroDeCorrespondencias ( Tuit tuit )
	{
		String [] palabras = tuit.getTexto().split(" ");
		for ( String palabra : palabras )
		{
			for ( String key : tuit.getHashMap().keySet() )
			{
				if ( Utilidades.correspondencia(key, palabra) )
				{
					tuit.getHashMap().put ( key, tuit.getHashMap().get(key) + 1 );	
				}

			}
			
			if ( isNumeric ( palabra ) )
			{
				tuit.setNumberOfNumbers( tuit.getNumberOfNumbers() + 1 );
			}
		}
	}
	
	public static boolean isNumeric(String s) {  
	    return s.matches("[-+]?\\d*\\.?\\d+");  
	}  
	
	public static void reemplazarValores ( Tuit tuit, String [] restricciones )
	{
		for ( int i = 0; i < restricciones.length; i++ )
		{
			tuit.setTexto(tuit.getTexto().toLowerCase().replaceAll(restricciones[i], " "));
		}
	}
	
	public static void getNumberOfUrls(List<Tuit>tuits){
		String lRegex = "(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
	    Pattern pattern = Pattern.compile(lRegex);
		for(Tuit tuit: tuits){
			int numberOfURLs=0;
		    Matcher  matcher = pattern.matcher(tuit.getTexto());
		    while (matcher.find())
		    	numberOfURLs++;
		    tuit.setNumberOfURLs(numberOfURLs);
		    
		}
	}
	
	public static void getNumberOfMentions(List<Tuit>tuits){
		String regex="@(\\w){1,15}";
		
		Pattern pattern = Pattern.compile(regex);
		for(Tuit tuit: tuits){
			int numberOfMentions=0;
		    Matcher  matcher = pattern.matcher(tuit.getTexto());
		    while (matcher.find())
		    	numberOfMentions++;
		    tuit.setNumberOfMentions(numberOfMentions);
		}
	}
}
