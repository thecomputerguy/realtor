package com.realtor.io.controllers;

import com.realtor.io.dto.ProjectDTO;
import com.realtor.io.helpers.URIHelper;
import com.realtor.io.mappers.ProjectMapper;
import com.realtor.io.models.Project;
import com.realtor.io.services.ProjectService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/project/")
public class ProjectController {

    ProjectMapper projectMapper;
    ProjectService projectService;
    Environment environment;
    URIHelper uriHelper;

    @PostMapping(name = "create")
    public ResponseEntity<?> create(@RequestBody @Valid ProjectDTO projectDTO) throws UnknownHostException {
        Project project = projectMapper.updateProject(projectDTO, new Project());
        Project created = projectService.create(project);
        ProjectDTO response = projectMapper.updateProjectDTO(created, projectDTO);
        String protocol = "http://";
        String path = "v1/project/" + project.getId();
        return ResponseEntity.created(uriHelper.getUri(protocol, path)).body(response);
    }


    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody @Valid ProjectDTO projectDTO, @RequestParam("id") @NotNull Long id){
        Project project = projectMapper.updateProject(projectDTO, projectService.findById(id));
        Project updated = projectService.update(project);
        ProjectDTO response = projectMapper.updateProjectDTO(updated, projectDTO);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@RequestParam("id") @NotNull Long id){
        Project project = projectService.findById(id);
        ProjectDTO response = projectMapper.updateProjectDTO(project, new ProjectDTO());
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("all")
    public ResponseEntity<?> findAll(){
        Collection<Project> projectList = projectService.findAll();
        List<ProjectDTO> resultList = projectList
                .parallelStream()
                .map(project -> projectMapper.updateProjectDTO(project, new ProjectDTO()))
                .collect(Collectors.toList());
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("data",resultList);
        return ResponseEntity.ok().body(body);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteById(@RequestParam("id") @NotNull Long id){
        projectService.deleteById(id);
        return ResponseEntity.ok().body("");
    }

    @DeleteMapping("delete/all")
    public ResponseEntity<?> deleteAll(){
        projectService.deleteAll();
        return ResponseEntity.ok("");
    }
}
