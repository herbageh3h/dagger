package com.icbc.dagger.hunter.checker;

public class JarChecker extends NamePatternChecker {
    public JarChecker() {
        super("jar");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*\\.jar$");
    }

}
