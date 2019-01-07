package com.putdns.jmh;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class JmhApplication {

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder().include(Main.class.getSimpleName()).forks(1).build();
    new Runner(opt).run();
  }

}

