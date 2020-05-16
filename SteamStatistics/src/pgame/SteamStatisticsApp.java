package pgame;

import java.util.TreeSet;

public class SteamStatisticsApp {

	public static void main(String[] args) {
		
		TreeSet<Game> gamesLibrary = new TreeSet<Game>();
		GameStatsLoader.Load(gamesLibrary);
	}
}
