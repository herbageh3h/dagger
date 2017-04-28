package com.icbc.dagger.hunter.checker;

public class JettyChecker extends NamePatternChecker {
    public JettyChecker() {
        super("jetty");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*jetty.*\\.jar$");
    }

}
