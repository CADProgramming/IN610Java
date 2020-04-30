package pbook;

import java.util.Comparator;

public class AuthorCompare implements Comparator<Book> {

	@Override
	public int compare(Book b1, Book b2) {
		//Sort by authors
		return b1.getAuthor().compareTo(b2.getAuthor());
	}
	
}
