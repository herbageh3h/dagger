package com.icbc.dagger.hunter;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.icbc.dagger.hunter.xml.MavenMeta;
import com.icbc.dagger.hunter.xml.MavenMetaParser;
import com.icbc.dagger.util.PropUtil;
import com.icbc.dagger.util.StringUtil;
import com.icbc.dagger.util.TimeStat;

/**
 * Batch download all versions of specific jar from maven repo
 * 
 * @author huanghao
 * @since 20170501
 *
 */
public class JarDownloader {
    private static final Logger logger = LoggerFactory.getLogger(JarDownloader.class);

    private FileDownloader downloader = new FileDownloader();
    private static final String MAVEN_REPO_ADDRESS = "http://repo1.maven.org/maven2/";
    private static final String META_FILE_NAME = "maven-metadata.xml";

    // main entry
    public void download(final String groupId, final String artifactId) {
        String artifactUrl = artifactUrl(groupId, artifactId);
        String metaUrl = artifactUrl + META_FILE_NAME;
        logger.debug("meta url: {}", metaUrl);

        String destdir = destdir(groupId, artifactId);
        logger.debug("dest dir: {}", destdir);

        File metaFile = null;
        if (downloader.fileExists(metaUrl, destdir)) {
            metaFile = new File(destdir, META_FILE_NAME);
        } else {
            metaFile = downloader.downloadOneFile(metaUrl, destdir);
        }

        MavenMetaParser parser = new MavenMetaParser();
        MavenMeta meta = parser.parse(metaFile);
        List<String> versionList = meta.getVersionList();
        logger.debug("versions: {}", versionList);

        for (String version : versionList) {
            String jarUrl = jarUrl(artifactUrl, artifactId, version);
            logger.debug("processing {}", jarUrl);

            boolean exists = downloader.fileExists(jarUrl, destdir);
            if (!exists) {
                downloader.downloadOneFile(jarUrl, destdir);
                logger.info("downloading {}", jarUrl);
            } else {
                logger.debug("Version {} already exists, skip downloading.", version);
            }
        }
    }

    private String jarUrl(final String baseUrl, final String artifactId, final String version) {
        StringBuilder sb = new StringBuilder();
        sb.append(baseUrl);
        sb.append(version);
        sb.append("/");
        sb.append(artifactId);
        sb.append("-");
        sb.append(version);
        sb.append(".jar");

        return sb.toString();
    }

    private String artifactUrl(final String groupId, final String artifactId) {
        StringBuilder sb = new StringBuilder();
        sb.append(MAVEN_REPO_ADDRESS);
        sb.append(groupId.replace(".", "/"));
        sb.append("/");
        sb.append(artifactId);
        sb.append("/");

        return sb.toString();
    }

    public String destdir(final String groupId, final String artifactId) {
        StringBuilder sb = new StringBuilder();
        String opensoftdir = PropUtil.getProperty("opensoftdir");
        sb.append(StringUtil.dealEndSeparator(opensoftdir, true));
        sb.append(groupId);
        sb.append(File.separator);
        sb.append(artifactId);

        return sb.toString();
    }

    public static void main(String[] args) {
        TimeStat timer = new TimeStat();
        timer.start();

        JarDownloader jarDownloader = new JarDownloader();
        jarDownloader.download("junit", "junit");

        timer.end();
        System.out.println("Program Running Time: " + timer.delta());
    }
}
