package com.icbc.dagger.hunter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.icbc.dagger.hunter.data.OpenSoft;
import com.icbc.dagger.util.PrintUtil;
import com.icbc.dagger.util.TimeStat;

public class SoftScanner {
    private AppFinder appFinder = new AppFinder();
    private CategoryFinder categoryFinder = new CategoryFinder();
    private VersionFinder versionFinder = new VersionFinder();

    public List<OpenSoft> genSoftList(List<String> fileList) {
        List<OpenSoft> softList = new ArrayList<OpenSoft>();

        for (String path : fileList) {
            OpenSoft soft = new OpenSoft();
            soft.setPath(path);

            fillApp(soft);

            fillCategory(soft);

            fillVersion(soft);

            softList.add(soft);
        }

        return softList;
    }

    private void fillVersion(OpenSoft soft) {
        versionFinder.fillVersion(soft);
    }

    private void fillApp(OpenSoft soft) {
        appFinder.fillApp(soft);
    }

    private void fillCategory(OpenSoft soft) {
        categoryFinder.fillCategory(soft);
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

        List<OpenSoft> softList = softTool.genSoftList(fileList);
        PrintUtil.printList(softList, "soft_list.csv");

        timer.end();
        System.out.println("Program Running Time: " + timer.delta());
    }
}
