package com.github.baev;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 13.04.15
 */
public class TestWithShittyAssertion {

    @Test
    public void test() throws Exception {
        String result = RandomStringUtils.random(1000, "qwertyuiopasdfghjklzxcvbnm");
        assertThat("Wow is present!", result, containsString("wow"));
    }
}
