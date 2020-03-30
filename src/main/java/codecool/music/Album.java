package codecool.music;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Album {

    private String artistName;
    private String albumName;
    private int releaseYear;
    private String genre;
    private double length;

    public Album(String artistName, String albumName, int releaseYear, String genre, double length) {
        this.artistName = artistName;
        this.albumName = albumName;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.length = length;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public double getLength() {
        return length;
    }

    @Override
    public String toString() {
        return Stream.of(artistName, albumName, releaseYear, genre, length)
                .map(i -> String.valueOf(i))
                .collect(Collectors.joining(" \t\t | "));

        /*return "Album{" +
                "artistName='" + artistName + '\'' +
                ", albumName='" + albumName + '\'' +
                ", releaseYear=" + releaseYear +
                ", genre='" + genre + '\'' +
                ", length=" + length +
                '}';

         */
    }

}
