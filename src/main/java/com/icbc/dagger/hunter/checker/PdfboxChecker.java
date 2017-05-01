package com.icbc.dagger.hunter.checker;

/**
 * apache pdfbox: A tool for working with PDF documents.
 * 
 * @author huanghao
 * @since 20170430
 *
 */
public class PdfboxChecker extends NamePatternChecker {
    public PdfboxChecker() {
        super("pdfbox");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*pdfbox.*\\.jar$");
    }

}
