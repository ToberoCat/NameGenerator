package io.github.toberocat.data;

import java.io.InputStream;
import java.net.URL;

public class FileReader {
    public static InputStream readResourceFile(String path) {
        return FileReader.class.getResourceAsStream(path);
    }
    public static URL readResourceUrl(String path) {
        return FileReader.class.getResource(path);
    }

}
