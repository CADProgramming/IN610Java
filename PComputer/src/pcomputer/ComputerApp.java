package pcomputer;

public class ComputerApp {

	public static void main(String[] args) {
		Computer c1 = new Computer("Acer", "Intel i5 7600k", 16, 500);
		Laptop l1 = new Laptop("Dell", "Ryzen 7 2700x", 16, 250, 21.0, 1.2);
		Laptop l2 = new Laptop("Acer", "Ryzen 5 1700", 8, 500, 20.0, 1.7);
		System.out.println(c1);
		System.out.println(l1);
		System.out.println(l2);
		System.out.println("Amount of computers: " + Computer.getCount());
	}

}
