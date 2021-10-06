# primes-kafka Project
Sample application that computes primes numbers and sends some data to Kafka. 

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

Open http://localhost:8080/primes/random/100. 
> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.
