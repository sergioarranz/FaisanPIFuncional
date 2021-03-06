package Vista;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import ClasesTabla.Actividad;
import ClasesTabla.Espacio;
import ClasesTabla.Subvencion;
import Controlador.Controlador;
import Controlador.ControladorImpl;
import Modelo.Modelo;
import Modelo.ModeloImpl;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SubvOptions extends JFrame implements Vista{

	private ControladorImpl controlador;
	private ModeloImpl modelo;
	
	private JPanel contentPane;
	private JFrame frame;
	private JTextField txtDateFrom;
	private JTextField txtMoney;
	private JLabel lblInfo;
	private JTextField txtcif;
	private JTextField txtprueba;

	public SubvOptions(ControladorImpl con) {
		this.controlador=con;
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 910, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_left = new JPanel();
		panel_left.setBackground(new Color(240, 240, 240));
		panel_left.setBounds(0, 0, 637, 550);
		contentPane.add(panel_left);
		panel_left.setLayout(null);
		
		JLabel lblAdd = new JLabel("Añadir");
		lblAdd.setForeground(Color.BLACK);
		
		JLayeredPane MultPanel = new JLayeredPane();
		MultPanel.setBounds(0, 58, 637, 492);
		panel_left.add(MultPanel);
		MultPanel.setLayout(new CardLayout(0, 0));
		
		
		JPanel add_panel = new JPanel();
		add_panel.setBackground(Color.WHITE);
		MultPanel.add(add_panel, "name_23382852103736");
		
		JPanel doc_panel = new JPanel();
		doc_panel.setBackground(new Color(100, 149, 237));
		MultPanel.add(doc_panel, "name_23357301890851");
		
		
		
		
		add_panel.setLayout(null);
		txtDateFrom = new JTextField();
		txtDateFrom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtDateFrom.setText("");
			}
		});
		txtDateFrom.setForeground(UIManager.getColor("FormattedTextField.inactiveForeground"));
		txtDateFrom.setDisabledTextColor(new Color(255, 255, 255));
		//txtName.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtDateFrom.setFont(controlador.getSegoeui().deriveFont(Font.PLAIN,12));
		txtDateFrom.setText("  *Fecha solicitud");
		txtDateFrom.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, null));
		txtDateFrom.setBounds(20, 62, 210, 33);
		add_panel.add(txtDateFrom);
		txtDateFrom.setColumns(10);
		txtDateFrom.setBorder(BorderFactory.createCompoundBorder(txtDateFrom.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		txtMoney = new JTextField();
		txtMoney.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMoney.setText("");
			}
		});
		txtMoney.setForeground(UIManager.getColor("FormattedTextField.inactiveForeground"));
		txtMoney.setDisabledTextColor(new Color(255, 255, 255));
		//txtSurname.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtMoney.setFont(controlador.getSegoeui().deriveFont(Font.PLAIN,12));
		txtMoney.setText("  Importe");
		txtMoney.setColumns(10);
		txtMoney.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, null));
		txtMoney.setBounds(278, 62, 140, 33);
		add_panel.add(txtMoney);
		txtMoney.setBorder(BorderFactory.createCompoundBorder(txtMoney.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		JLabel lblSubvTitle = new JLabel("Solicitud Subvención");
		//lblRepTitle.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblSubvTitle.setFont(controlador.getSegoeui().deriveFont(Font.PLAIN,18));
		lblSubvTitle.setForeground(new Color(128, 128, 128));
		lblSubvTitle.setBounds(20, 20, 170, 30);
		add_panel.add(lblSubvTitle);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(UIManager.getColor("ComboBox.background"));
		separator_2.setBounds(6, 107, 637, 12);
		add_panel.add(separator_2);
		
		JCheckBox chckbxAgree = new JCheckBox("El cliente aporta la documentación necesaria para el registro de la nueva subvención");
		chckbxAgree.setForeground(new Color(128, 128, 128));
		//chckbxAgree.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		chckbxAgree.setFont(controlador.getSegoeui().deriveFont(Font.PLAIN,12));
		chckbxAgree.setBounds(23, 382, 592, 23);
		add_panel.add(chckbxAgree);
		
		JButton btnRegister = new JButton("Registrar");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.insertarSubvencion();
				txtprueba.setForeground(new Color(42, 239, 35));
				txtprueba.setText("La subvención para la asociación con CIF:"+ getTxtcif() + "ha sido registrada satisfactoriamente.");
			}
		});
		//btnRegister.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnRegister.setFont(controlador.getCentury().deriveFont(Font.BOLD,13));
		btnRegister.setForeground(new Color(128, 128, 128));
		btnRegister.setBounds(21, 417, 140, 39);
		add_panel.add(btnRegister);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setForeground(new Color(128, 128, 128));
		//btnCancel.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btnCancel.setFont(controlador.getCentury().deriveFont(Font.BOLD,13));
		btnCancel.setBounds(173, 417, 140, 39);
		add_panel.add(btnCancel);
		
		lblInfo = new JLabel("Los campos marcados con * son obligatorios");
		lblInfo.setForeground(new Color(128, 128, 128));
		//lblInfo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblInfo.setFont(controlador.getSegoeui().deriveFont(Font.PLAIN,12));
		lblInfo.setBounds(365, 27, 284, 16);
		add_panel.add(lblInfo);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(231, 62, 28, 33);
		add_panel.add(dateChooser);
		
		JLabel lblBuscarActividad = new JLabel("Buscar Asociación");
		lblBuscarActividad.setForeground(Color.GRAY);
		lblBuscarActividad.setFont(null);
		lblBuscarActividad.setBounds(20, 119, 170, 30);
		add_panel.add(lblBuscarActividad);
		
		txtcif = new JTextField();
		txtcif.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtcif.setText("");
			}
		});
		txtcif.setText("  *Introduzca CIF");
		txtcif.setForeground(Color.GRAY);
		txtcif.setFont(controlador.getSegoeui().deriveFont(Font.PLAIN,12));
		txtcif.setDisabledTextColor(Color.WHITE);
		txtcif.setColumns(10);
		txtcif.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, null));
		txtcif.setBounds(20, 151, 115, 41);
		add_panel.add(txtcif);
		
		JLabel lblNewLabel_1 = new JLabel("*Para dar de alta la nueva subvención es obligatorio que esté vinculada a una asociación");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(controlador.getSegoeui().deriveFont(Font.PLAIN,12));
		lblNewLabel_1.setBounds(20, 218, 563, 16);
		add_panel.add(lblNewLabel_1);
		
		txtprueba = new JTextField();
		txtprueba.setBorder(null);
		txtprueba.setBounds(20, 456, 595, 30);
		txtprueba.setFont(controlador.getSegoeui().deriveFont(Font.BOLD,13));
		add_panel.add(txtprueba);
		txtprueba.setColumns(10);
		
		
		
		lblAdd.setBounds(78, 30, 52, 16);
		//lblAdd.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblAdd.setFont(controlador.getSegoeui().deriveFont(Font.BOLD,14));
		panel_left.add(lblAdd);
		
		JSeparator sep_header = new JSeparator();
		sep_header.setBounds(0, 53, 637, 12);
		panel_left.add(sep_header);
		sep_header.setForeground(new Color(128, 128, 128));
		
		JPanel panel_right = new JPanel();
		panel_right.setBackground(new Color(32,47,90));
		panel_right.setBounds(637, 0, 273, 550);
		contentPane.add(panel_right);
		panel_right.setLayout(null);
		
		doc_panel.setVisible(false);
		add_panel.setVisible(false);
	}
	
	@Override
	public void setControlador(Controlador controlador) {
		this.controlador = (ControladorImpl) controlador;
	}

	@Override
	public void setModelo(Modelo modelo) {
		this.modelo = (ModeloImpl) modelo;
	}

	public String getTxtDateFrom() {
		return txtDateFrom.getText();
	}

	public String getTxtMoney() {
		return txtMoney.getText();
	}

	public String getTxtcif() {
		return txtcif.getText();
	}
}

