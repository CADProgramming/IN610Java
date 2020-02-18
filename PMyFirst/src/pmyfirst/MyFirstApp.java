package pmyfirst;

import java.util.Random;

public class MyFirstApp 
{
	public static void main(String[] args) {
		int number;
		System.out.println("My first line");
		System.out.println(Math.PI);
		System.out.println(Math.E);
		System.out.println(Math.abs(-12));
		System.out.println(Math.max(3.0, 10.0));
		System.out.println(Math.min(12.0, 7.0));
		System.out.println(Math.pow(2, 3));
		Random generator = new Random();
        int dice = (generator.nextInt(6) + 1);
        System.out.println(dice);
        System.out.println("Number is a static class variable");
        number = 5;
        //declare a local method variable called number2
	}

}
