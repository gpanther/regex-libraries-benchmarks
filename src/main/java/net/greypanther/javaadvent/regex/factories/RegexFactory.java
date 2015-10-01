package net.greypanther.javaadvent.regex.factories;

import net.greypanther.javaadvent.regex.Regex;

public abstract class RegexFactory {
    public final String getName() {
        return getClass().getSimpleName();
    }

    public abstract Regex create(String pattern);
}
