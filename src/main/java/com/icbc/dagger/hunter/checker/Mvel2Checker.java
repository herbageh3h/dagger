package com.icbc.dagger.hunter.checker;

/**
 * mvel2: A powerful expression language for Java-based applications.
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class Mvel2Checker extends NamePatternChecker {
    public Mvel2Checker() {
        super("mvel");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*mvel2.*\\.jar$");
    }

}
