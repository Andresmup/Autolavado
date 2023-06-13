package com.autolavado.igu;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;


	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 734, 515);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Autolavado");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(293, 11, 130, 41);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 90, 300, 414);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnCargarDatos = new JButton("Cargar Datos");
		btnCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargaDatos pantalla = new CargaDatos();
				pantalla.setVisible(true);
				pantalla.setLocationRelativeTo(null);				
			}
		});
		btnCargarDatos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCargarDatos.setBounds(24, 21, 239, 71);
		panel_1.add(btnCargarDatos);
		
		JButton btnVerDatos = new JButton("Ver Datos");
		btnVerDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerDatos pantalla = new VerDatos();
				pantalla.setVisible(true);
				pantalla.setLocationRelativeTo(null);		
			}
		});
		btnVerDatos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVerDatos.setBounds(24, 127, 239, 71);
		panel_1.add(btnVerDatos);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        dispose();
		        System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSalir.setBounds(24, 241, 239, 71);
		panel_1.add(btnSalir);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\andre\\Desktop\\ORACLE\\Java\\peluqueria-canina\\src\\main\\resources\\imagenes\\logo-vehiculo.png"));
		lblNewLabel_1.setBounds(333, 90, 350, 400);
		panel.add(lblNewLabel_1);
	}
}
