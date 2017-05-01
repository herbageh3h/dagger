package com.icbc.dagger.hunter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import com.icbc.dagger.hunter.data.OpenSoft;
import com.icbc.dagger.util.PropUtil;

public class SoftCsvWriter {
    public void printSoftList(List<OpenSoft> list, String fileName) {
        PrintWriter pw = null;

        try {
            String tmpdir = PropUtil.getProperty("tmpdir");
            pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(tmpdir + File.separator + fileName))));

            for (OpenSoft soft : list) {
                pw.println(soft.csv());
            }

            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
}
