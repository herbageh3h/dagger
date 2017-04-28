package com.icbc.dagger.hunter.checker;

public class CommonsChecker extends NamePatternChecker {
    public CommonsChecker() {
        super("commons");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*commons.*\\.jar$");
    }

}
