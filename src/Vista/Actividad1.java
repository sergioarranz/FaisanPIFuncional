package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import ClasesTabla.Actividad;
import ClasesTabla.Asociacion;
import Controlador.Controlador;
import Controlador.ControladorImpl;
import Modelo.Modelo;
import Modelo.ModeloImpl;

public class Actividad1 extends JFrame implements Vista {

	private ControladorImpl controlador;
	private ModeloImpl modelo;

	private JPanel contentPane;
	
	private JTable table;

	private JScrollPane scrollPane;
	private JTextField txtName;
	private JTextField txtId;
	private JTextField txtDateFrom;
	private JTextField txtDateTo;

	public Actividad1(ControladorImpl con) {
		controlador=con;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel container = new JPanel();
		container.setBounds(0, 0, 910, 550);
		contentPane.add(container);
		container.setLayout(null);
		
		JPanel menu = new JPanel();
		menu.setBackground(new Color(0, 18, 50));
		menu.setBounds(0, 0, 83, 550);
		container.add(menu);
		menu.setLayout(null);
		
		JLabel lblAssoc = new JLabel("");
		lblAssoc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.pasarAsociaciones();
				dispose();
			}
		});
		lblAssoc.setBounds(18, 83, 45, 55);
		lblAssoc.setIcon(new ImageIcon("img/header-assoc.png"));
		menu.add(lblAssoc);
		
		JLabel lblSubv = new JLabel("");
		lblSubv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.pasarSubvenciones();
				dispose();
			}
		});
		lblSubv.setIcon(new ImageIcon("img/Coins-40.png"));
		lblSubv.setBounds(18, 160, 45, 40);
		menu.add(lblSubv);
		
		JLabel lblActiv = new JLabel("");
		lblActiv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.pasarActividad();
				dispose();
			}
		});
		lblActiv.setIcon(new ImageIcon("img/Activity Feed Filled-40.png"));
		lblActiv.setBounds(18, 231, 61, 40);
		menu.add(lblActiv);
		
		JLabel lblEsp = new JLabel("");
		lblEsp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.pasarEspacioMunicipal();
				dispose();
			}
		});
		lblEsp.setIcon(new ImageIcon("img/Park Bench-40.png"));
		lblEsp.setBounds(18, 301, 61, 40);
		menu.add(lblEsp);
		
		JLabel lblHome = new JLabel("");
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.pasarMenuInicio();
				dispose();
			}
		});
		lblHome.setIcon(new ImageIcon("img/Top Menu-40.png"));
		lblHome.setBounds(18, 16, 45, 55);
		menu.add(lblHome);
		
		JPanel tableContainer = new JPanel();
		tableContainer.setBorder(null);
		tableContainer.setForeground(new Color(192, 192, 192));
		tableContainer.setBackground(new Color(32, 47, 90));
		tableContainer.setBounds(81, 254, 829, 296);
		container.add(tableContainer);
		tableContainer.setLayout(null);
		
				scrollPane = new JScrollPane();
				scrollPane.setBounds(22, 20, 771, 258);
				tableContainer.add(scrollPane);
		
		JPanel filterContainer = new JPanel();
		filterContainer.setBackground(new Color(240, 240, 240));
		filterContainer.setBounds(81, 59, 829, 196);
		container.add(filterContainer);
		filterContainer.setLayout(null);
		
		JLabel lblLogo = new JLabel("Gest-U");
		lblLogo.setBounds(700, 6, 123, 40);
		lblLogo.setFont(controlador.getSegoeui().deriveFont(Font.PLAIN,37));
		filterContainer.add(lblLogo);
		
		JLabel lblSlogan = new JLabel("Experts on management");
		lblSlogan.setFont(controlador.getSegoeui().deriveFont(Font.PLAIN,14));
		lblSlogan.setBounds(665, 39, 158, 26);
		filterContainer.add(lblSlogan);
		
		txtName = new JTextField();
		txtName.setForeground(new Color(128,128,128));
		txtName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtName.setText("");
			}
		});
		txtName.setFont(controlador.getSegoeui().deriveFont(Font.PLAIN,12));
		txtName.setText("Actividad");
		txtName.setBackground(new Color(240, 240, 240));
		txtName.setBorder(null);
		txtName.setBounds(28, 103, 194, 16);
		filterContainer.add(txtName);
		txtName.setColumns(10);
		
		txtId = new JTextField();
		txtId.setForeground(new Color(128,128,128));
		txtId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtId.setText("");
			}
		});
		txtId.setText("Identificador");
		txtId.setFont(controlador.getSegoeui().deriveFont(Font.PLAIN,12));
		txtId.setColumns(10);
		txtId.setBorder(null);
		txtId.setBackground(UIManager.getColor("TabbedPane.selectedTabTitlePressedColor"));
		txtId.setBounds(28, 75, 194, 16);
		filterContainer.add(txtId);
		
		
		
		txtDateFrom = new JTextField();
		txtDateFrom.setForeground(new Color(128,128,128));
		txtDateFrom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtDateFrom.setText("");
			}
		});
		txtDateFrom.setText("Alta desde");
		txtDateFrom.setFont(controlador.getSegoeui().deriveFont(Font.PLAIN,12));
		txtDateFrom.setColumns(10);
		txtDateFrom.setBorder(null);
		txtDateFrom.setBackground(UIManager.getColor("TabbedPane.selectedTabTitlePressedColor"));
		txtDateFrom.setBounds(250, 75, 143, 16);
		filterContainer.add(txtDateFrom);
		
		txtDateTo = new JTextField();
		txtDateTo.setForeground(new Color(128,128,128));
		txtDateTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtDateTo.setText("");
			}
		});
		txtDateTo.setText("Alta hasta");
		txtDateTo.setFont(controlador.getSegoeui().deriveFont(Font.PLAIN,12));
		txtDateTo.setColumns(10);
		txtDateTo.setBorder(null);
		txtDateTo.setBackground(UIManager.getColor("TabbedPane.selectedTabTitlePressedColor"));
		txtDateTo.setBounds(250, 104, 143, 16);
		filterContainer.add(txtDateTo);
		


		
		JPanel btnPreimp = new JPanel();
		btnPreimp.setLayout(null);
		btnPreimp.setBackground(new Color(189,195,199));
		btnPreimp.setBounds(683, 89, 125, 40);
		filterContainer.add(btnPreimp);
		
		JLabel lblPreimp = new JLabel("PREIMPRESOS");
		lblPreimp.setIcon(new ImageIcon("img/Paper-30.png"));
		lblPreimp.setForeground(Color.WHITE);
		lblPreimp.setFont(controlador.getSegoeui().deriveFont(Font.PLAIN,12));
		lblPreimp.setBounds(6, 6, 122, 28);
		btnPreimp.add(lblPreimp);
		
		JPanel btnAdd = new JPanel();
		btnAdd.setLayout(null);
		btnAdd.setBackground(new Color(189, 195, 199));
		btnAdd.setBounds(546, 89, 125, 40);
		filterContainer.add(btnAdd);
		
		JLabel lblAdd = new JLabel("AÑADIR");
		lblAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.pasarActivOptions();
			}
		});
		lblAdd.setIcon(new ImageIcon("img/Add Property-30.png"));
		lblAdd.setForeground(Color.WHITE);
		lblAdd.setFont(controlador.getSegoeui().deriveFont(Font.PLAIN,12));
		lblAdd.setBounds(17, 0, 88, 40);
		btnAdd.add(lblAdd);
		
		
		JPanel btnFilter = new JPanel();
		btnFilter.setLayout(null);
		btnFilter.setBackground(new Color(189, 195, 199));
		btnFilter.setBounds(28, 139, 150, 40);
		filterContainer.add(btnFilter);
		
		JLabel lblFilter = new JLabel("    CONSULTAR");
		lblFilter.setIcon(new ImageIcon("img/Search Property-30.png"));
		lblFilter.setForeground(Color.WHITE);
		lblFilter.setFont(controlador.getSegoeui().deriveFont(Font.BOLD,12));
		lblFilter.setBounds(13, 0, 131, 40);
		btnFilter.add(lblFilter);
		
		JDateChooser DateCFrom = new JDateChooser();
		DateCFrom.setBounds(405, 75, 28, 26);
		filterContainer.add(DateCFrom);
		
		JDateChooser DateCTo = new JDateChooser();
		DateCTo.setBounds(405, 103, 28, 26);
		filterContainer.add(DateCTo);
		
		JSeparator sepfilter_1 = new JSeparator();
		sepfilter_1.setOrientation(SwingConstants.VERTICAL);
		sepfilter_1.setBounds(513, 27, 21, 150);
		filterContainer.add(sepfilter_1);
		
		JSeparator sepfilter_2 = new JSeparator();
		sepfilter_2.setForeground(new Color(128,128,128));
		sepfilter_2.setBounds(28, 90, 194, 16);
		filterContainer.add(sepfilter_2);
		
		JSeparator sepfilter_3 = new JSeparator();
		sepfilter_3.setForeground(Color.GRAY);
		sepfilter_3.setBounds(250, 89, 143, 16);
		filterContainer.add(sepfilter_3);
		
		JSeparator sepfilter_4 = new JSeparator();
		sepfilter_4.setForeground(Color.GRAY);
		sepfilter_4.setBounds(28, 117, 197, 16);
		filterContainer.add(sepfilter_4);
		
		JSeparator sepfilter_5 = new JSeparator();
		sepfilter_5.setForeground(Color.GRAY);
		sepfilter_5.setBounds(250, 117, 143, 16);
		filterContainer.add(sepfilter_5);
		
		JComboBox selectType = new JComboBox();
		selectType.setBounds(54, 41, 168, 27);
		selectType.setModel(new DefaultComboBoxModel(new String[] {"-- Seleccione --", "Deporte", "Cultural", "Social", "Juvenil"}));
		filterContainer.add(selectType);
		
		JLabel lblFilterTitle = new JLabel("Filtros de búsqueda");
		lblFilterTitle.setForeground(new Color(105, 105, 105));
		lblFilterTitle.setFont(controlador.getSegoeui().deriveFont(Font.BOLD,15));
		lblFilterTitle.setBounds(28, 6, 178, 32);
		filterContainer.add(lblFilterTitle);
		
		JSpinner spinnerDest = new JSpinner();
		spinnerDest.setBounds(382, 40, 51, 26);
		filterContainer.add(spinnerDest);
		
		JLabel lblDest = new JLabel("Nº destinatarios");
		lblDest.setFont(controlador.getSegoeui().deriveFont(Font.PLAIN,12));
		lblDest.setBounds(250, 45, 130, 16);
		lblDest.setForeground(new Color(128,  128,  128));
		filterContainer.add(lblDest);
		
		JLabel lblType = new JLabel("Tipo:");
		lblType.setForeground(new Color(105, 105, 105));
		lblType.setFont(controlador.getSegoeui().deriveFont(Font.PLAIN,12));
		lblType.setBounds(28, 45, 33, 16);
		filterContainer.add(lblType);
		
		JPanel headerContainer = new JPanel();
		headerContainer.setBackground(Color.WHITE);
		headerContainer.setBounds(81, 0, 829, 59);
		container.add(headerContainer);
		headerContainer.setLayout(null);
		
		JLabel lblSectionIMG = new JLabel("");
		lblSectionIMG.setBounds(16, 6, 40, 40);
		lblSectionIMG.setIcon(new ImageIcon("img/actividadheader.png"));
		headerContainer.add(lblSectionIMG);
		
		JLabel lblTitle = new JLabel("Actividades");
		lblTitle.setBounds(65, 6, 131, 36);
		lblTitle.setForeground(new Color(128, 128, 128));
		lblTitle.setFont(controlador.getSegoeui().deriveFont(Font.PLAIN,20));
		headerContainer.add(lblTitle);
		
		JSeparator sep_header = new JSeparator();
		sep_header.setBounds(63, 34, 112, 12);
		headerContainer.add(sep_header);
		
		JLabel lblUserIMG = new JLabel("");
		lblUserIMG.setBounds(633, 6, 40, 40);
		lblUserIMG.setIcon(new ImageIcon("img/User-40 (2).png"));
		headerContainer.add(lblUserIMG);
		
		JLabel lblUser = new JLabel("Usuario");
		lblUser.setBounds(675, 6, 76, 40);
		lblUser.setForeground(new Color(128, 128, 128));
		lblUser.setFont(controlador.getSegoeui().deriveFont(Font.PLAIN,20));
		headerContainer.add(lblUser);
		
		JLabel lblLogOut = new JLabel("");
		lblLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.pasarLogin();
				dispose();
			}
		});
		lblLogOut.setBounds(781, 6, 40, 40);
		lblLogOut.setIcon(new ImageIcon("img/Exit-35.png"));
		headerContainer.add(lblLogOut);

		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()>=2){
					System.out.println("MIAU:3");
					
					int x=(int)(table.getModel().getValueAt(table.getSelectedRow(), 0));
					ArrayList<Asociacion> a=modelo.getA();
					Asociacion u=null;
					for(int i=0;i<a.size();i++){
						if(a.get(i).getId()==x)
							u=a.get(i);
					}
					System.out.println(u);
				}
				
			}
			
		});
		
		
		scrollPane.setViewportView(table);
		// tabla
//		table_1 = controlador.datos();
		//scrollPane.setViewportView(table_1);
	}

	public void actualizarTabla(){
		ArrayList<Actividad> a=modelo.getC();
		DefaultTableModel model = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.addColumn("IDENTIFICADOR");
		model.addColumn("NOMBRE");
		model.addColumn("FECHA");
		model.addColumn("LUGAR");
		model.addColumn("TIPO");
		model.addColumn("DESCRIPCION");
		for (int i = 0; i < a.size(); i++) {
			model.addRow(new Object[] {a.get(i).getId(),a.get(i).getNombre(),a.get(i).getFecha(),a.get(i).getLugar(),a.get(i).getTipo(),a.get(i).getDescripcion()});
		}

		table.setModel(model);
		table.setBackground(new Color(106, 116, 145));
		table.setShowGrid(false);
		
		scrollPane.setViewportView(table);
	}

	@Override
	public void setControlador(Controlador controlador) {
		this.controlador = (ControladorImpl) controlador;
	}

	@Override
	public void setModelo(Modelo modelo) {
		this.modelo = (ModeloImpl) modelo;
	}
}
