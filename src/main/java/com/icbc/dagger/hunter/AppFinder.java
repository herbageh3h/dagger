package com.icbc.dagger.hunter;

import com.icbc.dagger.hunter.data.ThirdPartySoft;
import com.icbc.dagger.util.PropUtil;

public class AppFinder {
    private String ROOTDIR;

    {
        ROOTDIR = PropUtil.getProperty("rootdir");
        if (!ROOTDIR.endsWith("/")) {
            ROOTDIR += "/";
        }
    }

    public void fillApp(ThirdPartySoft soft) {
        String path = soft.getPath();

        String workpath = path.replace("\\", "/");
        if (workpath.indexOf(ROOTDIR) != -1) {
            workpath = workpath.substring(ROOTDIR.length(), workpath.length());
        }
        String[] ss = workpath.split("/");

        soft.setApp(ss[0]);
    }
}
