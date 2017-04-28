package com.icbc.dagger.hunter.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icbc.dagger.hunter.SoftCsvReader;

public class SoftSizeCenter {
    private Map<String, List<ThirdPartySoft>> center;

    public void loadCsv() {
        SoftCsvReader softReader = new SoftCsvReader();
        List<ThirdPartySoft> softList = softReader.readCsv("jar_size.csv");

        center = new HashMap<String, List<ThirdPartySoft>>();
        for (ThirdPartySoft soft : softList) {
            String name = soft.getName();

            if (center.containsKey(name)) {
                center.get(name).add(soft);
            } else {
                List<ThirdPartySoft> softHistList = new ArrayList<ThirdPartySoft>();
                softHistList.add(soft);
                center.put(name, softHistList);
            }
        }
    }

    public boolean contains(String softName) {
        return center.containsKey(softName);
    }

    public List<ThirdPartySoft> getSoftHist(String softName) {
        return center.get(softName);
    }
}
