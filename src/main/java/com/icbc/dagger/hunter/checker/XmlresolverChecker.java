package com.icbc.dagger.hunter.checker;

/**
 * apache xml commons resolver: An apache-hosted set of DOM, SAX, and JAXP
 * interfaces for use in other XML-based projects.
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class XmlresolverChecker extends NamePatternChecker {
    public XmlresolverChecker() {
        super("apache xml");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*xml-resolver.*\\.jar$");
    }

}
