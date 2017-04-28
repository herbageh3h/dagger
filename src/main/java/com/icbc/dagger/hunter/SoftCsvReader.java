package com.icbc.dagger.hunter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.icbc.dagger.hunter.data.ThirdPartySoft;
import com.icbc.dagger.util.PrintUtil;
import com.icbc.dagger.util.PropUtil;

public class SoftCsvReader {
    public List<ThirdPartySoft> readCsv(String fileName) {
        List<ThirdPartySoft> retList = new ArrayList<ThirdPartySoft>();
        String datadir = PropUtil.getProperty("datadir");

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(datadir, fileName)));
            String line = "";
            while ((line = br.readLine()) != null) {
                if ("".equals(line.trim())) {
                    break;
                }

                String[] ss = line.split(",");

                if (ss.length < 5) {
                    break;
                }

                ThirdPartySoft soft = new ThirdPartySoft();
                soft.setApp(ss[0]);
                soft.setCategory(ss[1]);
                soft.setName(ss[2]);
                soft.setVersion(ss[3]);
                soft.setPath(ss[4]);

                if (ss.length > 5) {
                    soft.setSize(Long.parseLong(ss[5]));
                }

                retList.add(soft);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return retList;
    }

    public static void main(String[] args) {
        SoftCsvReader softReader = new SoftCsvReader();
        List<ThirdPartySoft> ctpJarList = softReader.readCsv("ctp_jar.csv");
        PrintUtil.printList(ctpJarList, "ctp_jar_copy.csv");
    }

}
