package com.icbc.dagger.hunter.checker;

/**
 * rhino js: An open source implementation of Javascript written entirely in
 * Java. It is typically embedded into java applications to provide scripting to
 * end users.
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class RhinoChecker extends NamePatternChecker {
    public RhinoChecker() {
        super("rhino");
    }

    @Override
    protected void setupPattern() {
        this.setRegex("js[\\.-].*jar$");
    }

}
