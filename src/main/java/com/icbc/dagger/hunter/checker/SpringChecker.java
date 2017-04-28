package com.icbc.dagger.hunter.checker;

public class SpringChecker extends NamePatternChecker {
    public SpringChecker() {
        super("spring");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*spring.*\\.jar$");
    }

}
