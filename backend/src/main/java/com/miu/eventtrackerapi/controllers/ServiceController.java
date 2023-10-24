package com.miu.eventtrackerapi.controllers;

import com.miu.eventtrackerapi.entities.DataApi;
import com.miu.eventtrackerapi.entities.Service;
import com.miu.eventtrackerapi.repositories.DataApiRepository;
import com.miu.eventtrackerapi.repositories.ServiceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {
    private final ServiceRepository repo;

    public ServiceController(ServiceRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public Page<Service> getAll(Pageable pageable){
        return repo.findAll(pageable);
    }

    @GetMapping("/{id}")
    Service getDataApi(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("service id="+id));
    }
}
