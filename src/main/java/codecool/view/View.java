package codecool.view;

import codecool.music.Album;

import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import static codecool.view.ConsoleColors.*;

public class View {

    public void showTheLongestAlbum(Album album) {
        System.out.println("The longest album: "
                + album.getAlbumName() + " - "
                + album.getArtistName() + " - "
                + "length: " + BLACK_BOLD + album.getLength() + RESET
        );
    }

    public void showTheShortestAlbum(Album album) {
        System.out.println("The shortest album: "
                + album.getAlbumName() + " - "
                + album.getArtistName() + " - "
                + "length: " + BLACK_BOLD + album.getLength() + RESET
        );
    }

    public void showTheOldestAlbum(Album album) {
        System.out.println("The oldest album: "
                + album.getAlbumName() + " - "
                + album.getArtistName() + " - "
                + "year of release: " + BLACK_BOLD + album.getReleaseYear() + RESET
        );
    }

    public void showTheYoungestAlbum(Album album) {
        System.out.println("The youngest album: "
                + album.getAlbumName() + " - "
                + album.getArtistName() + " - "
                + "year of release: " + BLACK_BOLD + album.getReleaseYear() + RESET
        );
    }

    public void showAlbumsCount(long countOfAlbums) {
        System.out.println("Number of albums in the library: " + BLACK_BOLD + countOfAlbums + RESET);
    }

    public void showAlbumsCountByGenre(Map<String, Integer> genreCounter){
        System.out.println("Count of albums by genre: ");
        genreCounter.forEach((k,v) -> System.out.println(k + " : " + BLACK_BOLD + v + RESET));
    }

    public void showFullReportHeading() {
        System.out.println(BLACK_BOLD + BLACK_UNDERLINED + "Full raport: " + RESET);
    }

    public void showSimilarAlbumsByGenre(String genre, List<Album> albums) {
        albums.forEach(System.out::println);
    }
}
