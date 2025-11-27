package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	
	private List<String> authors = new ArrayList<String>();
	public Book() {
		
	}
	public List<String> getAuthors() {
		return authors;
	}
	public Book(String title) {
	    super();
	}
	public void addAuthor(String authorName) {
		if (!authors.contains(authorName) ) {
			authors.add(authorName);
			System.out.print("Author" + authorName + "added");
		}
		else {
			System.out.print("Author" + authorName + "existed");
		}
	}
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName) ) {
			authors.remove(authorName);
			System.out.print("Author" + authorName + "removed");
		}
		else {
			System.out.print("Author" + authorName + "not existed");
		}
	}
}