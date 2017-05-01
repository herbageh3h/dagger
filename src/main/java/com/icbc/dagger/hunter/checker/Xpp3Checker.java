package com.icbc.dagger.hunter.checker;

/**
 * xpp3: Xmlpull parser. A streaming Xml pull parser. Used when there is a need
 * to process quickly and efficiently all xml input elements.
 * 
 * <ul>
 * <li>groupId: xpp3</li>
 * <li>artifactId: xpp3</li>
 * </ul>
 * 
 * @author huanghao
 * @since 20170430
 *
 */
public class Xpp3Checker extends NamePatternChecker {
    public Xpp3Checker() {
        super("xpp3");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*xpp3.*\\.jar$");
    }

}
