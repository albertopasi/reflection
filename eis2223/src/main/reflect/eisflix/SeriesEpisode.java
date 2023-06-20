package it.unipd.dei.eis.reflect.eisflix;

public class SeriesEpisode extends Video {

    protected String seriesName;
    protected int seasonNumber;
    protected int episodeNumber;

    public SeriesEpisode(String title, int durationInSeconds, String seriesName, int seasonNumber, int episodeNumber) {
        super(title, durationInSeconds);
        this.seriesName = seriesName;
        this.seasonNumber = seasonNumber;
        this.episodeNumber = episodeNumber;
    }

    public String getSeriesName() {
        return this.seriesName;
    }

    public int getSeasonNumber() {
        return this.seasonNumber;
    }

    public int getEpisodeNumber() {
        return this.episodeNumber;
    }

}
