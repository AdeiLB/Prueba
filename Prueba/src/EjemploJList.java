import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class EjemploJList extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EjemploJList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 480);
		
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("AAAA","Apellido",LocalDate.now()));
		
		
		///
		
		DefaultListModel<Person> listModel = new DefaultListModel<>();
		
		
		String[] nombres = {"AAA AAAA","BBB BBBB","CCC CCC"};
		JList jList = new JList<>(nombres);
		JScrollPane panel = new JScrollPane(jList);
		
		add(panel);
		
		
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new EjemploJList();
				
			}
		});
		
	}

}
