package codecool;

import codecool.dao.AlbumDAO;
import codecool.dao.AlbumDAOImpl;
import codecool.music.Album;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Comparator;
import java.util.List;

public class MusicService {

    private AlbumDAO albumDAO = new AlbumDAOImpl();
    private String filePath = "src/main/resources/albums-repo.csv";
    private List<Album> albums;

    public MusicService() {
        this.albums = readAlbumDataFromFile();
        showAllAlbums(this.albums);
        System.out.println("#############################################################################################");
        findAllAlbumsByGenre(albums,"opera");
        System.out.println("#############################################################################################");
        findAlbumsByTimeRange(albums,0,3.5);
        System.out.println("#############################################################################################");
        findTheShortestAlbum(albums);
        System.out.println("#############################################################################################");
        findTheLongestAlbum(albums);
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

    public void findTheShortestAlbum(List<Album> albums) {
        albums.stream()
                .min(Comparator.comparingDouble(Album::getLength))
                .ifPresent(System.out::println);
    }

    public void findTheLongestAlbum(List<Album> albums) {
        albums.stream()
                .max(Comparator.comparingDouble(Album::getLength))
                .ifPresent(System.out::println);
    }
    

    private List<Album> readAlbumDataFromFile() {
        try {
            albums = albumDAO.getAlbumsFromFile(filePath);
        } catch (NoSuchFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return albums;
    }

}
