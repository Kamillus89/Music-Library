package codecool;

import codecool.dao.AlbumDAO;
import codecool.dao.AlbumDAOImpl;
import codecool.music.Album;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
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
    }

    public void showAllAlbums(List<Album> albums){
        albums.forEach(System.out::println);
    }

    public void findAllAlbumsByGenre(List<Album> albums, String genre) {
        albums.stream()
                .filter(album -> album.getGenre().equalsIgnoreCase(genre))
                .forEach(System.out::println);
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
