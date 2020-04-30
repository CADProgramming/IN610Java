//Book class_____________________________________________________

package pbook;

public class Book implements Comparable<Book> {
	
	private String title;
	private String author;
	
	public Book(String title, String author) {
		setTitle(title);
		setAuthor(author);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public int compareTo(Book b1) {
		//Natural sort order
		if (title.compareTo(b1.getTitle()) == 0)
		{
			return author.compareTo(b1.getAuthor());
		}
		
		return title.compareTo(b1.getTitle());
	}
	
	@Override
	public String toString() {
		return "Title: " + title + "\nAuthor: " + author + "\n";
	}
}

//____________________________________________________