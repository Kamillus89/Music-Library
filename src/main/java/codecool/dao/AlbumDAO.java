package codecool.dao;

import codecool.music.Album;

import java.io.IOException;
import java.util.List;

/**
 * This interface allows user to read data.
 * It returns a List of Album and throws IOException if there is no file in provided filePath.
 *
 * @author Kamil Olsza
 */

public interface AlbumDAO {

    List<Album> getAlbumsFromFile(String filePath) throws IOException;
}
