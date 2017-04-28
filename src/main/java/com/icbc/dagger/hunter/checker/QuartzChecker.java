package com.icbc.dagger.hunter.checker;

/**
 * quartz: Job scheduler.
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class QuartzChecker extends NamePatternChecker {
    public QuartzChecker() {
        super("quartz");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*quartz.*\\.jar$");
    }

}
