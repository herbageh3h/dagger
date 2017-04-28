package com.icbc.dagger.hunter;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.icbc.dagger.hunter.data.CtpSoft;
import com.icbc.dagger.hunter.data.ThirdPartySoft;
import com.icbc.dagger.util.FileUtil;

public class CtpCleaner {
    private CtpSoft ctpSoft;

    public void cleanCtp(List<ThirdPartySoft> fullList) {
        List<ThirdPartySoft> ctpList = new ArrayList<ThirdPartySoft>();

        for (ThirdPartySoft soft : fullList) {
            if ("ctp".equals(soft.getCategory())) {
                ctpList.add(soft);
            }
        }

        for (ThirdPartySoft ctp : ctpList) {
            String path = ctp.getPath();
            String dir = new File(path).getParent();
            List<ThirdPartySoft> componentList = ctpSoft.getCtpComponents(ctp.signature());

            if (componentList == null) {
                continue;
            }

            Iterator<ThirdPartySoft> it = fullList.iterator();
            while (it.hasNext()) {
                ThirdPartySoft soft = it.next();

                if (!FileUtil.sameDir(soft.getPath(), dir)) {
                    continue;
                }

                if (componentList.contains(soft)) {
                    it.remove();
                }
            }
        }
    }

    public void setCtpSoft(CtpSoft ctpSoft) {
        this.ctpSoft = ctpSoft;
    }
}
