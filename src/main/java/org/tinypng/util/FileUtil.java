package org.tinypng.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtil
{
    public static List<String> getFiles(String basePath, String[] extensions) throws IOException
    {
        return Files.find(Paths.get(basePath),
                Integer.MAX_VALUE,
                (filePath, fileAttr) -> fileAttr.isRegularFile())
                .map(Path::toString)
                .filter(path -> Arrays.asList(extensions).contains(getExtension(path)))
                .collect(Collectors.toList());
    }

    public static String getExtension(String fileName)
    {
        int lastIndex = fileName.lastIndexOf('.');
        if (lastIndex == -1)
        {
            return null;
        }

        return fileName.substring(lastIndex);
    }
}
