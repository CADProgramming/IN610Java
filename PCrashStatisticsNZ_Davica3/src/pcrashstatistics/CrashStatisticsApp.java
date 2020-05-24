package pcrashstatistics;

import java.util.ArrayList;

/**
 * Application class for the Crash Statistics App
 * This application shows all of the NZTA's statistics for all crashes that occurred from 2001 - 2018
 * It allows the user to sort, search and see a statistical summary of specific parts of this data set
 *
 * @author	Clayton Davidson
 * @version 1.0
 * @since	24/05/2020
 */
public class CrashStatisticsApp {

	/**
	 * When executed, runs the user interface after loading the data from the CSV file
	 * 
	 * @param args Entry Point arguments
	 * @throws Exception Can throw IO exception if file is not correctly loaded
	 */
	public static void main(String[] args) throws Exception {
		ArrayList<VehicleCrash> crashData = new ArrayList<VehicleCrash>();
		DataLoader.Load(crashData);

		DataForm userInterface = new DataForm(crashData);
	}
}
