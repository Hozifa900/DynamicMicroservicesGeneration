package com.miu.eventtrackerapi.controllers;

import com.miu.eventtrackerapi.entities.DataApi;
import com.miu.eventtrackerapi.entities.Message;
import com.miu.eventtrackerapi.entities.Service;
import com.miu.eventtrackerapi.repositories.DataApiRepository;
import com.miu.eventtrackerapi.repositories.MessageRepository;
import com.miu.eventtrackerapi.repositories.ServiceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private final MessageRepository repo;

    public MessageController(MessageRepository repo) {
        this.repo = repo;
    }

//    @GetMapping
//    public ResponseEntity<List<Message>> getAll(@RequestParam("page") int page,
//                                                @RequestParam("pageSize") int pageSize){
//
//        var items = repo.findAll();
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Range", "items 0-1/"+items.size());
//        headers.add("Access-Control-Expose-Headers", "Content-Range");
//        return ResponseEntity.ok()
//                .headers(headers)
//                .body(items);
//    }

    @GetMapping
    public Page<Message> getAll(@RequestParam(required = false,name = "service_id") Long serviceId, Pageable pageable){
        if(serviceId == null)
            return repo.findAll(pageable);
        return repo.findByServiceId(serviceId, pageable);
    }
}
