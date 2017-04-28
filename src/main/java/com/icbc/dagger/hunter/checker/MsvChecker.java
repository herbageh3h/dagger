package com.icbc.dagger.hunter.checker;

/**
 * msv: Oracle Multi-Schema XML Validator. Validate XML documents against
 * several kinds of XML schemas.
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class MsvChecker extends NamePatternChecker {
    public MsvChecker() {
        super("msv");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*(msv|xsdlib).*\\.jar$");
    }

}
