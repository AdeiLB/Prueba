package ejemplosClase;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractCellEditor;
import javax.swing.CellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

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
		
		class MyTableModel extends AbstractTableModel{
			
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
				Person p = personas.get(row);
				switch (column) {
				case 0: return p.getName();
				case 1 : return p.getSurname();
				case 3 : return p.getBirthDate();
				default: return null;
					
				}
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
				
				return cabeceras[column];	
				
			
			}
			
		}
		
		JTable jTable = new JTable(new MyTableModel(personas));
		JScrollPane scroll = new JScrollPane(jTable);
		add(scroll);
		
		//Generar componenetes
		
		JButton botonImp = new JButton("Imprimir datos");
		JTextField textSur = new JTextField(30);
		
		//Crear Panel
		
		JPanel panelBj = new JPanel();
		
		//Aniadir compponente a panel
		
		panelBj.add(botonImp);
		panelBj.add(textSur);
		
		
		//aniadir panel a ventana
		
		add(panelBj, BorderLayout.SOUTH);
		
		
		botonImp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for (Person p : personas) {
					System.out.println(p.toString());
					botonImp.setEnabled(false);
					botonImp.setBackground(Color.black);
				}
		textSur.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jTable.repaint();
				
			}
		});
				
			}
		});
		
		
		setVisible(true);
	}
	
	class MyRender extends JLabel implements TableCellRenderer{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			String strCell = value.toString();
			setText(strCell);
			if (strCell.startsWith("N")){
				setBackground(Color.RED);
				setOpaque(true);
			}else {
				setBackground(Color.GREEN);
				setOpaque(true);
			}
			return this;
		}
		
		
	}
	
	class MyEditor extends AbstractCellEditor implements TableCellEditor{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private JComboBox<String> jComboBox;
		
		@Override
		public Object getCellEditorValue() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			// TODO Auto-generated method stub
			return null;
		}
		
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
