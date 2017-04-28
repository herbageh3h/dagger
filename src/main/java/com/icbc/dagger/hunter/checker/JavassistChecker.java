package com.icbc.dagger.hunter.checker;

/**
 * javassist: A java library providing a means to manipulate the java bytecode
 * of an application.
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class JavassistChecker extends NamePatternChecker {
    public JavassistChecker() {
        super("javassist");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*javassist.*\\.jar$");
    }

}
