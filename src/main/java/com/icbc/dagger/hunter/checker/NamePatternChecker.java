package com.icbc.dagger.hunter.checker;

import java.io.File;
import java.util.regex.Pattern;

public class NamePatternChecker implements Checker {
    protected String name;
    protected Pattern pattern;

    public NamePatternChecker(String name, String regex) {
        this.name = name;
        setRegex(regex);
    }

    public NamePatternChecker(String name) {
        this.name = name;
        setupPattern();
    }

    @Override
    public boolean pass(File f) {
        return pattern.matcher(f.getName().toLowerCase()).matches();
    }

    @Override
    public boolean pass(String path) {
        return pass(new File(path));
    }

    public void setRegex(String regex) {
        pattern = Pattern.compile(regex);
    }

    protected void setupPattern() {
    }

    public String getName() {
        return name;
    }

}
