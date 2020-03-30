package codecool;

import codecool.dao.AlbumDAO;
import codecool.dao.AlbumDAOImpl;

import java.io.IOException;

public class MusicService {
    public static void main( String[] args ) {
        AlbumDAO albumDAO = new AlbumDAOImpl();
        String filePath = "src/main/resources/albums-repo.csv";

        try {
            albumDAO.getAlbumsFromFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
