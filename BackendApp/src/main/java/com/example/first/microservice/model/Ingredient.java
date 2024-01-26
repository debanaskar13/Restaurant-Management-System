package com.example.first.microservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private User vendor;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "slug",nullable = false)
    private String slug;

    @Column(name = "type",nullable = false)
    private String type;

    @Column(name = "sku",nullable = false)
    private String sku;

    @Column(name = "quantity",nullable = false)
    private float quantity;

    @Column(name = "unit",nullable = false)
    private int unit;

    @Column(name = "created_at",nullable = false)
    @CreationTimestamp
    private Instant createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Instant updatedAt;

    @Column(name = "content")
    private String content;
}
