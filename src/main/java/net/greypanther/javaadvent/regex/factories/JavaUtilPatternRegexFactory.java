package net.greypanther.javaadvent.regex.factories;

import java.util.regex.Pattern;

import net.greypanther.javaadvent.regex.Regex;

public final class JavaUtilPatternRegexFactory extends RegexFactory {
    @Override
    public Regex create(String pattern) {
        Pattern rx = Pattern.compile(pattern);

        return new Regex() {
            @Override
            public boolean containsMatch(String string) {
                return rx.matcher(string).find();
            }
        };
    }
}
