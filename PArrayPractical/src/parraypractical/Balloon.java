package parraypractical;

import java.util.Random;

public class Balloon {
	private Random rand = new Random();
	private int colour;
	
	public Balloon() {
		colour = rand.nextInt(10) + 1;
	}
	
	public int getColour() {
		return colour;
	}

	public String writeColour() {
		String returnString = "";
		
		switch(colour) {
		case 1:
			returnString = "red";
			break;
		case 2:
			returnString = "orange";
			break;
		case 3:
			returnString = "yellow";
			break;
		case 4:
			returnString = "green";
			break;
		case 5:
			returnString = "cyan";
			break;
		case 6:
			returnString = "blue";
			break;
		case 7:
			returnString = "purple";
			break;
		case 8:
			returnString = "pink";
			break;
		case 9:
			returnString = "magenta";
			break;
		case 10:
			returnString = "aqua";
			break;
		}
		
		return returnString;
	}
}
