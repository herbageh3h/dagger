package com.icbc.dagger.hunter.checker;

/**
 * ehcache: Distributed cache for general purpose.
 * 
 * <ul>
 * <li>groupId: org.ehcache</li>
 * <li>artifactId: ehcache</li>
 * </ul>
 * 
 * @author huanghao
 * @since 20170430
 *
 */
public class EhcacheChecker extends NamePatternChecker {
    public EhcacheChecker() {
        super("ehcache");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*ehcache.*\\.jar$");
    }

}
