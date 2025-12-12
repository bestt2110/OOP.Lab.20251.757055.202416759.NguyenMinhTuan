package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	private int numOfDisc = 0;
	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}
	public String getArtist() {
		return artist;
	}
	public void addTrack(Track trackName) {
		if (!tracks.contains(trackName) ) {
			tracks.add(trackName);
			numOfDisc++;
			System.out.print("Track" + trackName + "added");
		}
		else {
			System.out.print("Track" + trackName + "existed");
		}
	}
	public void removeTrack(String trackName) {
		if (tracks.contains(trackName) ) {
			tracks.remove(trackName);
			numOfDisc--;
			System.out.print("Track" + trackName + "removed");
		}
		else {
			System.out.print("Track" + trackName + "not existed");
		}
	}
	public int getLength() {
		int total = 0;
		for (int i = 0; i < numOfDisc; i++) {
			int length = tracks.get(i).getLength();
			total += length;
		}
		return total;
		}
	
	public CompactDisc(String title, String artist, ArrayList<Track> tracks) {
		super(title);
		this.artist = artist;
		this.tracks = tracks;
	}
	public CompactDisc(String title, String category, String artist, ArrayList<Track> tracks, float cost) {
		super(title, category, cost);
		this.artist = artist;
		this.tracks = tracks;
	}
	public CompactDisc(String title, String category, String director, String artist, ArrayList<Track> tracks, float cost) {
		super(title,category,director,cost);
		this.artist = artist;
		this.tracks = tracks;
	}
	public CompactDisc(String title, String category, String director, String artist, ArrayList<Track> tracks, int length, float cost) {
		super(title,category,director,length,cost);
		this.artist = artist;
		this.tracks = tracks;
	}

	@Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: CD length is non-positive (" + this.getLength() + ")");
        }
        
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        
        // Phát các bài hát con (Tracks)
        for (Track track : tracks) {
            try {
                track.play();
            } catch (PlayerException e) {
                throw e; // Ném tiếp lỗi lên trên
            }
        }
    }
	@Override
	public String toString() {
	    String result = "CD";

	    if (getTitle() != null) {
	        result += " - [Title: " + getTitle() + "]";
	    }
	    if (getCategory() != null) {
	        result += " - [Category: " + getCategory() + "]";
	    }
	    if (getDirector() != null) {
	        result += " - [Director: " + getDirector() + "]";
	    }
	    if (tracks != null) {
	    	result += " - [Tracklist: " + tracks + "]";
	    }
	    if (getLength() > 0) {
	        result += " - [Length: " + getLength() + "]";
	    }
	    if (getCost() > 0) {
	        result += " - [Price: " + getCost() + "$]";
	    }
	    return result;
	}
}
