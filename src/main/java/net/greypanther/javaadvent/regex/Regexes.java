package net.greypanther.javaadvent.regex;

import java.util.List;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

import net.greypanther.javaadvent.regex.factories.ApacheXerxesRegexFactory;
import net.greypanther.javaadvent.regex.factories.ComBasistechTclRegexFactory;
import net.greypanther.javaadvent.regex.factories.ComKarneimRegexFactory;
import net.greypanther.javaadvent.regex.factories.ComStevesoftPatRegexFactory;
import net.greypanther.javaadvent.regex.factories.DkBricsAutomatonRegexFactory;
import net.greypanther.javaadvent.regex.factories.GnuRegexpReRegexFactory;
import net.greypanther.javaadvent.regex.factories.JRegexFactory;
import net.greypanther.javaadvent.regex.factories.JavaUtilPatternRegexFactory;
import net.greypanther.javaadvent.regex.factories.KmyRegexUtilRegexFactory;
import net.greypanther.javaadvent.regex.factories.OrgApacheRegexpRegexFactory;
import net.greypanther.javaadvent.regex.factories.OroRegexFactory;
import net.greypanther.javaadvent.regex.factories.RegexFactory;

final class Regexes {
    // based on http://tusker.org/regex/regtest.java
    final static int LONG_MATCH_IDX = 4;

    final static String URL_MATCH1 = "^(([^:]+)://)?([^:/]+)(:([0-9]+))?(/.*)";
    final static String URL_MATCH2 = "(([^:]+)://)?([^:/]+)(:([0-9]+))?(/.*)";
    final static String USD_MATCH = "usd [+-]?[0-9]+.[0-9][0-9]";
    final static String WORDS_MATCH = "\\b(\\w+)(\\s+\\1)+\\b";
    final static String LONG_MATCH = "\\{(\\d+):(([^}](?!-} ))*)";
    final static String[] REGEXES = { URL_MATCH1, URL_MATCH2, USD_MATCH, WORDS_MATCH, LONG_MATCH };

    final static String URL1 = "http://www.linux.com/";
    final static String URL2 = "http://www.thelinuxshow.com/main.php3";
    final static String USD = "usd 1234.00";
    final static String WORDS1 = "he said she said he said no";
    final static String WORDS2 = "same same same";
    final static String TEXT = "{1:\n"
            + Strings.repeat("this is some more text - and some more and some more and even more\n", 42) + "-}\n";
    final static String[] TEXTS = { URL1, URL2, USD, WORDS1, WORDS2 };

    final static List<RegexFactory> FACTORIES = ImmutableList.of(new JavaUtilPatternRegexFactory(),
            new DkBricsAutomatonRegexFactory(), new OrgApacheRegexpRegexFactory(), new ComStevesoftPatRegexFactory(),
            new JRegexFactory(), new KmyRegexUtilRegexFactory(), new OroRegexFactory(), new GnuRegexpReRegexFactory(),
            new ComKarneimRegexFactory(), new ApacheXerxesRegexFactory(), new ComBasistechTclRegexFactory());
}
