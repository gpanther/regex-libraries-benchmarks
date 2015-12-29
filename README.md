A [JMH](http://openjdk.java.net/projects/code-tools/jmh/) benchmark for different Java regular expression libraries inspired by [tusker.org](http://tusker.org/regex/regex_benchmark.html).

To run the code:

````
# we need to skip tests since almost all libraries fail a test or an other
mvn -Dmaven.test.skip=true clean package
# run the benchmarks including libraries which are not in Maven central
java -cp lib/jint.jar:target/benchmarks.jar net.greypanther.javaadvent.regex.RegexBenchmarks
````

The benchmark code is licensed under the Apache 2.0 license. Individual libraries are licensed under their respective licenses.

Read the post detailing the results on [the JavaAdvent calendar](http://www.javaadvent.com/2015/12/java-regular-expression-library-benchmarks-2015.html).
