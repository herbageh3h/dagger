package com.icbc.dagger.hunter.checker;

public class BatisChecker extends NamePatternChecker {
    public BatisChecker() {
        super("batis");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*batis.*\\.jar$");
    }
}
