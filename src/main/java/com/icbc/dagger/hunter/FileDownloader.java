package com.icbc.dagger.hunter;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.icbc.dagger.util.PropUtil;
import com.icbc.dagger.util.TimeStat;

public class FileDownloader {
    private static final Logger logger = LoggerFactory.getLogger(FileDownloader.class);

    private static final int CONNECT_TIMEOUT = 30000; // 30 seconds

    private static final int READ_TIMEOUT = 60000; // 60 seconds

    public boolean fileExists(String url, String dir) {
        try {
            URL srcUrl = new URL(url);
            String fileName = FilenameUtils.getName(srcUrl.getPath());
            File f = new File(dir, fileName);
            return f.exists();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public File downloadOneFile(String url) {
        String tmpdir = PropUtil.getProperty("tmpdir");

        return downloadOneFile(url, new File(tmpdir));
    }

    public File downloadOneFile(String url, File targetDir) {
        logger.info("Begin to download {}", url);
        logger.debug("Target directory: {}", targetDir);

        File destFile = null;
        try {
            URL srcUrl = new URL(url);
            String destName = FilenameUtils.getName(srcUrl.getPath());
            logger.debug("Generated file name: {}", destName);

            destFile = new File(targetDir, destName);
            FileUtils.copyURLToFile(srcUrl, destFile, CONNECT_TIMEOUT, READ_TIMEOUT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("End downloading.");

        return destFile;
    }

    public File downloadOneFile(String url, String targetDir) {
        File target = new File(targetDir);

        if (target.exists() && target.isFile()) {
            throw new RuntimeException("Target already exists and is not a directory, path: " + targetDir);
        }

        if (!target.exists()) {
            logger.info("Create target directory, path: {}", targetDir);
            boolean success = target.mkdirs();

            if (!success) {
                logger.error("Target directory can't be created, path: {}", targetDir);
                throw new RuntimeException("Target directory can't be created.");
            }
        }

        return downloadOneFile(url, target);
    }

    public static void main(String[] args) {
        TimeStat timer = new TimeStat();
        timer.start();

        FileDownloader downloader = new FileDownloader();
        downloader.downloadOneFile("http://repo1.maven.org/maven2/junit/junit/maven-metadata.xml",
                "/Users/huanghao/tmp/junit/junit");

        timer.end();
        System.out.println("Program Running Time: " + timer.delta());
    }
}
