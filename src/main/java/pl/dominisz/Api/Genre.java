package pl.dominisz.Api;

public enum  Genre {
    POP("Pop"),
    ROCK("Rock"),
    METAL("Metal"),
    HIPHOP("HipHop"),
    EMPTY("Empty");

    private String description;

    Genre(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
