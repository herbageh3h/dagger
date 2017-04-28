package com.icbc.dagger.hunter.checker;

public class AsmChecker extends NamePatternChecker {
    public AsmChecker() {
        super("asm");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*asm.*\\.jar$");
    }

}
