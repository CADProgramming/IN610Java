package plocaldatetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class LocalDateTimeApp {

	public static void main(String[] args) {
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);
		System.out.println(currentDate.getDayOfWeek());
		System.out.println(currentDate.getMonth());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/y");
		
		Instant timerStart = Instant.now();		
		LocalDate birthDate = LocalDate.parse(JOptionPane.showInputDialog("Enter Birthday (dd/mm/yyyy): "), formatter);
		Instant timerFinish = Instant.now();
		
		Duration time = Duration.between(timerStart, timerFinish);
		Period age = Period.between(birthDate, currentDate);
		System.out.println(age.getYears());
		System.out.println("You took " + time.toMillis() + "ms to enter your birthday");
	}

}
