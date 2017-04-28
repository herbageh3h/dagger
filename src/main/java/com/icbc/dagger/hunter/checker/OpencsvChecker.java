package com.icbc.dagger.hunter.checker;

/**
 * opencsv: A simple CSV parser for java.
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class OpencsvChecker extends NamePatternChecker {
    public OpencsvChecker() {
        super("opencsv");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*opencsv.*\\.jar$");
    }

}
