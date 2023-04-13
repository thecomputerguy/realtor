package com.realtor.io.dto;

import com.realtor.io.models.ProjectStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProjectDTO(
        @NotNull(message = "Name cannot be null")
        @Size(min = 5, max = 2000, message = "Name must be at least 5 characters and at most 2000 characters long")
        String name,
        @NotNull(message = "Description cannot be null")
        @Size(min = 5, max = 4000, message = "Description must be at least 5 characters and at most 4000 characters long")
        String description,
        @NotNull(message = "Hosted cannot be null")
        @Size(min = 5, max = 2000, message = "Hosted must be at least 5 characters and at most 2000 characters long")
        String hosted,
        String imageUrls,
        @NotNull(message = "Status cannot be null")
        ProjectStatus status,
        @NotNull(message = "Deleted cannot be null")
        Boolean deleted
) {
        public ProjectDTO(){ this("DummyValue", "DummyValue", "DummyValue", "DummyValue", ProjectStatus.STARTED, false);}

}
