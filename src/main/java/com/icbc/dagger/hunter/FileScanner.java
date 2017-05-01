package com.icbc.dagger.hunter;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import com.icbc.dagger.hunter.checker.Checker;
import com.icbc.dagger.hunter.checker.JarChecker;
import com.icbc.dagger.hunter.data.OpenSoft;
import com.icbc.dagger.hunter.excluder.CtpExcluder;
import com.icbc.dagger.hunter.excluder.Excluder;
import com.icbc.dagger.util.PrintUtil;
import com.icbc.dagger.util.StringUtil;
import com.icbc.dagger.util.TimeStat;

public class FileScanner {
    private List<Checker> checkerList;
    private List<Excluder> excluderList;
    private FilenameFilter traverseFilter;

    public List<String> genFileList(String path) {
        if (StringUtil.isBlank(path)) {
            return new ArrayList<String>();
        }

        File root = new File(path);
        File[] files = root.listFiles(traverseFilter);

        List<String> retList = new ArrayList<String>();
        for (File file : files) {
            if (file.isFile()) {
                if (!checkName(file)) {
                    continue;
                }

                retList.add(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                retList.addAll(genFileList(file.getAbsolutePath()));
            }
        }

        return retList;
    }

    private boolean checkName(File f) {
        for (Excluder eliminator : excluderList) {
            if (eliminator.exclude(f)) {
                return false;
            }
        }

        for (Checker filter : checkerList) {
            if (filter.pass(f)) {
                return true;
            }
        }

        return false;
    }

    public void setCheckerList(List<Checker> checkerList) {
        this.checkerList = checkerList;
    }

    public void setTraverseFilter(FilenameFilter traverseFilter) {
        this.traverseFilter = traverseFilter;
    }

    public void setExcluderList(List<Excluder> excluderList) {
        this.excluderList = excluderList;
    }

    public static void main(String[] args) throws Exception {
        TimeStat timer = new TimeStat();
        timer.start();

        FileScanner scanner = new FileScanner();
        scanner.setTraverseFilter(new DefaultFilenameFilter());

        List<Checker> checkerList = new ArrayList<Checker>();
        checkerList.add(new JarChecker());
        scanner.setCheckerList(checkerList);

        List<Excluder> exluderList = new ArrayList<Excluder>();
        exluderList.add(new CtpExcluder());
        scanner.setExcluderList(exluderList);

        List<String> fileList = scanner.genFileList("/Users/huanghao/repos/cms");
        PrintUtil.printList(fileList, "file_list.txt");

        SoftScanner softScanner = new SoftScanner();
        List<OpenSoft> softList = softScanner.genSoftList(fileList);
        PrintUtil.printList(softList, "soft_list.csv");

        timer.end();
        System.out.println("Program Running Time: " + timer.delta());
    }

}
