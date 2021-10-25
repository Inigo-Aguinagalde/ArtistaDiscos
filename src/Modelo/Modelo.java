package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class Modelo {



	public Modelo() {

	}




	public void insertarArtista(String nombre,String apellido,String localidad) {
		String sql= "insert into artista(nombre,apellido,localidad) values (?,?,?)";

		try(Connection conn = Conection.connect();
				PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1,nombre);
			pst.setString(2,apellido);
			pst.setString(3,localidad);

			pst.executeUpdate();


		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

	public void insertarDisco(String nombre,String fecha,int id) {
		String sql= "insert into disco(nombre,fecha_publi,id_artista) values (?,?,?)";

		try(Connection conn = Conection.connect();
				PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1,nombre);
			pst.setString(2,fecha);
			pst.setInt(3,id);

			pst.executeUpdate();


		}catch(SQLException e) {
			e.printStackTrace();
		}

	}


	public ResultSet todosArtistas() {

		String sql= "select * from artista";
		ResultSet result=null;
		

		try(Connection conn = Conection.connect();
				PreparedStatement pst = conn.prepareStatement(sql)) {
			
			result = pst.executeQuery();

			


		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		

	}




	public ResultSet buscarArtista(String artista) {
		// TODO Auto-generated method stub
		ResultSet result = null;
		String sql="select d.nombre,d.fecha_publi,d.id,a.nombre from disco d,artista a where d.id_artista =a.id and a.nombre =?";
		
		try(Connection conn = Conection.connect();
				PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1,artista);
			result = pst.executeQuery();

			


		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	public void modificarArtista(String nombre,String apellido,String localidad,String nombre_artista) {
		String sql="update artista set name=?, apellido=?, localiad=? where nombre=?";
		
		try(Connection conn = Conection.connect();
				PreparedStatement pst = conn.prepareStatement(sql)){
			
			pst.setString(1, nombre);
			pst.setString(2, apellido);
			pst.setString(3,localidad);
			pst.setString(4,nombre_artista);
			
			pst.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
