package com.blackblaze.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(schema = "public", name = "service_entity")
public class CaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "image_url")
    private String imageUrl;
}