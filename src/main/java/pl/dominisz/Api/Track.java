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
        return "Track{" +
                "title='" + title + '\'' +
                ", lenght=" + lenght +
                ", compositor='" + compositor + '\'' +
                ", lyricsAuthor='" + lyricsAuthor + '\'' +
                ", genre=" + genre.getDescription() +
                '}';
    }
}

