//package com.miu.eventtrackerapi.repositories;
//
//import com.miu.eventtrackerapi.entities.DataApi;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface DataApiRepository extends JpaRepository<DataApi, Long> {
//    Page<DataApi> findByApprovedTrue(Pageable pageable);
//    Page<DataApi> findAll(Pageable pageable);
//    Page<DataApi> findByApprovedFalse(Pageable pageable);
//
//    Optional<DataApi> findByUrl(String url);
//
//}
