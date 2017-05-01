package com.icbc.dagger.hunter.checker;

/**
 * apache lucene: An information retrieval library.
 * 
 * <ul>
 * <li>groupId: org.apache.lucene</li>
 * </ul>
 * 
 * @author huanghao
 * @since 20170430
 *
 */
public class LuceneChecker extends NamePatternChecker {
    public LuceneChecker() {
        super("lucene");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*lucene.*\\.jar$");
    }

}
