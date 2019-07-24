package com.gympass.speedland;

import org.junit.BeforeClass;

import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;

public class BasicTest {

    @BeforeClass
    public static void setUp() {
        loadTemplates("com.gympass.speedland");
    }
}
