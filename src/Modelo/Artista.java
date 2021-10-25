package Modelo;

import java.util.Scanner;

public class Artista {

	private int id;
	private String nombre;
	private String apellido;
	private String localidad;
	Modelo modelo;
	Scanner sc;
	
	public Artista(Scanner sc, Modelo modelo) {
		this.sc=sc;
		this.modelo=modelo;
		
		
		
		modelo.insertarArtista(getNombre(), getApellido(), getLocalidad());
		
	}


	public Artista(Modelo modelo2, String nombre2, String apellido2, String localidad2) {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getLocalidad() {
		return localidad;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	public void mostrarArtista() {
		
		System.out.println("id: "+id+" nombre: "+nombre+" apellido: "+apellido+" localidad: "+localidad);
		
	}
	
	
}
