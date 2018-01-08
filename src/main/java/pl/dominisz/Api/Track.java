package pl.dominisz.Api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Track {
    private String title;
    private int lenght;
    private String compositor;
    private String lyricsAuthor;
    private Genre genre;

    @Override
    public String toString() {
        return
                "Tytul : '" + title + '\'' +
                ", Długosc : " + lenght +
                ", Kompozytor : " + compositor + '\'' +
                ", Autor Tekstu : " + lyricsAuthor + '\'' +
                ", Gatunek : " + genre.getDescription();
    }
}

