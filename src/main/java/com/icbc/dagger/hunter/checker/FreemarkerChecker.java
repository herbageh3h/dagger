package com.icbc.dagger.hunter.checker;

/**
 * apache freemarker: A general purpose template engine, used to generate source
 * code, configuration file or email.
 * 
 * <p>
 * <strong>groupId:</strong> org.freemarker
 * <strong>artifactId:</strong> freemarker
 * </p>
 * 
 * @author huanghao
 * @since 20170430
 *
 */
public class FreemarkerChecker extends NamePatternChecker {
    public FreemarkerChecker() {
        super("freemarker");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*freemarker.*\\.jar$");
    }

}
