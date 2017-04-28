package com.icbc.dagger.hunter.checker;

/**
 * cglib: A powerful, high performance and quality code generation library.
 * 
 * @author kfzx-huanghao
 * @since 20170426
 *
 */
public class CglibChecker extends NamePatternChecker {
    public CglibChecker() {
        super("cglib");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*cglib.*\\.jar$");
    }

}
