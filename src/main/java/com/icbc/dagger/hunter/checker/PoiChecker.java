package com.icbc.dagger.hunter.checker;

public class PoiChecker extends NamePatternChecker {
    public PoiChecker() {
        super("poi");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*poi.*\\.jar$");
    }
}
