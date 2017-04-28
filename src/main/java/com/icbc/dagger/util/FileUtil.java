package com.icbc.dagger.util;

import java.io.File;

public class FileUtil {
    public static boolean sameDir(String path, String benchDir) {
        String dir = new File(path).getParent();
        return dir.equals(benchDir);
    }

    public static long getSize(String path) {
        return new File(path).length();
    }

    public static void main(String[] args) {
        System.out.println(FileUtil.getSize("D:/ctp/V5.5.00.0/json.jar"));
    }
}
