package com.miu.eventtrackerapi.Service;


import com.miu.eventtrackerapi.entities.DataApi;
import com.miu.eventtrackerapi.integration.KafkaRetriever;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class MessageService {

    private final ConsumerFactory<String, String> consumerFactory;
    private final KafkaRetriever<String> retriever;

    public MessageService(ConsumerFactory<String, String> consumerFactory, KafkaRetriever<String> retriever) {
        this.consumerFactory = consumerFactory;
        this.retriever = retriever;
    }

    public List<DataApi> getMessagesFromTopic(String topicName) {
        return retriever.getAllFromTopic(topicName, Duration.ofSeconds(1)).stream()
                .map(r-> {
                    var api = new DataApi();
                    api.setApiKey(topicName + UUID.randomUUID().toString());
                    api.setUrl(r);
                    api.setNeedsKey(false);
                    return api;
                }).toList();
    }
}
