package pcomputer;

public class Laptop extends Computer{
	private static final String DEFAULT_MAN = "HP";
	private double screenSize;
	private double weight;
	
	public Laptop(String manufacturer, String processor, int ramSize, int diskSize, double screenSize, double weight) {
		super(manufacturer, processor, ramSize, diskSize);
		setScreenSize(screenSize);
		setWeight(weight);
	}
	
	public Laptop(String processor, int ramSize, int diskSize, double screenSize, double weight) {
		super(DEFAULT_MAN, processor, ramSize, diskSize);
		setScreenSize(screenSize);
		setWeight(weight);
	}
	
	public double getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return super.toString() +
				"Screen Size: " + screenSize + "inch\n" + 
				"Weight: " + weight + "Kg\n";
	}
}
