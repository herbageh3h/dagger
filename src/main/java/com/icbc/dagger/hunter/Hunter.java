package com.icbc.dagger.hunter;

import java.util.ArrayList;
import java.util.List;

import com.icbc.dagger.hunter.checker.Checker;
import com.icbc.dagger.hunter.data.CtpSoft;
import com.icbc.dagger.hunter.data.ThirdPartySoft;
import com.icbc.dagger.hunter.excluder.BlackListExcluder;
import com.icbc.dagger.hunter.excluder.Excluder;
import com.icbc.dagger.util.PropUtil;
import com.icbc.dagger.util.TimeStat;

/**
 * Hunter: code monitor tool.
 * 
 * <p>
 * sub proj under dagger.
 * </p>
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class Hunter {
    public void runScanner() {

        FileScanner scanner = new FileScanner();
        scanner.setTraverseFilter(new DefaultFilenameFilter());

        CheckerArmy checkers = new CheckerArmy();
        List<Checker> checkerList = checkers.jarCheckers();
        scanner.setCheckerList(checkerList);

        List<Excluder> excluderList = new ArrayList<Excluder>();
        excluderList.add(new BlackListExcluder());
        scanner.setExcluderList(excluderList);

        String scandir = PropUtil.getProperty("scandir");
        List<String> fileList = scanner.genFileList(scandir);

        SoftScanner softScanner = new SoftScanner();
        softScanner.setCheckerList(checkerList);
        List<ThirdPartySoft> softList = softScanner.getSoftList(fileList);

        SoftCsvWriter writer = new SoftCsvWriter();
        writer.printSoftList(softList, "soft_list.csv");

        CtpSoft ctp = new CtpSoft();
        ctp.loadCsv();
        CtpCleaner cleaner = new CtpCleaner();
        cleaner.setCtpSoft(ctp);
        cleaner.cleanCtp(softList);
        writer.printSoftList(softList, "clean_list.csv");
    }

    public static void main(String[] args) {
        TimeStat timer = new TimeStat();
        timer.start();

        Hunter app = new Hunter();
        app.runScanner();

        timer.end();
        System.out.println("Program Running Time: " + timer.delta());
    }
}
