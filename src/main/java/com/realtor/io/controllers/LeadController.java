package com.realtor.io.controllers;

import com.realtor.io.dto.LeadDTO;
import com.realtor.io.helpers.URIHelper;
import com.realtor.io.mappers.LeadMapper;
import com.realtor.io.models.Lead;
import com.realtor.io.services.LeadService;
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
@RequestMapping("/v1/lead/")
public class LeadController {


    LeadMapper leadMapper;
    LeadService leadService;
    Environment environment;
    URIHelper uriHelper;

    @PostMapping(name = "create")
    public ResponseEntity<?> create(@RequestBody @Valid LeadDTO leadDTO) throws UnknownHostException {
        Lead lead = leadMapper.updateLead(leadDTO, new Lead());
        Lead created = leadService.create(lead);
        LeadDTO response = leadMapper.updateLeadDTO(created, leadDTO);
        String protocol = "http://";
        String path = "v1/lead/" + lead.getId();
        return ResponseEntity.created(uriHelper.getUri(protocol, path)).body(response);
    }


    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody @Valid LeadDTO leadDTO, @RequestParam("id") @NotNull Long id){
        Lead lead = leadMapper.updateLead(leadDTO, leadService.findById(id));
        Lead updated = leadService.update(lead);
        LeadDTO response = leadMapper.updateLeadDTO(updated, leadDTO);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@RequestParam("id") @NotNull Long id){
        Lead lead = leadService.findById(id);
        LeadDTO response = leadMapper.updateLeadDTO(lead, new LeadDTO());
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("project/{projectId}")
    public ResponseEntity<?> findLeadsByProject(@RequestParam("projectId") @NotNull Long projectId){
        Collection<Lead> leads = leadService.findLeadsByProject(projectId);
        List<LeadDTO> resultList = leads
                .parallelStream()
                .map(lead -> leadMapper.updateLeadDTO(lead, new LeadDTO()))
                .collect(Collectors.toList());
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("data",resultList);
        return ResponseEntity.ok().body(body);
    }

    @GetMapping("all")
    public ResponseEntity<?> findAll(){
        Collection<Lead> leadList = leadService.findAll();
        List<LeadDTO> resultList = leadList
                .parallelStream()
                .map(lead -> leadMapper.updateLeadDTO(lead, new LeadDTO()))
                .collect(Collectors.toList());
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("data",resultList);
        return ResponseEntity.ok().body(body);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteById(@RequestParam("id") @NotNull Long id){
        leadService.deleteById(id);
        return ResponseEntity.ok().body("");
    }

    @DeleteMapping("delete/all")
    public ResponseEntity<?> deleteAll(){
        leadService.deleteAll();
        return ResponseEntity.ok("");
    }
}
