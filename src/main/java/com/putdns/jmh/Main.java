package com.putdns.jmh;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 3)
@Measurement(iterations = 10, time = 5, timeUnit = TimeUnit.SECONDS)
@Threads(16)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class Main {

  static boolean flag = false;

  static StringBuilder save;

  static String reference;

  @Benchmark
  public void empty() {}

  @Benchmark
  public void multi() {
    int a = 0, b = 1;
    flag = (a * b != 0);
  }

  @Benchmark
  public void and() {
    int a = 0, b = 1;
    flag = (a != 0 && b != 0);
  }

  @Benchmark
  public void plus() {
    String s = "base ";
    for (int i = 0; i < 10; i++) {
      s = s + " plus " + i;
    }
    reference = s;
  }

  @Benchmark
  public void append() {
    StringBuilder s = new StringBuilder("base ");
    for (int i = 0; i < 10; i++) {
      s.append(" appe ").append(i);
    }
    save = s;
  }

}
