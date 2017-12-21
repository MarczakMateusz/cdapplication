package pl.dominisz;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Track track1 = new TrackBuilder().withLenght(100).build();
        Track track2 = new TrackBuilder().withLenght(50).build();
        Track track3 = new TrackBuilder().withLenght(150).build();

        List<Track> trackList = new ArrayList<>();
        trackList.add(track1);
        trackList.add(track2);
        trackList.add(track3);

        Cd cd1 = new CdBuilder().withTrackList(trackList).build();

        cd1.showTotalTime();
    }
}
