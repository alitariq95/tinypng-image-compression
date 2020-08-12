package org.tinypng.service;

import com.tinify.Source;
import com.tinify.Tinify;
import org.tinypng.util.FileUtil;

import java.io.IOException;
import java.util.List;

public class CompressionService
{
    private final String[] IMAGE_EXTENSIONS = { ".jpeg", ".png" }; // these are the only two extensions supported
    private final String TINIFY_KEY = "{TINIFY_KEY}"; // change this with your api key

    public CompressionService()
    {
        Tinify.setKey(TINIFY_KEY);
    }

    public void compressImages(String basePath) throws IOException
    {
        List<String> files = FileUtil.getFiles(basePath, IMAGE_EXTENSIONS);
        for (String file : files)
        {
            compressImage(file);
        }
    }

    private void compressImage(String filePath) throws IOException
    {
        System.out.println("Compressing file: " + filePath);
        Source source = Tinify.fromFile(filePath);
        source.toFile(filePath);
        System.out.println("Compressed file successfully: " + filePath);
    }
}
