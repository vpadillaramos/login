package com.vpr.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import com.vpr.login.ui.Login;
import com.vpr.login.ui.Vista;

public class Controlador implements ActionListener{
	private Vista vista;
	private Modelo modelo;
	private Login login;
	
	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		
		//conecto con la base de datos
		try {
			modelo.conectar();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		//pruebo a iniciar sesion
		ventanaLogin();
		//addListeners();
		
		//desconecto de la base de datos
		try {
			modelo.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//Metodos
	private void ventanaLogin() {
		//lanzo la ventana del login
		
		login = new Login();
		
		
	}
	
	public void addListeners() {
		login.btEntrar.addActionListener(this);
		login.btCancelar.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "entrar":
			try {
				if(modelo.iniciarSesion(login.tfUsuario.getText(), login.tfContra.getText())) 
					login.tfUsuario.setText("CONECTADO");
				else
					login.tfUsuario.setText("ERROR");
				
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			break;
		}
	}
}
