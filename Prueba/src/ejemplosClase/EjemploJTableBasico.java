package ejemplosClase;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class EjemploJTableBasico extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EjemploJTableBasico() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 450);
		
		///
		
		ArrayList<Person> personas = new ArrayList<>();
		personas.add(new Person("Nombre1","Apellido1",LocalDate.of(1920, 03, 18)));
		personas.add(new Person("Nombre2","Apellido2",LocalDate.of(1920, 03, 16)));
		personas.add(new Person("Nombre3","Apellido3",LocalDate.of(1920, 03, 14)));
		///
		
//		DefaultTableModel modelo = new DefaultTableModel();
//		modelo.addColumn("nombre");
//		modelo.addColumn("Apellido");
//		modelo.addColumn("Nacimiento");
//		
//		for (Person a : personas) {
//			String[] fila = new String[3];
//			fila[0] = a.getName();
//			fila[1] = a.getSurname();
//			fila[2] = a.getBirthDate().toString();
//			modelo.addRow(fila);
//		}
		
		class MyTableModel extends DefaultTableModel{
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private List<Person> personas;
			String[] cabeceras = {"Nombre" , "Apellido" , "Nacimiento"};
			
			public MyTableModel(List<Person> perosnas) {
				this.personas = personas;
			}
			
			@Override
			public Object getValueAt(int row, int column) {
				return"---";
			}

			@Override
			public int getRowCount() {
				return personas.size();
			}

			@Override
			public int getColumnCount() {
				
				return cabeceras.length;
			}

			@Override
			public String getColumnName(int column) {
				
				column = cabeceras[column];	
				
			
			}
			
		}
		
		JTable jTable = new JTable(new MyTableModel(personas));
		JScrollPane scroll = new JScrollPane(jTable);
		add(scroll);
		
		//Boton que imprime los datos
		
		JButton botonImp = new JButton("Imprimir datos");
		JPanel panelBj = new JPanel();
		panelBj.add(botonImp);
		add(panelBj, BorderLayout.SOUTH);
		
		
		botonImp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for (Person p : personas) {
					System.out.println(p.toString());
					botonImp.setEnabled(false);
					botonImp.setBackground(Color.black);
				}
				
			}
		});
		
		
		setVisible(true);
	}
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				EjemploJTableBasico v = new EjemploJTableBasico();	
				
			}
		});
		
		
		
	}

	
}
