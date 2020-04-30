package panimal;

public abstract class Animal {
	protected String name;
	protected String type;
	
	public Animal(String name, String type) {
		setName(name);
		setType(type);
	}
	
	public abstract String speak();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "My name is " + name + ", I am a " + type + ", and I go " + speak();
	}
}
