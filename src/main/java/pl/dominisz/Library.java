package pl.dominisz;

import java.util.List;
import java.util.stream.Collectors;

public class Library {

    private List<Cd> cdList;

    public void add(Cd cd){
        cdList.add(cd);
    }
    public void remove(int index){
        cdList.remove(index);
    }

    public List<Cd> searchByCdName(String name) {
        String namePart = name.toUpperCase();
        return cdList.stream().filter(cd ->
                cd.getName().toUpperCase().contains(namePart)).
                collect(Collectors.toList());
    }

    public List<Cd> searchCdByTrackName(String name){
        String namePart = name.toUpperCase();
        return cdList.stream().filter(cd ->
                !cd.findByTrackName(name).isEmpty()).
                collect(Collectors.toList());
    }

    public List<Track> searchTrackByTrackName(String name){
        return cdList.stream().flatMap(cd ->
                cd.findByTrackName(name).stream()).collect(Collectors.toList());
    }

    public List<Cd> searchCdByGenre(Genre genre){
        return cdList.stream().filter(cd ->
                !cd.findByGenre(genre).isEmpty()).
                collect(Collectors.toList());
    }
    public List<Track> searchTrackByGenre(Genre genre){
        return cdList.stream().flatMap(cd ->
                cd.findByGenre(genre).stream()).collect(Collectors.toList());
    }

    public List<Cd> searchByPublicationDate(int date){
        return cdList.stream().filter(cd ->
                cd.getPublicationDate() == date).collect(Collectors.toList());
    }

    public void save(){

    }

    public void load(){

    }
}
