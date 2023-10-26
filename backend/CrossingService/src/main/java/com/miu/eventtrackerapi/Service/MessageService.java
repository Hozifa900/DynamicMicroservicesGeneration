package com.miu.eventtrackerapi.Service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miu.eventtrackerapi.entities.DataApi;
import com.miu.eventtrackerapi.integration.KafkaRetriever;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.*;

@Service
public class MessageService {

    private final ConsumerFactory<String, String> consumerFactory;
    private final KafkaRetriever<DataApi> retriever;

    public MessageService(ConsumerFactory<String, String> consumerFactory, KafkaRetriever<DataApi> retriever) {
        this.consumerFactory = consumerFactory;
        this.retriever = retriever;
    }

    public Collection<DataApi> getMessagesFromTopic(String topicName) {
        try {
            // Create an ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();
            return retriever.getAllFromTopic(topicName, Duration.ofSeconds(1));git
//                    .stream()
//                    .filter(r-> {
//                        System.out.println("Here it is: " + r);
                        // Parse the JSON string into a JsonNode
//                        JsonNode jsonNode = null;
//                        String jsonString;
//                        try {
//                            jsonString = objectMapper.writeValueAsString(r);
//                        } catch (JsonProcessingException e) {
//                            throw new RuntimeException(e);
//                        }
//                        try {
//                            jsonNode = objectMapper.readTree(String.valueOf(r));
//                        } catch (JsonProcessingException e) {
//                            throw new RuntimeException(e);
//                        }

                        // Accessing values from the JsonNode
//                        String url = jsonNode.get("url").asText();
//                        String apiKey = jsonNode.get("apiKey").asText();
//                        boolean needsKey = jsonNode.get("needsKey").asBoolean();

//                        var api = new DataApi();
//                        api.setApiKey(r.getApiKey());
//                        api.setUrl(r.getUrl());
//                        api.setNeedsKey(r.isNeedsKey());
//                        return api;
//                        return r;
//                        return false;
//                    }).toList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
