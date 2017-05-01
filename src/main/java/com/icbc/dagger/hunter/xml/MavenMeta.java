package com.icbc.dagger.hunter.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "metadata")
@XmlAccessorType(XmlAccessType.FIELD)
public class MavenMeta {
    @XmlElement(name = "groupId")
    private String groupId;

    @XmlElement(name = "artifactId")
    private String artifactId;

    @XmlElement(name = "versioning")
    private Versioning versioning;

    @Override
    public String toString() {
        return "MavenMeta [groupId=" + groupId + ", artifactId=" + artifactId + ", versioning=" + versioning + "]";
    }

    public List<String> getVersionList() {
        return versioning.getVersionList();
    }

}
