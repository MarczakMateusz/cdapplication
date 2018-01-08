package pl.dominisz.Api;

import java.util.ArrayList;
import java.util.List;

public class CdBuilder{
    private String name;
    private String performer;
    private int publicationDate;
    private List<Track> trackList;

    public CdBuilder() {
    }

    public CdBuilder withListOfTrack(List<Track>track){
        if(trackList == null){
            withTrackList(track);
        }
        trackList.addAll(track);
        return this;
    }

    public CdBuilder withOneTrack(Track track){
        if(trackList == null){
            this.trackList = new ArrayList<>();
            trackList.add(track);
        }
        trackList.add(track);
        return this;
    }

    public CdBuilder withName(String name){
        this.name = name;
        return this;
    }

    public CdBuilder withPerformer(String performer){
        this.performer = performer;
        return this;
    }

    public CdBuilder withPublicationDate(int year){
        this.publicationDate = year;
        return this;
    }

    public CdBuilder withTrackList(List<Track>trackList){
        this.trackList = trackList;
        return this;
    }

    public Cd build(){
        return new Cd(name,performer,publicationDate,trackList);
    }
}
