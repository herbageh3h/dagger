package com.icbc.dagger.hunter.finder;

import com.icbc.dagger.hunter.checker.CtpcoreChecker;
import com.icbc.dagger.hunter.data.OpenSoft;

public class CtpHelper {
    private CtpcoreChecker checker = new CtpcoreChecker();
    private SizeHelper sizeHelper = new SizeHelper();
    private MetaHelper metaHelper = new MetaHelper();

    public String findVersion(OpenSoft soft) {
        String path = soft.getPath();

        if (!checker.pass(path)) { 
            return "";
        }

        String name = soft.getName();

        if ("cte4ctp".equalsIgnoreCase(name)) {
            return sizeHelper.findVersion(soft);
        }

        String version = metaHelper.findVersion(soft);
        if (!"".equals(version)) {
            return version;
        }

        version = sizeHelper.findVersion(soft);

        return version;
    }
}
