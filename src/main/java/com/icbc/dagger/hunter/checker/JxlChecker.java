package com.icbc.dagger.hunter.checker;

public class JxlChecker extends NamePatternChecker {
    public JxlChecker() {
        super("jxl");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*jxl.*\\.jar$");
    }

}
