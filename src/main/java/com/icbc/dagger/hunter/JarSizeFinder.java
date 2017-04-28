package com.icbc.dagger.hunter;

import java.util.ArrayList;
import java.util.List;

import com.icbc.dagger.hunter.checker.Checker;
import com.icbc.dagger.hunter.checker.JarChecker;
import com.icbc.dagger.hunter.data.ThirdPartySoft;
import com.icbc.dagger.hunter.excluder.Excluder;
import com.icbc.dagger.util.FileUtil;
import com.icbc.dagger.util.PrintUtil;
import com.icbc.dagger.util.PropUtil;

public class JarSizeFinder {
    private AppFinder appFinder = new AppFinder();
    private VersionFinder versionFinder = new VersionFinder();

    public List<ThirdPartySoft> scanJar(String dir) {
        return scanJar(dir, "");
    }

    public List<ThirdPartySoft> scanJar(String dir, String softName) {
        FileScanner scanner = new FileScanner();
        scanner.setTraverseFilter(new DefaultFilenameFilter());

        List<Checker> checkerList = new ArrayList<Checker>();
        checkerList.add(new JarChecker());
        scanner.setCheckerList(checkerList);

        List<Excluder> excluderList = new ArrayList<Excluder>();
        scanner.setExcluderList(excluderList);

        List<String> fileList = scanner.genFileList(dir);
        PrintUtil.printList(fileList, "jar_list.txt");

        List<ThirdPartySoft> jarList = new ArrayList<ThirdPartySoft>();
        for (String path : fileList) {
            ThirdPartySoft jar = new ThirdPartySoft();
            jar.setPath(path);

            if (!"".equals(softName)) {
                jar.setCategory(softName);
            }

            appFinder.fillApp(jar);
            versionFinder.fillVersion(jar);
            jar.setSize(FileUtil.getSize(path));

            jarList.add(jar);
        }

        return jarList;
    }

    public static void main(String[] args) {
        JarSizeFinder scanner = new JarSizeFinder();
        String scandir = PropUtil.getProperty("scandir");
        List<ThirdPartySoft> jarList = scanner.scanJar(scandir, "ant");
        PrintUtil.printList(jarList, "jar_size_list.csv");
    }
}
