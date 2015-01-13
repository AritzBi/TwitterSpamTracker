import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainProgram {
	
	public static void main(String[] args) {
		
		ReadCSV reader=new ReadCSV();
		List<Tuit>publicidad=reader.run("Publicidad.csv");
		List<Tuit>noPublicidad=reader.run("NoPublicidad.csv");
		
		String [] prepositions={" a ", " ante ", " bajo ", " cabe ", " con ", " contra ", " de ", " desde ", 
								" durante ", " en ", " entre ", " hacia ", " hasta ", " mediante ", " para ", " por ", 
								" según ", " sin ", " so ", " sobre ", " tras ", " versus ", " vía ", "la ", " si "};		
		
		String [] determinantes = { " su ", " al ", " esta ", " ese " , " mi ", " la ", " el ", 
									" lo ", " las ", " los " , " l@s ", " tus ", " ellos ", " ellas ", 
									" tu ", " un ", " una ", " del ", " y ", " o ", " nuestras ", " nuestros ", " cualquier ", " nuestra", " cada "};
		
		String [] pronombres = { " me ", " te ", " se ", " nos ", " os " };
		
		String [] signosDePuntacion = { ";", "¿", ": ", " ? ", " : ", " ¿ ", "\\? ", " +"};
		
		String [] diasDeLaSemana = { " lunes ", " martes ", " miercoles ", " jueves ", " viernes " };
		
		for(Tuit tuit: publicidad){
			reemplazarValores ( tuit, prepositions );
			reemplazarValores(tuit, determinantes );
			reemplazarValores(tuit, signosDePuntacion);
			reemplazarValores(tuit, pronombres);
			reemplazarValores(tuit, diasDeLaSemana);
			System.out.println(tuit.getTexto());
		}
		
		for(Tuit tuit: noPublicidad){
			reemplazarValores ( tuit, prepositions );
			reemplazarValores(tuit, determinantes );
			reemplazarValores(tuit, signosDePuntacion);
			reemplazarValores(tuit, pronombres);
			reemplazarValores(tuit, diasDeLaSemana);
		}
		
		for ( Tuit tuit : publicidad )
		{
			obtenerNumeroDeCorrespondencias( tuit );
		}
		getNumberOfUrls(publicidad);
		//getNumberOfUrls(noPublicidad);
		getNumberOfMentions(publicidad);
		//getNumberOfMentions(noPublicidad);
	}
	
	public static void obtenerNumeroDeCorrespondencias ( Tuit tuit )
	{
		System.out.println(tuit.getTexto());
		String [] palabras = tuit.getTexto().split(" ");
		for ( String palabra : palabras )
		{
			if ( Utilidades.correspondencia("regalo", palabra) )
			{
				System.out.println("Correspondencia 1");
			}
			if ( Utilidades.correspondencia("compra", palabra) )
			{
				System.out.println("Correspondencia 2");
			}
			
		}
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
