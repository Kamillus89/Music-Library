package codecool.dao;

import codecool.music.Album;

import java.io.IOException;
import java.util.List;

public interface AlbumDAO {

    List<Album> getAlbumsFromFile(String filePath) throws IOException;
}
