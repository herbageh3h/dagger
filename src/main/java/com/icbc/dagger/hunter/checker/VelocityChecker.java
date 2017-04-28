package com.icbc.dagger.hunter.checker;

public class VelocityChecker extends NamePatternChecker {
    public VelocityChecker() {
        super("velocity");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*velocity.*\\.jar$");
    }

}
