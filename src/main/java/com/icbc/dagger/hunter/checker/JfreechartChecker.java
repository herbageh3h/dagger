package com.icbc.dagger.hunter.checker;

public class JfreechartChecker extends NamePatternChecker {
    public JfreechartChecker() {
        super("jfreechart");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*jfreechart.*\\.jar$");
    }

}
