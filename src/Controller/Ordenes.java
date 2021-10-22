package Controller;

import java.util.Scanner;

import Modelo.Artista;
import Modelo.Conection;
import Modelo.Disco;
import Modelo.Modelo;

public class Ordenes {

	Modelo modelo;
	
	public Ordenes(Modelo modelo) {
		// TODO Auto-generated constructor stub
		this.modelo=modelo;
	}

	public void datosArtistas(String nombre,String apellido,String localidad) {
		
		Artista artista = new Artista(modelo,nombre,apellido,localidad);

	}

	public void datosDiscos(String nombre, String fecha, int id_artista) {
		
		Disco disco = new Disco(modelo, nombre,fecha,id_artista);

	}

	public void todosArtistas() {
		// TODO Auto-generated method stub
		
		modelo.todosArtistas();
	}



}
