package com.vpr.login.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.vpr.login.Modelo;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class Login extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	public JTextField tfUsuario;
	public JTextField tfContra;
	public JLabel lblUsuario;
	public JLabel lblContrasea;
	public JButton btEntrar;
	public JButton btCancelar;


	public Login() {
		setTitle("Login");
		setBounds(100, 100, 328, 226);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(131, 65, 117, 20);
		contentPanel.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		tfContra = new JTextField();
		tfContra.setBounds(131, 102, 117, 20);
		contentPanel.add(tfContra);
		tfContra.setColumns(10);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(63, 68, 48, 14);
		contentPanel.add(lblUsuario);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblContrasea.setAlignmentY(Component.TOP_ALIGNMENT);
		lblContrasea.setBounds(43, 105, 81, 14);
		contentPanel.add(lblContrasea);
		
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		btEntrar = new JButton("Entrar");
		btEntrar.setActionCommand("entrar");
		btEntrar.addActionListener(this);
		buttonPane.add(btEntrar);
		getRootPane().setDefaultButton(btEntrar);

		btCancelar = new JButton("Cancelar");
		btCancelar.setActionCommand("cancelar");
		btCancelar.addActionListener(this);
		buttonPane.add(btCancelar);
		
		
		
		/*
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btEntrar = new JButton("Entrar");
				btEntrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btEntrar.setActionCommand("entrar");
				buttonPane.add(btEntrar);
				getRootPane().setDefaultButton(btEntrar);
			}
			{
				JButton btCancelar = new JButton("Cancelar");
				btCancelar.setActionCommand("cancelar");
				buttonPane.add(btCancelar);
			}
		}*/
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true); //la hago modal antes de que se cree
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "entrar":
			try {
				Modelo modelo = new Modelo();
				if(modelo.iniciarSesion(tfUsuario.getText(), tfContra.getText())) {
					System.out.println("CONECTADO");
					setVisible(false);
				}
				else
					System.out.println("ERROR");
				
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			break;
		
		case "cancelar":
			setVisible(false);
			break;
		}
	}
}
