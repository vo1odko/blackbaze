package com.blackblaze.repository;

import com.blackblaze.model.AdviceEntity;
import com.blackblaze.model.CaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdviceRepository extends JpaRepository<AdviceEntity, Long> {
}