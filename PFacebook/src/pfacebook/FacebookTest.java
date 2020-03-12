package pfacebook;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pfacebook.Friend;
import pfacebook.Gender;
import pfacebook.Relationship;

class FacebookTest {

	Facebook claytonProfile = new Facebook();

	Friend spongeBob = new Friend("Spongebob", "Squarepants");
	Friend patrick = new Friend("Patrick", "Star", 2003, 4, 23);
 	Friend squidward = new Friend("Squidward", "Tentacles", 1972, 10, 9, Gender.MALE, "Bikini Bottom", "squiddy08@tentacles.com", Relationship.SINGLE);
	
	@Test
	void testCountFriends() {
		claytonProfile.addFriend(spongeBob);
		claytonProfile.addFriend(patrick);
		claytonProfile.addFriend(squidward);
		
		assertEquals(3, claytonProfile.countFriends());
	}

	@Test
	void testRemoveFriendSuccess() {
		claytonProfile.addFriend(spongeBob);
		claytonProfile.addFriend(patrick);
		claytonProfile.addFriend(squidward);
		
		assertEquals("SUCCESS", claytonProfile.removeFriend(squidward));
		assertEquals(2, claytonProfile.countFriends());
	}
	
	@Test
	void testRemoveFriendFail() {
		claytonProfile.addFriend(spongeBob);
		claytonProfile.addFriend(patrick);
		
		assertEquals("NOT FOUND", claytonProfile.removeFriend(squidward));
		assertEquals(2, claytonProfile.countFriends());
	}

	@Test
	void testAddFriendSuccess() {
		claytonProfile.addFriend(spongeBob);
		claytonProfile.addFriend(patrick);
		
		assertEquals("SUCCESS", claytonProfile.addFriend(squidward));
		assertEquals(3, claytonProfile.countFriends());
	}
	
	@Test
	void testAddFriendFail() {
		claytonProfile.addFriend(spongeBob);
		claytonProfile.addFriend(patrick);
		claytonProfile.addFriend(squidward);
		
		assertEquals("ALREADY EXISTS", claytonProfile.addFriend(squidward));
		assertEquals(3, claytonProfile.countFriends());
	}

	@Test
	void testToString() {
		claytonProfile.addFriend(spongeBob);
		claytonProfile.addFriend(patrick);
		claytonProfile.addFriend(squidward);
		
		claytonProfile.toString();
	}

	@Test
	void testDisplayUnder21() {
		claytonProfile.addFriend(spongeBob);
		claytonProfile.addFriend(patrick);
		claytonProfile.addFriend(squidward);
		
		claytonProfile.displayUnder21();
	}

	@Test
	void testToAlphaSortString() {
		claytonProfile.addFriend(spongeBob);
		claytonProfile.addFriend(patrick);
		claytonProfile.addFriend(squidward);
		
		claytonProfile.toAlphaSortString();
	}

}
