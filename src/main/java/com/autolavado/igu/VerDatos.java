package com.autolavado.igu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import com.autolavado.logica.modelo.Vehiculo;
import com.autolavado.persistencia.Controladora;

public class VerDatos extends JFrame {
	private JPanel panel = new JPanel();
	private DefaultTableModel modeloTabla = null;
	
	private JTable tablaVehiculos = null;
	private JScrollPane scrollTablaVehiculos = null;
	private Controladora controladora = new Controladora();


	private String titulos[] = {"numero", "modelo", "marca", "color", "brillo", "atencion", "observaciones", "nombreDueno",
			"telefonoDueno" };



	private void cargarTabla() {
		tablaVehiculos = new JTable();
		scrollTablaVehiculos = new JScrollPane();
		
		List<Vehiculo> listaVehiculos = controladora.traerVehiculos();


		DefaultTableModel modeloTabla = new DefaultTableModel(titulos, 0) {
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		
		if (listaVehiculos != null) {
			for (Vehiculo vehiculo : listaVehiculos) {
				Object[] objecto = {vehiculo.getNumeroCliente(), vehiculo.getModelo(), vehiculo.getMarca(), vehiculo.getColor(),
						vehiculo.getBrillo(), vehiculo.getAtencionEspecial(), vehiculo.getObservaciones(),
						vehiculo.getDueno().getNombre(), vehiculo.getDueno().getTelefono() };
				modeloTabla.addRow(objecto);
			}
		}
		
		modeloTabla.fireTableDataChanged();
		tablaVehiculos.revalidate();
		
		tablaVehiculos.setModel(modeloTabla);
		tablaVehiculos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollTablaVehiculos.setViewportView(tablaVehiculos);

		scrollTablaVehiculos.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollTablaVehiculos.setBounds(10, 80, 624, 400);
		panel.add(scrollTablaVehiculos);

	}

	public void mostrarMensaje(String mensaje, String tipo, String titulo) {
		JOptionPane optionPane = new JOptionPane();

		if (tipo.equals("ERROR")) {
			optionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
		} else {
			optionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
		}
		optionPane.setVisible(true);
	}

	public VerDatos() {

		setBounds(100, 100, 800, 530);

		getContentPane().setLayout(null);

		
		panel.setBounds(0, 0, 784, 491);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblVerDatos = new JLabel("Ver Datos");
		lblVerDatos.setBounds(318, 5, 147, 37);
		lblVerDatos.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(lblVerDatos);

		
		cargarTabla();


		JLabel lblDatosMascota = new JLabel("Datos Mascota:");
		lblDatosMascota.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDatosMascota.setBounds(10, 38, 147, 31);
		panel.add(lblDatosMascota);

		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tablaVehiculos.getRowCount() > 0) {
					if (tablaVehiculos.getSelectedRow() != -1) {
						int numeroCliente = Integer.parseInt(String.valueOf(tablaVehiculos.getValueAt(tablaVehiculos.getSelectedRow(), 0)));
						
						EditarDatos pantallaEditar = new EditarDatos(numeroCliente);
						pantallaEditar.setVisible(true);
						pantallaEditar.setLocationRelativeTo(null);	
						dispose();



					} else {
						mostrarMensaje("No selecciono ningun vehiculo", "Error", "ERROR");
					}
				} else {
					mostrarMensaje("No hay nada para editar en la tabla", "Error", "ERROR");
				}
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEditar.setBounds(644, 165, 130, 60);
		panel.add(btnEditar);

		JButton btnEliminar = new JButton("ELIMINAR");

		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tablaVehiculos.getRowCount() > 0) {
					if (tablaVehiculos.getSelectedRow() != -1) {
						int numeroCliente = Integer.parseInt(String.valueOf(tablaVehiculos.getValueAt(tablaVehiculos.getSelectedRow(), 0)));
						controladora.borrarConIdCliente(numeroCliente);

						mostrarMensaje("Borrado correctamente", "Borrar", "INFO");
						dispose();
						VerDatos pantalla = new VerDatos();
						pantalla.setVisible(true);
						pantalla.setLocationRelativeTo(null);		


					} else {
						mostrarMensaje("No selecciono ningun vehiculo", "Error", "ERROR");
					}
				} else {
					mostrarMensaje("No hay nada para eliminar en la tabla", "Error", "ERROR");
				}
			}
		});

		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEliminar.setBounds(644, 80, 130, 60);
		panel.add(btnEliminar);

	}

}
