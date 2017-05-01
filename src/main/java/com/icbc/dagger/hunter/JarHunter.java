package com.icbc.dagger.hunter;

import java.util.List;

import com.icbc.dagger.hunter.data.OpenSoft;
import com.icbc.dagger.util.PrintUtil;
import com.icbc.dagger.util.TimeStat;

public class JarHunter {
    private JarDownloader jarDownloader = new JarDownloader();
    private JarSizeFinder scanner = new JarSizeFinder();

    public List<OpenSoft> findJars(final String groupId, final String artifactId) {
        jarDownloader.download(groupId, artifactId);
        String softdir = jarDownloader.destdir(groupId, artifactId);
        List<OpenSoft> jarList = scanner.scanJar(softdir, groupId);

        return jarList;
    }

    public static void main(String[] args) {
        TimeStat timer = new TimeStat();
        timer.start();

        JarHunter hunter = new JarHunter();
        List<OpenSoft> list = hunter.findJars("org.easymock", "easymockclassextension");
        PrintUtil.printList(list, "jar_size_list.csv");

        timer.end();
        System.out.println("Program Running Time: " + timer.delta());
    }
}
