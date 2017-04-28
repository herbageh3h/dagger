package com.icbc.dagger.hunter.checker;

public class Dom4jChecker extends NamePatternChecker {
    public Dom4jChecker() {
        super("dom4j");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*dom4j.*\\.jar$");
    }


}
