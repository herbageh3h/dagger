package com.icbc.dagger.hunter.checker;

/**
 * apache neethi: General framework for the programmers to use WS Policy.
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class NeethiChecker extends NamePatternChecker {
    public NeethiChecker() {
        super("neethi");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*neethi.*\\.jar$");
    }

}
