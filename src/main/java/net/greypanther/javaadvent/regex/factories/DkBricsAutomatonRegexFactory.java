package net.greypanther.javaadvent.regex.factories;

import dk.brics.automaton.Automaton;

import dk.brics.automaton.RegExp;
import dk.brics.automaton.RunAutomaton;
import net.greypanther.javaadvent.regex.Regex;

public final class DkBricsAutomatonRegexFactory extends RegexFactory {

    @Override
    public Regex create(String pattern) {
        RegExp regexpr = new RegExp(pattern);
        Automaton auto = regexpr.toAutomaton();
        RunAutomaton runauto = new RunAutomaton(auto, true);

        return new Regex() {
            @Override
            public boolean containsMatch(String string) {
                return runauto.run(string);
            }
        };
    }

}
