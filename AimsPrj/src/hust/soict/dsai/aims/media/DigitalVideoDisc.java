package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Media {
	
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	private static int nbDigitalVideoDiscs=0;
	@Override
	public String toString() {
	    String result = "DVD";

	    if (title != null) {
	        result += " - [Title: " + title + "]";
	    }
	    if (category != null) {
	        result += " - [Category: " + category + "]";
	    }
	    if (director != null) {
	        result += " - [Director: " + director + "]";
	    }
	    if (length > 0) {
	        result += " - [Length: " + length + "]";
	    }
	    if (cost > 0) {
	        result += " - [Price: " + cost + "$]";
	    }
	    return result;
	}
	public boolean isMatch(String title) {
		return this.title.equalsIgnoreCase(title);
	}
	public boolean isMatch(int id) {
		return id==this.id;
	}
}