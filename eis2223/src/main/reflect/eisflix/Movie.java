package it.unipd.dei.eis.reflect.eisflix;

public class Movie extends Video {

    protected String[] genres;

    public Movie(String title, int durationInSeconds, String[] genres) {
        super(title, durationInSeconds);
        this.genres = genres;
    }

    public String[] getGenres() {
        return this.genres;
    }
}
