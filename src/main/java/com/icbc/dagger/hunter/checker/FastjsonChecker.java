package com.icbc.dagger.hunter.checker;


public class FastjsonChecker extends NamePatternChecker {
    public FastjsonChecker() {
        super("fastjson");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*fastjson.*\\.jar$");
    }

}
