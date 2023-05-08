package com.realtor.io.mappers;

import com.realtor.io.dto.LeadDTO;
import com.realtor.io.exceptions.ProjectNotFoundException;
import com.realtor.io.models.Lead;
import com.realtor.io.models.Project;
import com.realtor.io.repositories.ProjectRepository;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface LeadMapper {
    @Mapping(target = "project", ignore = true)
    LeadDTO updateLeadDTO(Lead lead, @MappingTarget LeadDTO leadDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "project", ignore = true)
    Lead updateLead(LeadDTO leadDTO, @MappingTarget Lead lead, @Context ProjectRepository projectRepository);

    @AfterMapping
    default void afterUpdateLeadDTO(Lead lead, @MappingTarget LeadDTO leadDTO) {
        leadDTO.setProject(lead.getProject() == null ? null : lead.getProject().getId());
    }

    @AfterMapping
    default void afterUpdateLead(LeadDTO leadDTO, @MappingTarget Lead lead,
                                    @Context ProjectRepository projectRepository) {
        if (leadDTO.getProject() != null && (lead.getProject() == null || !lead.getProject().getId().equals(leadDTO.getProject()))) {
            final Project project = projectRepository.findById(leadDTO.getProject())
                    .orElseThrow(() -> new ProjectNotFoundException("project not found"));
            lead.setProject(project);
        }
    }
}
