package com.icbc.dagger.hunter;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.icbc.dagger.hunter.data.ThirdPartySoft;
import com.icbc.dagger.hunter.finder.CtpHelper;
import com.icbc.dagger.hunter.finder.MetaHelper;
import com.icbc.dagger.hunter.finder.SizeHelper;

public class VersionFinder {
    private Pattern fileNamePattern = Pattern.compile("(.*?)-?(\\d{1,3}\\.(\\d{1,3}\\.?)*|\\d{8}).*?\\.jar$");
    private CtpHelper ctpHelper = new CtpHelper();
    private MetaHelper metaHelper = new MetaHelper();
    private SizeHelper sizeHelper = new SizeHelper();

    public void fillVersion(ThirdPartySoft soft) {
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

    private String findVersionByMeta(ThirdPartySoft soft) {
        return metaHelper.findVersion(soft);
    }

    private String findVersionBySize(ThirdPartySoft soft) {
        return sizeHelper.findVersion(soft);
    }

    private String findVersionByCtp(ThirdPartySoft soft) {
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

        ThirdPartySoft jar = new ThirdPartySoft();
        jar.setPath("D:/repos/gil/company/hbaseoec/WebContent/WEB-INF/lib/ant-launcher.jar");
        vf.fillVersion(jar);
        System.out.println(jar);
    }
}
