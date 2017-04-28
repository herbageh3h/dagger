package com.icbc.dagger.hunter.checker;

/**
 * apache xmlbean: A java-to-XML binding framework.
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class XmlbeanChecker extends NamePatternChecker {
    public XmlbeanChecker() {
        super("xmlbean");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*xbean.*\\.jar$");
    }

}
