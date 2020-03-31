package codecool.view;

import codecool.music.Album;

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

    public void showFullReportHeading() {
        System.out.println(BLACK_BOLD + BLACK_UNDERLINED + "Full raport: " + RESET);
    }


}
