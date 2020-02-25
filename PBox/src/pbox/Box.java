package pbox;

public class Box 
{
	private double height;
	private double width;
	private double length;
	
	public Box(double height, double width, double length) {
		setHeight(Math.abs(height));
		setWidth(Math.abs(width));
		setLength(Math.abs(length));
	}
	
	public Box(double squareBase, double height) {
		setHeight(Math.abs(height));
		setWidth(Math.abs(squareBase));
		setLength(Math.abs(squareBase));
	}
	
	public Box(double size) {
		setHeight(Math.abs(size));
		setWidth(Math.abs(size));
		setLength(Math.abs(size));
	}

	public double calcVolume() {
		return (height * length * width);
	}
	
	public double calcSurfaceArea() {
		double surfaceArea = 0;
		
		surfaceArea += 2 * (height * length);
		surfaceArea += 2 * (length * width);
		surfaceArea += 2 * (width * height);
		
		return surfaceArea;
	}
	
	@Override
	public String toString() {
		return "Height: " + height + "\n" +
				"Width: " + width + "\n" +
				"Length: " + length + "\n" + 
				"S.A: " + calcSurfaceArea() + "\n" +
				"V: "+ calcVolume() + "\n";
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public void setLength(double length) {
		this.length = length;
	}
	
	
}
