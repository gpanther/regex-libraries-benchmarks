package net.greypanther.javaadvent.regex.factories;

import net.greypanther.javaadvent.regex.Regex;

public final class KmyRegexUtilRegexFactory extends RegexFactory {

    @Override
    public Regex create(String pattern) {
        kmy.regex.util.Regex regexpr = kmy.regex.util.Regex.createRegex(pattern);
        return new Regex() {
            @Override
            public boolean containsMatch(String string) {
                return regexpr.matches(string);
            }
        };
    }

}
