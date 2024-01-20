package com.example.first.microservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDto {

    @JsonIgnore
    private int id;
    private String title;
    private String description;
    @JsonIgnore
    private boolean active;
    @JsonIgnore
    private String slug;
    @JsonIgnore
    private String content;

}
