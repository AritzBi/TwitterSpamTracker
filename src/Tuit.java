import java.util.HashMap;

public class Tuit {
	private String texto;
	private int seguidores;
	private int siguiendo;
	private int tweets;
	private int numberOfURLs;
	private int numberOfMentions;
	private HashMap<String,Integer> hashMap;
	
	public static String descuento = "descuent";
	public static String oferta = "ofert";
	public static String compra = "compr";
	public static String producto = "product";
	public static String PRUEBA = "prueb";
	public static String REBAJA = "rebaj";
	public static String PORCENTAJE = "%";
	public static String PERSONA = "person";
	public static String VIDEOJUEGO = "videojueg";
	public static String AMOR = "amor";
	public static String AGRADECER = "agradec";
	public static String DTO = "dto";
	public static String NUEVO = "nuev";
	public static String REGALO = "regal";
	public static String BUSCAR = "busc";
	public static String AHORRO = "ahorr";
	public static String NAVIDAD = "navid";
	public static String ADQUIERE = "adquier";
	public static String FORMA = "form";
	public static String NO = "no";
	public static String CUANDO = "cuand";
	public static String QUERER = "quer";
	public static String ALGO = "algo";
	public static String MUY = "muy";
	public static String TODO = "tod";
	public static String EURO = "€";
	public static String SEGUIR = "segui";

	public Tuit(String texto, int seguidores, int siguiendo, int tweets) {
		this.texto = texto;
		this.seguidores = seguidores;
		this.siguiendo = siguiendo;
		this.tweets = tweets;
		this.numberOfMentions=0;
		this.numberOfURLs=0;
		
		hashMap = new HashMap<String, Integer>();
		hashMap.put(descuento, 0 );
		hashMap.put(oferta, 0 );
		hashMap.put(compra, 0 );
		hashMap.put(producto, 0 );
		hashMap.put(PRUEBA, 0 );
		hashMap.put(REBAJA, 0 );
		hashMap.put(PORCENTAJE, 0 );
		hashMap.put(PERSONA, 0 );
		hashMap.put(VIDEOJUEGO, 0 );
		hashMap.put(AMOR, 0 );
		hashMap.put(AGRADECER, 0 );
		hashMap.put(DTO, 0 );
		hashMap.put(NUEVO, 0 );
		hashMap.put(REGALO, 0 );
		hashMap.put(BUSCAR, 0 );
		hashMap.put(AHORRO, 0 );
		hashMap.put(NAVIDAD, 0 );
		hashMap.put(ADQUIERE, 0 );
		hashMap.put(FORMA, 0 );
		hashMap.put(NO, 0 );
		hashMap.put(CUANDO, 0 );
		hashMap.put(QUERER, 0 );
		hashMap.put(ALGO, 0 );
		hashMap.put(MUY, 0 );
		hashMap.put(TODO, 0 );
		hashMap.put(EURO, 0);
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

	public HashMap<String, Integer> getHashMap() {
		return hashMap;
	}

	public void setHashMap(HashMap<String, Integer> hashMap) {
		this.hashMap = hashMap;
	}

}
