package Controller;

import java.sql.ResultSet;
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

	public ResultSet todosArtistas() {
		// TODO Auto-generated method stub
		ResultSet result;
		result = modelo.todosArtistas();
		return result;
	}
	
	public void nombreArtista() {
		
	}

	public ResultSet buscarArtista(String artista) {
		// TODO Auto-generated method stub
		ResultSet result;
		result= modelo.buscarArtista(artista);
		
		return result;
	}

	public void modificarArtista(String newName, String newApellido, String newLocalidad,String nombre_artista) {
		// TODO Auto-generated method stub
		modelo.modificarArtista(newName, newApellido, newLocalidad,nombre_artista);
	}



}
