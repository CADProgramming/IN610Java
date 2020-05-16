
public class Test {

	public static void main(String[] args) {
		System.out.println(registrationFee("special aid", false));
	}
	
	public static int registrationFee(String type, boolean sterilized)
	{
		int cost = 0;
		switch(type) {
		case "non-working":
			 cost = 96;
			 break;
		case "working":
			 cost = 24;
			 break;
		case "special aid":
			 cost = 19;
			 break;
		case "dangerous":
			 cost = 144;
			 break;
		}
		
		if (sterilized) return cost - 6;
		return cost;
	}
}
