package net.greypanther.javaadvent.regex.factories;

import net.greypanther.javaadvent.regex.Regex;

public final class ComStevesoftPatRegexFactory extends RegexFactory {

    @Override
    public Regex create(String pattern) {
        com.stevesoft.pat.Regex regexpr = new com.stevesoft.pat.Regex(pattern);

        return new Regex() {
            @Override
            public boolean containsMatch(String string) {
                try {
                    return regexpr.search(string);
                } catch (StackOverflowError err) {
                    return false;
                }
            }
        };
    }

}
