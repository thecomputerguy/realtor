package com.realtor.io.services;

import com.realtor.io.exceptions.ProjectNotFoundException;
import com.realtor.io.models.AuditInfo;
import com.realtor.io.models.Project;
import com.realtor.io.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Collection;

@Service
@AllArgsConstructor
public class ProjectService {
    ProjectRepository projectRepository;
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    public Project create(Project project) {
        AuditInfo auditInfo = AuditInfo.builder().createdOn(Instant.now()).createdBy("root").build();
        project.setAuditInfo(auditInfo);
        return projectRepository.save(project);
    }
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Project findById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(String.format("Project with given id: {%s} does not exist", id)));
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Project findByHosted(String hosted) {
        return projectRepository.findByHosted(hosted)
                .orElseThrow(() -> new ProjectNotFoundException(String.format("Project with given host name: {%s} does not exist", hosted)));
    }
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    public Project update(Project project) {
                project.getAuditInfo().setUpdatedOn(Instant.now());
                project.getAuditInfo().setUpdatedBy("root");
        return projectRepository.save(project);
    }
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Collection<Project> findAll() {
        return projectRepository.findAll();
    }
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    public void deleteById(Long id) {
        projectRepository.findById(id);
        projectRepository.deleteById(id);
    }
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    public void deleteAll() {
        projectRepository.deleteAll();
    }

}
