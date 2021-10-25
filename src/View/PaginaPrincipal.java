package View;

import java.sql.ResultSet;
import java.sql.SQLException;
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



		System.out.println(menu.menu());

		while(true) {
			System.out.println(menu.menu());
			int usuario=0;
			boolean error;
			do {
				sc.next();
				try {
					error = false;
					System.out.print("Ingrese un valor entero:");
					usuario = sc.nextInt();
					if(usuario<0||usuario>7) {
						error=true;
						System.out.println("El numero introducido no es correcto");
						sc.next();
					}
				} catch (InputMismatchException ex) {
					System.out.println("Debes introducir un numero entre el 0 y 7.");
					sc.next();
					error = true;
				}
			} while (error);









			switch (usuario) {
			case 0:	System.out.println("Termina la aplicación");
			System.exit(0);
			case 1:
				String nombre_artista;
				String apellido;
				String localidad;
				System.out.println("introduzca el nombre del artista");
				nombre_artista=sc.nextLine();

				System.out.println("Intoduzca el apellido del artista");
				apellido=sc.nextLine();

				System.out.println("Introduzca la localidad del artista");
				localidad=sc.nextLine();

				or.datosArtistas(nombre_artista, apellido, localidad);;

				break; // cargar productos


			case 2:
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
				;
				break;
			case 3: 
				ResultSet resultTodosArtistas;
				resultTodosArtistas = or.todosArtistas();

				try {
					while(resultTodosArtistas.next()) {
						System.out.println(resultTodosArtistas.getInt("id")+"| nombre:"+resultTodosArtistas.getString("nombre")+"| apellido: "+resultTodosArtistas.getString("apellido")+"| localidad: "+resultTodosArtistas.getString("localidad"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				break;
			case 4:
				System.out.println("case 4");
				String artista;
				ResultSet artistaDiscos;
				System.out.println("Introduzca el nombre del artista");
				artista=sc.nextLine();
				artistaDiscos = or.buscarArtista(artista);

				try {
					while(artistaDiscos.next()) {
						System.out.println(artistaDiscos.getInt("id")+"| nombre:"+artistaDiscos.getString("nombre")+"| fecha publicacion: "+artistaDiscos.getString("fecha_publi")+"| nombre del artista: "+artistaDiscos.getString("nombre"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				;



				break;
			case 5: ;
			System.out.println("case 5");
			System.out.println("Introduzca el nombre del artista que quieras modificar");
			String artista_modificar =sc.nextLine();
			String newName = null;
			String newApellido=null;
			String newLocalidad=null;
			int opcion=0;
			boolean submenu=true;
			while(submenu) {
				System.out.println(menu.submenu())	;
				menu.submenu();
				switch (opcion) {
				case 0: 
					submenu=false;
					break;
				case 1: 
					System.out.println("Introduzca el nuevo nombre del artista");
					newName=sc.nextLine();

					break;
				case 2: 
					System.out.println("Introduzca el nuevo apellido del artista");
					newApellido=sc.nextLine();
					break;
				case 3: 
					System.out.println("Introduzca la nueva localidad del artista");
					newLocalidad=sc.nextLine();
					break;

				}

			}
			or.modificarArtista(newName,newApellido,newLocalidad,artista_modificar);
			break;
			case 6:	System.out.println("case 5"); ;

			break;
			case 7: ;
			System.exit(0);
			break;

			}
			usuario=0;
			System.out.println("Pulse cualquier teclas"+usuario);
			sc.nextLine();
			sc.next();
			System.out.println(usuario);


		}

	}

}
