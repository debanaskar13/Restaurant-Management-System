package com.example.first.microservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.Instant;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDto {

    private int id;
    @NotBlank(message = "Role title can't be empty")
    @NotNull(message = "Role title can't be Null")
    @Size(min = 3,max = 50,message = "Role title should be within minimum 3 and maximum 50 characters")
    private String title;
    private String description;
    private boolean active;
    @NotBlank(message = "Role slug can't be empty")
    @NotNull(message = "Role slug can't be Null")
    @Size(min = 3,max = 50,message = "Role slug should be within minimum 3 and maximum 50 characters")
    private String slug;
    private String content;
    @JsonIgnore
    private Instant createdAt;
    @JsonIgnore
    private Instant updatedAt;

}
