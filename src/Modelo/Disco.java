package Modelo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Disco {


	private int id;
	private String fecha;
	private String nombre;
	private int id_artista;
	private Scanner sc;
	private Modelo modelo;
	


	public Disco(Modelo modelo,String nombre,String fecha,int id_artista) {
		this.sc=sc;
		this.modelo=modelo;
		setNombre(nombre);
		setFecha(fecha);
		setId_artista(id_artista);
		
		modelo.insertarDisco(getNombre(), getFecha(), getId_artista());
		
		
		
		
		
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId_artista() {
		return id_artista;
	}

	public void setId_artista(int id_artista) {
		this.id_artista = id_artista;
	}


}
