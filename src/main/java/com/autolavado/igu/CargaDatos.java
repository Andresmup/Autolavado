package com.autolavado.igu;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.autolavado.persistencia.Controladora;

public class CargaDatos extends JFrame {

	private JPanel contentPane;
	private JTextField txtModelo;
	private JTextField txtMarca;
	private JTextField txtColor;
	private JTextField txtNombreDueno;
	private JTextField txtTelefonoDueno;
	private Controladora controladora = new Controladora();

	public CargaDatos() {
		setBounds(100, 100, 800, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 789, 494);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cargar Datos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(297, 11, 202, 41);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 63, 356, 363);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Modelo");
		lblNewLabel_2.setBounds(10, 11, 59, 19);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Marca");
		lblNewLabel_2_1.setBounds(10, 47, 59, 19);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Color");
		lblNewLabel_2_2.setBounds(10, 77, 59, 19);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Brillo");
		lblNewLabel_2_3.setBounds(10, 107, 59, 19);
		panel_1.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Atención Especial");
		lblNewLabel_2_4.setBounds(10, 137, 91, 19);
		panel_1.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("Nombre dueño");
		lblNewLabel_2_5.setBounds(10, 178, 91, 19);
		panel_1.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("Tel dueño");
		lblNewLabel_2_6.setBounds(10, 222, 59, 19);
		panel_1.add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_2_5_2 = new JLabel("Observaciones");
		lblNewLabel_2_5_2.setBounds(10, 271, 82, 19);
		panel_1.add(lblNewLabel_2_5_2);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(103, 10, 243, 20);
		panel_1.add(txtModelo);
		txtModelo.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(103, 46, 243, 20);
		panel_1.add(txtMarca);
		
		txtColor = new JTextField();
		txtColor.setColumns(10);
		txtColor.setBounds(103, 77, 243, 20);
		panel_1.add(txtColor);
		
		txtNombreDueno = new JTextField();
		txtNombreDueno.setColumns(10);
		txtNombreDueno.setBounds(103, 177, 243, 20);
		panel_1.add(txtNombreDueno);
		
		txtTelefonoDueno = new JTextField();
		txtTelefonoDueno.setColumns(10);
		txtTelefonoDueno.setBounds(103, 221, 243, 20);
		panel_1.add(txtTelefonoDueno);
		
		final JTextArea txtObservaciones = new JTextArea();
		txtObservaciones.setBounds(102, 268, 244, 73);
		panel_1.add(txtObservaciones);
		
		final JComboBox cmbBrillo = new JComboBox();
		cmbBrillo.setModel(new DefaultComboBoxModel(new String[] {"-", "SI", "NO"}));
		cmbBrillo.setBounds(103, 105, 107, 22);
		panel_1.add(cmbBrillo);
		
		final JComboBox cmbAtencion = new JComboBox();
		cmbAtencion.setModel(new DefaultComboBoxModel(new String[] {"-", "SI", "NO"}));
		cmbAtencion.setBounds(103, 135, 107, 22);
		panel_1.add(cmbAtencion);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\andre\\Desktop\\ORACLE\\Java\\peluqueria-canina\\src\\main\\resources\\imagenes\\logo-vehiculo.png"));
		lblNewLabel_1.setBounds(386, 63, 350, 363);
		panel.add(lblNewLabel_1);
		
		JButton btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtModelo.setText("");
				txtMarca.setText("");
				txtColor.setText("");
				txtNombreDueno.setText("");
				txtTelefonoDueno.setText("");
				txtObservaciones.setText("");
				cmbAtencion.setSelectedIndex(0);
				cmbBrillo.setSelectedIndex(0);
			}
		});
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLimpiar.setBounds(81, 437, 176, 46);
		panel.add(btnLimpiar);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String modelo = txtModelo.getText();
				String marca = txtMarca.getText();
				String color = txtColor.getText();
				String brillo = (String) cmbBrillo.getSelectedItem();
				String atencion = (String) cmbAtencion.getSelectedItem();
				String observaciones = txtObservaciones.getText();
				String nombreDueno = txtNombreDueno.getText();
				String telefonoDueno = txtTelefonoDueno.getText();

				controladora.guardar(modelo,marca,color,brillo,atencion,observaciones,nombreDueno,telefonoDueno);
				
				JOptionPane optionPane = new JOptionPane();
				optionPane.showMessageDialog(null, "Guardado correctamente","Guardado exitoso",JOptionPane.INFORMATION_MESSAGE);
				optionPane.setVisible(true);
				
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnGuardar.setBounds(466, 437, 176, 46);
		panel.add(btnGuardar);
	}
}
