package it.unipd.dei.eis.reflect.eisflix;

public class Documentary extends Video {

    protected String topic;

    public Documentary(String title, int durationInSeconds, String topic) {
        super(title, durationInSeconds);
        this.topic = topic;
    }

    public String getTopic() {
        return this.topic;
    }

}
