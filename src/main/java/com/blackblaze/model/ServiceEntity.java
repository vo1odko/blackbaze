package com.blackblaze.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String imageUrl;
}