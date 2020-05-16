package ponebutton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class OneButton extends JFrame implements ActionListener{
	JButton button = new JButton("Exit");
	
	public OneButton() { 
		super("My first JFrame");
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.add(button);
		setContentPane(panel);
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getSource());
		System.exit(0);
	}
}
