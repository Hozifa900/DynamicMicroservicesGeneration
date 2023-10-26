package com.miu.eventtrackerapi.controllers;

import com.miu.eventtrackerapi.Service.MessageService;
import com.miu.eventtrackerapi.Service.ServiceService;
import com.miu.eventtrackerapi.entities.DataApi;
import com.miu.eventtrackerapi.entities.Service;
import com.miu.eventtrackerapi.integration.KafkaRetriever;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/services")
public class ServiceController {
    private final ServiceService service;
    private final MessageService message;
    public ServiceController(ServiceService service, MessageService message) {
        this.service = service;
        this.message = message;
    }

    @GetMapping
    public Set<String> getAll(){
        return service.listTopics();
    }

    @GetMapping("/{topicName}")
    public List<DataApi> getAllMessagesByTopic(@PathVariable String topicName){
        return message.getMessagesFromTopic(topicName);
    }

//    @GetMapping("/{id}")
//    Service getDataApi(@PathVariable Long id) {
//        return repo.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("service id="+id));
//    }
}
