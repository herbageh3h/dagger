package com.icbc.dagger.hunter.checker;

/**
 * jcifs: A client library that implements the CIFS/SMB networking protocol.
 * 
 * <ul>
 * <li>groupId: jcifs</li>
 * <li>artifactId: jcifs</li>
 * </ul>
 * 
 * @author huanghao
 * @since 20170430
 *
 */
public class JcifsChecker extends NamePatternChecker {
    public JcifsChecker() {
        super("jcifs");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*jcifs.*\\.jar$");
    }

}
