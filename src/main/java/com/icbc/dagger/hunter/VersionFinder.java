package com.icbc.dagger.hunter;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.icbc.dagger.hunter.data.OpenSoft;
import com.icbc.dagger.hunter.finder.CtpHelper;
import com.icbc.dagger.hunter.finder.MetaHelper;
import com.icbc.dagger.hunter.finder.SizeHelper;

public class VersionFinder {
    private Pattern fileNamePattern = Pattern.compile("(.*?)-?(\\d{1,3}\\.(\\d{1,3}\\.?)*|\\d{8}).*?\\.jar$");
    private CtpHelper ctpHelper = new CtpHelper();
    private MetaHelper metaHelper = new MetaHelper();
    private SizeHelper sizeHelper = new SizeHelper();

    public void fillVersion(OpenSoft soft) {
        String path = soft.getPath();
        String fileName = new File(path).getName();

        Matcher m = fileNamePattern.matcher(fileName);
        boolean b = m.find();
        if (b) {
            String name = m.group(1);
            if (name.endsWith("_")) {
                name = name.substring(0, name.length() - 1);
            }
            soft.setName(name);

            String version = m.group(2);
            if (version.endsWith(".") || version.endsWith("_")) {
                version = version.substring(0, version.length() - 1);
            }
            soft.setVersion(version);

            return;
        }

        soft.setName(trimNameSuffix(fileName));

        String version = findVersionByCtp(soft);
        if (!"".equals(version)) {
            soft.setVersion(version);
            return;
        }

        version = findVersionByMeta(soft);
        if (!"".equals(version)) {
            soft.setVersion(version);
            return;
        }

        version = findVersionBySize(soft);

        if ("".equals(version)) {
            version = "NO-VERSION";
        }

        soft.setVersion(version);
    }

    private String findVersionByMeta(OpenSoft soft) {
        return metaHelper.findVersion(soft);
    }

    private String findVersionBySize(OpenSoft soft) {
        return sizeHelper.findVersion(soft);
    }

    private String findVersionByCtp(OpenSoft soft) {
        return ctpHelper.findVersion(soft);
    }

    private String trimNameSuffix(String path) {
        if (path.endsWith(".jar")) {
            return path.substring(0, path.length() - 4);
        }

        return path;
    }

    public static void main(String[] args) throws Exception {
        VersionFinder vf = new VersionFinder();

        OpenSoft jar = new OpenSoft();
        jar.setPath("/Users/huanghao/repos/gil/solr/CrawlService/DBCrawler/lib/easymockclassextension.jar");
        vf.fillVersion(jar);
        System.out.println(jar);
    }
}
