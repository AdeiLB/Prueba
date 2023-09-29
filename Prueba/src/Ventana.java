import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;

public class Ventana extends JFrame{

	public Ventana() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 300, 600, 600);
		
		JButton boton = new JButton("boton");
		JPanel panel = new JPanel();
		
		boton.addActionListener(e ->{
			boton.setBackground(Color.BLACK);
			boton.setForeground(Color.WHITE);
			System.out.println("Color cambiado");
			boton.setEnabled(false);
		});
		
		this.add(panel);
		panel.add(boton);
		
		
		
		
		
		setVisible(true);
	}

	public static void main(String[] args) {
		Ventana v = new Ventana();
	}

}
