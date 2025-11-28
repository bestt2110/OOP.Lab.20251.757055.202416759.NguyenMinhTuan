package hust.soict.dsai.test.toString;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.*;

public class polymorphismTest {
	public static void main(String[] args) {
		ArrayList<Media> mediae = new ArrayList<>();
		ArrayList<Track> tracks = new ArrayList<>();
		ArrayList<String> authors = new ArrayList<>();
		
		
		mediae.add(new Book("Java Programming", "Student Book", authors , 20.5f));
		mediae.add(new DigitalVideoDisc("Avatar", "Scifi", 15.99f));
		mediae.add(new CompactDisc("Grammy 2025", "Music", tracks));
	
		for (Media m : mediae) {
		    System.out.println(m.toString());
		}
	
	
	}
}
