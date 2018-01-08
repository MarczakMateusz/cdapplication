package pl.dominisz.Api;

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

    @Override
    public String toString() {
        return "Cd{" +
                "Nazwa :'" + name + '\'' +
                ", Artysta :'" + performer + '\'' +
                ", Data Wydania :" + publicationDate +
                '}';
    }

    public String toStringExtended() {
        String tracks = "Utwory :";
        for (Track t: trackList) {
            tracks = tracks + t.toString();
        }
        return "Cd{" +
                "name='" + name + '\'' +
                ", performer='" + performer + '\'' +
                ", genre=" + genre +
                ", publicationDate=" + publicationDate + '\n' +
                tracks + '}';
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

