package net.greypanther.javaadvent.regex.factories;

import com.basistech.tclre.HsrePattern;
import com.basistech.tclre.PatternFlags;
import com.basistech.tclre.RePattern;
import com.basistech.tclre.RegexException;

import net.greypanther.javaadvent.regex.Regex;

public final class ComBasistechTclRegexFactory extends RegexFactory {

    @Override
    public Regex create(String pattern) {
        RePattern r;
        try {
            r = HsrePattern.compile(pattern, PatternFlags.ADVANCED);
        } catch (RegexException e) {
            throw new IllegalArgumentException(e);
        }
        return new Regex() {
            @Override
            public boolean containsMatch(String string) {
                return r.matcher(string).matches();
            }
        };
    }

}
