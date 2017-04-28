package com.icbc.dagger.util;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;

public class PropUtilTest {
    @SuppressWarnings("deprecation")
    @Test
    public void testGetProperty() {
        assertEquals("Version not right", "1.0.0", PropUtil.getProperty("dagger_version"));
    }

}
