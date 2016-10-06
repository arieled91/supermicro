package utils;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil implements IMessage{

    private FileUtil() {}

    @NotNull public static InputStream read(@NotNull String path){
        try {
            return Files.newInputStream(Paths.get(path));
        } catch (final IOException ignored) {
            System.err.println(String.format(FILE_NOT_FOUND,path));
        }
        System.exit(5);
        return null;
    }

    public static void write(@NotNull String targetPath, @NotNull Iterable<String> file){
        try {
            Files.write(Paths.get(targetPath), file, Charset.forName("UTF-8"));
        } catch (final IOException e) {
            System.err.println(String.format(FILE_NOT_FOUND,targetPath));
            System.exit(5);
        }
    }
}
