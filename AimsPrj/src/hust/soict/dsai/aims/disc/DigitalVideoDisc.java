package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
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
	public void setTitle(String title) {
		this.title = title;
	}
	private static int nbDigitalVideoDiscs=0;
	private int id;
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