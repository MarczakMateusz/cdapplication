package pl.dominisz;

import lombok.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Data
public class Library {

    private static final String FILE_NAME = "text";

    private List<Cd> cdList;

    public void add(Cd cd){
        if(cdList == null){
            this.cdList = new ArrayList<>();
            cdList.add(cd);
        }else{
            cdList.add(cd);
        }
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

    public void save() {
        //1 liczba plyt w biblio - B1
        // tytul 1
        // artysta 1 plyty
        //liczba trakow 1 plyty -M1
        //tytul 1 utworu
        //czas 1 utworu
        //
        //
        //
        //
        //tytul 2 utworu
        //--*M1
        //Rok wydania plyty
        //tytul 2
        //artysta 2 plyty
        //liczba trakow 2 plyty -M2
        try {
            File file = new File(FILE_NAME);
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println(cdList.size());
            for (Cd cd : cdList) {
                saveCdToFile(printWriter, cd);
            }
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Problem z zapisem do pliku " + FILE_NAME);
        }
    }

    private void saveCdToFile(PrintWriter printWriter, Cd cd) {
        printWriter.println(cd.getName());
        printWriter.println(cd.getPerformer());
        printWriter.println(cd.getTrackList().size());
        for (Track track :cd.getTrackList()){
            saveTrackToFile(printWriter, track);
        }
        printWriter.println(cd.getPublicationDate());
    }

    private void saveTrackToFile(PrintWriter printWriter, Track track) {
        printWriter.println(track.getTitle());
        printWriter.println(track.getLenght());
        printWriter.println(track.getCompositor());
        printWriter.println(track.getLyricsAuthor());
        printWriter.println(track.getGenre());
    }

    public void load() {
        cdList = new ArrayList<>();
        try {
            File file = new File(FILE_NAME);
            Scanner in = new Scanner(file);

            int libSize = Integer.parseInt(in.nextLine());
            for (int i = 0; i < libSize; i++) {
                cdList.add(loadCdFromFile(in));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Problem z zapisem do pliku " + FILE_NAME);
        }

        System.out.println(cdList.size());
    }

    private Cd loadCdFromFile(Scanner in) {
        List<Track> trackList = new ArrayList<>();
        String Name = in.nextLine();
        String performer = in.nextLine();

        int trackSize = Integer.parseInt(in.nextLine());
        for(int i = 0;i<trackSize;i++){
            trackList.add(loadTrackFromFile(in));
        }
        Cd cd = new CdBuilder().
                withName(Name).
                withPerformer(performer).
                withTrackList(trackList).
                withPublicationDate(Integer.parseInt(in.nextLine())).
                build();

        return cd;
    }

    private Track loadTrackFromFile(Scanner in) {
        Track track = new TrackBuilder().
                withTitle(in.nextLine()).
                withLenght(Integer.parseInt(in.nextLine())).
                withCompositor(in.nextLine()).
                withlyricsAuthor(in.nextLine()).
                withGenre(Genre.valueOf(in.nextLine())).
                build();
        return track;
    }


}
