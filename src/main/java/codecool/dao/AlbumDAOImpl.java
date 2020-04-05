package codecool.dao;

import codecool.music.Album;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AlbumDAOImpl implements AlbumDAO {

    @Override
    public List<Album> getAlbumsFromFile(String filePath) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            List<Album> albums = lines.map(line -> {
                String[] arr = line.split(",");
                return new Album(arr[0],arr[1],Integer.valueOf(arr[2]),arr[3],Double.valueOf(arr[4]));})
                    .collect(Collectors.toList());
            return albums;
        }
    }
}
