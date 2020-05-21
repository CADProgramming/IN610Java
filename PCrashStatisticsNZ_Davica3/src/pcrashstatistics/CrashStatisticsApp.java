package pcrashstatistics;

import java.util.ArrayList;

public class CrashStatisticsApp {

	public static void main(String[] args) throws Exception {
		ArrayList<VehicleCrash> crashData = new ArrayList<VehicleCrash>();
		DataLoader.Load(crashData);

		DataForm userInterface = new DataForm(crashData);
	}
}
