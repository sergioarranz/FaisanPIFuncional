package baseDeDatos;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
	private static Connection conexion;
	private String user;
	private String pwd;
	private String db;
	
	public Conexion(){
		this.cargar();
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(InstantiationException | IllegalAccessException | ClassNotFoundException e){
			System.out.println("error al buscar el driver mysql");
			e.printStackTrace();
		}
		try{
			conexion=DriverManager.getConnection("jdbc:mysql://"+db, user,pwd);
			System.out.println("conexion realizada con exito");
		}catch(SQLException e){
			System.out.println("error en la conexion");
			e.printStackTrace();
			
		}
	}
	
	public void cargar() {
		FileInputStream fileIn = null;
		try {
			Properties configProperty = new Properties();
			File file = new File("config.ini");
			fileIn = new FileInputStream(file);
			configProperty.load(fileIn);
			
			user=configProperty.getProperty("user");
			pwd=configProperty.getProperty("pwd");
			db=configProperty.getProperty("db");
			System.out.println(""+user+pwd+db);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConexion() {
		return conexion;
	}

	public static void setConexion(Connection conexion) {
		Conexion.conexion = conexion;
	}
	

}