package pl.dominisz;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class Cd {
    private String name;
    private String performer;
    private Set<Genre> genre;
    private int publicationDate;
    private List<Track> trackList;
    private double totalTime;

    public Cd(String name, String performer,int publicationDate, List<Track> trackList) {
        this.trackList = trackList;
        this.name = name;
        this.performer = performer;
        this.genre = setGenre();
        this.publicationDate = publicationDate;
        this.totalTime = countTotalTime();
    }

    public List<Track> findByGenre(Genre genre){
        return trackList.stream().filter(tr -> tr.getGenre().equals(genre)).
                collect(Collectors.toList());
    }

    public List<Track> findByTrackName(String title) {
        String TitlePart = title.toUpperCase();
        return trackList.stream().filter(tr -> tr.getTitle().toUpperCase().
                contains(TitlePart)).collect(Collectors.toList());
    }
    public void showTotalTime(){
        String showTime;
        String prefix = "Calkowity czas nagran to : ";
        String time = String.valueOf(getTotalTime()/60).replace(".",":");
        String sufix = " min";

        if(time.length() > 4 ){
            time = time.substring(0,4);
        }
        else if(time.length() < 4 && time.length() > 1){
            time = time + "0";
        }
        else{
            time = time + "00";
        }
        showTime = prefix+time+sufix;
    }

    private int countTotalTime(){
        return trackList.stream().mapToInt(Track::getLenght).sum();
    }

    private Set<Genre> setGenre(){
        return trackList.stream().map(Track::getGenre).collect(Collectors.toSet());
    }
}

class CdBuilder{
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
