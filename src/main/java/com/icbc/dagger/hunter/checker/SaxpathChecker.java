package com.icbc.dagger.hunter.checker;

/**
 * saxpath: Merged into jaxen.
 * @author kfzx-huanghao
 *
 */
public class SaxpathChecker extends NamePatternChecker {
    public SaxpathChecker() {
        super("saxpath");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*saxpath.*\\.jar$");
    }

}
