package com.blackblaze.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(schema = "public", name = "advice_entity")
public class AdviceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "service_description")
    private String serviceDescription;

    @Column(name = "service_duration")
    private String serviceDuration;

    @Column(name = "service_price")
    private String servicePrice;

    @Column(name = "comparison_id")
    private String comparisonId;
}