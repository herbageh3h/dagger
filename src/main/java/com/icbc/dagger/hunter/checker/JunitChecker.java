package com.icbc.dagger.hunter.checker;

/**
 * junit: A unit testing framework for Java.
 * 
 * @author huanghao
 * @since 20170430
 *
 */
public class JunitChecker extends NamePatternChecker {
    public JunitChecker() {
        super("junit");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*junit.*\\.jar$");
    }

}
