package pbox;

public class BoxApp {

	public static void main(String[] args) {
		Box box1 = new Box(10);
		Box box2 = new Box(8, 5);
		Box box3 = new Box(12, 7, 9);
		
		System.out.println(box1.toString());
		System.out.println(box2.toString());
		System.out.println(box3.toString());
	}

}
