package com.icbc.dagger.hunter.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icbc.dagger.hunter.SoftCsvReader;

public class CtpSoft {
    private Map<String, List<OpenSoft>> ctpSoft;

    public void loadCsv() {
        SoftCsvReader softReader = new SoftCsvReader();
        List<OpenSoft> ctpJarList = softReader.readCsv("ctp_jar.csv");

        ctpSoft = new HashMap<String, List<OpenSoft>>();
        for (OpenSoft jar : ctpJarList) {
            String app = jar.getApp();

            if (ctpSoft.containsKey(app)) {
                ctpSoft.get(app).add(jar);
            } else {
                List<OpenSoft> jarList = new ArrayList<OpenSoft>();
                jarList.add(jar);
                ctpSoft.put(app, jarList);
            }
        }

        Map<String, List<OpenSoft>> signatureMap = new HashMap<String, List<OpenSoft>>();
        for (String ctpVersion : ctpSoft.keySet()) {
            List<OpenSoft> jarList = ctpSoft.get(ctpVersion);

            for (OpenSoft jar : jarList) {
                if ("ctp".equals(jar.getCategory())) {
                    signatureMap.put(jar.signature(), jarList);
                }
            }
        }
        ctpSoft.putAll(signatureMap);
    }

    public List<OpenSoft> getCtpComponents(String signature) {
        return ctpSoft.get(signature);
    }

    public static void main(String[] args) {
        CtpSoft ctp = new CtpSoft();
        ctp.loadCsv();
    }
}
