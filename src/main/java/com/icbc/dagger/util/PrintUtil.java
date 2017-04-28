package com.icbc.dagger.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public class PrintUtil {
    public static void printList(List<?> list) {
        printList(list, "foo.txt");
    }

    public static void printList(List<?> list, String fileName) {
        PrintWriter pw = null;

        try {
            String tmpdir = PropUtil.getProperty("tmpdir");
            pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(tmpdir + File.separator + fileName))));

            for (Object obj : list) {
                pw.println(obj);
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
