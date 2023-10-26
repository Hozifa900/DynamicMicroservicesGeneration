package com.miu.eventtrackerapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Data
// @Entity
public class DataApi {
    // @Id
    // @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String url;
    private String apiKey;
//    private String description;
    private boolean needsKey;
    // private String name;
    // private boolean approved;
//    @Temporal(TemporalType.TIMESTAMP)
//    @CreationTimestamp
//    private LocalDateTime createdAt;
//    @Temporal(TemporalType.TIMESTAMP)
//    @UpdateTimestamp
//    private LocalDateTime updatedAt;
}
