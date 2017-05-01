package com.icbc.dagger.hunter;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.icbc.dagger.hunter.data.CtpSoft;
import com.icbc.dagger.hunter.data.OpenSoft;
import com.icbc.dagger.util.FileUtil;

public class CtpCleaner {
    private CtpSoft ctpSoft;

    public void cleanCtp(List<OpenSoft> fullList) {
        List<OpenSoft> ctpList = new ArrayList<OpenSoft>();

        for (OpenSoft soft : fullList) {
            if ("ctp".equals(soft.getCategory())) {
                ctpList.add(soft);
            }
        }

        for (OpenSoft ctp : ctpList) {
            String path = ctp.getPath();
            String dir = new File(path).getParent();
            List<OpenSoft> componentList = ctpSoft.getCtpComponents(ctp.signature());

            if (componentList == null) {
                continue;
            }

            Iterator<OpenSoft> it = fullList.iterator();
            while (it.hasNext()) {
                OpenSoft soft = it.next();

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
