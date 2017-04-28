package com.icbc.dagger.hunter.checker;

public class Slf4jChecker extends NamePatternChecker {
    public Slf4jChecker() {
        super("slf4j");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*slf4j.*\\.jar$");
    }

}
