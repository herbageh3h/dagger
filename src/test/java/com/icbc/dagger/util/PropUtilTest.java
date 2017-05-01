package com.icbc.dagger.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PropUtilTest {
    @Test
    public void testGetProperty() {
        assertEquals("Version not right", "1.0.0", PropUtil.getProperty("dagger_version"));
    }

}
