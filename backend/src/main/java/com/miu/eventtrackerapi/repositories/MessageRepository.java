package com.miu.eventtrackerapi.repositories;

import com.miu.eventtrackerapi.entities.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
    Page<Message> findAll(Pageable pageable);
    Page<Message> findByServiceId(Long serviceId, Pageable pageable);
}
