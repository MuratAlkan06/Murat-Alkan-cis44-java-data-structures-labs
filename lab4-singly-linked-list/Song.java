public class Song {
    String title;
    String artist;
    // Constructor and getters...

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String toString() {
        return "\"" + title + "\" by " + artist;
    }
}
