package com.icbc.dagger.hunter.checker;

public class HttpComponentsChecker extends NamePatternChecker {
    public HttpComponentsChecker() {
        super("httpcomponents");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*(httpclient|httpcore).*\\.jar$");
    }
}
