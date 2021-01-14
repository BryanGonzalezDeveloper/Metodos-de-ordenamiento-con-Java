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
		setBounds(100, 100, 747, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cantidad:");
		lblNewLabel.setBounds(10, 11, 74, 14);
		contentPane.add(lblNewLabel);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(71, 8, 142, 17);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JLabel lblBurbuja = new JLabel("BURBUJA");
		lblBurbuja.setBounds(51, 54, 74, 14);
		contentPane.add(lblBurbuja);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 79, 115, 313);
		contentPane.add(scrollPane);
		
		JList listBurbuja = new JList();
		scrollPane.setViewportView(listBurbuja);
		
		JLabel lblTiempoBurbuja = new JLabel("DURACION:");
		lblTiempoBurbuja.setBounds(31, 403, 115, 14);
		contentPane.add(lblTiempoBurbuja);
		
		JButton btnNewButton = new JButton("Aplicar algoritmo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				//int[] prueba= {15,67,8,16,44,27,12,35};
				//objOrdenamiento.datos=objOrdenamiento.burbuja(prueba);
				
				objOrdenamiento.generarDatos(Integer.parseInt(txtCantidad.getText()));
				objOrdenamiento.burbuja(objOrdenamiento.llenarArreglo());
				listBurbuja.setModel(objOrdenamiento.imprimir());
				lblTiempoBurbuja.setText("Duracion: "+objOrdenamiento.getDuracion()+" ms");
			}
			
		});
		btnNewButton.setBounds(228, 7, 163, 23);
		contentPane.add(btnNewButton);
	}
}
