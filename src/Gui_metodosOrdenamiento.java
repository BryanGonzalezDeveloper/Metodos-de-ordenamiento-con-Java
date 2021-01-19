import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui_metodosOrdenamiento extends JFrame {

	private JPanel contentPane;
	private JTextField txtCantidad;
	ClsMetodosOrdenamiento objOrdenamiento=new ClsMetodosOrdenamiento();
	private JTextField txtNumero;
	int[]arrBinaria;

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
		txtCantidad.setBounds(20, 36, 142, 17);
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
		JLabel lblNewLabel_1_1 = new JLabel("Numero:");
		lblNewLabel_1_1.setBounds(401, 11, 64, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblBinaria = new JLabel("");
		lblBinaria.setBounds(732, 38, 64, 14);
		contentPane.add(lblBinaria);
		
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
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(769, 93, 91, 327);
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
		btnGenerar.setBounds(165, 36, 142, 18);
		contentPane.add(btnGenerar);
		
		
		
	
		JLabel lblNewLabel_2 = new JLabel("Arreglo Original");
		lblNewLabel_2.setBounds(775, 79, 108, 14);
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
					arrBinaria=arr;
			}
		});
		scrollPane_4.setColumnHeaderView(btnShell);
		
		JLabel lblSecuencial = new JLabel("");
		lblSecuencial.setBounds(568, 36, 64, 14);
		contentPane.add(lblSecuencial);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(476, 8, 86, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		JButton btnSecuencial = new JButton("SECUENCIAL");
		btnSecuencial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				int numero=Integer.parseInt(txtNumero.getText());
				if(objOrdenamiento.busquedaSecuencial(objOrdenamiento.datos, numero))
					JOptionPane.showMessageDialog(null, "DATO ENCONTRADO");
				else
					JOptionPane.showMessageDialog(null, "DATO NO ENCONTRADO");
				lblSecuencial.setText(objOrdenamiento.getDuracion()+" ms");
			}
		});
		btnSecuencial.setBounds(572, 7, 115, 23);
		contentPane.add(btnSecuencial);
		
		JButton btnBinaria = new JButton("BINARIA");
		btnBinaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int numero=Integer.parseInt(txtNumero.getText());
				if(objOrdenamiento.busquedaBinaria(arrBinaria, numero))
					JOptionPane.showMessageDialog(null, "Dato encontrado");
				else
					JOptionPane.showMessageDialog(null, "DATO NO ENCONTRADO");
				lblBinaria.setText(objOrdenamiento.getDuracion()+ " ms");
			}
		});
		btnBinaria.setBounds(732, 7, 115, 23);
		contentPane.add(btnBinaria);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(631, 79, 115, 313);
		contentPane.add(scrollPane_5);
		
		JList listQuickSort = new JList();
		scrollPane_5.setViewportView(listQuickSort);
		
		JLabel lblTiempoQuickSort = new JLabel("DURACION:");
		lblTiempoQuickSort.setBounds(631, 403, 115, 28);
		contentPane.add(lblTiempoQuickSort);
		
		JButton btnQuickSort = new JButton("QuickSort");
		btnQuickSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				long inicio=System.currentTimeMillis();
				int[]arr=objOrdenamiento.Quicksort(objOrdenamiento.datos.clone(), 0, objOrdenamiento.datos.length-1);
				long fin =System.currentTimeMillis();
				lblTiempoQuickSort.setText((fin-inicio)+" ms");
				listQuickSort.setModel(objOrdenamiento.imprimir(arr));
			}
		});
		scrollPane_5.setColumnHeaderView(btnQuickSort);
		
		
		
		
		
	
		
		
	}
}
