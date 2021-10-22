package View;

public class Menu {
	
	
	public String menu() {
		String menu;
		
		menu="\n "
				+ "\r \n"
				+ "1. Insertar nuevo artista \r\n"
				+ "2. Insertar nuevo disco\r\n"
				+ "3. Mostrar los artistas registrados\r\n"
				+ "4. Consultar los datos del artista X y sus discos, donde X será el nombre del artista\r\n"
				+ "5. Modificar datos de un artista r\n"
				+ "6. Eliminar un artista junto con todos sus discos\r\n"
				+ "0. Salir\r\n";
		
		return menu;
	}

}
