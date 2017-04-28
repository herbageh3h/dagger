package com.icbc.dagger.hunter.checker;

public class StrutsChecker extends NamePatternChecker {
    public StrutsChecker() {
        super("struts");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*struts.*\\.jar$");
    }

}
