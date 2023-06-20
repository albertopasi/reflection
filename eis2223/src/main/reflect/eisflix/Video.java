package it.unipd.dei.eis.reflect.eisflix;

public class Video implements VideoInterface {

    protected String title;
    protected int durationInSeconds;

    public Video(){

    }

    public Video(String title, int durationInSeconds) {
        this.title = title;
        this.durationInSeconds = durationInSeconds;
    }

    public String getTitle() {
        return this.title;
    }

    public int getDurationInMinutes() {
        return (int) Math.ceil(durationInSeconds / 60);
    }
}
