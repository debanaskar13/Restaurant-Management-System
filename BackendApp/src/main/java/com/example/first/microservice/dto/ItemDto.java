package com.example.first.microservice.dto;

import com.example.first.microservice.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Empty;

import java.time.Instant;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ItemDto {

    private int id;

    @NotBlank(message = "user Id cannot be null")
    @NotEmpty(message = "User Id cannot be Empty")
    private int userId;
    private int vendorId;

    @NotBlank(message = "Title cannot be null")
    @NotEmpty(message = "Title cannot be Empty")
    @Size(min = 3,max = 50,message = "title length should be within 3 and 50 characters")
    private String title;

    @NotBlank(message = "Slug cannot be null")
    @NotEmpty(message = "Slug cannot be Empty")
    @Size(min = 3,max = 50,message = "Slug length should be within 3 and 50 characters")
    private String slug;
    private String summary;
    private String type;
    private boolean cooking;
    private String sku;
    private float price;
    private float quantity;
    private int unit;
    private String recipe;
    private String instructions;
    private Instant createdAt;
    private Instant updatedAt;
    private String content;

}
