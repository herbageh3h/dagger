package com.icbc.dagger.hunter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.icbc.dagger.hunter.checker.Checker;
import com.icbc.dagger.hunter.checker.FastjsonChecker;
import com.icbc.dagger.hunter.checker.JacksonChecker;
import com.icbc.dagger.hunter.data.ThirdPartySoft;
import com.icbc.dagger.util.PrintUtil;
import com.icbc.dagger.util.TimeStat;

public class SoftScanner {
    private AppFinder appFinder = new AppFinder();
    private VersionFinder versionFinder = new VersionFinder();
    private List<Checker> checkerList;

    public List<ThirdPartySoft> getSoftList(List<String> fileList) {
        List<ThirdPartySoft> softList = new ArrayList<ThirdPartySoft>();

        for (String path : fileList) {
            ThirdPartySoft soft = new ThirdPartySoft();
            soft.setPath(path);

            fillApp(soft);

            soft.setCategory(findCategory(path));

            fillVersion(soft);

            softList.add(soft);
        }

        return softList;
    }

    private void fillVersion(ThirdPartySoft soft) {
        versionFinder.fillVersion(soft);
    }

    private void fillApp(ThirdPartySoft soft) {
        appFinder.fillApp(soft);
    }

    private String findCategory(String path) {
        for (Checker checker : checkerList) {
            if (checker.pass(path)) {
                return checker.getName();
            }
        }
        return "NO-CATEGORY";
    }

    public void setCheckerList(List<Checker> checkerList) {
        this.checkerList = checkerList;
    }

    public static void main(String[] args) throws Exception {
        TimeStat timer = new TimeStat();
        timer.start();

        BufferedReader br = new BufferedReader(new FileReader(new File("D:/tmp/file_list.txt")));

        List<String> fileList = new ArrayList<String>();
        String line = null;
        while ((line = br.readLine()) != null) {
            fileList.add(line);
        }
        br.close();

        SoftScanner softTool = new SoftScanner();
        List<Checker> checkerList = new ArrayList<Checker>();
        checkerList.add(new FastjsonChecker());
        checkerList.add(new JacksonChecker());
        softTool.setCheckerList(checkerList);

        List<ThirdPartySoft> softList = softTool.getSoftList(fileList);
        PrintUtil.printList(softList, "soft_list.csv");

        timer.end();
        System.out.println("Program Running Time: " + timer.delta());
    }
}
