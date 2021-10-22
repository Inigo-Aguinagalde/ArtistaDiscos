package View;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controller.Ordenes;
import Modelo.Artista;
import Modelo.Disco;
import Modelo.Modelo;


public class PaginaPrincipal {
	Menu menu = new Menu();
	Modelo modelo = new Modelo();
	Ordenes or = new Ordenes(modelo);
	
	public void mostrarMenu() {
		Scanner sc = new Scanner(System.in);
		boolean error =true;
		int usuario=0;


		while(true) {

			System.out.println(menu.menu());
			
			while(error) {
				try {
					usuario=sc.nextInt();
					if(usuario<0||usuario>7) {
						System.out.println("El numero introducido no es correcto");
						sc.nextLine();

					}else {
						error=false;
					}

				}catch(InputMismatchException e) {
					e.printStackTrace();
				}

			}




			sc.nextLine();

			switch (usuario) {
			case 0:	System.out.println("Termina la aplicación");
			System.exit(0);
			case 1: ;
			String nombre_artista;
			String apellido;
			String localidad;
			System.out.println("introduzca el nombre del artista");
			nombre_artista=sc.nextLine();
			
			System.out.println("Intoduzca el apellido del artista");
			apellido=sc.nextLine();
			
			System.out.println("Introduzca la localidad del artista");
			localidad=sc.nextLine();
			
			or.datosArtistas(nombre_artista, apellido, localidad);
			break; // cargar productos
			
			
			case 2: ;
			String nombre_disco;
			int id_artista;
			boolean repetir=true;
			String date;
			System.out.println("introduzca el nombre del disco");
			nombre_disco=sc.nextLine();
			
			System.out.println("Intoduzca la fecha de salida del disco");
			System.out.println("Introduzca primero el dia, despues el mes y por ultimo el año");

			int dia = 0;
			while(repetir) {
				try {
					dia=sc.nextInt();
					if(dia>30 || dia<=0) {
						System.out.println("El dia no es correcto");
					}else {
						repetir=false;
					}
				}catch(InputMismatchException e) {
					e.printStackTrace();
					sc.next();
				}

			}

			repetir=true;
			System.out.println("Introduzca el mes");
			int mes = 0;
			while(repetir) {
				try {
					mes=sc.nextInt();
					if(mes>12 || mes<=0) {
						System.out.println("El mes no es correcto");
					}else {
						repetir=false;
					}
				}catch(InputMismatchException e) {
					e.printStackTrace();
					sc.next();
				}

			}

			repetir=true;
			System.out.println("Introduzca el año");
			int año = 0;
			while(repetir) {
				try {
					año=sc.nextInt();

					repetir=false;
				}catch(InputMismatchException e) {
					e.printStackTrace();
					sc.next();
					repetir=true;
				}

			}
			date = dia+"/"+mes+"/"+año;
			String fecha = date;

			
			System.out.println("Introduzca el id del artista");
			id_artista=sc.nextInt();
			or.datosDiscos(nombre_disco,fecha,id_artista);
			break;
			case 3: ;
			or.todosArtistas();
			
			break;
			case 4: ;
			
			break;
			case 5: ;
			
			break;
			case 6: ;
			
			break;
			case 7: ;
			System.exit(0);
			break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + usuario);
			}
			System.out.println("Pulse cualquier tecla"+usuario);
			sc.nextLine();
			System.out.println(usuario);
		}

	}

}
