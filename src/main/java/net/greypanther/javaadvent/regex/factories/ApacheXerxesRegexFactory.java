package net.greypanther.javaadvent.regex.factories;

import net.greypanther.javaadvent.regex.Regex;

public final class ApacheXerxesRegexFactory extends RegexFactory {

    @Override
    public Regex create(String pattern) {
        org.apache.xerces.impl.xpath.regex.RegularExpression p = new org.apache.xerces.impl.xpath.regex.RegularExpression(
                pattern);
        return new Regex() {
            @Override
            public boolean containsMatch(String string) {
                return p.matches(string);
            }
        };
    }

}
