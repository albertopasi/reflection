package it.unipd.dei.eis.reflect;

import it.unipd.dei.eis.reflect.eisflix.*;

public class E09Serialization {

    public static void main(String[] args) {

        Movie movie = new Movie("Back to the Future", (60 + 56) * 60, new String[]{"Scifi", "Comedy"});
        Documentary documentary = new Documentary("Apollo 11", 45 * 60, "Historical");
        SeriesEpisode seriesEpisode = new SeriesEpisode("Uno", 54 * 60, "Better Call Saul", 1, 1);

        Video[] videos = new Video[]{
                movie,
                documentary,
                seriesEpisode
        };

        for (Video video : videos) {
            StringBuilder sb = new StringBuilder();
            VideoSerialization.serializeHelper(sb, video);
            System.out.println(sb);
        }

    }

}
