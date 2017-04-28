package com.icbc.dagger.hunter.checker;

/**
 * sdo: Oracle(BEA) service data object. A technology that allows heterogeneous
 * data to be accessed in a uniform way.
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class SdoChecker extends NamePatternChecker {
    public SdoChecker() {
        super("sdo");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*sdo.*\\.jar$");
    }

}
