package com.icbc.dagger.hunter.checker;

/**
 * apache httpComponents: Creating and maintaining a toolset of low level Java
 * components focused on HTTP and associated protocols.
 * 
 * @author huanghao
 * @since 20170430
 *
 */
public class HttpComponentsChecker extends NamePatternChecker {
    public HttpComponentsChecker() {
        super("httpcomponents");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*(httpclient|httpcore|httpmime).*\\.jar$");
    }
}
