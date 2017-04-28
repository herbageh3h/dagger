package com.icbc.dagger.hunter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.icbc.dagger.hunter.checker.Checker;

@SuppressWarnings("serial")
public class SelfJarExcludeChecker implements Checker {
    private String name;

    public SelfJarExcludeChecker(String name) {
        this.name = name;
    }

    private List<String> blackList = new ArrayList<String>() {
        {
            add("amcclient.jar");
            add("ctp-access.jar");
            add("ctp-components.jar");
            add("ctp-dataservice.jar");
            add("ctp-engine.jar");
            add("ctp-extend.jar");
            add("ctp-framework.jar");
            add("ctp-infra.jar");
            add("ctp-internal-memcached.jar");
            add("ctp-rest.jar");
            add("ctp-service.jar");
            add("ctp-widget.jar");
            add("ssic.jar");
            add("ojdbc6.jar");
        }
    };

    @Override
    public boolean pass(File f) {
        if (blackList.contains(f.getName().toLowerCase())) {
            return false;
        }

        return true;
    }

    @Override
    public boolean pass(String path) {
        return pass(new File(path));
    }

    @Override
    public String getName() {
        return name;
    }

}
