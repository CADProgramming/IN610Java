package pcrashstatistics;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class to load in data from a CSV file line by line into VehicleCrash objects
 * @author Clayton Davidson
 *
 */
public class DataLoader {
	
	/**
	 * Loads data in from CSV
	 * @param crashData Data structure to hold incoming data
	 * @throws Exception IO Exception if the file is not found
	 */
	public static void Load(ArrayList<VehicleCrash> crashData) throws Exception {
		String line;
		
		try {
			
			Scanner scannerReader = new Scanner(new File("finaldata_201809.csv"));
			int rowID = 0;
			
			//Loops through the file line by line
			while (scannerReader.hasNextLine()) {
				
				line = scannerReader.nextLine();
				
				String[] fields = line.split(",");
				
				int[] injuries = { Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), Integer.parseInt(fields[4])};
				int[] speedLimits = { fields[21].equals("LSZ") ? 100 : Integer.parseInt(fields[21]), Integer.parseInt(fields[22]), Integer.parseInt(fields[23])};
				int[] crashObjectsHit = new int[37];
				
				for	(int i = 0; i < crashObjectsHit.length; i++) {
					crashObjectsHit[i] = Integer.parseInt(fields[i + 27]);
				}
				
				boolean isIntersection = false;
				boolean isFromSideRoad = false;
				boolean onStateHighway = false;
				boolean roadIsWet = false;
				if (fields[9].equals("Intersection")) isIntersection = true;
				if (fields[11].equals("2")) isFromSideRoad = true;
				if (fields[13].equals("Yes")) onStateHighway = true;
				if (fields[19].equals("Wet")) roadIsWet = true;
				
				String location = fields[6].replace(" ", "");
				if (!fields[7].equals(fields[6])) location += ", " + fields[7];
				if (!fields[8].equals(fields[7])) location += ", " + fields[8];
				
				//Adds object to array using line contents
				crashData.add(new VehicleCrash(rowID, Integer.parseInt(fields[0]), fields[1], injuries, fields[5], location, isIntersection, fields[10], isFromSideRoad, Integer.parseInt(fields[12]), 
						onStateHighway, fields[14], fields[15], fields[16], fields[17], fields[18], roadIsWet, fields[20], speedLimits, 
						fields[24], fields[25], fields[26], crashObjectsHit));
				
				//Increases Row ID
				rowID++;
			}
			
			//Closes file
			scannerReader.close();
			
		} catch(IOException e) {
			
			//File not found
			System.out.println("IO Exception has occured");
		}
	}
}
