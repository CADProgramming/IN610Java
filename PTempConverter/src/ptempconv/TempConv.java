package ptempconv;

import java.text.DecimalFormat;

public class TempConv {
	private double cel;
	private double fah;
	private double kel;
	private DecimalFormat formatter;
	
	public TempConv(double cel) {
		formatter = new DecimalFormat("0.##");
		setCel(cel);
	}
	
	@Override
	public String toString() {
		return "Celsius: " + getCel() + " | Fahrenheit: " + getFah() + " | Kelvin: " + getKel();
	}
	
	public double getCel() {
		String celString = formatter.format(cel);
		return Double.parseDouble(celString);
	}

	public void setCel(double cel) {
		this.cel = cel;
		fah = ((cel * (9.0/5.0)) + 32);
		kel = (cel + 273.15);
	}

	public double getFah() {
		String fahString = formatter.format(fah);
		return Double.parseDouble(fahString);
	}

	public void setFah(double fah) {
		this.fah = fah;
		cel = ((fah - 32) * (5.0/9.0));
		kel = (cel + 273.15);
	}

	public double getKel() {
		String kelString = formatter.format(kel);
		return Double.parseDouble(kelString);
	}

	public void setKel(double kel) {
		this.kel = kel;
		cel = (kel - 273.15);
		fah = ((cel * (9.0/5.0)) + 32);
	}

}
