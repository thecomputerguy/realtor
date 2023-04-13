package com.realtor.io.repositories;

import com.realtor.io.models.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface LeadRepository extends JpaRepository<Lead, Long> {
    @Query("SELECT lead FROM Lead lead WHERE lead.project.id = :projectId")
    Collection<Lead> findAllLeadsByProject(@Param("projectId") Long projectId);
}
