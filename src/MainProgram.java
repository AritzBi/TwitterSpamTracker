import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainProgram {
	
	public static void main(String[] args) {
		ReadCSV reader=new ReadCSV();
		ArrayList<Tuit>publicidad=reader.run("Publicidad.csv");
		ArrayList<Tuit>noPublicidad=reader.run("NoPublicidad.csv");
		String [] prepositions={" a ", " ante ", " bajo ", " cabe ", " con ", " contra ", " de ", " desde ", " durante ", " en ", " entre ", " hacia ", " hasta ", " mediante ", " para ", " por ", " según ", " sin ", " so ", " sobre ", " tras ", " versus ", " vía "};		
		for(Tuit tuit: publicidad){
			for(int i=0;i<prepositions.length;i++){
				tuit.getTexto().replaceAll(prepositions[i], "");
			}
		}
		
		for(Tuit tuit: noPublicidad){
			for(int i=0;i<prepositions.length;i++){
				tuit.getTexto().replaceAll(prepositions[i], "");
			}
		}
		
		//getNumberOfUrls(publicidad);
		//getNumberOfUrls(noPublicidad);
		getNumberOfMentions(publicidad);
		//getNumberOfMentions(noPublicidad);
	}
	
	public static void getNumberOfUrls(ArrayList<Tuit>tuits){
		String lRegex = "(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
	    Pattern pattern = Pattern.compile(lRegex);
		for(Tuit tuit: tuits){
			int numberOfURLs=0;
			System.out.println(tuit.getTexto());
		    Matcher  matcher = pattern.matcher(tuit.getTexto());
		    if(matcher.matches()){
		    	System.out.println("Pito");
		    }
		    while (matcher.find())
		    	numberOfURLs++;
		    System.out.println(numberOfURLs);
		    tuit.setNumberOfURLs(numberOfURLs);
		    
		}
	}
	
	public static void getNumberOfMentions(ArrayList<Tuit>tuits){
		String regex="@[a-z0-9_-]{3,15}";
		
		Pattern pattern = Pattern.compile(regex);
		for(Tuit tuit: tuits){
			int numberOfMentions=0;
			System.out.println(tuit.getTexto());
		    Matcher  matcher = pattern.matcher(tuit.getTexto());
		    while (matcher.find())
		    	numberOfMentions++;
		    System.out.println(numberOfMentions);
		    tuit.setNumberOfMentions(numberOfMentions);
		}
	}
}
