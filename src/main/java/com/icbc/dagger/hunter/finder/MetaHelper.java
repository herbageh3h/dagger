package com.icbc.dagger.hunter.finder;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import com.icbc.dagger.hunter.data.ThirdPartySoft;

public class MetaHelper {
    private Pattern pattern = Pattern.compile("meta-inf.*?maven.*?pom\\.properties$");

    public String findVersion(ThirdPartySoft soft) {
        String path = soft.getPath();

        ZipInputStream zin = null;
        BufferedReader br = null;
        String version = "";
        try {
            zin = new ZipInputStream(new BufferedInputStream(new FileInputStream(new File(path))));
            ZipEntry entry = null;
            ZipFile zf = new ZipFile(path);

            outer: while ((entry = zin.getNextEntry()) != null) {
                String entryName = entry.getName();

                if (pattern.matcher(entryName.toLowerCase()).matches()) {
                    br = new BufferedReader(new InputStreamReader((zf.getInputStream(entry))));
                    String line;
                    while ((line = br.readLine()) != null) {
                        if (line.toLowerCase().indexOf("version") != -1) {
                            version = line.split("=")[1];
                            break outer;
                        }
                    }

                }

                if ("meta-inf/manifest.mf".equals(entryName.toLowerCase())) {
                    br = new BufferedReader(new InputStreamReader((zf.getInputStream(entry))));
                    String line;
                    while ((line = br.readLine()) != null) {
                        line = line.toLowerCase();

                        if (line.startsWith("implementation-version")) {
                            version = line.split(":")[1].trim();
                            break outer;
                        }

                        if (line.startsWith("bundle-version")) {
                            version = line.split(":")[1].trim();
                            break outer;
                        }

                        if (line.startsWith("version")) {
                            version = line.split(":")[1].trim();
                            break outer;
                        }

                        if (line.startsWith("manifest-version")) {
                            version = line.split(":")[1].trim();

                            if (!"1.0".equals(version)) {
                                break outer;
                            }

                            version = "";
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (zin != null) {
                try {
                    zin.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

        return version;
    }
}
