package com.realtor.io.services;

import com.realtor.io.exceptions.ProjectNotFoundException;
import com.realtor.io.models.Project;
import com.realtor.io.repositories.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class ProjectService {
    ProjectRepository projectRepository;
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    public Project create(Project project) {
        return projectRepository.save(project);
    }
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Project findById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(String.format("Project with given id: {%s} does not exist", id)));
    }
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    public Project update(Project project) {
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
