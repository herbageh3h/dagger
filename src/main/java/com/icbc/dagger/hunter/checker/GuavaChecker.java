package com.icbc.dagger.hunter.checker;

/**
 * guava: Google code library
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class GuavaChecker extends NamePatternChecker {
    public GuavaChecker() {
        super("guava");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*guava.*\\.jar$");
    }

}
