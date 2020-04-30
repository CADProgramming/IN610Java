//BookApp Class __________________________________________________

package pbook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class BookApp {

	public static void main(String[] args) {
		TreeSet<Book> books = new TreeSet<Book>();

		books.add(new Book("Rachel's Legacy", "Thomas Julie"));
		books.add(new Book("Bulibasha", "Ihimaera Witi"));
		books.add(new Book("Chappy", "Grace Patricia"));
		books.add(new Book("Wild Pork and Watercress", "Crump Barry"));
		books.add(new Book("The Invisible Mile", "Coventry David"));
		books.add(new Book("Dad Art", "Wilkins Damien"));
		books.add(new Book("The Antipodeans", "McGee Greg"));
		books.add(new Book("Absence", "King Joanna"));
		books.add(new Book("Taken", "O'Callagan Sue"));
		books.add(new Book("Taken", "Crais Robert"));
		
		AuthorCompare ac = new AuthorCompare();
		
		//Collection.sort(books);
		//Collections.sort(books, ac);
		
		for(Book book : books) {
			System.out.println(book.toString());
		}
	}

}

//____________________________________________________