package com.icbc.dagger.hunter;

import java.io.File;

import com.icbc.dagger.hunter.data.OpenSoft;
import com.icbc.dagger.util.PropUtil;

public class AppFinder {
    private String ROOTDIR;

    public AppFinder() {
        ROOTDIR = PropUtil.getProperty("rootdir");
        if (!ROOTDIR.endsWith("/")) {
            ROOTDIR += "/";
        }
    }

    public void fillApp(OpenSoft soft) {
        String path = soft.getPath();
        String app = "";

        String workpath = path.replace("\\", "/");
        if (workpath.indexOf(ROOTDIR) != -1) {
            workpath = workpath.substring(ROOTDIR.length(), workpath.length());
            String[] ss = workpath.split("/");
            app = ss[0];
        } else {
            app = new File(workpath).getParentFile().getName();
        }

        soft.setApp(app);
    }
}
