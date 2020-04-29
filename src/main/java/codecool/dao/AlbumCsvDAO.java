package codecool.dao;

import codecool.music.Album;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
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
            return lines
                    .map(line -> {
                        String[] albumDataArray = line.split(",");
                        return new Album.Builder()
                                .artistName(albumDataArray[0])
                                .albumName(albumDataArray[1])
                                .releaseYear(albumDataArray[2])
                                .genre(albumDataArray[3])
                                .length(Double.valueOf(albumDataArray[4]))
                                .build();
                    })
                    .collect(Collectors.toList());
        } catch (NoSuchFileException e) {
            System.out.println("Unfortunately, application could not find any file with provided file name and file path");
        }

        return new ArrayList<>();
    }
}
