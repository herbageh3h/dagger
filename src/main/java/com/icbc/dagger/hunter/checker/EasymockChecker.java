package com.icbc.dagger.hunter.checker;

/**
 * easymock: Provide an easy way to create mock objects for interfaces and
 * classes. Generating them on the fly.
 * 
 * @author huanghao
 * @since 20170430
 *
 */
public class EasymockChecker extends NamePatternChecker {
    public EasymockChecker() {
        super("easymock");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*easymock.*\\.jar$");
    }

}
