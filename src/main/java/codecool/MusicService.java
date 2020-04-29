package codecool;

import codecool.dao.AlbumDAO;
import codecool.dao.AlbumCsvDAO;
import codecool.music.Album;
import codecool.view.View;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MusicService {

    private String filePath = "src/main/resources/albums-repo.csv";
    private AlbumDAO albumDAO = new AlbumCsvDAO(filePath);
    private List<Album> albums;
    private View view;

    public MusicService() {
        this.albums = readAlbumDataFromFile();
        this.view = new View();
        showAllAlbums(this.albums);
        System.out.println("#############################################################################################");
        findAllAlbumsByGenre(albums,"opera");
        System.out.println("#############################################################################################");
        findAlbumsByTimeRange(albums,0,3.5);
        System.out.println("#############################################################################################");
        findAlbumsByArtist(albums,"Jane Austen");
        System.out.println("\n");
        getTheFullReport(albums);
        System.out.println("#############################################################################################");
        getSimilarAlbumsByGenre(albums,"opera");
    }

    public void showAllAlbums(List<Album> albums){
        albums.forEach(System.out::println);
    }

    public void findAllAlbumsByGenre(List<Album> albums, String genre) {
        albums.stream()
                .filter(album -> album.getGenre().equalsIgnoreCase(genre))
                .forEach(System.out::println);
    }

    public void findAlbumsByTimeRange(List<Album> albums, double start, double end) {
        albums.stream()
                .filter(album -> album.getLength() >= start && album.getLength() <= end)
                .forEach(System.out::println);
    }

    public Album findTheShortestAlbum(List<Album> albums) {
        return albums.stream()
                .min(Comparator.comparingDouble(Album::getLength))
                .get();
    }

    public Album findTheLongestAlbum(List<Album> albums) {
        return albums.stream()
                .max(Comparator.comparingDouble(Album::getLength))
                .get();
    }

    public void findAlbumsByArtist(List<Album> albums, String artistName) {
        albums.stream()
                .filter(album -> album.getArtistName().equalsIgnoreCase(artistName))
                .forEach(System.out::println);
    }

    public void getTheFullReport(List<Album> albums){
        view.showFullReportHeading();
        view.showTheLongestAlbum(findTheLongestAlbum(albums));
        view.showTheShortestAlbum(findTheShortestAlbum(albums));
        view.showTheOldestAlbum(
                albums.stream()
                .min(Comparator.comparingInt(Album::getReleaseYear))
                .get()
                );
        view.showTheYoungestAlbum(
                albums.stream()
                .max((a1,a2) -> a1.getReleaseYear() - a2.getReleaseYear())
                .get()
                );
        view.showAlbumsCount(
                albums.stream()
                .count()
        );
        view.showAlbumsCountByGenre(
                albums.stream()
                .collect(Collectors.groupingBy(Album::getGenre,
                        Collectors.collectingAndThen(
                                Collectors.mapping(Album::getGenre, Collectors.toList()),
                                List::size
                        )))
                );
    }

    public void getSimilarAlbumsByGenre(List<Album> albums, String genre) {
        view.showSimilarAlbumsByGenre(genre,albums
                .stream()
                .filter(album -> album.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList()));
    }

    private List<Album> readAlbumDataFromFile() {
        try {
            albums = albumDAO.getAlbumsFromFile();
        } catch (NoSuchFileException | NullPointerException e) {
            e.printStackTrace();
            System.out.println("Unfortunately, application could not find any file with provided file name and file path");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return albums;
    }

}
