package ppizza;

public class PizzaApp implements PizzaConstants {

	public static void main(String[] args) {
		System.out.println(PizzaConstants.COMPANY_NAME + 
				"\n-----------------------\n\n" + "Menu:\n\n"
				+ "Small: $" + PizzaConstants.PRICE_SMALL + "\n"
				+ "Regular: $" + PizzaConstants.PRICE_REGULAR + "\n"
				+ "Large: $" + PizzaConstants.PRICE_LARGE + "\n" + 
				"\n-----------------------\n\n");
		
	}

}
