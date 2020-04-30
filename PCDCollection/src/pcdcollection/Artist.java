package pcdcollection;

import java.util.ArrayList;

/**
 *
 * @author dale
 */
public class Artist implements Comparable<Artist> {
    String name;
    ArrayList<Song> songs = new ArrayList<Song>();

    public Artist(String name, ArrayList<Song> songs) {
        this.name=name;
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder out= new StringBuilder("Song list for " +getName() +"\n");
        for (int i = 0; i < songs.size(); i++) {
            out.append(songs.get(i)+"\n");

        }
        return out.toString();
    }

	@Override
	public int compareTo(Artist o) {
		return name.compareTo(o.getName());
	}
}
