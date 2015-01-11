import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainProgram {
	
	public static void main(String[] args) {
		
		ReadCSV reader=new ReadCSV();
		List<Tuit>publicidad=reader.run("Publicidad.csv");
		List<Tuit>noPublicidad=reader.run("NoPublicidad.csv");
		
		String [] prepositions={" a ", " ante ", " bajo ", " cabe ", " con ", " contra ", " de ", " desde ", " durante ", " en ", " entre ", " hacia ", " hasta ", " mediante ", " para ", " por ", " según ", " sin ", " so ", " sobre ", " tras ", " versus ", " vía ", "la ", " si "};		
		
		String [] determinantes = { " su ", " al ", " esta ", " ese " , " mi ", " la ", " el ", " lo ", " las ", " los " , " l@s ", " tus ", " ellos ", " ellas ", " tu ", " un ", " una ", " del ", " y ", " o ", " nuestras ", " nuestros ", " cualquier "};
		
		String [] signosDePuntacion = { ";", "¿", "¡", "!", ": ", " ? "}; 
		
		for(Tuit tuit: publicidad){
			for(int i=0;i<prepositions.length;i++){
				tuit.setTexto(tuit.getTexto().toLowerCase().replaceAll(prepositions[i], " "));
			}
			for(int i=0; i < determinantes.length;i++) {
				tuit.setTexto(tuit.getTexto().toLowerCase().replaceAll(determinantes[i], " "));
			}
			for(int i=0; i < signosDePuntacion.length;i++) {
				tuit.setTexto(tuit.getTexto().toLowerCase().replaceAll(signosDePuntacion[i], " "));
			}
			System.out.println(tuit.getTexto());
		}
		
		for(Tuit tuit: noPublicidad){
			for(int i=0;i<prepositions.length;i++){
				tuit.setTexto(tuit.getTexto().toLowerCase().replaceAll(prepositions[i], " "));
			}
			for(int i=0; i < determinantes.length;i++) {
				tuit.setTexto(tuit.getTexto().toLowerCase().replaceAll(determinantes[i], " "));
			}
			for(int i=0; i < signosDePuntacion.length;i++) {
				tuit.setTexto(tuit.getTexto().toLowerCase().replaceAll(signosDePuntacion[i], " "));
			}
		}
		
		getNumberOfUrls(publicidad);
		//getNumberOfUrls(noPublicidad);
		getNumberOfMentions(publicidad);
		//getNumberOfMentions(noPublicidad);
	}
	
	public static void getNumberOfUrls(List<Tuit>tuits){
		String lRegex = "(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
	    Pattern pattern = Pattern.compile(lRegex);
		for(Tuit tuit: tuits){
			int numberOfURLs=0;
			System.out.println(tuit.getTexto());
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
