package io.moyada.serializer.jmh;

import org.openjdk.jmh.profile.Profiler;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author xueyikang
 * @since 1.0
 **/
public abstract class AbstractBenchMark {

    public static Options getOptional(String filename, Class<? extends Profiler>... profs) {
        OptionsBuilder builder = new OptionsBuilder();
        for (Class<? extends Profiler> prof : profs) {
            builder.addProfiler(prof);
        }

        Options opt = builder
                .include(filename)
                .jvmArgs("-server", "-Xms2048m", "-Xmx2048m", "-XX:+UseTLAB", "-XX:+UseG1GC")
                .resultFormat(ResultFormatType.CSV)
                .output(filename + ".csv")
                .result(filename + ".-result.csv")
                .build();

        return opt;
    }
}
