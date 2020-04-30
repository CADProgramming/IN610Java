package panimal;

public class Dog extends Animal implements Domesticated{

	public Dog(String name) {
		super(name, "Dog");
	}

	@Override
	public String work() {
		return "*stands on hind legs*";
	}

	@Override
	public String reward() {
		return "*receives doggy treat*";
	}

	@Override
	public String speak() {
		return "WOOF!";
	}
	
	@Override
	public String toString() {
		return super.toString() + " I can do tricks too! " + work() + " Good boy - " + reward() + " but you need $" + Domesticated.REGFEE + " to keep me.";
	}

}
