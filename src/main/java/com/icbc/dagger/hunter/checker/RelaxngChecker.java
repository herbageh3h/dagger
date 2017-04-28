package com.icbc.dagger.hunter.checker;

/**
 * relax ng: Regular Expression Language for XML Next Generation. A schema
 * language for XML.
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class RelaxngChecker extends NamePatternChecker {
    public RelaxngChecker() {
        super("relax ng");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*relaxng.*\\.jar$");
    }

}
