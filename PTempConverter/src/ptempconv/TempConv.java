package ptempconv;

import java.lang.Math;

public class TempConv {
	private double cel;
	private double fah;
	private double kel;
	
	public TempConv(double cel) {
		updateTempFromCel(cel);
	}
	
	@Override
	public String toString() {
		return "Celcius: " + getCel() + "\n" + 
				"Fahrenheit: " + getFah() + "\n" +
				"Kelvin: " + getKel() + "\n";
	}

	public void updateTempFromCel(double cel) {
		setCel(cel);
		setFah((cel * (9.0/5.0)) + 32);
		setKel(cel + 273.15);
	}
	
	public void updateTempFromFah(double fah) {
		setFah(fah);
		setCel((fah - 32) * (5.0/9.0));
		setKel(cel + 273.15);
	}
	
	public void updateTempFromKel(double kel) {
		setKel(kel);
		setCel(kel - 273.15);
		setFah((cel * (9.0/5.0)) + 32);
	}
	
	public double getCel() {
		return Math.round(cel * 100) / 100.0;
	}

	public void setCel(double cel) {
		this.cel = cel;
	}

	public double getFah() {
		return Math.round(fah * 100) / 100.0;
	}

	public void setFah(double fah) {
		this.fah = fah;
	}

	public double getKel() {
		return Math.round(kel * 100) / 100.0;
	}

	public void setKel(double kel) {
		this.kel = kel;
	}

}
