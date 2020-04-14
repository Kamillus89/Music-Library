package codecool.music;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Album {

    private String artistName;
    private String albumName;
    private int releaseYear;
    private String genre;
    private double length;

    public Album() { }

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

    public static final class Builder{

        private String artistName;
        private String albumName;
        private int releaseYear;
        private String genre;
        private double length;

        public Builder artistName(String artistName) {
            this.artistName = artistName;
            return this;
        }

        public Builder albumName(String albumName) {
            this.albumName = albumName;
            return this;
        }

        public Builder releaseYear(int releaseYear) {
            this.releaseYear = releaseYear;
            return this;
        }

        public Builder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder length(double length) {
            this.length = length;
            return this;
        }

        public Album build() {

            Album album = new Album();

            album.artistName = this.artistName;
            album.albumName = this.albumName;
            album.releaseYear = this.releaseYear;
            album.genre = this.genre;
            album.length = this.length;

            return album;
        }
    }
}
