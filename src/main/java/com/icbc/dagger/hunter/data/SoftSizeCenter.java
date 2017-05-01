package com.icbc.dagger.hunter.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icbc.dagger.hunter.SoftCsvReader;

public class SoftSizeCenter {
    private Map<String, List<OpenSoft>> center;

    public void loadCsv() {
        SoftCsvReader softReader = new SoftCsvReader();
        List<OpenSoft> softList = softReader.readCsv("jar_size.csv");

        center = new HashMap<String, List<OpenSoft>>();
        for (OpenSoft soft : softList) {
            String name = soft.getName();

            if (center.containsKey(name)) {
                center.get(name).add(soft);
            } else {
                List<OpenSoft> softHistList = new ArrayList<OpenSoft>();
                softHistList.add(soft);
                center.put(name, softHistList);
            }
        }
    }

    public boolean contains(String softName) {
        return center.containsKey(softName);
    }

    public List<OpenSoft> getSoftHist(String softName) {
        return center.get(softName);
    }
}
