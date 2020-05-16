package pgame;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.TreeSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GameStatsLoader {
	
	private static final int MAXGAMES = 50;
	private static int gamesLoaded = 0;
	
	public static void Load(TreeSet<Game> gamesLibrary) {
		fillGamesLibrarySet(gamesLibrary);
		setGameFields(gamesLibrary);
		
		for (Game game : gamesLibrary) {
			System.out.println(game);
		}
	}
	
	private static void setGameFields(TreeSet<Game> gamesLibrary) {
		for (Game game : gamesLibrary) {
			String URLString = "https://api.steampowered.com/ISteamUserStats/GetNumberOfCurrentPlayers/v1/?key=91735AEFDFDDF052B207DC9D284128B0&appid=" + game.getId();
			
			JSONObject jsonData = pullDataFromAPI(URLString);
			
			if (jsonData != null) {
				JSONObject response = (JSONObject) jsonData.get("response");
				
				//if (response.containsKey("player_count")) {
				//	game.setPlayerBase((Long) response.get("player_count"));
				//}
			}
			
			jsonData = pullDataFromAPI(URLString);
			
			if (jsonData != null) {
				JSONObject response = (JSONObject) jsonData.get("response");
				
				//if (response.containsKey("player_count")) {
				//	game.setPlayerBase((Long) response.get("player_count"));
				//}
			}
			
			jsonData = pullDataFromAPI(URLString);
			
			if (jsonData != null) {
				JSONObject response = (JSONObject) jsonData.get("response");
				
				//if (response.containsKey("player_count")) {
				//	game.setPlayerBase((Long) response.get("player_count"));
				//}
			}
			
			jsonData = pullDataFromAPI(URLString);
			
			if (jsonData != null) {
				JSONObject response = (JSONObject) jsonData.get("response");
				
				//if (response.containsKey("player_count")) {
				//	game.setPlayerBase((Long) response.get("player_count"));
				//}
			}
			
			jsonData = pullDataFromAPI(URLString);
			
			if (jsonData != null) {
				JSONObject response = (JSONObject) jsonData.get("response");
				
				//if (response.containsKey("player_count")) {
				//	game.setPlayerBase((Long) response.get("player_count"));
				//}
			}
			
			gamesLoaded += 1;
			float percent = (((float)gamesLoaded / (float)gamesLibrary.size())) * 100.0f;
			System.out.println(gamesLoaded + "/" + gamesLibrary.size() + " - " + String.format("%.2f", percent) + "%");
		}
	}
	
	private static void fillGamesLibrarySet(TreeSet<Game> gamesLibrary) {
		String URLString = "http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?key=91735AEFDFDDF052B207DC9D284128B0&steamid=76561198144797372&format=json&include_appinfo=true&include_played_free_games=true";
		
		JSONObject jsonData = pullDataFromAPI(URLString);
		
		if (jsonData != null) {
			JSONObject response = (JSONObject) jsonData.get("response");
			JSONArray games = (JSONArray) response.get("games");
			
			for (int i = 0; i < games.size() && i < MAXGAMES; i++) {
				JSONObject gameData = (JSONObject) games.get(i);
				
				Long appId = (Long) gameData.get("appid");
				String name = (String) gameData.get("name");
				Long totalPlayTime = (Long) gameData.get("playtime_forever");
				
				gamesLibrary.add(new Game(appId, name, totalPlayTime));
			}
		}
	}
	
	private static JSONObject pullDataFromAPI(String URLString) {
		String apiData = "";
		
		try {
			
			URL url = new URL(URLString);
			
			try {
				
				HttpURLConnection conn = (HttpURLConnection)url.openConnection();
				conn.setRequestMethod("GET");
				conn.connect();
				int responsecode = conn.getResponseCode();
				
				if(responsecode != 200) {
					System.out.println("Data not loaded: " + responsecode);
				
				} else {
					Scanner sc = new Scanner(url.openStream());
					while(sc.hasNext())
					{
						apiData += sc.nextLine();
					}
					sc.close();
				}
			} catch (IOException e) {

				e.printStackTrace();
				System.out.println("Error - Could not connect");
				
			}
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
			System.out.println("Error - Bad URL");
			
		}
		
		JSONParser parser = new JSONParser();
		try {
			if (apiData != "") {
				JSONObject jsonData = (JSONObject) parser.parse(apiData);
				return jsonData;
			}
				
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("Error - Cannot parse data to JSON object");
			
		}
		
		return null;
	}
}
