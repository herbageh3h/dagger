package com.icbc.dagger.hunter.checker;


public class JacksonChecker extends NamePatternChecker {

    public JacksonChecker() {
        super("jackson");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*jackson.*\\.jar$");
    }

}
