package pcdcollection;

import java.util.ArrayList;

/**
 *
 * @author dale
 */
public class CDCollection {
    ArrayList<Artist> artists = new ArrayList<Artist>();

    public CDCollection(ArrayList<Artist> artists) {
        this.artists = artists;

    }

    @Override
     public String toString() {
        StringBuilder out= new StringBuilder("Artists list" +"\n");
        for (int i = 0; i < artists.size(); i++) {
            out.append(artists.get(i)+"\n");

        }
        return out.toString();
    }




}
