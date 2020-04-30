package panimal;

public class SeaLion extends Animal {

	public SeaLion(String name) {
		super(name, "Sea Lion");
	}

	@Override
	public String speak() {
		return "ROAR!";
	}
}
