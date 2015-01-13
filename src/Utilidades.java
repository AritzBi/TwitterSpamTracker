
public class Utilidades {

	public static boolean correspondencia ( String palabraClave , String palabra )
	{
		int aciertos = 0;
		
		if ( palabraClave != null && !palabraClave.isEmpty() && palabra != null && !palabra.isEmpty())
		{
			int lengthMinimo = 0;
			
			if ( palabraClave.length() < palabra.length() )
				lengthMinimo = palabraClave.length();
			else
				lengthMinimo = palabra.length();
			
			for ( int i = 0; i < lengthMinimo ; i++ )
			{
				char letra = palabra.charAt(i);
				char letraClave = palabraClave.charAt(i);
				
				if ( letraClave == letra )
				{
					aciertos++;
				}
				else
				{
					i = lengthMinimo;
				}
			}
			
			int lengthPalabra = palabra.length();
			int porcentaje = ( aciertos * 100 ) / lengthPalabra;
			return porcentaje > 55;
			
		}

		return false;
	}
	
	public static void main ( String [] args ) {
		System.out.println(correspondencia("regalo", "relájate"));
	}
	
	
}
