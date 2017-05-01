package com.icbc.dagger.hunter.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class MavenMetaParser {
    public MavenMeta parse(File xmlFile) {
        MavenMeta meta = null;

        try {
            JAXBContext context = JAXBContext.newInstance(MavenMeta.class);
            Unmarshaller parser = context.createUnmarshaller();
            meta = (MavenMeta) parser.unmarshal(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return meta;
    }

    public static void main(String[] args) {
        MavenMetaParser parser = new MavenMetaParser();
        MavenMeta meta = parser.parse(new File("/Users/huanghao/tmp/maven-metadata.xml"));
        System.out.println(meta);
    }
}
