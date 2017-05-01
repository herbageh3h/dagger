package com.icbc.dagger.hunter;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class DefaultFilenameFilter implements FilenameFilter {

    private List<String> blackList;

    public DefaultFilenameFilter() {
        blackList = new ArrayList<String>();
        blackList.add(".git");
        blackList.add("vaim");
    }

    @Override
    public boolean accept(File dir, String name) {
        if (blackList.contains(name.toLowerCase())) {
            return false;
        }

        return true;
    }

}
