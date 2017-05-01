package com.icbc.dagger.hunter.excluder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BlackListExcluder implements Excluder {
    private List<String> blackList;

    public BlackListExcluder() {
        blackList = new ArrayList<String>();
        blackList.add("commons-httpclient-test.jar");
    };

    @Override
    public boolean exclude(File f) {
        String fileName = f.getName();

        if (blackList.contains(fileName)) {
            return true;
        }

        return false;
    }

}
