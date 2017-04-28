package com.icbc.dagger.hunter.checker;

public class Log4jChecker extends NamePatternChecker {
    public Log4jChecker() {
        super("log4j");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*log4j.*\\.jar$");
    }
}
