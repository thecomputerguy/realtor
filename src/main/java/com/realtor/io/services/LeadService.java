package com.realtor.io.services;

import com.realtor.io.exceptions.LeadNotFoundException;
import com.realtor.io.models.Lead;
import com.realtor.io.repositories.LeadRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
@Service
public class LeadService {
    LeadRepository leadRepository;
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    public Lead create(Lead lead) {
        return leadRepository.save(lead);
    }
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Lead findById(Long id) {
        return leadRepository.findById(id)
                .orElseThrow(() -> new LeadNotFoundException(String.format("Lead with given id: {%s} does not exist", id)));
    }
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    public Lead update(Lead lead) {
        return leadRepository.save(lead);
    }
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Collection<Lead> findAll() {
        return leadRepository.findAll();
    }
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    public void deleteById(Long id) {
        leadRepository.findById(id);
        leadRepository.deleteById(id);
    }
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    public void deleteAll() {
        leadRepository.deleteAll();
    }
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Collection<Lead> findLeadsByProject(Long projectId) {
        return leadRepository.findAllLeadsByProject(projectId);
    }
}
