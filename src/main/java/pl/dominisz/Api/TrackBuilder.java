package pl.dominisz.Api;

public class TrackBuilder{

    private String title;
    private int lenght;
    private String compositor;
    private String lyricsAuthor;
    private Genre genre;

    public TrackBuilder(){

    }

    public TrackBuilder withTitle(String title){
        this.title = title;
        return this;
    }

    public TrackBuilder withLenght(int lenght){
        this.lenght = lenght;
        return this;
    }

    public TrackBuilder withCompositor(String compositor){
        this.compositor = compositor;
        return this;
    }

    public TrackBuilder withlyricsAuthor(String lyricsAuthor){
        this.lyricsAuthor = lyricsAuthor;
        return this;
    }

    public TrackBuilder withGenre(Genre genre){
        this.genre = genre;
        return this;
    }

    public Track build(){
        return new Track(title,lenght,compositor,lyricsAuthor,genre);
    }
}
