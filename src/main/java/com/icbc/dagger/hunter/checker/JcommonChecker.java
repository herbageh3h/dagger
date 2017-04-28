package com.icbc.dagger.hunter.checker;

/**
 * jcommon: A set of common utility libraries used inside Facebook java
 * projects, internal and open source.
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class JcommonChecker extends NamePatternChecker {
    public JcommonChecker() {
        super("jcommon");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*jcommon.*\\.jar$");
    }

}
