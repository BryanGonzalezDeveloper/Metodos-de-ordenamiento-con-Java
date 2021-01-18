import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui_metodosOrdenamiento extends JFrame {

	private JPanel contentPane;
	private JTextField txtCantidad;
	ClsMetodosOrdenamiento objOrdenamiento=new ClsMetodosOrdenamiento();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_metodosOrdenamiento frame = new Gui_metodosOrdenamiento();
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
	public Gui_metodosOrdenamiento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 886, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Define la cantidad de elementos en el arreglo:");
		lblNewLabel.setBounds(10, 11, 297, 14);
		contentPane.add(lblNewLabel);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(338, 9, 142, 17);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 79, 115, 313);
		contentPane.add(scrollPane);
		
		JList listBurbuja = new JList();
		scrollPane.setViewportView(listBurbuja);
		JLabel lblTiempoBurbuja = new JLabel("DURACION:");
		lblTiempoBurbuja.setBounds(31, 403, 115, 28);
		contentPane.add(lblTiempoBurbuja);
		
		
		JButton btnBurbuja = new JButton("Burbuja");
		
		btnBurbuja.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				//INSTRUCCIONES PARA MOSTRAR EL ORDENAMIENTO UTILIZANDO EL ALGORITMO BURBUJA
				
				int[] arr=objOrdenamiento.burbuja(objOrdenamiento.datos.clone());
				listBurbuja.setModel(objOrdenamiento.imprimir(arr));
				lblTiempoBurbuja.setText(objOrdenamiento.getDuracion()+" ms");
			}
		});
		
		scrollPane.setColumnHeaderView(btnBurbuja);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(192, 79, 115, 313);
		contentPane.add(scrollPane_1);
		
		JList listSeleccion = new JList();
		scrollPane_1.setViewportView(listSeleccion);
		
		
		
		JLabel lblTiempoSeleccion = new JLabel("DURACION:");
		lblTiempoSeleccion.setBounds(192, 403, 115, 28);
		contentPane.add(lblTiempoSeleccion);
		
		JButton btnSeleccion = new JButton("Seleccion");
		btnSeleccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//INSTRUCCIONES PARA MOSTRAR EL ORDENAMIENTO UTILIZANDO EL ALGORITMO DE SELECCION
				
			int[]arr=	objOrdenamiento.seleccion(objOrdenamiento.datos.clone());
				listSeleccion.setModel(objOrdenamiento.imprimir(arr));
				lblTiempoSeleccion.setText(objOrdenamiento.getDuracion()+" ms");
			}
		});
		scrollPane_1.setColumnHeaderView(btnSeleccion);
		
		JLabel lblNewLabel_1 = new JLabel("SELECCIONA UN ALGORITMO DE ORDENAMIENTO:");
		lblNewLabel_1.setBounds(209, 39, 292, 14);
		contentPane.add(lblNewLabel_1);
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(738, 82, 91, 327);
		contentPane.add(scrollPane_2);
		JList listOriginal = new JList();
		scrollPane_2.setViewportView(listOriginal);
		JButton btnGenerar = new JButton("Generar arreglo");
		
		btnGenerar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				objOrdenamiento.generarDatos(Integer.parseInt(txtCantidad.getText()));
			listOriginal.setModel(objOrdenamiento.imprimir(objOrdenamiento.llenarArreglo()));
			}
		});
		btnGenerar.setBounds(490, 9, 142, 18);
		contentPane.add(btnGenerar);
		
		
		
	
		JLabel lblNewLabel_2 = new JLabel("Arreglo Original");
		lblNewLabel_2.setBounds(736, 39, 108, 14);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(341, 79, 115, 313);
		contentPane.add(scrollPane_3);
		JLabel lblTiempoInsercion = new JLabel("DURACION:");
		lblTiempoInsercion.setBounds(341, 403, 115, 28);
		contentPane.add(lblTiempoInsercion);
		JList listInsercion = new JList();
		scrollPane_3.setViewportView(listInsercion);
		
		JButton btnInsercion = new JButton("Insercion");
		btnInsercion.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				//INSTRUCCIONES PARA MOSTRAR EL ORDENAMIENTO UTILIZANDO EL ALGORITMO DE INSERCION.
				
				int[]arr=	objOrdenamiento.insercionDirecta(objOrdenamiento.datos.clone());
					listInsercion.setModel(objOrdenamiento.imprimir(arr));
					lblTiempoInsercion.setText(objOrdenamiento.getDuracion()+" ms");
			}
		});
		
		scrollPane_3.setColumnHeaderView(btnInsercion);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(506, 79, 115, 313);
		contentPane.add(scrollPane_4);
		
		JLabel lblTiempoShell = new JLabel("DURACION:");
		lblTiempoShell.setBounds(506, 403, 115, 28);
		contentPane.add(lblTiempoShell);
		
		JList listShellSort = new JList();
		scrollPane_4.setViewportView(listShellSort);
		
		JButton btnShell = new JButton("Shell sort");
		btnShell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	//INSTRUCCIONES PARA MOSTRAR EL ORDENAMIENTO UTILIZANDO EL ALGORITMO DE SHELL SORT.
				
				int[]arr=	objOrdenamiento.shellSort(objOrdenamiento.datos.clone());
					listShellSort.setModel(objOrdenamiento.imprimir(arr));
					lblTiempoShell.setText(objOrdenamiento.getDuracion()+" ms");
			}
		});
		scrollPane_4.setColumnHeaderView(btnShell);
		
	
		
		
	}
}
