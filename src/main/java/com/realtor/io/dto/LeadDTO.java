package com.realtor.io.dto;

import com.realtor.io.models.LeadStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class LeadDTO{
        Long id;
        @NotNull(message = "Project ID cannot be null")
        Long project;
        @NotNull(message = "First Name cannot be null")
        @Size(min = 5, max = 255, message = "First name must be at least 5 characters and at most 255 characters long")
        String firstName;
        @NotNull(message = "Surname cannot be null")
        @Size(min = 5, max = 255, message = "Surname must be at least 5 characters and at most 255 characters long")
        String middleName;
        @NotNull(message = "Last Name cannot be null")
        @Size(min = 5, max = 255, message = "Last Name must be at least 5 characters and at most 255 characters long")
        String lastName;
        @NotNull(message = "Email cannot be null")
        @Size(min = 5, max = 255, message = "Email must be at least 5 characters and at most 255 characters long")
        String email;
        @NotNull(message = "Phone cannot be null")
        @Size(min = 10, max = 13, message = "Phone must be at least 10 digits and at most 13 digits long")
        String phone;
        @NotNull(message = "Status cannot be null")
        LeadStatus status;
        @NotNull(message = "Deleted cannot be null")
        Boolean deleted;
}
