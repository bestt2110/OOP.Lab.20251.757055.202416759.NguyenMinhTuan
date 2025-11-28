package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	
	private static int nbDigitalVideoDiscs=0;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = 
			new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = 
			new MediaComparatorByCostTitle();
	
	public Media() {
		
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}
	
	public Media(String title) {
		super();
		this.title = title;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	
	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	
	public boolean isMatch(String title) {
		return this.title.equalsIgnoreCase(title);
	}
	public boolean isMatch(int id) {
		return id==this.id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;                // cùng object
	    if (!(obj instanceof Media)) return false;    // khác kiểu → false

	    Media other = (Media) obj;
	    return this.getTitle().equals(other.getTitle());
	}
}