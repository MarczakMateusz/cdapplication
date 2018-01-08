package pl.dominisz;

import pl.dominisz.Api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CdTest {

    @org.junit.jupiter.api.Test
    void getGenre() {
        Track track1 = new TrackBuilder().withGenre(Genre.HIPHOP).build();
        Track track2 = new TrackBuilder().withGenre(Genre.METAL).build();
        Track track3 = new TrackBuilder().withGenre(Genre.POP).build();

        List<Track>trackList = new ArrayList<>();
        trackList.add(track1);
        trackList.add(track2);
        trackList.add(track3);

        Cd cd1 = new CdBuilder().withTrackList(trackList).build();

        assertEquals(cd1.getGenre().size(),3);
        assertTrue(cd1.getGenre().contains(Genre.HIPHOP));
        assertTrue(cd1.getGenre().contains(Genre.METAL));
        assertTrue(cd1.getGenre().contains(Genre.POP));
    }

    @org.junit.jupiter.api.Test
    void getTotalTime() {
        Track track1 = new TrackBuilder().withLenght(100).build();
        Track track2 = new TrackBuilder().withLenght(50).build();
        Track track3 = new TrackBuilder().withLenght(150).build();

        List<Track>trackList = new ArrayList<>();
        trackList.add(track1);
        trackList.add(track2);
        trackList.add(track3);

        Cd cd1 = new CdBuilder().withTrackList(trackList).build();

        assertEquals(cd1.getTotalTime(),300);
    }


    @org.junit.jupiter.api.Test
    public void methodShoulAddTrack(){

        Track track1 = new TrackBuilder().withLenght(100).build();
        Track track2 = new TrackBuilder().withLenght(50).build();
        Track track3 = new TrackBuilder().withLenght(150).build();
        Track track4 = new TrackBuilder().withLenght(45).build();

        List<Track>trackList = new ArrayList<>();
        trackList.add(track1);
        trackList.add(track2);
        trackList.add(track3);

        Cd cd1 = new CdBuilder().withTrackList(trackList).withOneTrack(track4).build();

        assertEquals(cd1.getTrackList().size(),4);

    }

}