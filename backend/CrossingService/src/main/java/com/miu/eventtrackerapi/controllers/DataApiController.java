package com.miu.eventtrackerapi.controllers;

import com.miu.eventtrackerapi.entities.DataApi;
import com.miu.eventtrackerapi.entities.Message;
import com.miu.eventtrackerapi.integration.KafkaRetriever;
import com.miu.eventtrackerapi.repositories.DataApiRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.Arrays;
import javax.xml.crypto.Data;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
public class DataApiController {
    private final DataApiRepository repo;

    public DataApiController(DataApiRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/sources")
    public List<DataApi> getAll(Pageable pageable){
        // return repo.findByApprovedTrue(pageable);
        var ret = new KafkaRetriever<String>();
        return ret.getAllFromTopic("api", Duration.ofSeconds(1)).stream()
        .map(r-> {
            var api = new DataApi();
            api.setApiKey(UUID.randomUUID().toString());
            api.setUrl(r);
            return api;
        }).toList();
    }

    @GetMapping("/disallowedsources")
    public Page<DataApi> getAllDisallowedApis(Pageable pageable) {
        return repo.findByApprovedFalse(pageable);
    }

    @GetMapping("/sources/{id}")
    DataApi getDataApi(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("DataApiService id="+id));
    }

    @PutMapping("/sources/{id}/approve")
    DataApi updateDataApi(@PathVariable Long id){
        return repo.findById(id)
                .map(da -> {
                    da.setApproved(true);
                    return repo.save(da);
                })
                .orElseThrow();
    }

    @PutMapping("/sources")
    void updateDataApis(@PathVariable Long idList[], @RequestBody DataApi api){

        Arrays.stream(idList)
                .map(repo::findById)
                .map(e->e.orElse(null))
                .filter(Objects::nonNull)
                .forEach(da-> {
//                            if (api.getName() != null) da.setName(api.getName());
//                            if (api.getUrl() != null) da.setUrl(api.getUrl());
//                    if (api.isApproved() == null) da.setApproved(api.isApproved());
//                            repo.save(da);
                            System.out.println(da);
                        }
                );
    }

    @PostMapping("/sources")
    DataApi addDataApi(@RequestBody DataApi api) {
        return repo.save(api);
    }

//    @PostMapping("/sources")
//    public DataApiService addApi(@RequestBody DataApiService api){
//        return repo.findByUrl(api.getUrl())
//                .orElse(()->repo.save(api));
//    }
}

