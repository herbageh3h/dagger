package com.icbc.dagger.hunter.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icbc.dagger.hunter.SoftCsvReader;

public class CtpSoft {
    private Map<String, List<ThirdPartySoft>> ctpSoft;

    public void loadCsv() {
        SoftCsvReader softReader = new SoftCsvReader();
        List<ThirdPartySoft> ctpJarList = softReader.readCsv("ctp_jar.csv");

        ctpSoft = new HashMap<String, List<ThirdPartySoft>>();
        for (ThirdPartySoft jar : ctpJarList) {
            String app = jar.getApp();

            if (ctpSoft.containsKey(app)) {
                ctpSoft.get(app).add(jar);
            } else {
                List<ThirdPartySoft> jarList = new ArrayList<ThirdPartySoft>();
                jarList.add(jar);
                ctpSoft.put(app, jarList);
            }
        }

        Map<String, List<ThirdPartySoft>> signatureMap = new HashMap<String, List<ThirdPartySoft>>();
        for (String ctpVersion : ctpSoft.keySet()) {
            List<ThirdPartySoft> jarList = ctpSoft.get(ctpVersion);

            for (ThirdPartySoft jar : jarList) {
                if ("ctp".equals(jar.getCategory())) {
                    signatureMap.put(jar.signature(), jarList);
                }
            }
        }
        ctpSoft.putAll(signatureMap);
    }

    public List<ThirdPartySoft> getCtpComponents(String signature) {
        return ctpSoft.get(signature);
    }

    public static void main(String[] args) {
        CtpSoft ctp = new CtpSoft();
        ctp.loadCsv();
    }
}
