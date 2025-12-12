package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
	
	public DigitalVideoDisc(String title) {
		super(title);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title,category,director,cost);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title,category,director,length,cost);
	}
	
	@Override
	public String toString() {
	    String result = "DVD";

	    if (getTitle() != null) {
	        result += " - [Title: " + getTitle() + "]";
	    }
	    if (getCategory() != null) {
	        result += " - [Category: " + getCategory() + "]";
	    }
	    if (getDirector() != null) {
	        result += " - [Director: " + getDirector() + "]";
	    }
	    if (getLength() > 0) {
	        result += " - [Length: " + getLength() + "]";
	    }
	    if (getCost() > 0) {
	        result += " - [Price: " + getCost() + "$]";
	    }
	    return result;
	}
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
		}
		else {
			throw new PlayerException("ERROR: DVD length is non-positive");
		}
	}
}