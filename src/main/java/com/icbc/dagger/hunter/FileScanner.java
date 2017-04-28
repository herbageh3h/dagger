package com.icbc.dagger.hunter;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import com.icbc.dagger.hunter.checker.AntChecker;
import com.icbc.dagger.hunter.checker.AntlrChecker;
import com.icbc.dagger.hunter.checker.AopallianceChecker;
import com.icbc.dagger.hunter.checker.AsmChecker;
import com.icbc.dagger.hunter.checker.AxiomChecker;
import com.icbc.dagger.hunter.checker.BatisChecker;
import com.icbc.dagger.hunter.checker.Checker;
import com.icbc.dagger.hunter.checker.CommonsChecker;
import com.icbc.dagger.hunter.checker.CxfChecker;
import com.icbc.dagger.hunter.checker.Dom4jChecker;
import com.icbc.dagger.hunter.checker.FastjsonChecker;
import com.icbc.dagger.hunter.checker.HttpComponentsChecker;
import com.icbc.dagger.hunter.checker.JacksonChecker;
import com.icbc.dagger.hunter.checker.JbpmChecker;
import com.icbc.dagger.hunter.checker.JdomChecker;
import com.icbc.dagger.hunter.checker.JedisChecker;
import com.icbc.dagger.hunter.checker.JettyChecker;
import com.icbc.dagger.hunter.checker.JfreechartChecker;
import com.icbc.dagger.hunter.checker.JxlChecker;
import com.icbc.dagger.hunter.checker.Log4jChecker;
import com.icbc.dagger.hunter.checker.PoiChecker;
import com.icbc.dagger.hunter.checker.Slf4jChecker;
import com.icbc.dagger.hunter.checker.SpringChecker;
import com.icbc.dagger.hunter.checker.StrutsChecker;
import com.icbc.dagger.hunter.checker.VelocityChecker;
import com.icbc.dagger.hunter.data.ThirdPartySoft;
import com.icbc.dagger.hunter.excluder.CtpExcluder;
import com.icbc.dagger.hunter.excluder.Excluder;
import com.icbc.dagger.util.PrintUtil;
import com.icbc.dagger.util.TimeStat;

public class FileScanner {
    private List<Checker> checkerList;
    private List<Excluder> excluderList;
    private FilenameFilter traverseFilter;

    public List<String> genFileList(String path) {
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

        checkerList.add(new FastjsonChecker());
        checkerList.add(new JacksonChecker());
        checkerList.add(new StrutsChecker());
        checkerList.add(new BatisChecker());
        checkerList.add(new JbpmChecker());
        checkerList.add(new SpringChecker());
        checkerList.add(new JdomChecker());
        checkerList.add(new Dom4jChecker());
        checkerList.add(new CxfChecker());
        checkerList.add(new VelocityChecker());
        checkerList.add(new Slf4jChecker());
        checkerList.add(new PoiChecker());
        checkerList.add(new JfreechartChecker());
        checkerList.add(new Log4jChecker());
        checkerList.add(new JettyChecker());
        checkerList.add(new CommonsChecker());
        checkerList.add(new JedisChecker());
        checkerList.add(new AntChecker());
        checkerList.add(new JxlChecker());
        checkerList.add(new HttpComponentsChecker());
        checkerList.add(new AntlrChecker());
        checkerList.add(new AopallianceChecker());
        checkerList.add(new AsmChecker());
        checkerList.add(new AxiomChecker());

        scanner.setCheckerList(checkerList);

        List<Excluder> eliminatorList = new ArrayList<Excluder>();
        eliminatorList.add(new CtpExcluder());
        scanner.setExcluderList(eliminatorList);

        List<String> fileList = scanner.genFileList("D:/repos/cms");
        PrintUtil.printList(fileList, "file_list.txt");

        SoftScanner softScanner = new SoftScanner();
        softScanner.setCheckerList(checkerList);
        List<ThirdPartySoft> softList = softScanner.getSoftList(fileList);
        PrintUtil.printList(softList, "soft_list.csv");

        timer.end();
        System.out.println("Program Running Time: " + timer.delta());
    }

}
