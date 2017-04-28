package com.icbc.dagger.hunter.checker;

public class AopallianceChecker extends NamePatternChecker {
    public AopallianceChecker() {
        super("aopalliance");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*aopalliance.*\\.jar$");
    }

}
