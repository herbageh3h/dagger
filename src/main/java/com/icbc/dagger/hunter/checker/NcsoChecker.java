package com.icbc.dagger.hunter.checker;

/**
 * ncso: Domino notes client.
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class NcsoChecker extends NamePatternChecker {
    public NcsoChecker() {
        super("ncso");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*ncso.*\\.jar$");
    }

}
