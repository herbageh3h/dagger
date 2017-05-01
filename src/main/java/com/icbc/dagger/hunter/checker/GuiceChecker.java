package com.icbc.dagger.hunter.checker;

/**
 * guice: Provides support for dependency injection using anntotations to
 * configure Java objects.
 * 
 * @author huanghao
 * @since 20170430
 *
 */
public class GuiceChecker extends NamePatternChecker {
    public GuiceChecker() {
        super("guice");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*guice.*\\.jar$");
    }

}
