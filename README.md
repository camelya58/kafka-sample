# kafka-sample
The application demonstrates service of communication between producer and consumer microservices using [Apache Kafka](https://kafka.apache.org/downloads/).

## Step 1. 
Install Apache Kafka for MacOS X.
```
brew install kafka
```

Install Apache Kafka for Ubuntu.
```
apt install kafka
```

## Step 2. 
Start zookeeper and kafka in terminal. Set up path to zookeeper.properties and server.properties.
```
zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties & kafka-server-start /usr/local/etc/kafka/server.properties
```

## Step 3.
Create topic server, set up port(9092) and quantity of replications (1) and partitions (1), write topic's name (example-topic).
```
bin/kafka-topics.sh --create \
  --zookeeper localhost:9092 \
  --replication-factor 1 --partitions 1 \
  --topic example-topic
```

## Step 4.
Set up kafka-producer service.
```xml
<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka</artifactId>
</dependency>
```
Change directory to kafka-producer and run application.
```
cd kafka-producer
mvn spring-boot:run

```

## Step 5.
Set up kafka-consumer service.
```xml
<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka</artifactId>
</dependency>
```
Change directory to kafka-consumer and run application.
```
cd kafka-consumer
mvn spring-boot:run

```

## Step 6.
Open the url - localhost:8080/swagger-ui.html, choose `kafka-producer-controller` and send any message.
```
curl -X POST "http://localhost:8080/kafka/publish?message=Good%20evening!" -H "accept: */*"
```

## Step 7.
See in terminal of kafka-consumer - log.info.
```
2020-05-05 23:46:32.849  INFO 16760 --- [           main] c.e.k.k.KafkaConsumerApplication         : Receive message=Good evening!

```

## Contribute
For any problems, comments, or feedback please create an issue [here](https://github.com/camelya58/kafka-sample/issues).
<br>
