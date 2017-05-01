package com.icbc.dagger.hunter.checker;

/**
 * apache log4j: Logging framework.
 * 
 * <ul>
 * <li>groupId:log4j</li>
 * <li>artifactId: log4j</li>
 * </ul>
 * 
 * @author huanghao
 * @since 20170501
 *
 */
public class Log4jChecker extends NamePatternChecker {
    public Log4jChecker() {
        super("log4j");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*log4j.*\\.jar$");
    }
}
