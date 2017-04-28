package com.icbc.dagger.hunter.checker;

/**
 * json in java: JSON encoder/decoder in Java. Convert between JSON and XML,
 * HTTP headers, Cookies, and CDL. Developed by Douglas Crockford.
 * 
 * <p>
 * <strong>groupId</strong>: org.json<br>
 * <strong>artifactId</strong>: json<br>
 * </p>
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class JsonChecker extends NamePatternChecker {
    public JsonChecker() {
        super("json");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*json.*\\.jar$");
    }

}
