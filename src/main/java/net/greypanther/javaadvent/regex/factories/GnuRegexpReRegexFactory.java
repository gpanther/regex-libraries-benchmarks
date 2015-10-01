package net.greypanther.javaadvent.regex.factories;

import gnu.regexp.REException;
import net.greypanther.javaadvent.regex.Regex;

public final class GnuRegexpReRegexFactory extends RegexFactory {

    @Override
    public Regex create(String pattern) {
        gnu.regexp.RE regexpr;
        try {
            regexpr = new gnu.regexp.RE(pattern);
        } catch (REException e) {
            throw new IllegalArgumentException(e);
        }

        return new Regex() {
            @Override
            public boolean containsMatch(String string) {
                return regexpr.isMatch(string);
            }
        };
    }

}
