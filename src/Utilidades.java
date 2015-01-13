
public class Utilidades {

	public static boolean correspondencia ( String palabraClave , String palabra )
	{
		int aciertos = 0;
		
		for ( int i = 0; i < palabraClave.length() ; i++ )
		{
			char letra = palabra.charAt(i);
			char letraClave = palabraClave.charAt(i);
			
			if ( letraClave == letra )
			{
				aciertos++;
			}
		}
		
		int lengthPalabra = palabra.length();
		int porcentaje = ( aciertos * 100 ) / lengthPalabra;
		return porcentaje > 55;
		
	}
	
	
}
