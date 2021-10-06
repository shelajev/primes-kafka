package org.shelajev.primes;

public class ComputationLog {
  public long from;
  public long to;
  public long time;

  public ComputationLog(long min, long max, long time) {
    from = min;
    to = max;
    this.time = time;
  }


  @Override
  public String toString() {
    return "ComputationLog{" +
      "from=" + from +
      ", to=" + to +
      ", time=" + time +
      '}';
  }
}
