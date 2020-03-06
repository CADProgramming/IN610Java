package pfriend;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class FriendTest {

	 Friend spongeBob = new Friend("Spongebob", "Squarepants");
	 Friend patrick = new Friend("Patrick", "Star", 1985, 4, 23);
	 Friend squidward = new Friend("Squidward", "Tentacles", 1972, 10, 9, Gender.MALE, "Bikini Bottom", "squiddy08@tentacles.com", Relationship.SINGLE);
	
	@Test
	void testIsValidName() {
		assertEquals(true, spongeBob.isValidName());
	}

	@Test
	void testCalcAge() {
		assertEquals(34, patrick.calcAge());
	}
	
	@Test
	void testCalcAge2() {
		assertEquals(-1, spongeBob.calcAge());
	}
	
	@Test
	void testName() {
		assertEquals(true, spongeBob.isTheSameFriend(spongeBob));
	}

	@Test
	void testIsTheSameFriend() {
		assertEquals(false, patrick.isTheSameFriend(squidward));
	}

	@Test
	void testToString() {
		assertEquals("First Name: Squidward\nLast Name: Tentacles\nBirth Date: 1972-10-09\nGender: MALE\nHome Town: Bikini Bottom\nEmail: squiddy08@tentacles.com\nRelationship Status: SINGLE\n", squidward.toString());
	}
	
	@Test
	void testToStringNoNull() {
		assertEquals("First Name: Patrick\nLast Name: Star\nBirth Date: 1985-04-23\n", patrick.toString());
	}

	@Test
	void testSetLastName() {
		spongeBob.setLastName("Joe");
		assertEquals("Joe", spongeBob.getLastName());
	}

	@Test
	void testSetBirthDate() {
		patrick.setBirthDate(LocalDate.of(2001, 10, 10));
		assertEquals(LocalDate.of(2001, 10, 10), patrick.getBirthDate());
	}

	@Test
	void testSetGender() {
		squidward.setGender(Gender.FEMALE);
		assertEquals(Gender.FEMALE, squidward.getGender());
	}

	@Test
	void testSetHomeTown() {
		squidward.setHomeTown("I'm gonna take my horse to the old town road, I'm gonna ride till I can't no more.");
		assertEquals("I'm gonna take my horse to the old town road, I'm gonna ride till I can't no more.", squidward.getHomeTown());
	}

	@Test
	void testSetEmail() {
		squidward.setEmail("yahoo@yahoo.com");
		assertEquals("yahoo@yahoo.com", squidward.getEmail());
	}

	@Test
	void testSetRelationshipStatus() {
		squidward.setRelationshipStatus(Relationship.DIVORCED);
		assertEquals(Relationship.DIVORCED, squidward.getRelationshipStatus());
	}
	
	@Test
	void getDateEntered() {
		LocalDate todaysDate = LocalDate.of(2020, 03, 6);
		assertEquals(todaysDate, spongeBob.getDateEntered());
	}
}
