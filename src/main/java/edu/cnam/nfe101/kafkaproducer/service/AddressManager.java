package edu.cnam.nfe101.kafkaproducer.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import edu.cnam.nfe101.kafkaproducer.model.AddressCsv;

@Service
public class AddressManager {

    private static final Logger log = LoggerFactory.getLogger(AddressManager.class);

    private final CsvReader csvReader;
    private final KafkaSender kafkaSender;

    public AddressManager(CsvReader csvReader, KafkaSender kafkaSender) {
        this.csvReader = csvReader;
        this.kafkaSender = kafkaSender;
    }

    public void transfer(String csvFileName) {
        log.info("Transferring data from CSV file: {} to Kafka", csvFileName);

        List<AddressCsv> csvAddresses = csvReader.readAddresses(csvFileName);
        log.info("Sending csv addresses to kafka");

        csvAddresses
                .stream()
                .map(csv -> AddressMapper.toJson(csv))
                .forEach(address -> {
                    kafkaSender.sendAddress(address);
                });
        log.info("Finished transferring file: {}", csvFileName);
    }
}
