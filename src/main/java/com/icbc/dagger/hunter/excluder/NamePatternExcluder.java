package com.icbc.dagger.hunter.excluder;

import java.io.File;
import java.util.regex.Pattern;


public class NamePatternExcluder implements Excluder {
    protected Pattern pattern;

    public NamePatternExcluder(String regex) {
        setRegex(regex);
    }

    public NamePatternExcluder() {
        setupPattern();
    }

    @Override
    public boolean exclude(File f) {
        return pattern.matcher(f.getName().toLowerCase()).matches();
    }

    public void setRegex(String regex) {
        pattern = Pattern.compile(regex);
    }

    protected void setupPattern() {
    }

}
