package pl.dominisz;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
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

    @org.junit.jupiter.api.Test
    public void methodShouldSaveDateToFile(){
        Track track1 = new TrackBuilder().
                withLenght(100).
                withTitle("ula").
                withGenre(Genre.POP).
                withCompositor("ulam").
                withlyricsAuthor("ha").
                build();

        Track track2 = new TrackBuilder().
                withLenght(50).
                withTitle("title").
                withGenre(Genre.ROCK).
                withCompositor("compositor").
                withlyricsAuthor("lyrics autor").
                build();


        List<Track>trackList = new ArrayList<>();
        trackList.add(track1);
        trackList.add(track2);

        Cd cd1 = new CdBuilder().
                withTrackList(trackList).
                withPublicationDate(1997).
                withPerformer("performer").
                withName("Cd name").
                build();

        Library library = new Library();
        library.add(cd1);
        library.add(cd1);
        library.save();
    }

    @org.junit.jupiter.api.Test
    public void methodShouldLoadDataFromFile(){
        Library library = new Library();
        library.load();
        assertEquals(2, library.getCdList().size());
    }



}