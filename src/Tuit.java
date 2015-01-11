public class Tuit {
	private String texto;
	private int seguidores;
	private int siguiendo;
	private int tweets;
	private int numberOfURLs;
	private int numberOfMentions;

	public Tuit(String texto, int seguidores, int siguiendo, int tweets) {
		this.texto = texto;
		this.seguidores = seguidores;
		this.siguiendo = siguiendo;
		this.tweets = tweets;
		this.numberOfMentions=0;
		this.numberOfURLs=0;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getSeguidores() {
		return seguidores;
	}

	public void setSeguidores(int seguidores) {
		this.seguidores = seguidores;
	}

	public int getSiguiendo() {
		return siguiendo;
	}

	public void setSiguiendo(int siguiendo) {
		this.siguiendo = siguiendo;
	}

	public int getTweets() {
		return tweets;
	}

	public void setTweets(int tweets) {
		this.tweets = tweets;
	}
	
	public int getNumberOfURLs() {
		return numberOfURLs;
	}

	public void setNumberOfURLs(int numberOfURLs) {
		this.numberOfURLs = numberOfURLs;
	}

	public int getNumberOfMentions() {
		return numberOfMentions;
	}

	public void setNumberOfMentions(int numberOfMentions) {
		this.numberOfMentions = numberOfMentions;
	}

	public String toString(){
		return "Texto: "+texto+" Seguidores: "+seguidores+" Siguiendo: "+siguiendo+" Tweets: "+tweets ;
	}

}
