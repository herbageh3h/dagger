package com.icbc.dagger.hunter.checker;

public class AxiomChecker  extends NamePatternChecker {
    public AxiomChecker() {
        super("axiom");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*axiom.*\\.jar$");
    }

}
