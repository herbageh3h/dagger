package com.icbc.dagger.hunter.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "versioning")
@XmlAccessorType(XmlAccessType.FIELD)
public class Versioning {
    @XmlElementWrapper(name = "versions")
    @XmlElement(name = "version")
    private List<String> versionList;

    @Override
    public String toString() {
        return "" + versionList;
    }
    
    public List<String> getVersionList() {
        return versionList;
    }

}
