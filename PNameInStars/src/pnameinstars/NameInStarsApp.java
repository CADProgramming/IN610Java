package pnameinstars;

import javax.swing.JOptionPane;

public class NameInStarsApp {

	public static void main(String[] args) 
	{
		// get the users name
        String userName = JOptionPane.showInputDialog("Enter your name");
        //Create a NameInStars object that stores the users name
        NameInStars you = new NameInStars(userName);
        // display the name
        JOptionPane.showMessageDialog(null, you.surroundNameInStars());

	}

}
