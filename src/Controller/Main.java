package Controller;

import Modelo.Conection;
import View.PaginaPrincipal;

public class Main {
	
	public static void main(String [] args) {
		PaginaPrincipal pp = new PaginaPrincipal();
		
		Conection c = new Conection();
		c.connect();
		
		pp.mostrarMenu();
	


		
	}

}
