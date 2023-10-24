package com.miu.eventtrackerapi.repositories;

import com.miu.eventtrackerapi.entities.Message;
import com.miu.eventtrackerapi.entities.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    Page<Service> findAll(Pageable pageable);
}
