package com.icbc.dagger.hunter.checker;

public class JdomChecker extends NamePatternChecker {
    public JdomChecker() {
        super("jdom");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*jdom.*\\.jar$");
    }

}
