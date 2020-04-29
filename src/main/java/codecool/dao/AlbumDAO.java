package codecool.dao;

import codecool.music.Album;

import java.io.IOException;
import java.util.List;

/**
 * AlbumDAO interface - serves as data object access.
 *
 * Implementing this interface allows user to read data from specified data base.
 *
 * @author Kamil Olsza
 */

public interface AlbumDAO {

    /**
     * getAlbumsFromFile methods dosen't take any parameter and reads file line by line.
     * In case there is no such file in provided file path the IOException is thrown.
     *
     * @return List<Album>
     * @throws IOException in case there is no file in provided file path
     */
    List<Album> getAlbumsFromFile() throws IOException;
}
