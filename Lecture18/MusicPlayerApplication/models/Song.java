package MusicPlayerApplication.models;

public class Song {
    private String title;
    private String artist;
    private String filePath;

    public Song (String title, String artist, String filePath) {
        this.title = title;
        this.artist = artist;
        this.filePath = filePath;
    }

    public String getTitle () {
        return this.title;
    }

    public String getArtist () {
        return this.artist;
    }

    public String getFilePath () {
        return this.filePath;
    }

}
