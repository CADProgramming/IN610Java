package pgame;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SteamStatisticsApp {

	public static void main(String[] args) {
		
		ArrayList<Game> gamesLibrary = new ArrayList<Game>();
		ArrayList<Achievement> achievements = new ArrayList<Achievement>();
		
		String URLString = "http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?key=91735AEFDFDDF052B207DC9D284128B0&steamid=76561198144797372&format=json&include_appinfo=true&include_played_free_games=true";
	
		JSONObject jsonData = pullDataFromAPI(URLString);
		JSONObject response = (JSONObject) jsonData.get("response");
		JSONArray games = (JSONArray) response.get("games");
		
		for (int i = 0; i < games.size(); i++) {
			JSONObject gameData = (JSONObject) games.get(i);
			
			Long appId = (Long) gameData.get("appid");
			String name = (String) gameData.get("name");
			Long totalPlayTime = (Long) gameData.get("playtime_forever");
			
			gamesLibrary.add(new Game(appId, name, totalPlayTime));
			
			System.out.println(gamesLibrary.get(i));
		}
		
		URLString = "http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?key=91735AEFDFDDF052B207DC9D284128B0&steamid=76561198144797372&format=json&include_appinfo=true&include_played_free_games=true";
		
		jsonData = pullDataFromAPI(URLString);
		
		//Get more game information
	}
	
	public static JSONObject pullDataFromAPI(String URLString) {
		String apiData = "";
		
		try {
			
			URL url = new URL(URLString);
			
			try {
				
				HttpURLConnection conn = (HttpURLConnection)url.openConnection();
				conn.setRequestMethod("GET");
				conn.connect();
				int responsecode = conn.getResponseCode();
				
				if(responsecode != 200) {
					throw new RuntimeException("HttpResponseCode: " + responsecode);
				
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
			JSONObject jsonData = (JSONObject) parser.parse(apiData);
			return jsonData;
				
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("Error - Cannot parse data to JSON object");
			
		}
		
		return null;
	}
}
