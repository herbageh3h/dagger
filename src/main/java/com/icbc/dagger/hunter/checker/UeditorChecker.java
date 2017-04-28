package com.icbc.dagger.hunter.checker;

/**
 * ueditor: BAIDU front end rich text editor.
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class UeditorChecker extends NamePatternChecker {
    public UeditorChecker() {
        super("ueditor");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*ueditor.*\\.jar$");
    }

}
