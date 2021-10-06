package org.shelajev.primes;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Path("/primes")
public class PrimesResource {

    @Channel("computation-logs")
    Emitter<String> computationLogEmitter;

    private Random r = new Random(41);

    @GET
    @Path("/random/{upperbound}")
    public List<Long> random(@PathParam int upperbound) {
        int to = 2 + r.nextInt(upperbound - 2);
        int from = 1 + r.nextInt(to - 1);

        return primeSequence(from, to);
    }

    public boolean isPrime(long n) {
        return LongStream.rangeClosed(2, (long) Math.sqrt(n))
          .allMatch(i -> n % i != 0);
    }

    public List<Long> primeSequence(long min, long max) {
        long start = -System.currentTimeMillis();
        List<Long> result = LongStream.range(min, max)
          .filter(this::isPrime)
          .boxed()
          .collect(Collectors.toList());
        start += System.currentTimeMillis();
        ComputationLog c = new ComputationLog(min, max, start);
        computationLogEmitter.send(c.toString());

        return result;
    }
}