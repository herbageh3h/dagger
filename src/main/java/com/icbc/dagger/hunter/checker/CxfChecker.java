package com.icbc.dagger.hunter.checker;

public class CxfChecker extends NamePatternChecker {
    public CxfChecker() {
        super("cxf");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*cxf.*\\.jar$");
    }

}
