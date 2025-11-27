package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	private int qtyOrdered = 0;
	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}
	public String getArtist() {
		return artist;
	}
	public void addTrack(Track trackName) {
		if (!tracks.contains(trackName) ) {
			tracks.add(trackName);
			qtyOrdered++;
			System.out.print("Track" + trackName + "added");
		}
		else {
			System.out.print("Track" + trackName + "existed");
		}
	}
	public void removeTrack(String trackName) {
		if (tracks.contains(trackName) ) {
			tracks.remove(trackName);
			qtyOrdered--;
			System.out.print("Track" + trackName + "removed");
		}
		else {
			System.out.print("Track" + trackName + "not existed");
		}
	}
	public int getLength() {
		int total = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			int length = tracks.get(i).getLength();
			total += length;
		}
		return total;
		}
	public CompactDisc(String artist, ArrayList<Track> tracks) {
		super();
		this.artist = artist;
		this.tracks = tracks;
	}
}
