package net.greypanther.javaadvent.regex.factories;

import org.apache.oro.text.regex.MalformedPatternException;

import net.greypanther.javaadvent.regex.Regex;

public final class OroRegexFactory extends RegexFactory {

    @Override
    public Regex create(String pattern) {
        org.apache.oro.text.regex.Perl5Compiler perl5Compiler = new org.apache.oro.text.regex.Perl5Compiler();
        org.apache.oro.text.regex.Perl5Matcher perl5Matcher = new org.apache.oro.text.regex.Perl5Matcher();
        org.apache.oro.text.regex.Pattern regexpr;
        try {
            regexpr = perl5Compiler.compile(pattern);
        } catch (MalformedPatternException e) {
            throw new IllegalArgumentException(e);
        }
        
        return new Regex() {
            @Override
            public boolean containsMatch(String string) {
                return perl5Matcher.matches(string, regexpr);
            }
        };
    }

}
