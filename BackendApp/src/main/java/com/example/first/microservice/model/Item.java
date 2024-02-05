//package com.example.first.microservice.model;
//
//
//import jakarta.persistence.*;
//import lombok.*;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import java.time.Instant;
//
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@Builder
//@Entity
//@Table(name = "item")
//public class Item {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @ManyToOne()
//    @JoinColumn(name = "user_id",nullable = false)
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "vendor_id")
//    private User vendor;
//
//    @Column(name = "title",nullable = false)
//    private String title;
//
//    @Column(name = "slug",nullable = false)
//    private String slug;
//
//    @Column(name = "summary")
//    private String summary;
//
//    @Column(name = "type")
//    private String type;
//
//    @Column(name = "cooking")
//    private boolean cooking;
//
//    @Column(name = "sku")
//    private String sku;
//
//    @Column(name = "price")
//    private float price;
//
//    @Column(name = "quantity")
//    private float quantity;
//
//    @Column(name = "unit")
//    private int unit;
//
//    @Column(name = "recipe")
//    private String recipe;
//
//    @Column(name = "instructions")
//    private String instructions;
//
//    @ManyToOne
//    @JoinColumn(name = "restaurant_id")
//    private Restaurant restaurant;
//
//    @Column(name = "created_at",nullable = false)
//    @CreationTimestamp
//    private Instant createdAt;
//
//    @Column(name = "updated_at")
//    @UpdateTimestamp
//    private Instant updatedAt;
//
//    @Column(name = "content")
//    private String content;
//}
