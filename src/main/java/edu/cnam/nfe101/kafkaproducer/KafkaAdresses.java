package edu.cnam.nfe101.kafkaproducer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class KafkaAdresses {
    private static final Logger log = LoggerFactory.getLogger(KafkaAdresses.class);

    public static void main(String[] args) {
        log.info("Starting Kafka Producer for AdressesLimoges");

        String bootstrapServers = "172.17.78.90:9092";
        String topic = "test";
        String csvFile = "C:\\Users\\Steven\\Documents\\IdeaProjects\\kafka-producer\\data\\addresses-limoges.csv";

        // Create Producer properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // Create the producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;

            br.readLine(); // Skip the header line

            // Read and send each line
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 9) {
                    // Create a message with JSON-like structure
                    String key = fields[0]; // cle_interop as key
                    String value = String.format("{\"voie_nom\": \"%s\", \"numero\": \"%s\", \"suffixe\": \"%s\", \"cad_parcelles\": \"%s\", \"x\": %s, \"y\": %s, \"long\": %s, \"lat\": %s}",
                            fields[1], fields[2], fields[3], fields[4], fields[5], fields[6], fields[7], fields[8]);

                    // Create a producer record
                    ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, key, value);

                    // send data - asynchronous
                    producer.send(producerRecord, (recordMetadata, e) -> {
                        if (e == null) {
                            log.info("Record sent to Topic: {} | Partition: {} | Offset: {} | Timestamp: {}",
                                    recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset(), recordMetadata.timestamp());
                        } else {
                            log.error("Error while producing", e);
                        }
                    });
                } else {
                    log.warn("Invalid CSV row: {}", line);
                }
            }
        } catch (IOException e) {
            log.error("Error reading CSV file", e);
        } finally {
            // flush data - synchronous
            producer.flush();
            // flush and close producer
            producer.close();
        }
    }
}
