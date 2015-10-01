package net.greypanther.javaadvent.regex;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import net.greypanther.javaadvent.regex.factories.RegexFactory;

@State(Scope.Benchmark)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@Fork(1)
public class RegexBenchmarks {
    @Param({})
    public String factoryName;

    private Regex[] regexes;

    @Setup
    public void prepare() throws Exception {
        regexes = new Regex[Regexes.REGEXES.length];
        RegexFactory factory = (RegexFactory) Class.forName("net.greypanther.javaadvent.regex.factories." + factoryName)
                .newInstance();
        for (int i = 0; i < Regexes.REGEXES.length; ++i) {
            regexes[i] = factory.create(Regexes.REGEXES[i]);
        }

    }

    @Benchmark
    public long benchmark() {
        long counter = 0;
        for (Regex regex : regexes) {
            for (String text : Regexes.TEXTS) {
                counter += regex.containsMatch(text) ? 1 : 0;
            }
        }
        return counter;
    }

    @Benchmark
    public long testLarge() {
        String longText = Regexes.TEXT;
        return regexes[Regexes.LONG_MATCH_IDX].containsMatch(longText) ? 1 : 0;
    }

    public static void main(String[] args) throws RunnerException {
        String[] factoryNames = Regexes.FACTORIES.stream().map(f -> f.getClass().getSimpleName())
                .toArray(String[]::new);

        Options opt = new OptionsBuilder().include(RegexBenchmarks.class.getSimpleName())
                .param("factoryName", factoryNames).build();

        new Runner(opt).run();
    }
}
