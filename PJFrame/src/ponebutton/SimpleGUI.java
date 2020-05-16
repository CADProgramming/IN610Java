package ponebutton;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SimpleGUI extends JFrame implements ActionListener {
	private JLabel label = new JLabel("Click for yes or no");
	private JButton noBtn = new JButton("No");
	private JButton yesBtn = new JButton("Yes");
	private JPanel btnPanel = new JPanel();
	private JTextArea textArea = new JTextArea(10, 12);
	
	public SimpleGUI() {
		textArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		setSize(400, 400);
		setVisible(true);
		setTitle("Frame with two buttons");
		
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		
		btnPanel.add(noBtn);
		btnPanel.add(yesBtn);
		
		cp.add(scroll);
		cp.add(label);
		cp.add(btnPanel);
		
		yesBtn.addActionListener(this);
		noBtn.addActionListener(this);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == yesBtn) {
			textArea.append("Yes was pressed\n");
			
		}
		else {
			textArea.append("No was pressed\n");
			
		}
		
	}
}
