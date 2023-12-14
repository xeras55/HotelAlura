package com.alura.jdbc.views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.alura.jdbc.controller.HuespedController;
import com.alura.jdbc.controller.ReservaController;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
//import java.util.Date;
import java.sql.Date;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {
	private static HuespedController HuespedController;
	private static ReservaController ReservaController;
	private JComboBox<Format> txtTipoDeBusqueda;
	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHuesped;
	private JLabel labelAtras;
	private JLabel labelExit;
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Busqueda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtBuscar.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(331, 62, 280, 42);
		contentPane.add(lblNewLabel_4);

		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);

		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		modelo = (DefaultTableModel) tbReservas.getModel();
		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Fecha Check In");
		modelo.addColumn("Fecha Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pago");
		// modelo.addColumn("Habitacion");
		JScrollPane scroll_table = new JScrollPane(tbReservas);
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), scroll_table, null);
		scroll_table.setVisible(true);

		txtTipoDeBusqueda = new JComboBox();
		txtTipoDeBusqueda.setBounds(350, 128, 170, 20);
		txtTipoDeBusqueda.setBackground(SystemColor.text);
		txtTipoDeBusqueda.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtTipoDeBusqueda.setModel(new DefaultComboBoxModel(new String[] {
				"Tipo de busqueda", "ID", "Nombre y fecha de nacimiento"
		}));
		txtTipoDeBusqueda.setEnabled(false);
		contentPane.add(txtTipoDeBusqueda);

		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
		modeloHuesped.addColumn("Número de Huesped");
		modeloHuesped.addColumn("Nombre");
		modeloHuesped.addColumn("Apellido");
		modeloHuesped.addColumn("Fecha de Nacimiento");
		modeloHuesped.addColumn("Nacionalidad");
		modeloHuesped.addColumn("Telefono");
		modeloHuesped.addColumn("Número de Reserva");
		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")), scroll_tableHuespedes,
				null);
		scroll_tableHuespedes.setVisible(true);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(panel.getSelectedIndex());
				if (panel.getSelectedIndex() == 0) {
					txtTipoDeBusqueda.setEnabled(false);
					txtTipoDeBusqueda.setSelectedIndex(0);
				} else {
					txtTipoDeBusqueda.setEnabled(true);
				}
			}
		});

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);

		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);

			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);

		final JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);

		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);

		final JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) { // Al usuario pasar el mouse por el botón este cambiará de color
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) { // Al usuario quitar el mouse por el botón este volverá al estado original
				btnexit.setBackground(Color.white);
				labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);

		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);
		// !funcion para busvar agregada con parametros de id, nombre y fecha de
		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				limpiarTabla();
				limpiarTablaReservas();
				ArrayList<String> separ = new ArrayList<>();
				ArrayList<String> fechaSeparadaArray = new ArrayList<>();
				String valor = txtBuscar.getText();

				if (valor == null || valor.length() <= 0) {
					JOptionPane.showMessageDialog(null, "Ingrese los datos correctos", "Formato incorrecto",
							JOptionPane.WARNING_MESSAGE);
				} else {
					try {
						int selected = panel.getSelectedIndex();
						if (selected == 0) {
							Long valorLong = Long.parseLong(valor);
							listarReservaPorId(valorLong);
						} else {
							valor = txtBuscar.getText();
							Integer tipoDebusqueda = txtTipoDeBusqueda.getSelectedIndex();
							if (tipoDebusqueda == 1) {
								// System.out.println("Busqueda Por id");
								Long valorLong = Long.parseLong(valor);
								listarHuespedPorId(valorLong);
							} else if (tipoDebusqueda == 2) {
								String nombre = txtBuscar.getText();
								if (nombre == null) {
									JOptionPane.showMessageDialog(null, "Favor de ingresar los datos", "Formato vacio",
											JOptionPane.WARNING_MESSAGE);
								}
								String nombreSeparado = null;
								String fechaSeparada = null;
								SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
								java.sql.Date fechaConvertida = null;
								java.util.Date fechaString = null;
								String stringFechaa = null;
								String[] arrayStringFecha = null;
								String[] arrayDatosSeparados = nombre.split(" ");

								for (String i : arrayDatosSeparados) {
									separ.add(i);
								}
								try {
									stringFechaa = fechaSeparada = separ.get(1);
									arrayStringFecha = stringFechaa.split("/");
									System.out.println(stringFechaa);
									for (String j : arrayStringFecha) {
										fechaSeparadaArray.add(j);
									}
									String diaDeArray = fechaSeparadaArray.get(0);
									String mesDeArray = fechaSeparadaArray.get(1);
									String anoDeArray = fechaSeparadaArray.get(2);

									if (diaDeArray.length() <= 1) {
										JOptionPane.showMessageDialog(null, "Dia incorrecto", "Formato incorrecto",
												JOptionPane.WARNING_MESSAGE);
									}
									if (mesDeArray.length() <= 1) {
										JOptionPane.showMessageDialog(null, "Mes incorrecto", "Formato incorrecto",
												JOptionPane.WARNING_MESSAGE);
									}
									if (anoDeArray.length() < 4) {
										JOptionPane.showMessageDialog(null, "Año incorrecto", "Formato incorrecto",
												JOptionPane.WARNING_MESSAGE);
									}

									try {
										nombreSeparado = separ.get(0);
										fechaSeparada = separ.get(1);
									} catch (IndexOutOfBoundsException IOOB) {
										JOptionPane.showMessageDialog(null, "Formato invalido",
												"El formato ingresado no puede ser buscado o esta vacio",
												JOptionPane.WARNING_MESSAGE);
									}
									try {
										fechaString = formato.parse(fechaSeparada);
										fechaConvertida = new java.sql.Date(fechaString.getTime());
									} catch (ParseException e1) {
										JFrame jframeSinDatosValidos = new JFrame();
										JOptionPane.showMessageDialog(null, "El formato ingresado no puede ser buscado", "Formato invalido",
												JOptionPane.WARNING_MESSAGE);
									}
									listarHuespedPorNombreFecha(nombreSeparado, fechaConvertida);

								} catch (IndexOutOfBoundsException ioobe) {
									JOptionPane.showMessageDialog(null, "El formato ingresado no puede ser buscado", "Formato invalido",
											JOptionPane.WARNING_MESSAGE);
								}
							}
						}
					} catch (NumberFormatException e2) {
						System.out.println("No tengo nigun valor");
						JFrame jframeSinDatosValidos = new JFrame();
						JOptionPane.showMessageDialog(null, "No has ingresado ningun valor", "Valor no valido",
								JOptionPane.WARNING_MESSAGE);
					}
				}

			}
		});
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);

		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));

		JPanel btnEditar = new JPanel();
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);

		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selected = panel.getSelectedIndex();
				if (selected == 0) {
					modificarValoresReservas();
				} else if (selected == 1) {
					modificarValores();

				}
			}
		});

		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);

		JPanel btnEliminar = new JPanel();
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);

		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selected = panel.getSelectedIndex();
				if (selected == 0) {
					Long id = Long.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
					borrarReservas(id);
				} else if (selected == 1) {
					Long id = Long.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
					borrarHuesped(id);
				}
			}
		});

		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);
	}

	// Código que permite mover la ventana por la pantalla según la posición de "x"
	// y "y"
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}

	private void listarReservaPorId(Long id) {
		ReservaController = new ReservaController();

		var listaReservas = ReservaController.listarPorId1(id);
		listaReservas.forEach(reserva -> modelo.addRow(
				new Object[] { reserva.getId(),
						reserva.getFecha_de_entrada(),
						reserva.getFecha_de_salida(),
						reserva.getValor(),
						reserva.getForma_de_pago() }));
	}

	private void listarHuespedPorId(Long id) {
		HuespedController = new HuespedController();

		var listaHuespedes = HuespedController.listarPorId(id);
		listaHuespedes.forEach(huesped -> modeloHuesped.addRow(
				new Object[] { huesped.getId(),
						huesped.getNombre(),
						huesped.getApellido(),
						huesped.getfecha_de_nacimiento(),
						huesped.getNacionalidad(),
						huesped.getTelefono(),
						huesped.getId_reserva()
				}));

	}

	private void listarHuespedPorNombre(String nombre) {
		HuespedController = new HuespedController();

		var listaHuespedes = HuespedController.listarPorNombre(nombre);
		listaHuespedes.forEach(huesped -> modeloHuesped.addRow(
				new Object[] { huesped.getId(),
						huesped.getNombre(),
						huesped.getApellido(),
						huesped.getfecha_de_nacimiento(),
						huesped.getNacionalidad(),
						huesped.getTelefono()
				}));
	}

	private void listarHuespedPorNombreFecha(String nombre, Date cum) {
		HuespedController = new HuespedController();

		var listaHuespedes = HuespedController.listarPorNombreFecha(nombre, cum);
		listaHuespedes.forEach(huesped -> modeloHuesped.addRow(
				new Object[] { huesped.getId(),
						huesped.getNombre(),
						huesped.getApellido(),
						huesped.getfecha_de_nacimiento(),
						huesped.getNacionalidad(),
						huesped.getTelefono(),
						huesped.getId_reserva()
				}));
	}

	private void limpiarTabla() {
		int vector = modeloHuesped.getDataVector().size();
		for (int i = vector - 1; i >= 0; i--) {
			modeloHuesped.removeRow(i);
		}
	}

	private void limpiarTablaReservas() {
		int vector = modelo.getDataVector().size();
		for (int i = vector - 1; i >= 0; i--) {
			modelo.removeRow(i);
		}
	}

	private void modificarValores() {
		HuespedController = new HuespedController();
		if (tbHuespedes.getSelectedRow() < 0 || tbHuespedes.getSelectedColumn() < 0) {
			JOptionPane.showMessageDialog(this, "Por favor, elije un item", "WARNING", JOptionPane.WARNING_MESSAGE);
		} else {

			Long id = Long.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
			String nombre = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 1);
			String apellido = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 2);
			// java.sql.Date fechaDeNacimiento = (java.sql.Date)
			// modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 3);
			String entrada = modelo.getValueAt(tbReservas.getSelectedRow(), 3).toString().trim();
			Date fechaDeNacimiento = Date.valueOf(entrada);
			String nacionalidad = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 4);
			String telefono = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 5);

			HuespedController.modificarHuesped(nombre, apellido, fechaDeNacimiento, nacionalidad, telefono, id);
			JOptionPane.showMessageDialog(this, "El huesped número " + id + " se ha modificado.", "INFORMATION",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void borrarHuesped(Long id) {
		HuespedController = new HuespedController();
		HuespedController.borrarHuesped(id);
	}

	private void modificarValoresReservas() {
		ReservaController = new ReservaController();
		if (tbReservas.getSelectedRow() < 0 || tbReservas.getSelectedColumn() < 0) {
			JOptionPane.showMessageDialog(this, "Por favor, selecciona una reserva!", "WARNING", JOptionPane.WARNING_MESSAGE);
		} else {
			Long id = Long.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());

			String entrada = modelo.getValueAt(tbReservas.getSelectedRow(), 1).toString().trim();
			Date fechaEntrada = Date.valueOf(entrada);
			String salida = modelo.getValueAt(tbReservas.getSelectedRow(), 2).toString().trim();
			Date fechaSalida = Date.valueOf(salida);
			Double valor = Double.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 3).toString().trim());
			String formaPago = modelo.getValueAt(tbReservas.getSelectedRow(), 4).toString().trim();
			ReservaController.editarReservas(fechaEntrada, fechaSalida, valor, formaPago, id);
			JOptionPane.showMessageDialog(this, "La reserva número " + id + " se ha modificado.", "INFORMATION",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void borrarReservas(Long id) {
		ReservaController = new ReservaController();
		ReservaController.borrarReservas(id);
	}

}
