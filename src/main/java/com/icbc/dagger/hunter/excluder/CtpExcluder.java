package com.icbc.dagger.hunter.excluder;


public class CtpExcluder extends NamePatternExcluder {
    @Override
    protected void setupPattern() {
        this.setRegex(".*ctp.*");
    }
}
