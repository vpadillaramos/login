package com.vpr.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Modelo {
	//Constantes
	private final String IP = "192.168.34.5";
	private final String BD = "damt";
	private final String USUARIO = "damt";
	private final String CONTRASENA = "damt";
	
	//Variables
	private static Connection conexion;
	private PreparedStatement sentencia = null;
	private ResultSet resultado = null;
	
	//Metodos
	public void conectar() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conexion = DriverManager.getConnection("jdbc:mysql://"+IP+":3306/"+BD, USUARIO, CONTRASENA);
	}
	
	public void desconectar() throws SQLException {
		conexion.close();
	}
	
	public boolean iniciarSesion(String usuario, String contrasena) throws SQLException {
		
		String sentenciaSql = "SELECT id FROM usuarios where usuario = ? AND contrasena = ?";
		
		sentencia = conexion.prepareStatement(sentenciaSql);
		sentencia.setString(1, usuario);
		sentencia.setString(2, contrasena);
		resultado = sentencia.executeQuery();
		
		return resultado.next();
	}
}
