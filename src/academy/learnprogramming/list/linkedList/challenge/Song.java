package academy.learnprogramming.list.linkedList.challenge;

//Song class, which has got title and duration for the song.
public class Song {

    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return this.title;
    }

    public double getDuration() {
        return this.duration;
    }
}
