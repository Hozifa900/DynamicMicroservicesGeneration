package com.miu.eventtrackerapi.Service;


import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MessageService {

    private final ConsumerFactory<String, String> consumerFactory;

    public MessageService(ConsumerFactory<String, String> consumerFactory) {
        this.consumerFactory = consumerFactory;
    }

    public List<String> getMessagesFromTopic(String topicName) {
        Consumer<String, String> consumer = consumerFactory.createConsumer();

        consumer.subscribe(Collections.singletonList(topicName));

        List<String> messages = new ArrayList<>();

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(500));
            records.forEach(record -> {
                messages.add(record.value());
            });

            if (records.isEmpty()) {
                break;
            }
        }
        consumer.close();

        return messages;
    }
}
