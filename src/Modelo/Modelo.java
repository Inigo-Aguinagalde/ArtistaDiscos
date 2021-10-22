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


	public void todosArtistas() {

		String sql= "select * from artista";
		ResultSet result;
		

		try(Connection conn = Conection.connect();
				PreparedStatement pst = conn.prepareStatement(sql)) {
			
			result = pst.executeQuery();

			while(result.next()) {
				System.out.println(result.getInt("id")+"| nombre:"+result.getString("nombre")+"| apellido: "+result.getString("apellido")+"| localidad: "+result.getString("localidad"));
			}


		}catch(SQLException e) {
			e.printStackTrace();
		}

		

	}

}
