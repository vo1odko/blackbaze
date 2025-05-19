package com.blackblaze.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(schema = "public", name = "advice_entity")
public class AdviceEntity {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "service_name")
    private String serviceName;
    @Column(name = "service_description")
    private String serviceDescription;
    @Column(name = "service_duration")
    private String serviceDuration;
    @Column(name = "service_price")
    private String servicePrice;
    @Column(name = "img_before")
    private String imgBefore;
    @Column(name = "img_after")
    private String imgAfter;
}