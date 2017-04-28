package com.icbc.dagger.hunter.checker;

public class AntChecker extends NamePatternChecker {
    public AntChecker() {
        super("ant");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*ant-.*\\.jar$");
    }

}
