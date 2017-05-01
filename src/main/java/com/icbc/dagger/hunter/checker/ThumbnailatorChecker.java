package com.icbc.dagger.hunter.checker;

/**
 * thumbnailator: A thumbnail generation library.
 * 
 * @author huanghao
 * @since 20170430
 *
 */
public class ThumbnailatorChecker extends NamePatternChecker {
    public ThumbnailatorChecker() {
        super("thumbnailator");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*thumbnailator.*\\.jar$");
    }

}
