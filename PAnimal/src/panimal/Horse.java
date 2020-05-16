package panimal;

public class Horse extends Animal implements Domesticated {

	public Horse(String name) {
		super(name, "Horse");
	}

	@Override
	public String speak() {
		return "How do you do Neeiigghhbour";
	}

	@Override
	public String work() {
		return "*Just made a lovely cup of tea*";
	}

	@Override
	public String reward() {
		return "*Receives a stroke on the mane*";
	}

	@Override
	public String toString() {
		return super.toString() + " I can do tasks too! " + work() + " Good Day! - " + reward() + " but you need $" + Domesticated.REGFEE + " to keep me.";
	}
}
