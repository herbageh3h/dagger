package com.icbc.dagger.hunter.checker;

/**
 * ctp: ICBC Java development platform
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class CtpcoreChecker extends NamePatternChecker {
    public CtpcoreChecker() {
        super("ctp");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*(ctp-engine|core4ctp|cte4ctp).*\\.jar$");
    }

}
