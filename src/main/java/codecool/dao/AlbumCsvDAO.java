package codecool.dao;

import codecool.music.Album;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AlbumCsvDAO implements AlbumDAO {

    private String filePath;

    public AlbumCsvDAO(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Album> getAlbumsFromFile() throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            List<Album> albums = lines
                    .map(line -> {
                String[] albumDataArray = line.split(",");
                    return new Album.Builder()
                            .artistName(albumDataArray[0])
                            .albumName(albumDataArray[1])
                            .releaseYear(Integer.valueOf(albumDataArray[2]))
                            .genre(albumDataArray[3])
                            .length(Double.valueOf(albumDataArray[4]))
                            .build()
                            ;})
                    .collect(Collectors.toList());
            return albums;
        }
    }
}
