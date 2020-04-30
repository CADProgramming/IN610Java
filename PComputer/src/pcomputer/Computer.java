package pcomputer;

public class Computer {
	protected String manufacturer;
	protected String processor;
	protected int ramSize;
	protected int diskSize;
	private static int count;
	
	public Computer(String manufacturer, String processor, int ramSize, int diskSize) {
		setManufacturer(manufacturer);
		setProcessor(processor);
		setRamSize(ramSize);
		setDiskSize(diskSize);
		count++;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public int getRamSize() {
		return ramSize;
	}
	public void setRamSize(int ramSize) {
		this.ramSize = ramSize;
	}
	public int getDiskSize() {
		return diskSize;
	}
	public void setDiskSize(int diskSize) {
		this.diskSize = diskSize;
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Computer.count = count;
	}
	
	@Override
	public String toString() {
		return 
				"Manufacturer: " + manufacturer + "\n" + 
				"Processor: " + processor + "\n" + 
				"Ram Size: " + ramSize + "GB\n" + 
				"Disk Size: " + diskSize + "GB\n";
	}
}
