package net.greypanther.javaadvent.regex;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.google.common.collect.Lists;

import net.greypanther.javaadvent.regex.factories.RegexFactory;

@RunWith(Parameterized.class)
public final class RegexTest {
    private final RegexFactory factory;

    public RegexTest(String name, RegexFactory factory) {
        this.factory = factory;
    }

    @Test
    public void testUrl1() {
        Regex regex = factory.create(Regexes.URL_MATCH1);

        assertTrue(regex.containsMatch(Regexes.URL1));
        assertTrue(regex.containsMatch(Regexes.URL2));
        assertFalse(regex.containsMatch(Regexes.USD));
        assertFalse(regex.containsMatch(Regexes.WORDS1));
        assertFalse(regex.containsMatch(Regexes.WORDS2));
        assertFalse(regex.containsMatch(Regexes.TEXT));
    }

    @Test
    public void testUrl2() {
        Regex regex = factory.create(Regexes.URL_MATCH2);

        assertTrue(regex.containsMatch(Regexes.URL1));
        assertTrue(regex.containsMatch(Regexes.URL2));
        assertFalse(regex.containsMatch(Regexes.USD));
        assertFalse(regex.containsMatch(Regexes.WORDS1));
        assertFalse(regex.containsMatch(Regexes.WORDS2));
        assertFalse(regex.containsMatch(Regexes.TEXT));
    }

    @Test
    public void testUsd() {
        Regex regex = factory.create(Regexes.USD_MATCH);

        assertFalse(regex.containsMatch(Regexes.URL1));
        assertFalse(regex.containsMatch(Regexes.URL2));
        assertTrue(regex.containsMatch(Regexes.USD));
        assertFalse(regex.containsMatch(Regexes.WORDS1));
        assertFalse(regex.containsMatch(Regexes.WORDS2));
        assertFalse(regex.containsMatch(Regexes.TEXT));
    }

    @Test
    public void testWords() {
        Regex regex = factory.create(Regexes.WORDS_MATCH);

        assertFalse(regex.containsMatch(Regexes.URL1));
        assertFalse(regex.containsMatch(Regexes.URL2));
        assertFalse(regex.containsMatch(Regexes.USD));
        assertFalse(regex.containsMatch(Regexes.WORDS1));
        assertTrue(regex.containsMatch(Regexes.WORDS2));
        assertFalse(regex.containsMatch(Regexes.TEXT));
    }

    @Test
    public void testLong() {
        Regex regex = factory.create(Regexes.LONG_MATCH);

        assertFalse(regex.containsMatch(Regexes.URL1));
        assertFalse(regex.containsMatch(Regexes.URL2));
        assertFalse(regex.containsMatch(Regexes.USD));
        assertFalse(regex.containsMatch(Regexes.WORDS1));
        assertFalse(regex.containsMatch(Regexes.WORDS2));
        assertTrue(regex.containsMatch(Regexes.TEXT));
    }

    @Parameters( name = "{index}: {0}" )
    public static Collection<Object[]> data() {
        List<Object[]> result = Lists.newArrayList();
        for (RegexFactory factory : Lists.reverse(Regexes.FACTORIES)) {
            result.add(new Object[] { factory.getName(), factory });
        }
        return result;
    }
}
