package org.tinypng;

import org.tinypng.service.CompressionService;

import java.io.IOException;

public class Main
{
    private static final String basePath = "{folderAbsolutePath}"; // folder containing images

    public static void main(String args[]) throws IOException
    {
        CompressionService compressionService = new CompressionService();
        compressionService.compressImages(basePath);
    }
}
