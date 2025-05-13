package com.blackblaze.repository;

import com.blackblaze.model.AdviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdviceRepository extends JpaRepository<AdviceEntity, Long> {
    Optional<AdviceEntity> findByServiceName(String serviceName);
}