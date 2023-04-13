package com.realtor.io.mappers;

import com.realtor.io.dto.ProjectDTO;
import com.realtor.io.models.Project;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ProjectMapper {
        ProjectDTO updateProjectDTO(Project project, @MappingTarget ProjectDTO projectDTO);

        @Mapping(target = "id", ignore = true)
        @Mapping(target = "leads", ignore = true)
        Project updateProject(ProjectDTO projectDTO, @MappingTarget Project project);

}
