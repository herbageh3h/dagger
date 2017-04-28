package com.icbc.dagger.hunter.checker;

public class JbpmChecker extends NamePatternChecker {
    public JbpmChecker() {
        super("jbpm");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*jbpm.*\\.jar$");
    }

}
