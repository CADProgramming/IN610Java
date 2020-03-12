package pfacebook;

import java.util.ArrayList;

public class Facebook {
	ArrayList<Friend> friendList;
	String profile;
	
	public Facebook() {
		friendList = new ArrayList<Friend>();
		profile = "Clayton's Facebook Profile";
	}
	
	public int countFriends() {
		return friendList.size();
	}
	
	public String removeFriend(Friend newFriend) {
		String result = "SUCCESS";
		
		if (checkExists(newFriend)) {
			friendList.remove(newFriend);
		}
		else {
			result = "NOT FOUND";
		}
		
		return result;
	}
	
	public String addFriend(Friend newFriend) {
		String result = "SUCCESS";
		
		if (checkExists(newFriend)) {
			result = "ALREADY EXISTS";
		}
		else {
			friendList.add(newFriend);
		}
		
		return result;
	}
	
	private boolean checkExists(Friend newFriend) {
		boolean isInList = false;
		
			if (friendList.contains(newFriend)) {
				isInList = true;
			}
		
		return isInList;
	}
	
	@Override
	public String toString() {
		StringBuilder returnString = new StringBuilder("");
		
		for (Friend friendInList : friendList) {
			returnString.append(friendInList.toString());
		}
		
		System.out.println(returnString.toString());
		
		return returnString.toString();
	}
	
	public String displayUnder21() {
		StringBuilder returnString = new StringBuilder("");
		
		for (Friend friendInList : friendList) {
			if (friendInList.getBirthDate() != null && friendInList.calcAge() < 21) {
				returnString.append(friendInList.getFirstName());
				returnString.append('\n');
			}
		}
		
		System.out.println(returnString.toString());
		
		return returnString.toString();
	}
	
	public String toAlphaSortString() {
		ArrayList<Friend> sortedList = sortList();		
		StringBuilder returnString = new StringBuilder("");
		
		for (Friend friendInList : sortedList) {
			returnString.append(friendInList.getFirstName());
			returnString.append('\n');
		}
		
		System.out.println(returnString.toString());
		
		return returnString.toString();
	}
	
	private ArrayList<Friend> sortList() {
		ArrayList<Friend> sortedList = new ArrayList<Friend>();
		for (Friend friendInList : friendList) {
			sortedList.add(friendInList);
		}
		
		for (int n = 0; n < sortedList.size() - 1; n++) {
			for (int i = 0; i < sortedList.size() - 1; i++) {
				int letterIndex = 0;
				
				if (sortedList.get(i).getFirstName().charAt(letterIndex) > sortedList.get(i + 1).getFirstName().charAt(letterIndex)) {
					Friend temp = sortedList.get(i);
					sortedList.set(i, sortedList.get(i + 1));
					sortedList.set(i + 1, temp);					
				}
				else if (sortedList.get(i).getFirstName().charAt(letterIndex) == sortedList.get(i + 1).getFirstName().charAt(letterIndex) && 
						letterIndex + 1 < sortedList.get(i).getFirstName().length() - 1) {
					
				}
			}
		}
		
		return sortedList;
	}
}